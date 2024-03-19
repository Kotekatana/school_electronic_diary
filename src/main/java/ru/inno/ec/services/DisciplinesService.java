package ru.inno.ec.services;

import ru.inno.ec.models.Discipline;

import java.util.List;

public interface DisciplinesService {
    List<Discipline> getAllDisciplines();
    void  removeDiscipline(Long id);
    void addDiscipline(Discipline discipline);
}
