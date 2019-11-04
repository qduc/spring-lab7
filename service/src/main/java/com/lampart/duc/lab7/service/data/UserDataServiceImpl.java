package com.lampart.duc.lab7.service.data;

import com.lampart.duc.lab7.api.data.DataService;
import com.lampart.duc.lab7.api.data.DtoEntityAdapter;
import com.lampart.duc.lab7.data.entity.Users;
import com.lampart.duc.lab7.data.repository.UserRepository;
import com.lampart.duc.lab7.service.dto.UserDto;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDataServiceImpl implements DataService<UserDto> {

    private UserRepository userRepository;

    private DtoEntityAdapter<UserDto, Users> dtoEntityAdapter;

    public UserDataServiceImpl(UserRepository userRepository, DtoEntityAdapter<UserDto, Users> dtoEntityAdapter) {
        this.userRepository = userRepository;
        this.dtoEntityAdapter = dtoEntityAdapter;
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        Optional<Users> optional = userRepository.findById(id);
        return optional.map(users -> dtoEntityAdapter.toDto(users));
    }

    @Override
    public Iterable<UserDto> findAll() {
        Iterable<Users> entities = userRepository.findAll();
        List<UserDto> dtoList = new ArrayList<>();
        for (Users entity : entities) {
            dtoList.add(dtoEntityAdapter.toDto(entity));
        }
        return dtoList;
    }

    @Override
    public UserDto save(UserDto dto) {
        Users entity = dtoEntityAdapter.toEntity(dto);
        return dtoEntityAdapter.toDto(userRepository.save(entity));
    }
}
