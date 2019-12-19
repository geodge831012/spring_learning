package com.dengtacj.news.infrastructure.database.info;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.logging.Logger;

@Slf4j
@Configuration
@MapperScan(basePackages = "com.dengtacj.news.infrastructure.database.info.mapper", sqlSessionTemplateRef  = "infoSqlSessionTemplate")
public class InfoDataSourceConfig {

    @Bean(name = "infoDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.info")
    @Primary
    public DataSource infoDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "infoSqlSessionFactory")
    @Primary
    public SqlSessionFactory infoSqlSessionFactory(@Qualifier("infoDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/info/*.xml"));
        bean.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
        bean.setTypeAliasesPackage("com.dengtacj.news.infrastructure.database.info.dataobject");
        return bean.getObject();
    }

    @Bean(name = "infoTransactionManager")
    @Primary
    public DataSourceTransactionManager infoTransactionManager(@Qualifier("infoDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "infoSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate infoSqlSessionTemplate(@Qualifier("infoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
