package com.assignment.demo.service;

import com.assignment.demo.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> fetchUsersFromApiAndSave();

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

}
