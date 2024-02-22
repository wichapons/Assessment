package com.kbtg.bootcamp.posttest.UserTicket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTicketResponseDto {

    private String ticketId;
    public UserTicketResponseDto(String ticketId) {
        this.ticketId = ticketId;
    }
}
