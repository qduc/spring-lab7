package com.lampart.duc.lab7.application.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThymeleafConfiguration {

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
