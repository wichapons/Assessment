package com.kbtg.bootcamp.posttest.lottery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LotteryRepository extends JpaRepository<Lottery, Long> {
    @Query(value = "SELECT lottery.ticket_id FROM lottery WHERE lottery.is_sold = FALSE", nativeQuery = true)
    public List<String> findAvailableTicket();

    // Btw if you read this msg I already tried "findByIsSoldFalse()" but it didn't work krub Ajarn TT"

    @Query(value = "SELECT * FROM lottery WHERE lottery.ticket_id = ?1", nativeQuery = true)
    public Lottery findByTicketId(String id);

    //find ticket by user id
    @Query(value = "SELECT * FROM lottery WHERE lottery.owner_user_id = ?1", nativeQuery = true)
    public List<Lottery> findTicketByUserId(String userId);

    //delete ticket by ticket id
    @Query(value = "DELETE FROM lottery WHERE lottery.ticket_id = ?1", nativeQuery = true)
    @Modifying
    public void deleteTicketByTicketId(String ticketId);

    //find only ticket by user id
    @Query(value = "SELECT l.ticket_id,l.amount,l.price FROM lottery l WHERE lottery.owner_user_id = ?1", nativeQuery = true)
    public List<Lottery> findOnlyTicketByUserId(String userId);


}


