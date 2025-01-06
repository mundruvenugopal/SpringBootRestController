package com.example.demo.curdoperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.curdoperations.interceptor.GeneralInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	private GeneralInterceptor generalinterceptor;

    @Override
	public void addInterceptors(InterceptorRegistry registry) {
    	registry.addInterceptor(generalinterceptor);
		// TODO Auto-generated method stub
		
	}
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow all endpoints
                .allowedOrigins("*") // Allow all origins, adjust as necessary
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS"); // Specify allowed methods
    }
	/*
	 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * registry.addResourceHandler("/uploads/**")
	 * .addResourceLocations("file:uploads/"); }
	 */
}
