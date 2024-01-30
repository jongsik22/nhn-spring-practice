package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.annotation.SMS;
import com.nhnacademy.edu.springframework.annotation.Type;
import com.nhnacademy.edu.springframework.annotation.TypeName;
import com.nhnacademy.edu.springframework.domain.User;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageSendService {
    MessageSender messageSender;

    public MessageSendService() {

    }
    public void doSendMessage(User user, String message){
        messageSender.sendMessage(user,message);
    }
    @Autowired
    public void setMessageSender(@Type(typeName = TypeName.SMS, dummy = false) MessageSender messageSender) {
        this.messageSender = messageSender;
        System.out.println("------------------setter");
    }
}
