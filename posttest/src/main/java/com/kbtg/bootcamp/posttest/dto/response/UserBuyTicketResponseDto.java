package com.kbtg.bootcamp.posttest.userTicket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBuyTicketResponseDto {
    private String id;
    public UserBuyTicketResponseDto(String ticketId) {

        this.id = ticketId;
    }
}
