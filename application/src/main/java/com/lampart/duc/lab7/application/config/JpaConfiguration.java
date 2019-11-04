package com.lampart.duc.lab7.application.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.lampart.duc.lab7.data")
@EntityScan("com.lampart.duc.lab7.data")
public class JpaConfiguration {

}
