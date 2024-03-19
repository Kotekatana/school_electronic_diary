package ru.inno.ec.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.inno.ec.dto.UserForm;
import ru.inno.ec.models.Group;
import ru.inno.ec.models.User;
import ru.inno.ec.repositories.LearningGroupsRepository;
import ru.inno.ec.repositories.UsersRepository;
import ru.inno.ec.services.SignUpService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class SignUpServiceImpl implements SignUpService {

    private final UsersRepository usersRepository;
    private final LearningGroupsRepository learningGroupsRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm userForm) {
        Date date = null;
        Group learning = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(userForm.getDateOfBirth());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        User.Role role = userForm.getRole();
        if(role==null){
            role = User.Role.USER;
        }
        if(userForm.getGroupId()!=null){
            learning = learningGroupsRepository.findById(userForm.getGroupId()).orElseThrow();
        }
        User newUser = User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .state(User.State.CONFIRMED)
                .role(role)
                .learning(learning)
                .dateOfBirth(date)
                .age(0)
                .build();

        usersRepository.save(newUser);
    }
}
