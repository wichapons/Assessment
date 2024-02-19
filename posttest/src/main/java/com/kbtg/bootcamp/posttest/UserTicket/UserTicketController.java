package com.kbtg.bootcamp.posttest.UserTicket;

import com.kbtg.bootcamp.posttest.lottery.Lottery;
import com.kbtg.bootcamp.posttest.lottery.LotteryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lotteries")
public class UserTicketController {
    private final UserTicketService userTicketService;
    private final LotteryService lotteryService;

    public UserTicketController(UserTicketService userTicketService, LotteryService lotteryService) {
        this.userTicketService = userTicketService;
        this.lotteryService = lotteryService;
    }

    @GetMapping("")
    public List<Lottery> getAllTicket() {
        return lotteryService.findAllLotteries();
    }
}

