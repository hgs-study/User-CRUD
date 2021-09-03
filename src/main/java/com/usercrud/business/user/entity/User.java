package com.usercrud.business.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Builder
    private User(Long id,String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public void updatePassword(String password){
        this.password = password;
    }
}
