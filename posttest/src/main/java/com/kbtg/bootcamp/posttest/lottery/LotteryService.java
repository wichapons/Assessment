package com.kbtg.bootcamp.posttest.lottery;

import com.kbtg.bootcamp.posttest.Exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LotteryService {
    private final LotteryRepository lotteryRepository;

    public LotteryService(LotteryRepository lotteryRepository) {
        this.lotteryRepository = lotteryRepository;
    }

    public List<String> findAllLotteries() {
        return lotteryRepository.findAvailableTicket();
    }

    @Transactional
    public String createLottery(LotteryRequestDto request) {
        try {
            Lottery lottery = new Lottery();
            lottery.setLotteryNumber(request.getTicket());
            lottery.setPrice(request.getPrice());
            lottery.setAmount(request.getAmount());
            lotteryRepository.save(lottery);
            return lottery.getLotteryNumber();

        } catch (Exception e) {
            throw new NotFoundException("An error occurred while creating lottery");
        }
    }

    public Lottery findLotteryById(Long id) {
        return lotteryRepository.findById(id).orElseThrow(() -> new NotFoundException("Lottery not found"));
    }

    //public List<Lottery> findLotteryBy


}





