package com.kbtg.bootcamp.posttest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

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

    @Column(name = "action", nullable = false, unique = false)
    private String action;

//    @ManyToOne
//    @JoinColumn(name = "ticketId", referencedColumnName = "ticket_id", insertable = false, updatable = false)
//    private Lottery lottery;

}
