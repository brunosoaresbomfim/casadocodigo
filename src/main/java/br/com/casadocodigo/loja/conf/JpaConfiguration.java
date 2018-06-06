package br.com.casadocodigo.loja.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class JpaConfiguration {

	@Bean
	// metodo responsavel por enxergar os models e retornar todos os dados principais do bd
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean bean = 
				new LocalContainerEntityManagerFactoryBean();
		
		bean.setDataSource(getDataSource());
		bean.setPackagesToScan(new String[] {"br.com.casadocodigo.loja.models"});
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		bean.setJpaVendorAdapter(vendorAdapter);
		bean.setJpaProperties(getProperties());
		
		return bean;
	}
	
	@Bean
	// configuramos
	// os parâmetros de conexão com o banco de dados
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/casadocodigo");
		dataSource.setUsername("root");
		dataSource.setPassword("373571");
		
		return dataSource;
	}
	
	@Bean
	// responsavel pelas propriedades adicionais do JPA e Hibernate
	public Properties getProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		
		return properties;
	}
	
	@Bean
	// controle de transação usando a interface PlatformTransactionManager 
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(emf);

		return manager;
	}
	
	
	
	
	
	
	
	
	
}
