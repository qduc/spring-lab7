package com.lampart.duc.lab7.application;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.lampart.duc.lab7")
@EnableJpaRepositories("com.lampart.duc.lab7.data")
@EntityScan("com.lampart.duc.lab7.data")
public class Lab7Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab7Application.class, args);
    }

    /**
     * Configure thymeleaf-layout-dialect
     *
     * @link https://ultraq.github.io/thymeleaf-layout-dialect/
     */
    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
