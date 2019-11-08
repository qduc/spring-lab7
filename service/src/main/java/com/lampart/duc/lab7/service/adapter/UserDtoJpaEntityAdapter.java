package com.lampart.duc.lab7.service.adapter;

import com.lampart.duc.lab7.api.data.DtoEntityAdapter;
import com.lampart.duc.lab7.data.entity.Users;
import com.lampart.duc.lab7.service.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserDtoJpaEntityAdapter implements DtoEntityAdapter<UserDto, Users> {

    @Override
    public Users toEntity(UserDto dto) {
        Users entity = new Users(dto.getName(), dto.getUsername(), dto.getEmail(), dto.getPassword(), dto.getCreatedAt(), dto.getUpdatedAt());
        entity.setId(dto.getId());
        return entity;
    }

    @Override
    public UserDto toDto(Users entity) {
        return new UserDto(entity.getId(), entity.getName(), entity.getUsername(), entity.getEmail(), entity.getPassword(), entity.getCreatedAt(), entity.getUpdatedAt());
    }
}
