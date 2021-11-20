package uberpopug.taskmanagerservice.events.outbound

import org.apache.avro.specific.SpecificRecord
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import rvr.uberpopug.schemaregistry.taskmanager.v1.TaskAssigned
import rvr.uberpopug.schemaregistry.taskmanager.v1.TaskCompleted
import uberpopug.taskmanagerservice.model.Task
import java.util.*

@Component
class TaskLifecycleEventProducer(private val kafkaTemplate: KafkaTemplate<String, SpecificRecord>) {

    fun sendTaskAssigned(task: Task) {
        var taskAssignedEvent = TaskAssigned.newBuilder()
            .setEventId(UUID.randomUUID().toString())
            .setAccountPublicId(task.accountPublicId)
            .setPublicId(task.publicId.toString())
            .build()

        kafkaTemplate.send("TASK_LIFECYCLE", taskAssignedEvent)

    }
    fun sendTaskCompleted(task: Task) {
        var taskCompletedEvent = TaskCompleted.newBuilder()
            .setEventId(UUID.randomUUID().toString())
            .setAccountPublicId(task.accountPublicId)
            .setPublicId(task.publicId.toString())
            .build()

        kafkaTemplate.send("TASK_LIFECYCLE", taskCompletedEvent)

    }

}