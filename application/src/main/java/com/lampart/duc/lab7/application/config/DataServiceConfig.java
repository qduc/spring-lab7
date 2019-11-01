package com.lampart.duc.lab7.application.config;

import com.lampart.duc.lab7.api.data.UserDataService;
import com.lampart.duc.lab7.service.data.UserDataServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataServiceConfig {

    @Bean
    UserDataService userDataService(UserDataServiceImpl userDataService) {
        return userDataService;
    }
}
