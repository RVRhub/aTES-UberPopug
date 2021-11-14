package com.auth.service.events.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class AccountProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void createAccount(String content) {
		this.sendMessage("AccountRoleUpdated");
	}

	private void sendMessage(String msg) {
		kafkaTemplate.send("ACCOUNTS", msg);
	}

}
