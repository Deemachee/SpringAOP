package ru.learnup.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ContactAspect {
    private static final Logger log = LoggerFactory.getLogger(ContactAspect.class);

    @Before("@annotation(ru.learnup.annotations.LogMethod)")
    public void beforeAnnotation(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info("*".repeat(130));
        log.info("beforeAnnotation: Имя метода - {}, параметр метода - {} {}," +
                        " возвращаемое значение - {}",
                methodSignature.getName(), methodSignature.getParameterTypes(),
                methodSignature.getParameterNames(), methodSignature.getReturnType());
        log.info("*".repeat(130));
    }

    @After("@annotation(ru.learnup.annotations.WorkTime)")
    public void afterAnnotation(JoinPoint joinPoint) throws InterruptedException {
        long start = System.currentTimeMillis();
        log.info("*".repeat(130));
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Thread.sleep(10);
        long end = System.currentTimeMillis();
        log.info("afterAnnotation: Время работы метода {} с учетом засыпания - {} миллисекунд", methodSignature.getName(), end - start);
        log.info("*".repeat(130));
    }

}
