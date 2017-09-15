package org.itstep.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories("org.itstep.dao")
@EnableTransactionManagement
@EnableAsync
@EntityScan("org.itstep")
@ConfigurationProperties
public class DbConfig extends HikariConfig {

	@Value(value = "${spring.datasource.hikari.username}")
	private String username;

	@Value(value = "${spring.datasource.hikari.password}")
	private String password;

//	@Value(value = "${spring.datasource.hikari.data-source-class-name}")
//	private String dataSourceClassName;

	@Value(value = "${spring.datasource.hikari.driver-class-name}")
	private String dataSourceDriverName;
	
//	@Value(value = "${spring.datasource.hikari.database-name}")
//	private String databaseName;
//
//	@Value(value = "${spring.datasource.hikari.driver-type}")
//	private Integer driverType;

	@Value(value = "${spring.datasource.hikari.url}")
	private String url;

//	@Value(value = "${spring.datasource.hikari.schema}")
//	private String schema;

	@Value(value = "${spring.datasource.hikari.hbm2ddl.auto}")
	private String hbm2Ddl;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "org.itstep.dao" });
		em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		em.setJpaProperties(additionalProperties());
		return em;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", hbm2Ddl);
		return properties;
	}

    @Bean
    public DataSource dataSource() {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dataSourceDriverName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
