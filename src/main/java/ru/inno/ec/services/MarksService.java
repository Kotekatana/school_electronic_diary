package ru.inno.ec.services;

import ru.inno.ec.models.Discipline;
import ru.inno.ec.models.Marks;
import ru.inno.ec.models.Schedule;

import java.util.List;

public interface MarksService {
    List<Marks>getAllMarksByUserId(Long id);
    List<Marks> getAllMarks();
    List<Marks> getMarksByLessonId(Long id);
    void  removeMark(Long id);
    void addMark(Long id,Marks mark);
    Schedule getScheduleByMarkId(Long id);

}
