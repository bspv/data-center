package com.hxcf.analysis;

import com.hxcf.analysis.config.DefinitionProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients({"com.hxcf.api"})
@EnableDiscoveryClient
@ServletComponentScan
@EnableConfigurationProperties(DefinitionProperties.class)
@SpringBootApplication
public class AnalysisApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnalysisApplication.class, args);
    }

}
