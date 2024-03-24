package com.example.PP_3_1_2_CRUD_SpringBoot.service;

import com.example.PP_3_1_2_CRUD_SpringBoot.model.User;

import java.util.List;

public interface UserService {
    List<User> index();

    User show(Long id);

    void save(User user);

    void update(Long id, User updateUser);

    void delete(Long id);
}
