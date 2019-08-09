//package com.andrei.bills.config;
//
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//
//
//@Configuration
//@EnableTransactionManagement
//@Profile("bills-context")
//public class DataAccessConfig {
//
//	@Bean(name="billsTransactionManager")
//	public DataSourceTransactionManager billsTransactionManager() {
//
//
//		return new DataSourceTransactionManager(billsDataSource());
//	}
//
//
//
//	@Bean(name = "billsSqlSessionFactory")
//	public SqlSessionFactoryBean billsSqlSessionFactory() throws Exception {
//		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//		sessionFactory.setDataSource(billsDataSource());
//
//
//		sessionFactory.setTypeAliasesPackage("com.andrei.bills.model");
//
//		return sessionFactory;
//	}
//
//
//	@Bean(name="billsDataSource")
//	public DataSource billsDataSource() {
//		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
//		dsLookup.setResourceRef(true);
//		DataSource ds = dsLookup.getDataSource("jdbc/bills");
//		return ds;
//	}
//
//
//	@Bean(name="billsMapperScannerConfigurer")
//	public MapperScannerConfigurer billsMapperScannerConfigurer() {
//		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
//		configurer.setBasePackage("com.andrei.bills.dao");
//		configurer.setSqlSessionFactoryBeanName("billsSqlSessionFactory");
//
//		return configurer;
//	}
//
//
//}
