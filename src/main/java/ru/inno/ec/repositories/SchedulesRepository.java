package ru.inno.ec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.ec.models.Schedule;
import java.util.Date;
import java.util.List;

public interface SchedulesRepository extends JpaRepository<Schedule,Long> {
    List<Schedule> findAllByDateGreaterThanEqual(Date date);
}
