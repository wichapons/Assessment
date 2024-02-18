package com.kbtg.bootcamp.posttest.admin;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @GetMapping("/lotteries")
    public String getTicket() {

        return "Admin manage tickets";
    }

    @PostMapping("/lotteries")
    public String createLottery() {


        return "Admin create lottery";
    }

    
}
