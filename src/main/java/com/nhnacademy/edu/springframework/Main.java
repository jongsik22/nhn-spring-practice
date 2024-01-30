package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.domain.User;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import com.nhnacademy.edu.springframework.sender.SmsMessageSender;
import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        User user = new User("jongsik2@naver.com", "01027282144");
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.nhnacademy.edu.springframework")) {
            context.getBean("messageSendService", MessageSendService.class).doSendMessage(user, "hi");
            context.getBean("messageSendService2", MessageSendService.class).doSendMessage(user, "hi");
        }
    }
}