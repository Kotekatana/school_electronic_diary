package ru.inno.ec.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inno.ec.models.Discipline;
import ru.inno.ec.repositories.DisciplinesRepository;
import ru.inno.ec.services.DisciplinesService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DisciplinesServiceImpl implements DisciplinesService {

    private final DisciplinesRepository disciplinesRepository;
    @Override
    public List<Discipline> getAllDisciplines() {
        return disciplinesRepository.findAll();
    }

    @Override
    public void removeDiscipline(Long id) {
        Discipline discipline = disciplinesRepository.findById(id).orElseThrow();
        disciplinesRepository.delete(discipline);
    }

    @Override
    public void addDiscipline(Discipline discipline) {
        disciplinesRepository.save(discipline);
    }
}
