package com.nhnacademy.edu.springframework.sender;

import com.nhnacademy.edu.springframework.domain.User;

public class EmailMessageSender implements MessageSender{
    public EmailMessageSender() {
        System.out.println("------------------email init");
    }

    @Override
    public void sendMessage(User user, String message) {
        System.out.println("email message sender " + user.getEmail() + " " + message);
    }
}
