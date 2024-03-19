package ru.inno.ec.services;

import ru.inno.ec.dto.ScheduleForm;
import ru.inno.ec.models.Schedule;
import ru.inno.ec.models.User;

import java.util.List;

public interface ScheduleService {
    List<Schedule> getSchedule();
    void  removeSchedule(Long id);
    void addSchedule(ScheduleForm scheduleForm);

    Schedule getOneScheduleById(Long id);
    List<User> getUsersByScheduleId(Long id);
    List<Schedule> getScheduleByGroupId(Long id);
}
