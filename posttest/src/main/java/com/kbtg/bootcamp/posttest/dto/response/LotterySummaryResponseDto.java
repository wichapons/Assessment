package com.kbtg.bootcamp.posttest.lottery;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LotterySummaryResponseDto {
    private List<String> tickets;
    private int count;
    private Long cost;
}
