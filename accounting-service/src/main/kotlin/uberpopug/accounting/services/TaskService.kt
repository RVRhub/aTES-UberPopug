package uberpopug.accounting.services

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import uberpopug.accounting.controllers.dto.TaskDto
import uberpopug.accounting.controllers.dto.toDto
import uberpopug.accounting.repository.TasksRepository

@Service
class TaskService(
    private val tasksRepository: TasksRepository
) {
    fun getTasksByAccountId(): List<TaskDto> {
        return tasksRepository.findAll().map { task -> task.toDto() }
    }


    companion object {
        var logger: Logger = LoggerFactory.getLogger(TaskService::class.java)
    }
}
