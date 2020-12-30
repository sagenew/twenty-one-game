package com.twentyoneclient.config;

import com.twentyoneclient.service.RMIService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@Configuration
public class RMIConfig {
    @Bean
    public RmiProxyFactoryBean rmiProxy() {
        RmiProxyFactoryBean bean = new RmiProxyFactoryBean();
        bean.setServiceInterface(RMIService.class);
        bean.setServiceUrl("rmi://localhost:1099/twenty-one-rmi");

        return bean;
    }
}
