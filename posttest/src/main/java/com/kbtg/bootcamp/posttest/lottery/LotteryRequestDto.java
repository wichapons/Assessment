package com.kbtg.bootcamp.posttest.lottery;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
