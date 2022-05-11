package com.testboard2.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/*
 * @Configuration : 스프링부트 환결성정 클래스임을 명시, 자동으로 빈 등록
 * 이 애너테이션 붙으면, @ComponentScan 스캔할 때, 이 클래스에 @Bean 지정한 모든 빈들도 IoC 컨테이너 등록
 */
@Configuration
@PropertySource("classpath:/application.properties")
public class DBConfigration {

	// Hikari 설정1
	public HikariConfig hikariConfig() {
		
		return new HikariConfig();
	}
	
	// Hikari 설정2
	public DataSource dataSource() {
		
		DataSource dataSource = new HikariDataSource(hikariConfig());
		System.out.println( dataSource.toString() );
	
		return dataSource;
	}

	//MyBatis 설정1 : SqlSessionFactory <- SqlseseeionFactoryBean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		
		return factoryBean.getObject();
	}
	
	//MyBatis 설정2 : SqlSessionTemplate <- SqlseseeionFactory

	public SqlSessionTemplate sqlSessionTemplate() throws Exception{
		
		return new SqlSessionTemplate(sqlSessionFactory());
	}
}
