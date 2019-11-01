package com.lampart.duc.lab7.service.data;

import com.lampart.duc.lab7.api.data.UserDataService;
import com.lampart.duc.lab7.data.entity.Users;
import com.lampart.duc.lab7.data.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDataServiceImpl implements UserDataService {

    private UserRepository userRepository;

    public UserDataServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Users> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Iterable<Users> findAll() {
        return userRepository.findAll();
    }
}
