package uberpopug.taskmanagerservice.controllers.dto

import uberpopug.taskmanagerservice.model.Task

data class TaskDto(
    var taskId: Long? = null,
    var title: String? = null,
    var description: String? = null,
    var status: String? = null,
)

fun Task.toDto() = TaskDto(
    this.id,
    this.title,
    this.description,
    this.status
)

