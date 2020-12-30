package com.twentyone.config;

import com.twentyone.rabbitmq.RabbitBroker;
import com.twentyone.service.RMIService;
import com.twentyone.service.RMIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.remoting.support.RemoteExporter;

@Configuration
public class RMIConfig {
    @Autowired
    RabbitBroker rabbit;

    @Bean
    RemoteExporter registerRMIExporter() {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("twenty-one-rmi");
        exporter.setServiceInterface(RMIService.class);
        exporter.setService(new RMIServiceImpl(rabbit));
        return exporter;
    }
}
