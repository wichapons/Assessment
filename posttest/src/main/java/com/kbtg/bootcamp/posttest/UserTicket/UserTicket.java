package com.kbtg.bootcamp.posttest.UserTicket;

import com.kbtg.bootcamp.posttest.lottery.Lottery;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "user_ticket")
public class UserTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long Id;

    @Column(name = "userId", nullable = false, unique = true)
    @Size(min = 10, max = 10)
    private String userId;

    @Column(name = "owned_lottery_number", nullable = false, unique = true)
    @Size(min = 6, max = 6)
    //list of lottery number
    private List<Long> ownedLotteryNumber;
}
