package com.kbtg.bootcamp.posttest.UserTicket;

import com.kbtg.bootcamp.posttest.Exception.NotFoundException;
import com.kbtg.bootcamp.posttest.lottery.Lottery;
import com.kbtg.bootcamp.posttest.lottery.LotteryRepository;
import com.kbtg.bootcamp.posttest.lottery.LotteryService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserTicketService {
    private final UserTicketRepository userTicketRepository;
    private final LotteryService lotteryService;

    private final LotteryRepository lotteryRepository;

    public UserTicketService(UserTicketRepository userTicketRepository, LotteryService lotteryService, LotteryRepository lotteryRepository) {
        this.userTicketRepository = userTicketRepository;
        this.lotteryService = lotteryService;
        this.lotteryRepository = lotteryRepository;
    }

    //buy ticket
    @Transactional
   public String buyTicket(String userId, String ticketId) {
        try{
            //check ticket is available and not bought
            Lottery optionalLottery = lotteryService.findLotteryById(ticketId);
            if (optionalLottery.isSold() == true){
                throw new NotFoundException("This lottery is already sold out");
            }
            //update ticket to sold
            Lottery lottery = optionalLottery;
            lottery.setSold(true);
            lottery.setUserId(userId);
            lotteryRepository.save(lottery);

            //record transaction in user_ticket
            UserTicket userTicket = new UserTicket();
            userTicket.setUserId(userId);
            userTicket.setTicketId(ticketId);
            userTicket.setAction("buy");
            userTicketRepository.save(userTicket);

            System.out.println("user_ticket is saved, " + userTicket.getId());
            System.out.println("user_ticket is saved, " + userTicket.getId().toString());
            //return id of user_ticket
            return userTicket.getId().toString();
        } catch (Exception e){
            throw new NotFoundException("The lottery ticket number " + ticketId + " is not found in our system. Please check your ticket number again.");
        }



   }

}
