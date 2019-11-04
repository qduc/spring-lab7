package com.lampart.duc.lab7.service.adapter;

import com.lampart.duc.lab7.api.data.DtoEntityAdapter;
import com.lampart.duc.lab7.data.entity.Users;
import com.lampart.duc.lab7.service.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserDtoJpaEntityAdapter implements DtoEntityAdapter<UserDto, Users> {

    @Override
    public Users toEntity(UserDto dto) {
        return new Users(dto.getName(), dto.getUsername(), dto.getEmail(), dto.getPassword());
    }

    @Override
    public UserDto toDto(Users entity) {
        return new UserDto(entity.getName(), entity.getUsername(), entity.getEmail(), entity.getPassword());
    }
}
