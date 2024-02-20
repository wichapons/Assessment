package com.kbtg.bootcamp.posttest.lottery;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/lotteries")
public class LotteryController {
    private final LotteryService lotteryService;

    public LotteryController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }

    @GetMapping("")
    public List<Lottery> getAllLotteries() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        return lotteryService.findAllLotteries();
    }

    @PostMapping("")
    public Lottery createLottery( @Valid @RequestBody LotteryRequestDto request)throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        System.out.println("Got create request");


        return lotteryService.createLottery(request);
    }

    @GetMapping("/{id}")
    public Lottery getLotteryById(@PathVariable Long id) {
        return lotteryService.findLotteryById(id);
    }

}
