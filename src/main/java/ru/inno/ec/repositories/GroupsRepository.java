package ru.inno.ec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.ec.models.Group;

public interface GroupsRepository extends JpaRepository<Group,Long> {
}
