package com.kbtg.bootcamp.posttest.dto.response;

import com.kbtg.bootcamp.posttest.model.Lottery;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LotteryListWithAmountResponseDto {

    private List<Lottery> tickets;
    private int amount;
    private Long price;
    public LotteryListWithAmountResponseDto(List<Lottery> tickets, int amount, Long price) {
        this.tickets = tickets;
        this.amount = amount;
        this.price = price;
    }

}
