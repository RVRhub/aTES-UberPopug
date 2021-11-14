package com.auth.service.events.outbound;

import com.auth.service.model.AccountEntity;
import rvr.uberpopug.schemaregistry.AccountStreamEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AccountStreamProducer {

	@Autowired
	private KafkaTemplate<String, AccountStreamEvent> kafkaTemplate;

	public void sendAccountCreated(AccountEntity content) {
		AccountStreamEvent accountStreamEvent = content
				.toAccountStreamEventDto("AccountCreated");
		this.sendMessage(content.getId(), accountStreamEvent);
	}

	public void updateAccount(AccountEntity content) {
		AccountStreamEvent accountStreamEvent = content
				.toAccountStreamEventDto("AccountUpdate");
		this.sendMessage(content.getId(), accountStreamEvent);
	}

	public void deleteAccount(AccountEntity content) {
		AccountStreamEvent accountStreamEvent = content
				.toAccountStreamEventDto("AccountDeleted");
		this.sendMessage(content.getId(), accountStreamEvent);
	}

	private void sendMessage(UUID key, AccountStreamEvent event) {
		kafkaTemplate.send("ACCOUNTS_STREAM", key.toString(), event);
	}

}
