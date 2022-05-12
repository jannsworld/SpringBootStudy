package com.testboard2.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
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
	
	@Autowired
	private ApplicationContext applicationContext;

	/* HikariCP 설정1
	* @Bean : return 객체를 IoC 컨테이너에 등록
	* 틀별히 지정하는 이름이 없다면 IoC컨테이너에 해당 메서드명으로 등록, 물론 이름 지정 가능하고 보통 메서드명으로 등록한다. 중복X
	* application.properties 파일로부터 데이터베이스 관련된 정보를 읽어솨 히카리 설정 객체 리턴
	* 접두어는 해당 접두어로 시작하는 정보들을 읽어온다
	*/
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		
		return new HikariConfig();
	}
	
	/* HikariCP 설정2
	 * 
	 * 히카리 설정 객체(HikariConfig)를 넘겨 받아 DataSource 객체를 리턴하고 이 단계에서 데이터베이스 연결 완성
	 * 아이디, 패스워드 오류 시 다시 application.properties 파일 체크
	 * DB 연결 확인 위해서 dataSource 객체를 toString() 메서드로 출력하며
	 * 히카리풀 뒤에 숫자가 붙어 나옴 : HikariDataSource(HikiariPool-1)
	 * 이 단계를 통해 히카리CP(Connection Pool) 연결 완성
	 */
	public DataSource dataSource() {
		
		DataSource dataSource = new HikariDataSource(hikariConfig());
		System.out.println( dataSource.toString() );
	
		return dataSource;
	}

	/* MyBatis 설정1 
	 * 
	 * SqlSessionFactory 객체 생성 <- SqlseseeionFactoryBean
	 * 데이터소스 객체 넘겨 받아 처리해도 되고, 아니면 setDataSource(dataSource() ) 이렇게도 가능
	 * 
	 * 기본설정 3가지
	 * 	setDataSource 			: 빌드된 DataSource 세팅
	 * 	setMapperLocations 		: SQL 구문이 작성된 *Mapper.xml 경로를 정확히 등록
	 * 	setTypeAliasesPackage 	: 인자로 Alias 대상 클래스가 위치한 패키지 경로
	 * 
	 * 주의 ! 
	 * SqlSessionFactory 저장할 config 설정 시, Mapper에서 사용하고자 하는 DTO, VO, Entity 대해서 setTypeAliasesPackage 지정 필요
	 * 만약 미지정 시, aliases 찾지 못하는 오류 발생할 수 있음
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*Mapper.xml"));
		/*
		 * 매퍼에 대한 리소스는 AppicationContext 객체에서 가져올 수 있다.
		 * AppicationContext는 프레임워크 컨테이너로 쉽게 이야기 할 수 있고,
		 * 애플리케이션이 스타트해서 끝나는 그 순간까지 이 애플리케이션에서 필요한 모든 자원들을 모아놓고 관리
		 */
		factoryBean.setTypeAliasesPackage("com.testboard2.dto");

		
		return factoryBean.getObject();
	}

	/* MyBatis 설정2 
	 * 
	 * SqlSessionTemplate 객체 생성 <- SqlSessionFactory
	 * 넘겨받은 sqlSessionFactory를 통해 sqlSessionTemplate 객체 생성 및 리턴
	 * MyBatis sqlSession 객체가 Spring+MyBatis 연동 모듈에서는 sqlSessionTemplate 대체
	 */
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception{
		
		
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
