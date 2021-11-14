//package com.auth.service.model;
//
//import lombok.*;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import java.util.Objects;
//import java.util.UUID;
//
//@Data
//@Entity
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(callSuper = true)
//public class AccessRequestEntity  extends BaseUpdatedEntity {
//
//    @Column(nullable = false)
//    private String email;
//
//    private String firstName;
//
//    private String lastName;
//
//    @Column (nullable = false)
//    private String password;
//
//    private UUID publicId;
//
//    @ManyToOne
//    @JoinColumn(name = "account_id")
//    private AccountEntity account;
//
//    private Integer referId;
//
//    public boolean isConfirmed() {
//        return Objects.nonNull(account);
//    }
//
//    public AccountEntity toAccountEntity(){
//        return AccountEntity.builder()
//                .email(email)
//                .firstName(firstName)
//                .lastName(lastName)
//                .password(password)
//                .build();
//    }
//}
