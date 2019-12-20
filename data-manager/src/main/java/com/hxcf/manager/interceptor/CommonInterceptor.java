package com.hxcf.manager.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class CommonInterceptor extends HandlerInterceptorAdapter {

    private NamedThreadLocal<Long> timeThreadLocal = new NamedThreadLocal<>("StopWatch-StartTime");

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        timeThreadLocal.set(System.currentTimeMillis());
        return true;
    }


    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        log.info("Completed--->URI:{}, Method:{}, Time:{}ms",
                request.getRequestURI(),
                request.getMethod(),
                System.currentTimeMillis() - timeThreadLocal.get());
    }

}
