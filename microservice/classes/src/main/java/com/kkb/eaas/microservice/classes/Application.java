package com.kkb.eaas.microservice.classes;

import com.kkb.eaas.commons.base.BaseApiApplication;
import com.kkb.eaas.microservice.classes.db.route.ReadWriteDataSource;
import com.kkb.eaas.microservice.classes.repositories.ClassRepository;
import com.kkb.eaas.microservice.classes.repositories.SecondRepository;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by lixzh on 1/17/17.
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@ComponentScan
//@MapperScan("com.kkb.eaas.microservice.classes.mappers")
public class Application extends BaseApiApplication {
    private static Logger logger = Logger.getLogger(Application.class);

    //DataSource配置
    @Bean(name ="dataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    @Qualifier("dataSource")
    @Primary
    public DataSource dataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }

    //提供SqlSeesion
    @Bean(name ="sqlSessionFactory")
    @Primary
    @Qualifier("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("dataSource") DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:/mybatis-config.xml"));
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurerBean() throws Exception {

        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.kkb");
        mapperScannerConfigurer.setAnnotationClass(ClassRepository.class);
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }

    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    //---------------------------------------------------

    @Bean(name ="secondDataSource")
    @ConfigurationProperties(prefix="spring.secondDatasource")
    @Qualifier("secondDataSource")
    public DataSource seconddataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }

    @Bean(name ="secondWriteDataSource")
    @ConfigurationProperties(prefix="spring.secondDatasource.write")
    @Qualifier("secondWriteDataSource")
    public DataSource secondWritedataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }

    @Bean(name ="secondReadDataSource")
    @ConfigurationProperties(prefix="spring.secondDatasource.read1")
    @Qualifier("secondReadDataSource")
    public DataSource secondReadDataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }

    @Bean(name ="secondReadWriteDataSource")
    @Qualifier("secondReadWriteDataSource")
    public DataSource secondReadWriteDataSource(@Qualifier("secondWriteDataSource") DataSource secondWriteDataSource,
                                                @Qualifier("secondReadDataSource") DataSource secondReadDataSource) {
        ReadWriteDataSource readWriteDataSource = new ReadWriteDataSource();
        readWriteDataSource.setWriteDataSource(secondWriteDataSource);
        Map<String,DataSource> map = new HashMap<>();
        map.put("read1",secondReadDataSource);
        readWriteDataSource.setReadDataSourceMap(map);
        return readWriteDataSource;
    }

    //提供SqlSeesion
    @Bean(name ="secondSqlSessionFactory")
    @Qualifier("secondSqlSessionFactory")
    public SqlSessionFactory secondSqlSessionFactoryBean(@Qualifier("secondReadWriteDataSource") DataSource secondDataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(secondDataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:/mybatis-config.xml"));
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
    @Bean
    public MapperScannerConfigurer secondMapperScannerConfigurerBean() throws Exception {

        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.kkb");
        mapperScannerConfigurer.setAnnotationClass(SecondRepository.class);
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("secondSqlSessionFactory");
        return mapperScannerConfigurer;
    }

    @Bean
    public PlatformTransactionManager secondTransactionManager(@Qualifier("secondReadWriteDataSource") DataSource secondDataSource) {
        return new DataSourceTransactionManager(secondDataSource);
    }

    /**
     * Main Start
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("============= Class Service Start Success =============");
    }
}