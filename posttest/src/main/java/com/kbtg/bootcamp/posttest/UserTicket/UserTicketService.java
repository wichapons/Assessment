package com.kbtg.bootcamp.posttest.UserTicket;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTicketService {
    private final UserTicketRepository userTicketRepository;

    public UserTicketService(UserTicketRepository userTicketRepository) {
        this.userTicketRepository = userTicketRepository;

    }

    //buy ticket
//    public UserTicketResponseDto buyTicket(UserTicketRequestDto request) {
//        UserTicket userTicket = new UserTicket(request.getTicketId());
//        userTicketRepository.save(userTicket);
//
//    }

}
