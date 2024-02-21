package com.kbtg.bootcamp.posttest.UserTicket;

import com.kbtg.bootcamp.posttest.lottery.Lottery;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "user_ticket")
public class UserTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "timestamp", nullable = false)
    private Timestamp timestamp = Timestamp.valueOf(ZonedDateTime.now().toLocalDateTime());


    @Column(name = "userId", nullable = false, unique = false, length = 10)
    @Size(min = 10, max = 10)
    private String userId;

    @Column(name = "ticketId", nullable = false, unique = false, length = 6)
    @Size(min = 6, max = 6)
    private String ticketId;

}
