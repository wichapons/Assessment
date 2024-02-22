package com.kbtg.bootcamp.posttest.lottery;

import com.kbtg.bootcamp.posttest.Exception.LotteryException;
import com.kbtg.bootcamp.posttest.Exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public LotterySummaryResponseDto findLotteryByUserId(String userId) {
        try {
            List<Lottery> lotteryList = lotteryRepository.findTicketByUserId(userId);
            LotterySummaryResponseDto summary = new LotterySummaryResponseDto();

            // collect ticket IDs into a list
            List<String> ticketIds = lotteryList.stream()
                    .map(Lottery::getTicketId)
                    .collect(Collectors.toList());
            summary.setTicketId(ticketIds);

            // calculate total amount and price
            int totalAmount = lotteryList.stream()
                    .mapToInt(Lottery::getAmount)
                    .sum();
            summary.setAmount(totalAmount);

            long totalPrice = lotteryList.stream()
                    .mapToLong(Lottery::getPrice)
                    .sum();
            summary.setPrice(totalPrice);

            return summary;
        } catch (Exception e) {
            throw new NotFoundException("Lottery for user: " + userId + " not found" + e.getMessage());
        }
    }


}





