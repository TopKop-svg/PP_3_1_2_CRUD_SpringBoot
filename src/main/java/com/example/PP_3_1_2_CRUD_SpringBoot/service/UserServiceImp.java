package com.example.PP_3_1_2_CRUD_SpringBoot.service;

import com.example.PP_3_1_2_CRUD_SpringBoot.dao.UserDao;
import com.example.PP_3_1_2_CRUD_SpringBoot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
public class UserServiceImp implements UserService{
    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> index() {
        return userDao.index();
    }

    @Override
    @Transactional(readOnly = true)
    public User show(Long id) {
        return userDao.show(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void update(Long id, User updateUser) {
        userDao.update(id, updateUser);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }
}
