package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.domain.User;
import com.nhnacademy.edu.springframework.sender.SmsMessageSender;
import com.nhnacademy.edu.springframework.service.MessageSendService;

public class Main {
    public static void main(String[] args) {
        User user = new User("jongsik2@naver.com", "01027282144");
        new MessageSendService(new SmsMessageSender()).doSendMessage(user, "hi");
    }
}