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
@MapperScan(basePackages = "com.hxcf.analysis.mapper.pre", sqlSessionTemplateRef = "preSqlSessionTemplate",
        nameGenerator = BeanNameGenerator.class)
public class PreDataSourceConfig {
    @Bean(name = "preDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.pre")
    public DataSource preDataSource() {
        return DataSourceBuilder.create().build();
//        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "preSqlSessionFactory")
    public SqlSessionFactory preSqlSessionFactory(@Qualifier("preDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:sql_mapper/pre/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "preTransactionManager")
    public DataSourceTransactionManager preTransactionManager(@Qualifier("preDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "preSqlSessionTemplate")
    public SqlSessionTemplate preSqlSessionTemplate(@Qualifier("preSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
