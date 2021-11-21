package uberpopug.accounting.events.inbound

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Service
import rvr.uberpopug.schemaregistry.UberPopugTopics
import rvr.uberpopug.schemaregistry.avro.taskmanager.v1.StreamEvent
import rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle
import uberpopug.accounting.model.Task
import uberpopug.accounting.repository.TasksRepository
import uberpopug.accounting.services.TransactionManagerService
import java.math.BigDecimal
import java.util.*
import javax.transaction.Transactional
import kotlin.random.Random


@Service
class TaskConsumerService(
    private val tasksRepository: TasksRepository,
    private val transactionManagerService: TransactionManagerService,
) {

    @Transactional
    @KafkaListener(topics = [UberPopugTopics.TASKS_STREAM], groupId = "accountingGroup")
    fun createOrUpdateAccount(message: ConsumerRecord<String, StreamEvent>) {
        val taskStreamEvent = message?.value()
        logger.info(String.format("$$$$ => Consumed task stream: %s", taskStreamEvent))
        val task = tasksRepository.findTasksByPublicId(taskStreamEvent.getPublicId())
        if (task != null) {
            updateTask(taskStreamEvent, task)
        } else {
            createTask(
                taskStreamEvent.getPublicId(),
                taskStreamEvent.getTitle(),
                taskStreamEvent.getDescription(),
                taskStreamEvent.getStatus(),
                taskStreamEvent.accountPublicId
            )
        }
    }

    @Retryable(maxAttempts = 2)
    private fun updateTask(
        taskStreamEvent: StreamEvent,
        task: Task
    ) {
        if (taskStreamEvent.getTitle() != null) {
            task.title = taskStreamEvent.getTitle()
        }
        if (taskStreamEvent.getDescription() != null) {
            task.description = taskStreamEvent.getDescription()
        }
        if (taskStreamEvent.accountPublicId != null) {
            task.accountPublicId = taskStreamEvent.accountPublicId
        }
        tasksRepository.save(task)
    }

    @Transactional
    @Retryable(maxAttempts = 2)
    @KafkaListener(topics = [UberPopugTopics.TASK_LIFECYCLE], groupId = "accountingGroup")
    fun taskAssignedConsumer(message: ConsumerRecord<String, TaskLifecycle>) {
        val taskEvent = message?.value()
        if ("Assigned".equals(taskEvent.eventName)) {
            logger.info(String.format("$$$$ => Consumed TaskAssigned Event: %s", taskEvent))
            var updateAssignedTask = updateAssignedTask(taskEvent)
            transactionManagerService.reserveMoney(updateAssignedTask)
        } else if ("Completed".equals(taskEvent.eventName)) {
            logger.info(String.format("$$$$ => Consumed TaskCompleted Event: %s", taskEvent))
            updateCompletedTask(taskEvent)
                .ifPresent { transactionManagerService.replenishmentMoney(it) }
        }
    }

    @Retryable(maxAttempts = 2)
    private fun updateAssignedTask(taskEvent: TaskLifecycle): Task {
        val task = tasksRepository.findTasksByPublicId(taskEvent.getPublicId())
        return if (task != null) {
            task.accountPublicId = taskEvent.accountPublicId
            task.status = Task.Status.ASSIGNED.name
            tasksRepository.save(task)
        } else {
            createTask(
                taskEvent.getPublicId(),
                null, null,
                Task.Status.ASSIGNED.name,
                taskEvent.accountPublicId
            )
        }
    }

    private fun createTask(
        publicId: String?,
        title: String? = null,
        description: String? = null,
        status: String,
        accountPublicId: String?
    ): Task {
        return tasksRepository.save(
            Task(
                publicId,
                title,
                description,
                status,
                accountPublicId,
                generateAssignmentCost(),
                generateCost()
            )
        )
    }

    private fun updateCompletedTask(taskEvent: TaskLifecycle): Optional<Task> {
        val task = tasksRepository.findTasksByPublicId(taskEvent.getPublicId())
        if (task != null) {
            task.accountPublicId = taskEvent.accountPublicId
            task.status = Task.Status.COMPLETED.name
            return Optional.ofNullable(tasksRepository.save(task))
        }
        return Optional.empty()
    }

    private fun generateCost(): BigDecimal {
        return BigDecimal.valueOf(Random.nextDouble(from = 20.0, until = 40.0))
    }

    private fun generateAssignmentCost(): BigDecimal {
        return BigDecimal.valueOf(Random.nextDouble(from = 10.0, until = 20.0)).negate()
    }

    companion object {
        var logger: Logger = LoggerFactory.getLogger(TaskConsumerService::class.java)
    }
}