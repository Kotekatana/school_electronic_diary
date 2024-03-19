package ru.inno.ec.repositories;

import ru.inno.ec.models.User;

import java.util.List;

public interface UsersRepository {
    List<User> findAll(String orderByColumn, String direction);

    void save(User newUser);

    User findById(Long id);
}
