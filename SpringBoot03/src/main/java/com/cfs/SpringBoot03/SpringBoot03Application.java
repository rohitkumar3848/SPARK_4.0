package com.cfs.SpringBoot03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringBoot03Application implements CommandLineRunner {

    //This automatically inject dependency bcz we used constructor here.
    private final Notifications notifications;

    public SpringBoot03Application(Notifications notifications) {
        this.notifications = notifications;
    }

    public static void main(String[] args) {

        SpringApplication.run(SpringBoot03Application.class, args);

    }

    public void run(String... args) throws Exception {
        notifications.notifyMsg();
    }

}
