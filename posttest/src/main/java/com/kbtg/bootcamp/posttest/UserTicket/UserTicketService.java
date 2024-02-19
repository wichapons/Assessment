package com.kbtg.bootcamp.posttest.UserTicket;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTicketService {
    private final UserTicketRepository userTicketRepository;

    public UserTicketService(UserTicketRepository userTicketRepository) {
        this.userTicketRepository = userTicketRepository;
    }

    public List<UserTicket> getAllUserTicket() {
        return userTicketRepository.findAll();
    }

}
