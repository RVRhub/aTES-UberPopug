package uberpopug.taskmanagerservice.model

import uberpopug.taskmanagerservice.controllers.dto.TaskDto
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Task(val title:String, val description:String, val status:String) {
    enum class Status {
        CREATED, IN_PROGRESS, COMPLETED
    }

    @Id
    @GeneratedValue
    var id: Long? = null
}

fun TaskDto.toSource() = Task(
    this.title ?: "",
    this.description  ?: "",
    this.status  ?: ""
)
