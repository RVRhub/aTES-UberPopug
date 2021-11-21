package com.auth.service.events.outbound;

import java.util.UUID;

import com.auth.service.model.AccountEntity;
import rvr.uberpopug.schemaregistry.UberPopugTopics;
import rvr.uberpopug.schemaregistry.avro.account.v1.RoleChanged;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class AccountProducer {

	@Autowired
	private KafkaTemplate<String, RoleChanged> kafkaTemplate;

	public void roleChanged(AccountEntity content) {
		RoleChanged roleChangedEvent = RoleChanged.newBuilder()
				.setPublicId(content.toString())
				.setNewRole(content.getRole().toString())
				.setEventId(UUID.randomUUID().toString())
				.build();
		this.sendMessage(roleChangedEvent);
	}

	private void sendMessage(RoleChanged event) {
		kafkaTemplate.send(UberPopugTopics.ACCOUNTS, event);
	}

}
