package com.kbtg.bootcamp.posttest.userTicket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTicketResponseDto {

    private String ticket;
    public UserTicketResponseDto(String ticketId) {
        this.ticket = ticketId;
    }



}
