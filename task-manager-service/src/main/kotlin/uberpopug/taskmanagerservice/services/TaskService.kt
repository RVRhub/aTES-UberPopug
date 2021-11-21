package uberpopug.taskmanagerservice.services

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import kotlinx.coroutines.*
import uberpopug.taskmanagerservice.controllers.dto.TaskDto
import uberpopug.taskmanagerservice.controllers.dto.toDto
import uberpopug.taskmanagerservice.events.outbound.TaskLifecycleEventProducer
import uberpopug.taskmanagerservice.events.outbound.TaskStreamProducer
import uberpopug.taskmanagerservice.model.Task
import uberpopug.taskmanagerservice.model.toSource
import uberpopug.taskmanagerservice.repository.TasksRepository

@Service
class TaskService(private val tasksRepository: TasksRepository,
                  private val taskStreamProducer: TaskStreamProducer,
                  private val taskLifecycleService: TaskAssignmentService,
                  private val taskLifecycleEventProducer: TaskLifecycleEventProducer
) {
    fun getTasksByAccountId(): List<TaskDto> {
        return tasksRepository.findAll().map { task -> task.toDto() }
    }

    fun addNewTask(taskDto: TaskDto): TaskDto {
        logger.info("Add new task {}", taskDto)
        taskDto.status = Task.Status.CREATED.toString()
        val task = tasksRepository.save(taskDto.toSource())

        runBlocking {
            taskStreamProducer.sendTaskCreated(task)
            taskLifecycleService.assign(task)
        }

        return task.toDto()
    }

    fun complete(taskId: Long?) {
        logger.info("Complete task {}", taskId)

        tasksRepository.findById(taskId!!)
            .ifPresent {
                taskLifecycleService.complete(it)
            }
    }

    companion object {
        var logger: Logger = LoggerFactory.getLogger(TaskService::class.java)
    }
}
