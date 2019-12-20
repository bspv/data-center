package com.hxcf.manager.config;

import com.google.common.net.HttpHeaders;
import com.hxcf.manager.interceptor.CommonInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Bean
    public CommonInterceptor commonInterceptor() {
        return new CommonInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commonInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/static/**",
                        "/v2/api-docs-ext",
                        "/webjars/**",
                        "/swagger-resources",
                        "/swagger-resources/configuration/ui",
                        "/**.html");
    }

    /**
     * 跨域配置
     *
     * @param registry registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**/**").allowedOrigins("*")
                .allowedMethods("*").allowedHeaders("*")
                .allowCredentials(true).maxAge(3600)
                .exposedHeaders(HttpHeaders.SET_COOKIE);
    }
}
