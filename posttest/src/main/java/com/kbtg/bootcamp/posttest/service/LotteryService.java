package com.kbtg.bootcamp.posttest.service;

import com.kbtg.bootcamp.posttest.exception.LotteryException;
import com.kbtg.bootcamp.posttest.exception.NotFoundException;
import com.kbtg.bootcamp.posttest.repository.LotteryRepository;
import com.kbtg.bootcamp.posttest.dto.request.LotteryRequestDto;
import com.kbtg.bootcamp.posttest.dto.response.LotterySummaryResponseDto;
import com.kbtg.bootcamp.posttest.model.Lottery;
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
        //check if userId is string with number of 10 digits
        if (userId.length() != 10 || !userId.matches("[0-9]+" )){
            throw new NotFoundException("User ID is not valid. Please check your user ID again.");
        }
        try {
            List<Lottery> lotteryList = lotteryRepository.findTicketByUserId(userId);
            LotterySummaryResponseDto summary = new LotterySummaryResponseDto();

            // collect ticket IDs into a list
            List<String> ticketIds = lotteryList.stream()
                    .map(Lottery::getTicketId)
                    .collect(Collectors.toList());
            summary.setTickets(ticketIds);

            // calculate total amount and price
            int totalAmount = lotteryList.stream()
                    .mapToInt(Lottery::getAmount)
                    .sum();
            summary.setCount(totalAmount);

            long totalPrice = lotteryList.stream()
                    .mapToLong(Lottery::getPrice)
                    .sum();
            summary.setCost(totalPrice);

            return summary;
        } catch (Exception e) {
            throw new NotFoundException("Lottery for user: " + userId + " not found" + e.getMessage());
        }
    }


}





