    package com.cfs.SpringBoot03;

    import org.springframework.stereotype.Service;

    @Service
    public class EmailService implements MsgService {
        @Override
        public String getMsg() {
            return "Email Msg";
        }
    }
