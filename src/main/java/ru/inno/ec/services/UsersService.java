package ru.inno.ec.services;

import ru.inno.ec.dto.UserForm;
import ru.inno.ec.models.User;

import java.util.List;

public interface UsersService {
    List<User> getAllUsers();

    void addUser(UserForm user);

    User getUser(Long id);

    void updateUser(Long userId, UserForm user);

    void deleteUser(Long userId);
    public List<User> getUsersByGroupId(Long id);
}
