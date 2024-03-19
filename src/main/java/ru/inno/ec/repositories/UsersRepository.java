package ru.inno.ec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.ec.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    List<User> findAllByLearningId(Long id);

    List<User> findAllByLearningIdAndRole(Long id,User.Role role);
    List<User> findAllByStateNot(User.State state);
    Optional<User> findByEmail(String email);

}
