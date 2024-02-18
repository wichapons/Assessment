package com.kbtg.bootcamp.posttest.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user_ticket")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long Id;

    @Column(name = "username", nullable = false, unique = true,length = 20)
    private String username;

    @Column(name = "userId", nullable = false, unique = true)
    @Size(min = 10, max = 10)
    private String userId;

}
