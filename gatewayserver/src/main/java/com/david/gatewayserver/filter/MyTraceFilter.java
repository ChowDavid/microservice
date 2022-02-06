package com.david.gatewayserver.filter;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;


@Slf4j
@Order(1)
@Component
public class MyTraceFilter implements GlobalFilter {
	
	@Autowired
	FilterUtility filterUtility;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
		if (isCorrelationIdPresent(requestHeaders)){
			log.info("correlationId found {}",filterUtility.getCorrelationId(requestHeaders));
			
		} else {
			String correlationId = generateCorrelationId();
			exchange = filterUtility.setCorrelationId(exchange, correlationId);
			log.info("correlationId not found and generate as {}",correlationId);
		}
		return chain.filter(exchange);
	}
	
	private boolean isCorrelationIdPresent(HttpHeaders requeHeaders) {
		if (filterUtility.getCorrelationId(requeHeaders)!=null) {
			return true;
		} else {
			return false;
		}
	}
	
	private String generateCorrelationId() {
		return UUID.randomUUID().toString();
	}

}
