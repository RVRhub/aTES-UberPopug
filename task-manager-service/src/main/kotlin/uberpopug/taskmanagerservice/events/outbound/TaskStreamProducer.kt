package uberpopug.taskmanagerservice.events.outbound

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import rvr.uberpopug.schemaregistry.taskmanager.v1.StreamEvent
import uberpopug.taskmanagerservice.model.Task

@Component
class TaskStreamProducer(private val kafkaTemplate: KafkaTemplate<String, StreamEvent>) {

    fun sendAccountCreated(content: Task) {
        val taskStreamEvent: StreamEvent = content
            .toTaskStreamEventDto("Created")
        sendMessage(taskStreamEvent.getPublicId(), taskStreamEvent)
    }

    fun updateAccount(content: Task) {
        val taskStreamEvent: StreamEvent = content
            .toTaskStreamEventDto("Update")
        sendMessage(taskStreamEvent.getPublicId(), taskStreamEvent)
    }

    private fun sendMessage(key: String, event: StreamEvent) {
        kafkaTemplate.send("TASKS_STREAM", key, event)
    }

}