package com.auth.service.dto.request;


import com.auth.service.model.AccountEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    @Email
    @NotNull
    private String email;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Length(min = 4, max = 9)
    private String password;

    public AccountEntity toAccountEntity(){
        return AccountEntity.builder()
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .password(password)
                .role(AccountEntity.Role.DEVELOPER)
                .build();
    }

}
