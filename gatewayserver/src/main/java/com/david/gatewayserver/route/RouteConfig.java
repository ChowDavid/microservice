package com.david.gatewayserver.route;

import java.time.LocalDateTime;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
	
	@Bean
	public RouteLocator myRoute(RouteLocatorBuilder builder) {
		
		return builder.routes()
				.route(p->p.path("/david/accounts/**")
						.filters(f->f.rewritePath("/david/accounts/(?<segment>.*)","/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://ACCOUNTS"))
				.route(p->p.path("/david/loans/**")
						.filters(f->f.rewritePath("/david/loans/(?<segment>.*)","/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://LOANS"))
				.route(p->p.path("/david/cards/**")
						.filters(f->f.rewritePath("/david/cards/(?<segment>.*)","/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://CARDS"))	
				.build();
		
	}

}
