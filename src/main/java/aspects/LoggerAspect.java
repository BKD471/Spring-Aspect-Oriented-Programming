package aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class LoggerAspect {

    Logger logger= Logger.getLogger(LoggerAspect.class.getName());

    @Around("execution(*  services.*.*(..))")
    public String log(ProceedingJoinPoint jointPoint) throws  Throwable{
        logger.info(jointPoint.getSignature().toString()+" ...method execution starts");
        Instant start=Instant.now();
        var result=  jointPoint.proceed();
        Instant finish=Instant.now();
        long timeElapsed= Duration.between(start,finish).toMillis();
        System.out.println("Time elapsed "+timeElapsed);
        logger.info(jointPoint.getSignature().toString()+" ...method execution stops");
        return (String) result;
    }

    @Around("@annotation(interfaces.LogAspect)")
    public String logWithAnnotation(ProceedingJoinPoint jointPoint) throws  Throwable{
        logger.info("....Inside the logWithAnnotation");
        logger.info(jointPoint.toString()+" ...method execution starts");
        Instant start=Instant.now();
        var result=  jointPoint.proceed();
        Instant finish=Instant.now();
        long timeElapsed= Duration.between(start,finish).toMillis();
        System.out.println("Time elapsed "+timeElapsed);
        logger.info(jointPoint.toString()+" ...method execution stops");
        logger.info("....Inside the logWithAnnotation ends");
        return (String) result;
    }

    @AfterThrowing(value = "execution(* services.*.*(..))",throwing = "ex")
    public void logException(JoinPoint joinPoint,Exception ex) {
        logger.log(Level.SEVERE,"Exception is thrown due to "+ex.getMessage()+" from "+joinPoint.getSignature().toString());
    }

    @AfterReturning(value="execution(* services.*.*(..))",returning = "retVal")
    public void logReturnVal(JoinPoint joinPoint,Object retVal){
     logger.log(Level.INFO,"Returned value from "+joinPoint.getSignature().toString()+" is "+retVal);
    }
}
