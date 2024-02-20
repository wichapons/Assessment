package com.kbtg.bootcamp.posttest.lottery;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LotteryResponseDto {
    private String ticket;

    public LotteryResponseDto(String lotteryNumber) {
        this.ticket = lotteryNumber;
    }

}
