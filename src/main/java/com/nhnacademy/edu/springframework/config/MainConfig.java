package com.nhnacademy.edu.springframework.config;

import com.nhnacademy.edu.springframework.sender.MessageSender;
import com.nhnacademy.edu.springframework.sender.SmsMessageSender;
import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/beans.xml")
public class MainConfig {
    @Bean
    public MessageSender smsMessageSender(){
        return new SmsMessageSender();
    }

    @Bean
    public MessageSendService messageSendService(){
        return new MessageSendService(smsMessageSender());
    }
    @Bean
    public MessageSendService messageSendService2(){
        return new MessageSendService(smsMessageSender(), "01027282144");
    }
}
