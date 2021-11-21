package uberpopug.accounting.events.inbound

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import rvr.uberpopug.schemaregistry.UberPopugTopics
import rvr.uberpopug.schemaregistry.avro.account.v1.RoleChanged
import rvr.uberpopug.schemaregistry.avro.account.v1.StreamEvent
import uberpopug.accounting.model.Account
import uberpopug.accounting.repository.AccountRepository


@Service
class AccountConsumerService(private val accountRepository: AccountRepository) {

    @KafkaListener(topics = [UberPopugTopics.ACCOUNTS_STREAM], groupId = "accountingGroup")
    fun createOrUpdateAccount(message: ConsumerRecord<String, StreamEvent>) {
        val accountStreamEvent = message?.value()
        logger.info(String.format("$$$$ => Consumed account stream: %s", accountStreamEvent))
        accountRepository.save(Account(accountStreamEvent?.getPublicId(), accountStreamEvent?.getEmail(), accountStreamEvent?.getRole()))
    }

    @KafkaListener(topics = [UberPopugTopics.ACCOUNTS], groupId = "accountingGroup")
    fun updateRole(message: ConsumerRecord<String, RoleChanged>) {
        val roleChangedEvent = message?.value()
        logger.info(String.format("$$$$ => Consumed role update: %s", roleChangedEvent))
        val account = accountRepository.findAccountByPublicId(roleChangedEvent.getPublicId())
            .ifPresent { account ->
                account.role = roleChangedEvent.getNewRole()
                accountRepository.save(account)
            }
    }

    companion object {
        var logger: Logger = LoggerFactory.getLogger(AccountConsumerService::class.java)
    }
}