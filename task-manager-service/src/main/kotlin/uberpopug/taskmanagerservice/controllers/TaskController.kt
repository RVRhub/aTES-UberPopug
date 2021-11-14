package uberpopug.taskmanagerservice.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uberpopug.taskmanagerservice.controllers.dto.TaskDto
import uberpopug.taskmanagerservice.services.TaskService

@RestController
@RequestMapping("/task")
class TaskController(private val taskService: TaskService) {

    @GetMapping
    fun getAllTasksByAccount(): List<TaskDto> {
        return taskService.getTasksByAccountId()
    }

    @PostMapping
    fun addNewTask(@RequestBody task: TaskDto): TaskDto {
        return taskService.addNewTask(task)
    }
}