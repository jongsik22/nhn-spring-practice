package com.nhnacademy.edu.springframework.config;

import com.nhnacademy.edu.springframework.sender.MessageSender;
import com.nhnacademy.edu.springframework.sender.SmsMessageSender;
import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
@Configuration
@PropertySource("classpath:number.properties")
@ComponentScan(basePackages = "com.nhnacademy.edu.springframework")
@EnableAspectJAutoProxy
public class MainConfig {
    private MessageSender smsMessageSender;
    private String number;

    public MainConfig(@Qualifier("smsMessageSender") MessageSender smsMessageSender, @Value("${number}") String number) {
        this.smsMessageSender = smsMessageSender;
        this.number = number;
    }

    @Bean
    public MessageSendService messageSendService(){
        return new MessageSendService(smsMessageSender);
    }
    @Bean
    public MessageSendService messageSendService2(){
        return new MessageSendService(smsMessageSender, number);
    }
}
