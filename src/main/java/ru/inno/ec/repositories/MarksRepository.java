package ru.inno.ec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.ec.models.Marks;
import ru.inno.ec.models.User;

import java.util.List;

public interface MarksRepository extends JpaRepository<Marks,Long> {

    List<Marks> findAllByLessonId(Long id);
    List<Marks> findAllByUserId(Long id);
}
