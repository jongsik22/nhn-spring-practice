package com.nhnacademy.edu.springframework.sender;

import com.nhnacademy.edu.springframework.domain.User;

public class EmailMessageSender implements MessageSender{
    public EmailMessageSender() {
        System.out.println("------------------email init");
    }
    void init(){
        System.out.println("------------------email init() method");
    }
    @Override
    public void sendMessage(User user, String message) {
        System.out.println("email message sender " + user.getEmail() + " " + message);
    }
    void cleanup(){
        System.out.println("------------------email cleanup() method");
    }
}
