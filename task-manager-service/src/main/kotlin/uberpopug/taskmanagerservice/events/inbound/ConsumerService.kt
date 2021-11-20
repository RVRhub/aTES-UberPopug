package uberpopug.taskmanagerservice.events.inbound

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import rvr.uberpopug.schemaregistry.account.v1.RoleChanged
import rvr.uberpopug.schemaregistry.account.v1.StreamEvent
import uberpopug.taskmanagerservice.model.Account
import uberpopug.taskmanagerservice.repository.AccountRepository


@Service
class ConsumerService(private val accountRepository: AccountRepository) {

    @KafkaListener(topics = ["ACCOUNTS_STREAM"], groupId = "group_id")
    fun createOrUpdateAccount(message: ConsumerRecord<String, StreamEvent>) {
        val accountStreamEvent = message?.value()
        logger.info(String.format("$$$$ => Consumed account stream: %s", accountStreamEvent))
        accountRepository.save(Account(accountStreamEvent?.getPublicId(), accountStreamEvent?.getEmail(), accountStreamEvent?.getRole()))
    }

    @KafkaListener(topics = ["ACCOUNTS"], groupId = "group_id")
    fun updateRole(message: ConsumerRecord<String, RoleChanged>) {
        val roleChangedEvent = message?.value()
        logger.info(String.format("$$$$ => Consumed role update: %s", roleChangedEvent))
        val account = accountRepository.findByPublicId(roleChangedEvent.getPublicId())
        if (account != null) {
            account.role = roleChangedEvent.getNewRole()
            accountRepository.save(account)
        }
    }

    companion object {
        var logger: Logger = LoggerFactory.getLogger(ConsumerService::class.java)
    }
}