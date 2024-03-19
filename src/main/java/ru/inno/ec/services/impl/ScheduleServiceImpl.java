package ru.inno.ec.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inno.ec.dto.ScheduleForm;
import ru.inno.ec.models.Schedule;
import ru.inno.ec.models.User;
import ru.inno.ec.repositories.DisciplinesRepository;
import ru.inno.ec.repositories.LearningGroupsRepository;
import ru.inno.ec.repositories.SchedulesRepository;
import ru.inno.ec.repositories.UsersRepository;
import ru.inno.ec.services.ScheduleService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final SchedulesRepository schedulesRepository;
    private final DisciplinesRepository disciplinesRepository;
    private final UsersRepository usersRepository;
    private final LearningGroupsRepository learningGroupsRepository;
    @Override
    public List<Schedule> getSchedule() {
        Date date = new Date();
        return schedulesRepository.findAllByDateGreaterThanEqual(date);
    }

    @Override
    public void removeSchedule(Long id) {
        Schedule schedule = schedulesRepository.findById(id).orElseThrow();
        schedulesRepository.delete(schedule);
    }

    @Override
    public void addSchedule(ScheduleForm scheduleForm) {
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(scheduleForm.getDate());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Schedule schedule = Schedule.builder()
                .disciplineId(disciplinesRepository.findById(scheduleForm.getDisciplineId()).orElseThrow())
                .groupId(learningGroupsRepository.findById(scheduleForm.getGroupId()).orElseThrow())
                .lessonNumber(scheduleForm.getLessonNumber())
                .date(date)
                .build();

        schedulesRepository.save(schedule);
    }

    @Override
    public Schedule getOneScheduleById(Long id) {
        return schedulesRepository.findById(id).orElseThrow();
    }

    @Override
    public List<User> getUsersByScheduleId(Long id){
        Schedule schedule = schedulesRepository.findById(id).orElseThrow();
        Long sid = schedule.getGroupId().getId();
        return usersRepository.findAllByLearningIdAndRole(sid,User.Role.PUPIL);
    }

    public List<Schedule> getScheduleByGroupId(Long id){
        return schedulesRepository.findAll();
    }
}
