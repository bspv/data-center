package com.hxcf.analysis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.hxcf.analysis.mapper.wealth", sqlSessionTemplateRef = "wealthSqlSessionTemplate",
        nameGenerator = BeanNameGenerator.class)
public class WealthDataSourceConfig {
    @Bean(name = "wealthDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.wealth")
    public DataSource wealthDataSource() {
        return DataSourceBuilder.create().build();
//        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "wealthSqlSessionFactory")
    public SqlSessionFactory wealthSqlSessionFactory(@Qualifier("wealthDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:sql_mapper/wealth/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "wealthTransactionManager")
    public DataSourceTransactionManager wealthTransactionManager(@Qualifier("wealthDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "wealthSqlSessionTemplate")
    public SqlSessionTemplate wealthSqlSessionTemplate(@Qualifier("wealthSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
