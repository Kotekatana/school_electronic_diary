package ru.inno.ec.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.inno.ec.dto.UserForm;
import ru.inno.ec.models.User;
import ru.inno.ec.repositories.UsersRepository;
import ru.inno.ec.services.UsersService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final SignUpServiceImpl signUpService;


    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAllByStateNot(User.State.DELETED);
    }

    @Override
    public void addUser(UserForm user) {
        signUpService.signUp(user);
    }

    @Override
    public List<User> getUsersByGroupId(Long id){
        return usersRepository.findAllByLearningId(id);
    }

    @Override
    public User getUser(Long id) {
        return usersRepository.findById(id).orElseThrow();
    }

    @Override
    public void updateUser(Long userId, UserForm updateData) {
        User userForUpdate = usersRepository.findById(userId).orElseThrow();

        userForUpdate.setFirstName(updateData.getFirstName());
        userForUpdate.setLastName(updateData.getLastName());
        userForUpdate.setAge(updateData.getAge());

        usersRepository.save(userForUpdate);
    }

    @Override
    public void deleteUser(Long userId) {
        User userForDelete = usersRepository.findById(userId).orElseThrow();
        userForDelete.setState(User.State.DELETED);

        usersRepository.save(userForDelete);
    }
}
