package in.kamran.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final ApiInfo appInfo;

	static {
		appInfo = new ApiInfo("Messaging APP", "App keeping count of last 5 comments", "1.0", "",
				new Contact("Kamran Ali", "http://techguide.guru/", "kamranalinitb@gmail.com"), "", "");
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("in.kamran.controller")).paths(PathSelectors.any()).build()
				.apiInfo(appInfo);
	}
}
