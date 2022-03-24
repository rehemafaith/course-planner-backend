package com.courseplanner.Course.Planner.config;


import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2

public class SwaggerConfig {

	  @Bean
	  public Docket productApi() {
		  return new Docket(DocumentationType.SWAGGER_2).select() 
				.apis(RequestHandlerSelectors.basePackage("com.courseplanner.Course.Planner")).build() ;
	  }
	  
	  
	  private Predicate<String> postPaths() {
	    return Predicates.or(PathSelectors.regex("/api/posts."), PathSelectors.regex("/demo."));
	  }
	  
	  private ApiInfo apiInfo() {
	    return (new ApiInfoBuilder()).title("WELFARE").description("This is a Demo API").build();
	  }
}	 	