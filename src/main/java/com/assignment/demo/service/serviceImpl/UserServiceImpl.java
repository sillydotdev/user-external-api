package com.assignment.demo.service.serviceImpl;

import com.assignment.demo.dto.UserApiResponse;
import com.assignment.demo.dto.UserDto;
import com.assignment.demo.entity.User;
import com.assignment.demo.mapper.UserMapper;
import com.assignment.demo.repository.UserRepository;
import com.assignment.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final WebClient webClient;

    private static final String API_URL = "/users"; // Relative to base URL

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, WebClient webClient) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.webClient = webClient;
    }

    @Override
    public List<UserDto> fetchUsersFromApiAndSave() {
//        // Fetch users from the external API
//        UserDto[] userDtos =
//                webClient
//                        .get()
//                        .uri(API_URL)
//                        .retrieve()
//                        .bodyToMono(UserDto[].class)
//                        .block(); // Use block() to get the result synchronously
//
//        if (userDtos == null) {
//            throw new RuntimeException("Could not fetch users from the API");
//        }
//
//        List<UserDto> userDtoList = Arrays.asList(userDtos);
//
//        // Convert DTOs to Entities and save to the database
//        List<User> users = userDtoList.stream().map(userMapper::toEntity).collect(Collectors.toList());
//        userRepository.saveAll(users);
//
//        return userDtoList;

        UserApiResponse response =
                webClient
                        .get()
                        .uri(API_URL)
                        .retrieve()
                        .bodyToMono(UserApiResponse.class)
                        .block(); // Use block() to get the result synchronously

        if (response == null || response.getUsers() == null) {
            throw new RuntimeException("Could not fetch users from the API");
        }

        List<UserDto> userDtoList = response.getUsers();

        // Convert DTOs to Entities and save to the database
        List<User> users = userDtoList.stream().map(userMapper::toEntity).collect(Collectors.toList());
        userRepository.saveAll(users);

        return userDtoList;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toDtoList(users);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user =
                userRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return userMapper.toDto(user);
    }
}
