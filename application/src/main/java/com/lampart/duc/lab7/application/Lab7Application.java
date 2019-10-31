package com.lampart.duc.lab7.application;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.lampart.duc.lab7")
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
