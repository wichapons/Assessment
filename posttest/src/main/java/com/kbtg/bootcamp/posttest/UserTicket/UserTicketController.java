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

    @GetMapping("/lotteries")
    public List<Lottery> getAllTicket() {
        return lotteryService.findAllLotteries();
    }

    @PostMapping("/users/:userId/lotteries/:ticketId")
    public String buyTicket(@Valid @RequestParam String userId, @Valid @RequestParam String ticketId) {
        
        return "User's lottery tickets";
    }

}

