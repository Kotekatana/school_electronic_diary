package ru.inno.ec.services;

import ru.inno.ec.models.Group;

import java.util.List;

public interface LearningGroupsService {
    List<Group> getAllLearningGroups();
    void addLearningGroup(Group group);
    void removeLearningGroup(Long id);
}
