package com.hxcf.analysis.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableSwaggerBootstrapUi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUi
public class Knife4jConfig {
    @Resource
    private DefinitionProperties definitionProperties;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(!"prod".equals(definitionProperties.getActiveProfile()))//正式环境禁用Swagger
                .useDefaultResponseMessages(false)//缺省true，设置false时会把响应状态里除200以外的状态码去掉
                .groupName(definitionProperties.getApplicationName())//分组名
                .globalOperationParameters(buildGlobalOperationParameters())//全局参数设置
                .apiInfo(new ApiInfoBuilder()
                        .title("Data Analysis API")//大标题
                        .description("数据中心---数据同步分析---接口文档")//详细描述
                        .version("1.0")//版本
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hxcf.analysis.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private static List<Parameter> buildGlobalOperationParameters() {
        List<Parameter> list = new ArrayList<>();
        list.add(new ParameterBuilder().name("HX-SERIAL-NUMBER").description("请求流水号，每次请求都不同，每个模块都要记录到log日志，由请求方生成，可以使用UUID")
                .modelRef(new ModelRef("string")).parameterType("header").required(true).build());
        return list;
    }
}
