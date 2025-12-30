package com.cfs.SpringSecurity03;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    @PreAuthorize("hasRole('USER')")
    public String getBalance(){
        return "Your balance is 10k";
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String closeAccount(){
        return "Your account has been closed";
    }

    public String publicMethod(){
        return "Public account";
    }
}
