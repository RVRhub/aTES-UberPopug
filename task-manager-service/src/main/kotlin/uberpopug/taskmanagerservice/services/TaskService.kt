package uberpopug.taskmanagerservice.services

import org.springframework.stereotype.Service
import uberpopug.taskmanagerservice.controllers.dto.TaskDto
import uberpopug.taskmanagerservice.controllers.dto.toDto
import uberpopug.taskmanagerservice.model.Task
import uberpopug.taskmanagerservice.model.toSource
import uberpopug.taskmanagerservice.repository.TasksRepository

@Service
class TaskService(private val tasksRepository: TasksRepository) {
    fun getTasksByAccountId(): List<TaskDto> {
        return tasksRepository.findAll().map { task -> task.toDto() }
    }

    fun addNewTask(task: TaskDto): TaskDto {
        task.status = Task.Status.CREATED.toString()

        return tasksRepository.save(task.toSource()).toDto()
    }
}
