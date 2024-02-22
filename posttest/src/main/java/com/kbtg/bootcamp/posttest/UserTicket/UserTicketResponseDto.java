package com.kbtg.bootcamp.posttest.UserTicket;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserTicketResponseDto {

    private String ticket;
    public UserTicketResponseDto(String ticketId) {
        this.ticket = ticketId;
    }



}
