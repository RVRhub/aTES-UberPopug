package com.auth.service.events.outbound;

import com.auth.service.dto.request.AccountDto;
import com.auth.service.model.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AccountStreamProducer {

	@Autowired
	private KafkaTemplate<String, AccountStreamEvent> kafkaTemplate;

	public void sendAccountCreated(AccountEntity content) {
		AccountStreamEvent accountStreamEvent = content.toAccountStreamEventDto();
		accountStreamEvent.setEventName("AccountCreated");
		this.sendMessage(content.getId(), accountStreamEvent);
	}

	public void updateAccount(AccountEntity content) {
		AccountStreamEvent accountStreamEvent = content.toAccountStreamEventDto();
		accountStreamEvent.setEventName("AccountUpdate");
		this.sendMessage(content.getId(), accountStreamEvent);
	}

	public void deleteAccount(AccountEntity content) {
		AccountStreamEvent accountStreamEvent = content.toAccountStreamEventDto();
		accountStreamEvent.setEventName("AccountDeleted");
		this.sendMessage(content.getId(), accountStreamEvent);
	}

	private void sendMessage(UUID key, AccountStreamEvent event) {
		kafkaTemplate.send("ACCOUNTS_STREAM", key.toString(), event);
	}

}
