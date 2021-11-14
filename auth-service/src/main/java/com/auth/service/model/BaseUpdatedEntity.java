package com.auth.service.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.MappedSuperclass;
import java.time.Instant;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public class BaseUpdatedEntity extends BaseCreatedEntity {

	@UpdateTimestamp
	private Instant updateTime;
}
