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
        //check if userId is string with number of 10 digits
        if (userId.length() != 10 || !userId.matches("[0-9]+" ) || ticketId.length() != 6 || !ticketId.matches("[0-9]+")){
            throw new NotFoundException("User ID or ticket ID is not valid. Please check your information again.");
        }
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

            //return id of user_ticket
            return userTicket.getId().toString();
        } catch (Exception e){
            throw new NotFoundException("The lottery ticket number " + ticketId + " is not found in our system. Please check your ticket number again.");
        }
   }

    //sell ticket
    @Transactional
    public String sellTicket(String userId, String ticketId) {
        //check if userId is string with number of 10 digits
        if (userId.length() != 10 || !userId.matches("[0-9]+" ) || ticketId.length() != 6 || !ticketId.matches("[0-9]+")){
            throw new NotFoundException("User ID or ticket ID is not valid. Please check your information again.");
        }
        try{
            //check ticket is available and not bought
            List<Lottery> lottery = lotteryRepository.findTicketByUserId(userId);
            if (lottery.isEmpty()){
                throw new NotFoundException("This lottery is not found in your account na krub");
            }
            //check if ticket id is in user's account
            Optional<Lottery> optionalLottery = lottery.stream().filter(l -> l.getTicketId().equals(ticketId)).findFirst();
            if (optionalLottery.isEmpty()){
                throw new NotFoundException("You don't have this lottery ticket in your account na krub. Please check your ticket number again.");
            }

            System.out.println("Found ticket in user's account"+optionalLottery.get().getTicketId());

            //delete ticket
            lotteryRepository.deleteTicketByTicketId(ticketId);

            //record transaction in user_ticket
            UserTicket userTicket = new UserTicket();
            userTicket.setUserId(userId);
            userTicket.setTicketId(ticketId);
            userTicket.setAction("sell");
            userTicketRepository.save(userTicket);

            //return id of user_ticket
            return ticketId;
        } catch (Exception e){
            throw new NotFoundException("Something went wrong while deleting Ticket: " + e.getMessage());
        }
    }


}
