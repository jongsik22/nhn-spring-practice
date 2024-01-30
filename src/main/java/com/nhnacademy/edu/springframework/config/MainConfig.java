package com.nhnacademy.edu.springframework.config;

import com.nhnacademy.edu.springframework.sender.MessageSender;
import com.nhnacademy.edu.springframework.sender.SmsMessageSender;
import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/beans.xml")
public class MainConfig {
    @Autowired
    private SenderConfig senderConfig;

    @Value("${number}")
    private String number;

    @Bean
    public MessageSendService messageSendService(){
        return new MessageSendService(senderConfig.smsMessageSender());
    }
    @Bean
    public MessageSendService messageSendService2(){
        return new MessageSendService(senderConfig.smsMessageSender(), number);
    }
}
