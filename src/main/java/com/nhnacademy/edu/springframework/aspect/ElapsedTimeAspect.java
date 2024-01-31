package com.nhnacademy.edu.springframework.aspect;

import com.nhnacademy.edu.springframework.domain.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class ElapsedTimeAspect {
    @Pointcut("execution(* com.nhnacademy.edu.springframework.sender.*MessageSender.sendMessage(..)) && args(user, ..)")
    private void anyMessageSender(User user){}

    @Around("anyMessageSender(user)")
    private Object elapsedTime(ProceedingJoinPoint pjp, User user) throws Throwable {
        StopWatch stopWatch = new StopWatch();

        Object[] args = new Object[]{new User("asdf@qwer.com", "010-1111-2222"), "hihi"};
        try{
            stopWatch.start();

            return pjp.proceed(args);
        }finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }


    }
}
