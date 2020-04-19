package com.sanket.myproject.config;

import static org.hibernate.cfg.AvailableSettings.C3P0_ACQUIRE_INCREMENT;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_STATEMENTS;
import static org.hibernate.cfg.AvailableSettings.C3P0_MIN_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_TIMEOUT;
import static org.hibernate.cfg.AvailableSettings.DRIVER;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.PASS;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.URL;
import static org.hibernate.cfg.AvailableSettings.USER;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:database.properties")
//@EnableTransactionManagement
@ComponentScans(value= {
		@ComponentScan("com.sanket.myproject.dao"),
		@ComponentScan("com.sanket.myproject.service")
})
public class ApplicationConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public LocalSessionFactoryBean getLocalSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		Properties props = new Properties();
			
		//for JDBC
		props.put(DRIVER,env.getProperty("mysql.driver"));
		props.put(URL,env.getProperty("mysql.url"));
		props.put(USER,env.getProperty("mysql.user"));
		props.put(PASS,env.getProperty("mysql.password"));
//		
		
//		Hibernate
		props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
		props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
		
//		C3P0 props
//		hibermate.c3p0.min_size=5
//				hibermate.c3p0.max_size=20
//				hibermate.c3p0.acquire_increment=1
//				hibermate.c3p0.timeout=1900
//				hibermate.c3p0.max_statements=150

		props.put(C3P0_MIN_SIZE,env.getProperty("hibermate.c3p0.min_size"));
		props.put(C3P0_MAX_SIZE,env.getProperty("hibermate.c3p0.max_size"));
		props.put(C3P0_ACQUIRE_INCREMENT,env.getProperty("hibermate.c3p0.acquire_increment"));
		props.put(C3P0_TIMEOUT,env.getProperty("hibermate.c3p0.timeout"));
		props.put(C3P0_MAX_STATEMENTS,env.getProperty("hibermate.c3p0.max_statements"));
		
		factoryBean.setHibernateProperties(props);
		factoryBean.setPackagesToScan("com.sanket.myproject.model");
		
		return factoryBean;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionMgr() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getLocalSessionFactory().getObject());
		return transactionManager;
	}
}
