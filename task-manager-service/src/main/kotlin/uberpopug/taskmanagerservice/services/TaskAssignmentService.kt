package uberpopug.taskmanagerservice.services

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import uberpopug.taskmanagerservice.events.outbound.TaskLifecycleEventProducer
import uberpopug.taskmanagerservice.events.outbound.TaskStreamProducer
import uberpopug.taskmanagerservice.model.Account
import uberpopug.taskmanagerservice.model.Task
import uberpopug.taskmanagerservice.repository.AccountRepository
import uberpopug.taskmanagerservice.repository.TasksRepository
import kotlin.random.Random

@Service
class TaskAssignmentService(
    private val tasksRepository: TasksRepository,
    private val accountRepository: AccountRepository,
    private val taskLifecycleEventProducer: TaskLifecycleEventProducer
) {
    suspend fun assign(task: Task) {
        logger.info("Assign task {}", task)

        val assigningAccount = getRandomAccount()

        task.accountPublicId = assigningAccount.publicId
        task.status = Task.Status.ASSIGNED.toString()
        tasksRepository.save(task)

        taskLifecycleEventProducer.sendTaskAssigned(task)
    }

    private fun getRandomAccount(): Account {
        // TODO: Find by role

        var allAccounts = accountRepository.findAll()
        val index = Random.nextInt(allAccounts.size);
        return allAccounts[index]
    }

    companion object {
        var logger: Logger = LoggerFactory.getLogger(TaskAssignmentService::class.java)
    }
}
