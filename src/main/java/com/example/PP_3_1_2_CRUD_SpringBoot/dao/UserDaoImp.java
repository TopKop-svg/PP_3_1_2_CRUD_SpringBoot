package com.example.PP_3_1_2_CRUD_SpringBoot.dao;

import com.example.PP_3_1_2_CRUD_SpringBoot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }
    @Override
    public User show(Long id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }
    @Override
    public void update(Long id, User updateUser) {
        User user = entityManager.merge(updateUser);
        entityManager.persist(user);
    }
    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

}
