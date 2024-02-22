package com.kbtg.bootcamp.posttest.lottery;

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
