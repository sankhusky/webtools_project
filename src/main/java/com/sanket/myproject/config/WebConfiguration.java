package com.sanket.myproject.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.sanket.myproject"})
public class WebConfiguration extends WebMvcConfigurerAdapter {

	@Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
	  registry.addResourceHandler("resources/**").addResourceLocations("/resources/");
	 }
	 
	 @Bean
	 public InternalResourceViewResolver viewResolver(){
	  InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	  viewResolver.setViewClass(JstlView.class);
	  viewResolver.setPrefix("/WEB-INF/views/");
	  viewResolver.setSuffix(".jsp");
	  
	  return viewResolver;
	 }

	 @Bean
	   public MessageSource messageSource() {
	      ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	      source.setBasename("messages");
	      return source;
	   }
	   
}
