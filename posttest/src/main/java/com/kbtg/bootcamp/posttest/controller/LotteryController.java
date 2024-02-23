package com.kbtg.bootcamp.posttest.controller;

import com.kbtg.bootcamp.posttest.dto.request.LotteryRequestDto;
import com.kbtg.bootcamp.posttest.dto.response.LotteryListResponseDto;
import com.kbtg.bootcamp.posttest.dto.response.LotteryResponseDto;
import com.kbtg.bootcamp.posttest.dto.response.LotterySummaryResponseDto;
import com.kbtg.bootcamp.posttest.service.LotteryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("")
public class LotteryController {
    private final LotteryService lotteryService;

    public LotteryController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }

    @GetMapping("/lotteries")
    public Object getAllLotteries() {
        List<String> lotteryList = lotteryService.findAllLotteries();
        return new LotteryListResponseDto(lotteryList);
    }

    @PostMapping("/admin/lotteries")
    public LotteryResponseDto createLottery(@Valid @RequestBody LotteryRequestDto request)throws Exception {
        String lotteryNumber = lotteryService.createLottery(request);
        return new LotteryResponseDto(lotteryNumber);
    }

    @GetMapping("/users/{userId}/lotteries")
    public LotterySummaryResponseDto getLotteryByUserId(@Valid @PathVariable String userId) {
        //System.out.println(" UserId: " + userId + " has been found");
        return lotteryService.findLotteryByUserId(userId);
    }
}
