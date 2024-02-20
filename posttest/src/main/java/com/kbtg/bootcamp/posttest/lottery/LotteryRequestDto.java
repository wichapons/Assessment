package com.kbtg.bootcamp.posttest.lottery;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LotteryRequestDto {
    @NotNull
    @Size(min = 6, max = 6)
    private String ticket;

    @NotNull
    private Long price;

    @NotNull
    @Min(1)
    @Max(1)
    private int amount;

}
