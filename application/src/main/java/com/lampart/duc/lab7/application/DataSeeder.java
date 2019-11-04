package com.lampart.duc.lab7.application;

import com.github.javafaker.Faker;
import com.lampart.duc.lab7.api.data.DataService;
import com.lampart.duc.lab7.service.dto.UserDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final Faker faker;

    private final DataService<UserDto> userDataService;

    public DataSeeder(DataService<UserDto> userDataService) {
        this.userDataService = userDataService;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) throws Exception {
        UserDto user1 = new UserDto(faker.name().fullName(), faker.name().username(), faker.internet().safeEmailAddress(), "123");
        UserDto user2 = new UserDto(faker.name().fullName(), faker.name().username(), faker.internet().safeEmailAddress(), "123");
        UserDto user3 = new UserDto(faker.name().fullName(), faker.name().username(), faker.internet().safeEmailAddress(), "123");

        userDataService.save(user1);
        userDataService.save(user2);
        userDataService.save(user3);
    }
}
