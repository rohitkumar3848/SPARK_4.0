package com.cfs.SpringBoot03;

import org.springframework.stereotype.Component;

@Component
public class Notifications {
    private final MsgService emailService;
    Notifications(MsgService emailService) {
        this.emailService = emailService;
    }

    public void notifyMsg(){
            System.out.println(emailService.getMsg());
    }
}
