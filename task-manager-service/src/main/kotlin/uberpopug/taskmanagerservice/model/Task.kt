package uberpopug.taskmanagerservice.model

import org.hibernate.annotations.GenericGenerator
import rvr.uberpopug.schemaregistry.avro.taskmanager.v1.StreamEvent
import uberpopug.taskmanagerservice.controllers.dto.TaskDto
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Task(val title: String, val description: String, var status: String) {
    enum class Status {
        CREATED, ASSIGNED, COMPLETED
    }

    var accountPublicId: String? = null

    @Id
    @GeneratedValue
    var id: Long? = null

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
    )
    @Column(name = "public_id", updatable = false, nullable = false)
    var publicId: UUID = UUID.randomUUID()

    fun toTaskStreamEventDto(eventName: String): StreamEvent {
        return StreamEvent.newBuilder()
            .setPublicId(this.publicId.toString())
            .setTitle(this.title)
            .setDescription(this.description)
            .setStatus(this.status)
            .setAccountPublicId(this.accountPublicId)
            .setEventId(UUID.randomUUID().toString())
            .setEventName(eventName).build()
    }

}

fun TaskDto.toSource() = Task(
    this.title ?: "",
    this.description ?: "",
    this.status ?: ""
)
