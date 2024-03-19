package ru.inno.ec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.ec.models.Discipline;

public interface DisciplinesRepository extends JpaRepository<Discipline,Long> {
}
