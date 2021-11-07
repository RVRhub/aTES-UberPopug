package com.auth.service.events;

import com.auth.service.dto.request.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class AccountStreamProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendAccountCreated(AccountDto content) {
		this.sendMessage("AccountCreated");
	}

	public void updateAccount(AccountDto content) {
		this.sendMessage("AccountUpdate");
	}

	public void deleteAccount(AccountDto content) {
		this.sendMessage("AccountDeleted");
	}

	private void sendMessage(String msg) {
		kafkaTemplate.send("ACCOUNTS_STREAM", "one",  msg);
	}

}
