package com.cfs.SpringSecurity03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping("/balance")
    public String getBalance(){
        return bankService.getBalance();
    }

    @GetMapping("/close")
    public String closeAccount(){
        return bankService.closeAccount();
    }

    @GetMapping("/publicMethod")
    public String publicMethod(){
        return bankService.publicMethod();
    }
}
