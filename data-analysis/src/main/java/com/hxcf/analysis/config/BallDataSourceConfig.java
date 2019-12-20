package com.hxcf.analysis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.hxcf.analysis.mapper.ball", sqlSessionTemplateRef = "ballSqlSessionTemplate",
        nameGenerator = BeanNameGenerator.class)
public class BallDataSourceConfig {
    @Bean(name = "ballDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.ball")
    @Primary
    public DataSource ballDataSource() {
        return DataSourceBuilder.create().build();
//        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "ballSqlSessionFactory")
    @Primary
    public SqlSessionFactory ballSqlSessionFactory(@Qualifier("ballDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:sql_mapper/ball/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "ballTransactionManager")
    @Primary
    public DataSourceTransactionManager ballTransactionManager(@Qualifier("ballDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "ballSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate ballSqlSessionTemplate(@Qualifier("ballSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
