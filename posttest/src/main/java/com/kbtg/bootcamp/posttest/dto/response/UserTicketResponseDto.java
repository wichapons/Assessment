package com.kbtg.bootcamp.posttest.dto.response;

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
