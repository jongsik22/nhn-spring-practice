package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.domain.User;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import com.nhnacademy.edu.springframework.sender.SmsMessageSender;
import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        User user = new User("jongsik2@naver.com", "01027282144");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
            new MessageSendService(context.getBean("smsMessageSender", MessageSender.class)).doSendMessage(user, "hi");
            new MessageSendService(context.getBean("emailMessageSender", MessageSender.class)).doSendMessage(user, "hi");
        }
    }
}