package com.starWarsApis.starWarsApis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.starWarsApis.starWarsApis")
public class StarWarsApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarWarsApisApplication.class, args);
	}

	// @Bean
	// public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
	// ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
	// request.getHeaders().add("user-agent", "spring");
	// return execution.execute(request, body);
	// };
	// return restTemplateBuilder.additionalInterceptors(interceptor).build();
	// }

}
