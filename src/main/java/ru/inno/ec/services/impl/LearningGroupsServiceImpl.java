package ru.inno.ec.services.impl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inno.ec.models.Group;
import ru.inno.ec.repositories.LearningGroupsRepository;
import ru.inno.ec.services.LearningGroupsService;
import java.util.List;
@Service
@RequiredArgsConstructor
public class LearningGroupsServiceImpl  implements LearningGroupsService  {

    private final LearningGroupsRepository learningGroupsRepository;


    @Override
    public List<Group> getAllLearningGroups() {

        return learningGroupsRepository.findAll();
    }

    @Override
    public void addLearningGroup(Group group) {
        learningGroupsRepository.save(group);
    }

    @Override
    public void removeLearningGroup(Long id) {
        Group learningGroup = learningGroupsRepository.findById(id).orElseThrow();
        learningGroupsRepository.delete(learningGroup);
    }
}
