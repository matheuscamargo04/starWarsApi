package com.starWarsApis.starWarsApis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
