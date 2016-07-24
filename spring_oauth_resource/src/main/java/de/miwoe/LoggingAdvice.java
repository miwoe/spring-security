package de.miwoe;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Grauschleier on 24.07.2016.
 */
@Component
@Aspect
public class LoggingAdvice {

    @AfterReturning("execution(* de..*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println(joinPoint);
    }

    @Before("execution(* de..*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println(joinPoint);
    }
}
