package ru.inno.ec.services.impl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inno.ec.models.Marks;
import ru.inno.ec.models.Schedule;
import ru.inno.ec.repositories.MarksRepository;
import ru.inno.ec.repositories.SchedulesRepository;
import ru.inno.ec.services.MarksService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MarksServiceImpl implements MarksService {
    private final MarksRepository marksRepository;
    private final SchedulesRepository schedulesRepository;
    @Override
    public List<Marks> getAllMarks() {
        return marksRepository.findAll();
    }

    public List<Marks> getAllMarksByUserId(Long id){
        return marksRepository.findAllByUserId(id);
    }
    @Override
    public List<Marks> getMarksByLessonId(Long id) {
        return marksRepository.findAllByLessonId(id);
    }

    public Schedule getScheduleByMarkId(Long id){
        Marks mark = marksRepository.findById(id).orElseThrow();
        return mark.getLesson();
    };
    @Override
    public void removeMark(Long id) {
        Marks marks = marksRepository.findById(id).orElseThrow();
        marksRepository.delete(marks);
    }

    @Override
    public void addMark(Long id,Marks mark) {
        mark.setLesson(schedulesRepository.findById(id).orElseThrow());
        marksRepository.save(mark);
    }
}
