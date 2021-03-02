package org.nuptpig.fundbackend.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.nuptpig.fundcommon.Tools.JWTHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class requestAspect {
    private static final Logger logger = LoggerFactory.getLogger(requestAspect.class);

    private String userParamName = "userName";

    @Pointcut("execution(public * org.nuptpig.fundbackend.controller.*.*(..))")
    public void pointCut(){}

//    @Before("requestAspect()")
//    public void doBefore(JoinPoint joinPoint){
//        System.out.println("doBefore");
////        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
////        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
////        HttpServletRequest request = sra.getRequest();
//
//        String url = request.getRequestURL().toString();
//        String method = request.getMethod();
//        String uri = request.getRequestURI();
//        String queryString = request.getQueryString();
//
//        logger.info("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);
//    }
//
//    @After("requestAspect()")
//    public void doAfter(JoinPoint joinPoint){
//        System.out.println("doAfter");
//    }
//
//    @AfterReturning("requestAspect()")
//    public void doAfterReturning(JoinPoint joinPoint){
//        System.out.println("doAfterReturning");
//    }
//
//    @AfterThrowing("requestAspect()")
//    public void deAfterThrowing(JoinPoint joinPoint){
//        System.out.println("deAfterThrowing");
//    }

    @Around("pointCut()")
    public Object deAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("deAround");
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] paramNames = methodSignature.getParameterNames();
        for(int i=0; i<paramNames.length; i++){
            String paramName = paramNames[i];
            if (userParamName.equals(paramName)){
                // 从JWT获取用户名
                args[i] = JWTHelper.getUsername((String) args[i]);
            }
        }

        return joinPoint.proceed(args);
    }

}
