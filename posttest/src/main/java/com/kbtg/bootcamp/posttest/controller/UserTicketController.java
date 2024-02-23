package com.kbtg.bootcamp.posttest.controller;

import com.kbtg.bootcamp.posttest.dto.response.UserBuyTicketResponseDto;
import com.kbtg.bootcamp.posttest.service.LotteryService;
import com.kbtg.bootcamp.posttest.dto.response.UserTicketResponseDto;
import com.kbtg.bootcamp.posttest.service.UserTicketService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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
    public UserBuyTicketResponseDto buyTicket(@Valid @PathVariable  String userId, @Valid @PathVariable String ticketId) {
        return new UserBuyTicketResponseDto(userTicketService.buyTicket(userId, ticketId));
    }

    @DeleteMapping ("/users/{userId}/lotteries/{ticketId}")
    public UserTicketResponseDto sellTicket(@Valid @PathVariable  String userId, @Valid @PathVariable String ticketId) {
        return new UserTicketResponseDto(userTicketService.sellTicket(userId, ticketId));

    }

}

