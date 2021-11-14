package uberpopug.taskmanagerservice.events.inbound

import com.auth.service.events.outbound.AccountStreamEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import uberpopug.taskmanagerservice.model.Account
import uberpopug.taskmanagerservice.repository.AccountRepository


@Service
class ConsumerService(private val accountRepository: AccountRepository) {

    @KafkaListener(topics = ["ACCOUNTS_STREAM"], groupId = "group_id")
    fun consume(message: AccountStreamEvent?) {
        logger.info(String.format("$$$$ => Consumed message: %s", message))
        accountRepository.save(Account(message?.publicId, message?.email, null))
    }

    companion object {
        var logger: Logger = LoggerFactory.getLogger(ConsumerService::class.java)
    }
}