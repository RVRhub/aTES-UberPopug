package uberpopug.accounting.controllers.dto

import uberpopug.accounting.model.Task
import java.io.Serializable
import java.util.*

data class TaskDto(
    var taskId: Long? = null,
    var publicId: String? = null,
    var title: String? = null,
    var description: String? = null,
    var status: String? = null,
    var accountPublicId: String? = null
): Serializable

fun Task.toDto() = TaskDto(
    this.id,
    this.publicId,
    this.title,
    this.description,
    this.status,
    this.accountPublicId
)

