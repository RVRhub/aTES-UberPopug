package uberpopug.taskmanagerservice.events.outbound

import org.apache.avro.specific.SpecificRecord
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import rvr.uberpopug.schemaregistry.UberPopugTopics
import rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle
import uberpopug.taskmanagerservice.model.Task
import java.util.*


@Component
class TaskLifecycleEventProducer(private val kafkaTemplate: KafkaTemplate<String, SpecificRecord>) {

    fun sendTaskAssigned(task: Task) {
        var taskAssignedEvent = TaskLifecycle.newBuilder()
            .setEventId(UUID.randomUUID().toString())
            .setEventName("Assigned")
            .setAccountPublicId(task.accountPublicId)
            .setPublicId(task.publicId.toString())
            .build()

        kafkaTemplate.send(UberPopugTopics.TASK_LIFECYCLE, taskAssignedEvent)

    }
    fun sendTaskCompleted(task: Task) {
        var taskCompletedEvent = TaskLifecycle.newBuilder()
            .setEventId(UUID.randomUUID().toString())
            .setEventName("Completed")
            .setAccountPublicId(task.accountPublicId)
            .setPublicId(task.publicId.toString())
            .build()

        kafkaTemplate.send(UberPopugTopics.TASK_LIFECYCLE, taskCompletedEvent)

    }

    @Bean
    fun taskLifeCycleTopic(): NewTopic? {
        return NewTopic(UberPopugTopics.TASK_LIFECYCLE, 2, 1.toShort())
    }


}