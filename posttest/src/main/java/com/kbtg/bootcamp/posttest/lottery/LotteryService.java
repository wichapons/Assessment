package com.kbtg.bootcamp.posttest.lottery;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryService {
    private final LotteryRepository lotteryRepository;

    public LotteryService(LotteryRepository lotteryRepository) {
        this.lotteryRepository = lotteryRepository;
    }

    public List<Lottery> findAllLotteries() {
        return lotteryRepository.findAll();
    }
    public  Lottery createLottery(LotteryRequestDto request) {
        Lottery lottery = new Lottery();
        lottery.setLotteryNumber(request.getTicket());
        lottery.setPrice(request.getPrice());
        lottery.setAmount(request.getAmount());
        return lotteryRepository.save(lottery);
    }
}





