package com.kbtg.bootcamp.posttest.UserTicket;

import com.kbtg.bootcamp.posttest.lottery.Lottery;
import com.kbtg.bootcamp.posttest.lottery.LotteryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/lotteries")
public class UserTicketController {
    private final UserTicketService userTicketService;
    private final LotteryService lotteryService;

    public UserTicketController(UserTicketService userTicketService, LotteryService lotteryService) {
        this.userTicketService = userTicketService;
        this.lotteryService = lotteryService;
    }



    @PostMapping("/users/{userId}/lotteries/{ticketId}")
    public String buyTicket(@Valid @PathVariable  String userId, @Valid @PathVariable String ticketId) {
        
        return "User's lottery tickets ID: " + ticketId + " has been bought by user ID: " + userId;
    }

}

