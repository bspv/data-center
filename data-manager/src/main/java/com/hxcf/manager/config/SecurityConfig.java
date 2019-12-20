package com.hxcf.manager.config;

import com.hxcf.common.generic.Result;
import com.hxcf.common.generic.TipsCodeEnum;
import com.hxcf.common.util.JsonUtil;
import com.hxcf.manager.bean.UserBean;
import com.hxcf.manager.config.security.CustomAuthenticationFilter;
import com.hxcf.manager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String FORWARD_URI = "/security/forward";
    private static final String RESULT_KEY = "security_result";

    private final UserService userService;

    public void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(new AuthenticationProvider() {
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                String userName = (String) authentication.getPrincipal(); // 表单中的用户名
                String password = (String) authentication.getCredentials(); // 表单中的密码

                UserBean userBean = userService.loadUserByUsername(userName);
                if (userBean == null)
                    throw new BadCredentialsException(TipsCodeEnum.CODE_2004.getMessage());

                if (!userBean.getPassword().equals(password))
                    throw new BadCredentialsException(TipsCodeEnum.CODE_2004.getMessage());

                userBean = userService.loadAuthByUser(userBean);

                return new UsernamePasswordAuthenticationToken(userName, password, userBean.getAuthorities());
            }

            public boolean supports(Class<?> aClass) {
                return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
            }
        });
    }

    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().requestMatchers(CorsUtils::isPreFlightRequest).permitAll();
        http.authorizeRequests().anyRequest().authenticated();
        http.httpBasic().authenticationEntryPoint((httpServletRequest, httpServletResponse, e) -> {
            httpServletRequest.setAttribute(RESULT_KEY, JsonUtil.toJsonString(Result.failure(TipsCodeEnum.CODE_2002)));
            httpServletRequest.getRequestDispatcher(FORWARD_URI).forward(httpServletRequest, httpServletResponse);
        });

        http.addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        http.logout().logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> {
            httpServletRequest.setAttribute(RESULT_KEY, JsonUtil.toJsonString(Result.success(TipsCodeEnum.CODE_0000.getMessage())));
            httpServletRequest.getRequestDispatcher(FORWARD_URI).forward(httpServletRequest, httpServletResponse);
        }).permitAll();

        http.csrf().disable();

        http.exceptionHandling().accessDeniedHandler((httpServletRequest, httpServletResponse, e) -> {
            String code = TipsCodeEnum.CODE_2001.getCode();
            String message = e.getMessage();
            message = StringUtils.isNoneBlank(message) ? message : TipsCodeEnum.CODE_2001.getMessage();
            httpServletRequest.setAttribute(RESULT_KEY, JsonUtil.toJsonString(Result.failure(code, message)));
            httpServletRequest.getRequestDispatcher(FORWARD_URI).forward(httpServletRequest, httpServletResponse);
        });
    }

    @Bean
    public CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        filter.setAuthenticationSuccessHandler((req, resp, authentication) -> {
            req.setAttribute(RESULT_KEY, JsonUtil.toJsonString(Result.success(TipsCodeEnum.CODE_0000.getMessage())));
            req.getRequestDispatcher(FORWARD_URI).forward(req, resp);
        });
        filter.setAuthenticationFailureHandler((req, resp, e) -> {
            String code = TipsCodeEnum.CODE_2003.getCode();
            String message = e.getMessage();
            message = StringUtils.isNoneBlank(message) ? message : TipsCodeEnum.CODE_2003.getMessage();
            req.setAttribute(RESULT_KEY, JsonUtil.toJsonString(Result.failure(code, message)));
            req.getRequestDispatcher(FORWARD_URI).forward(req, resp);
        });
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(
                "/actuator/**",
                "/static/**",
                "/v2/api-docs-ext",
                "/v2/api-docs",
                "/webjars/**",
                "/swagger-resources",
                "/swagger-resources/configuration/ui",
                "/**.html")
                .antMatchers(HttpMethod.OPTIONS, "/**");
    }
}
