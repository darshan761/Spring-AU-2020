package com.springMVC.config;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.springMVC.dao.EmployeeDAO;
import com.springMVC.dao.EmployeeDAOImpl;

@Configuration
@PropertySource(value = { "classpath:application.properties" })
@ComponentScan(basePackages="net.codejava.spring")
@EnableWebMvc
public class MVCConfiguration extends WebMvcConfigurerAdapter{
 
	// for reading properties from application.properties
	@Autowired
    private Environment environment;
	
    @Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
     
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
 
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("driver"));
        dataSource.setUrl(environment.getProperty("url"));
        dataSource.setUsername(environment.getProperty("username"));
        dataSource.setPassword(environment.getProperty("password"));
         
        return dataSource;
    }
     
    @Bean
    public EmployeeDAO getContactDAO() {
        return new EmployeeDAOImpl(getDataSource());
    }
}