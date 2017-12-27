package com.training.springboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by lenovo on 2017/12/25.
 */
@Component
@Aspect
public class HttpAspect {

    private static Logger LOG = Logger.getLogger(HttpAspect.class);

    @Autowired
    private ObjectMapper mapper;

    @Pointcut("execution(* com.training.springboot.web.*.*(..))")
    public void pointCut(){}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        LOG.info("method start...");
        Object obj = pjp.proceed();
        LOG.info("method end...");
        return obj;
    }

    @Before("pointCut()")
    public void before(JoinPoint jp) throws JsonProcessingException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String ip = request.getRemoteAddr();
        String uri = request.getRequestURL().toString();
        String methodType = request.getMethod();
        String method = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();
        Map<String,String[]> map = request.getParameterMap();
        LOG.info("request uri is : "+ uri);
        LOG.info("request ip is:" + ip);
        LOG.info("request method type : " + methodType);
        LOG.info("request method : " + method);
        LOG.info("request params is : " + mapper.writeValueAsString(jp.getArgs()));
    }

    @AfterReturning(returning="obj",pointcut="pointCut()")
    public void afterReturning(Object obj) throws JsonProcessingException {
        LOG.info("response : " + mapper.writeValueAsString(obj));
    }
}
