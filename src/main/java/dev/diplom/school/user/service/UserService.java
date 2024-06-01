package dev.diplom.school.user.service;

import dev.diplom.school.user.model.entity.User;

import java.util.List;

public interface UserService {

    User findByLogin(String login);

    List<User> findAllUser();

}
