package com.david.account.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "account")
@Getter @Setter @ToString
public class AccountServiceConfig {
    private String msg;
    private String buildVersion;
    private Map<String,String> mailDetails;
    private List<String> activeBranches;
}

/**
 * For that it required a properties file in spring-cloud config server
 * account.msg=
 * account.buildVersion=
 * or
 * account.build-version=
 * account.mailDetails.Key1=Value1
 * account.mailDetails.Key2=Value2
 * account.activeBranches[0]=value
 *
 */
/**
 * this client will lookup the config server from application.properties file
 *   application:
 *     name: account
 *   profiles:
 *     active: prod
 *   config:
 *     import: optional:configserver:http://localhost:8071
 */
