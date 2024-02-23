package com.kbtg.bootcamp.posttest.userTicket;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTicketRequestDto {
    @Size(min = 10, max = 10, message = "User id length should be 10 characters")
    private String userId;
    @Size(min = 10, max = 10, message = "Ticket id length should be 10 characters")
    private String ticketId;

    public UserTicketRequestDto(String userId, String ticketId) {
        this.userId = userId;
        this.ticketId = ticketId;
    }


}
