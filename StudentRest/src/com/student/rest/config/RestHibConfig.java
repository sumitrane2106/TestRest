package com.student.rest.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value={"classpath:application.properties"})
public class RestHibConfig {

	@Autowired
	private Environment e;
	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(datasource());
		bean.setHibernateProperties(HibernateProperties());
		bean.setPackagesToScan(new String[] {"com.student.rest"});
		return bean;
		
	}	
	@Bean
	public DataSource datasource(){

		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName(e.getProperty("jdbc.driverClassName"));
		dmds.setUrl(e.getProperty("jdbc.url"));
		dmds.setUsername(e.getProperty("jdbc.username"));
		dmds.setPassword(e.getProperty("jdbc.password"));
		return dmds;
	
	}
	
	private Properties HibernateProperties(){
		
		Properties pro = new Properties();
		pro.put("hibernate.dialect", e.getProperty("hibernate.dialect"));
		pro.put("hibernate.show_sql", e.getProperty("hibernate.show_sql"));
		pro.put("hibernate.format_sql", e.getProperty("hibernate.format_sql"));
		pro.put("hibernate.hbm2ddl.auto", e.getProperty("hibernate.hbm2ddl.auto"));
		return pro;
		
	}

	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManagement(SessionFactory s){
		HibernateTransactionManager tx = new HibernateTransactionManager();
		tx.setSessionFactory(s);
		return tx;
		
	}
	
	
}
