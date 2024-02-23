package com.kbtg.bootcamp.posttest.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LotteryRequestDto {

    @Size(min = 6, max = 6)
    private String ticket;

    private Long price;

    @Min(1)
    @Max(1)
    private int amount;

    @Size(min = 10, max = 10)
    private String userId;

}
