package com.kbtg.bootcamp.posttest.dto.response;

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
