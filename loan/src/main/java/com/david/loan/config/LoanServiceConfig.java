package com.david.loan.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * required loan-default.properties in configserver
 */
@Lazy
@Configuration
@ConfigurationProperties(prefix = "loan")
@Getter
@Setter
@ToString
public class LoanServiceConfig {
    private String msg;
    private String buildVersion;
    private Map<String,String> mailDetails;
    private List<String> activeBranches;
}
