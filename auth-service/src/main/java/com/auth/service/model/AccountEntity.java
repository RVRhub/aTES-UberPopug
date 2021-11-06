package com.auth.service.model;

import com.auth.service.dto.request.UpdateAccountRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity extends BaseUpdatedEntity {

    @Column(unique = true)
    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private Role role;

    public boolean update(UpdateAccountRequest request) {
        boolean updated = false;
        if (!StringUtils.isEmpty(request.getFirstName()) && !request.getFirstName().equals(firstName)) {
            this.firstName = request.getFirstName();
            updated = true;
        }
        if (!StringUtils.isEmpty(request.getLastName()) && !request.getLastName().equals(lastName)) {
            this.lastName = request.getLastName();
            updated = true;
        }
        if (!StringUtils.isEmpty(request.getEmail()) && !request.getEmail().equals(email)) {
            this.email = request.getEmail();
            updated = true;
        }
        return updated;
    }

    public enum Role {
        ADMIN,
        MANAGER,
        DEVELOPER,
        ACCOUNTANT
    }
}
