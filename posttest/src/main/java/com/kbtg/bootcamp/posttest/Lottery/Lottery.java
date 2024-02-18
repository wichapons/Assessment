package com.kbtg.bootcamp.posttest.Lottery;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "lottery")
public class Lottery {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lottery_number", nullable = false, unique = true)
    @Size(min = 6, max = 6)
    private Long lotteryNumber;

    @Column(name = "is_active", nullable = false, columnDefinition = "boolean default true")
    private Boolean isActive;

}
