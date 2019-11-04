package com.lampart.duc.lab7.application;

import com.github.javafaker.Faker;
import com.lampart.duc.lab7.service.data.UserJpaDataService;
import com.lampart.duc.lab7.service.dto.UserDto;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.boot.CommandLineRunner;
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

    @Bean
    public Faker faker() {
        return new Faker();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    CommandLineRunner dataSeeder(UserJpaDataService userDataService, Faker faker) {
        return (args) -> {
            UserDto user1 = new UserDto(faker.name().fullName(), faker.name().username(), faker.internet().safeEmailAddress(), "123");
            UserDto user2 = new UserDto(faker.name().fullName(), faker.name().username(), faker.internet().safeEmailAddress(), "123");
            UserDto user3 = new UserDto(faker.name().fullName(), faker.name().username(), faker.internet().safeEmailAddress(), "123");

            userDataService.save(user1);
            userDataService.save(user2);
            userDataService.save(user3);
        };
    }
}
