package com.hxcf.manager.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hxcf.common.generic.TipsCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Map;

@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    /**
     * 从body获取登录信息
     *
     * @param request  请求
     * @param response 响应
     * @return 返回值
     * @throws AuthenticationException 异常
     */
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!HttpMethod.POST.matches(request.getMethod())) {
            throw new AuthenticationServiceException(String.format(TipsCodeEnum.CODE_0020.getMessage(), request.getMethod()));
        }
        if (MediaType.APPLICATION_JSON_VALUE.equals(request.getContentType())) {
            UsernamePasswordAuthenticationToken authenticationToken;
            try (InputStream is = request.getInputStream()) {
                Map map = new ObjectMapper().readValue(is, Map.class);
                Object name = map.get(SPRING_SECURITY_FORM_USERNAME_KEY);
                Object pwd = map.get(SPRING_SECURITY_FORM_PASSWORD_KEY);
                String username = name != null ? String.valueOf(name) : "";
                String password = pwd != null ? String.valueOf(pwd) : "";
                authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            } catch (Exception e) {
                authenticationToken = new UsernamePasswordAuthenticationToken("", "");
                log.error(e.getMessage(), e);
            }
            setDetails(request, authenticationToken);
            return getAuthenticationManager().authenticate(authenticationToken);
        }
        return super.attemptAuthentication(request, response);
    }
}
