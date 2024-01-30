package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.annotation.SMS;
import com.nhnacademy.edu.springframework.annotation.Type;
import com.nhnacademy.edu.springframework.annotation.TypeName;
import com.nhnacademy.edu.springframework.domain.User;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class MessageSendService {
    private MessageSender messageSender;
    private String phoneNumber;
    @Autowired
    public MessageSendService(@Qualifier("smsMessageSender") MessageSender messageSender, @Value("${number}") String phoneNumber) {
        this.messageSender = messageSender;
        this.phoneNumber = phoneNumber;
    }

    public MessageSendService() {

    }
    public void doSendMessage(User user, String message){
        messageSender.sendMessage(user,message + " " + phoneNumber);
    }
    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
        System.out.println("------------------setter");
    }
}
