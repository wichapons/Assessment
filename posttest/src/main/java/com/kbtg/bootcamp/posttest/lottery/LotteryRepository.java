package com.kbtg.bootcamp.posttest.lottery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LotteryRepository extends JpaRepository<Lottery, Long> {
    @Query(value = "SELECT lottery.ticket_id FROM lottery WHERE lottery.is_sold = FALSE", nativeQuery = true)
    public List<String> findAvailableTicket();
    // Btw if you read this msg I already tried "findByIsSoldFalse()" but it didn't work krub Ajarn TT"
}


