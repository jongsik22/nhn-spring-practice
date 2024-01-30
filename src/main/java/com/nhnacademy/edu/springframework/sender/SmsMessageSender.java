package com.nhnacademy.edu.springframework.sender;

import com.nhnacademy.edu.springframework.domain.User;
import org.springframework.stereotype.Component;

@Component
public class SmsMessageSender implements MessageSender{
    public SmsMessageSender() {
        System.out.println("------------------sms init");
    }

    @Override
    public void sendMessage(User user, String message) {
        System.out.println("sms message sender " + user.getPhoneNumber() + " " + message);
    }

}
