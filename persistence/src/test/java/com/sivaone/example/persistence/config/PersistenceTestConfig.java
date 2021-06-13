package com.sivaone.example.persistence.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Persistence config for unit tests.
 */
@Configuration
@EnableJpaRepositories("com.sivaone.example.persistence.repository")
@EnableTransactionManagement
@PropertySource("application.properties")
@SuppressWarnings({"PMD.BeanMembersShouldSerialize"})
public class PersistenceTestConfig {

  @Autowired
  private Environment env;

  /**
   * Datasource config.
   *
   * @return datasource
   */
  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getProperty("jdbc.driverClass"));
    dataSource.setUsername(env.getProperty("jdbc.username"));
    dataSource.setUrl(env.getProperty("jdbc.url"));

    return dataSource;
  }

  /**
   * Entity manager config.
   *
   * @return EMF bean
   */
  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
    emf.setDataSource(dataSource());
    emf.setPackagesToScan("com.sivaone.example.persistence.entity");

    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    emf.setJpaVendorAdapter(vendorAdapter);

    Properties properties = new Properties();
    properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    emf.setJpaProperties(properties);

    return emf;
  }

  /**
   * Transaction manager config.
   *
   * @return Transaction manager
   */
  @Bean
  public PlatformTransactionManager transactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
    return transactionManager;
  }

  /**
   * Exception processor config.
   *
   * @return Exception post processor
   */
  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslationPostProcessor() {
    return new PersistenceExceptionTranslationPostProcessor();
  }
}
