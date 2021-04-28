package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component // SpringConfig에 있는 TimeTraceAop를 써도 되고 지금처럼 Componet를 써도 된다.
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))") // 패키지 하위에 다 적용한다는 뜻
//    @Around("execution(* hello.hellospring.service..*(..))") //  service만 하고 싶을 때
    public  Object execut(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
