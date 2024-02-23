package com.kbtg.bootcamp.posttest.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LotteryListResponseDto {
    private List<String> tickets;

    public LotteryListResponseDto(List<String> lotteryNumbers) {
        this.tickets = lotteryNumbers;
    }

}
