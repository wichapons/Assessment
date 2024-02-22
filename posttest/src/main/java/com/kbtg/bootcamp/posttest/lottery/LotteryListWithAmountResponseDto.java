package com.kbtg.bootcamp.posttest.lottery;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LotteryListWithAmountResponseDto {

    //List of tickets
    private List<String> tickets;
    public LotteryListWithAmountResponseDto(List<String> tickets) {
        this.tickets = tickets;
    }
}
