package com.kbtg.bootcamp.posttest.UserTicket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lotteries")
public class UserTicketController {
    private final UserTicketService userTicketService;

    public UserTicketController(UserTicketService userTicketService) {
        this.userTicketService = userTicketService;
    }

    @GetMapping("")
    public List<UserTicket> getTicket() {
        return userTicketService.getAllUserTicket();
    }
}

