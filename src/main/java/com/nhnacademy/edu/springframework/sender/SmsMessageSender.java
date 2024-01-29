package com.nhnacademy.edu.springframework.sender;

import com.nhnacademy.edu.springframework.domain.User;

public class SmsMessageSender implements MessageSender{
    public SmsMessageSender() {
        System.out.println("------------------sms init");
    }
    void init(){
        System.out.println("------------------sms init() method");
    }
    @Override
    public void sendMessage(User user, String message) {
        System.out.println("sms message sender " + user.getPhoneNumber() + " " + message);
    }
    void cleanup(){
        System.out.println("------------------sms cleanup() method");
    }
}
