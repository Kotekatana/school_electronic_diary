package ru.inno.ec.services;

import ru.inno.ec.models.User;
import ru.inno.ec.security.details.CustomUserDetails;

import java.util.List;

public interface ProfileService {
    User getCurrentUser(CustomUserDetails userDetails);

}
