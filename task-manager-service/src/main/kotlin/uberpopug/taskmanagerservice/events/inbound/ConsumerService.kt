package uberpopug.taskmanagerservice.events.inbound

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import rvr.uberpopug.schemaregistry.AccountStreamEvent
import uberpopug.taskmanagerservice.model.Account
import uberpopug.taskmanagerservice.repository.AccountRepository


@Service
class ConsumerService(private val accountRepository: AccountRepository) {

    @KafkaListener(topics = ["ACCOUNTS_STREAM"], groupId = "group_id")
    fun consume(message: ConsumerRecord<String, AccountStreamEvent>) {
        val accountStreamEvent = message?.value()
        logger.info(String.format("$$$$ => Consumed message: %s", accountStreamEvent))
        accountRepository.save(Account(accountStreamEvent?.getPublicId(), accountStreamEvent?.getEmail(), null))
    }

    companion object {
        var logger: Logger = LoggerFactory.getLogger(ConsumerService::class.java)
    }
}