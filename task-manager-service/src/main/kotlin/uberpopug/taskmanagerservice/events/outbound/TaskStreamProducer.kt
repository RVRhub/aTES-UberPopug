package uberpopug.taskmanagerservice.events.outbound

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import rvr.uberpopug.schemaregistry.UberPopugTopics
import rvr.uberpopug.schemaregistry.avro.taskmanager.v1.StreamEvent
import uberpopug.taskmanagerservice.model.Task

@Component
class TaskStreamProducer(private val kafkaTemplate: KafkaTemplate<String, StreamEvent>) {

    fun sendTaskCreated(content: Task) {
        val taskStreamEvent: StreamEvent = content
            .toTaskStreamEventDto("Created")
        sendMessage(taskStreamEvent.getPublicId(), taskStreamEvent)
    }

    fun sendTaskUpdate(content: Task) {
        val taskStreamEvent: StreamEvent = content
            .toTaskStreamEventDto("Update")
        sendMessage(taskStreamEvent.getPublicId(), taskStreamEvent)
    }

    private fun sendMessage(key: String, event: StreamEvent) {
        kafkaTemplate.send(UberPopugTopics.TASKS_STREAM, key, event)
    }

}