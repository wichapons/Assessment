package com.kbtg.bootcamp.posttest.Admin;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
