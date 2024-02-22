package com.kbtg.bootcamp.posttest.lottery;

import com.kbtg.bootcamp.posttest.Exception.LotteryException;
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
            throw new LotteryException("Duplicate lottery ticket, please add another ticket number.");
        }
    }

    //findLotteryById
    public Lottery findLotteryById(String id) {
        try {
            return lotteryRepository.findByTicketId(id);
        } catch (Exception e) {
            throw new NotFoundException("Lottery " + id + " not found");
        }
    }

    //findLotteryByUserId
    public List<String> findLotteryByUserId(String userId) {
        try {
            return lotteryRepository.findOnlyTicketByUserId(userId);
        } catch (Exception e) {
            throw new NotFoundException("Lottery for user: " + userId + " not found" + e.getMessage());
        }
    }


}





