package com.mysite.work;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;


//@SpringBootApplication(scanBasePackages={"com.mysite.work"})
@SpringBootApplication
@MapperScan(value= {"com.mysite.work.mapper"})

public class BootGradleMysiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootGradleMysiteApplication.class, args);
	}
	
	@Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        
        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:sql/*Mapper.xml");
        sessionFactory.setMapperLocations(res);
        
        return sessionFactory.getObject();
    }

}
