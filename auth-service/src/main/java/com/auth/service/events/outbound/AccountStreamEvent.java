package com.auth.service.events.outbound;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountStreamEvent {
	private String publicId;
	private String firstName;
	private String lastName;
	private String email;
	private String eventName;
}


