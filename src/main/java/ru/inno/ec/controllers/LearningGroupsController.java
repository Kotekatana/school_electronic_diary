package ru.inno.ec.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.inno.ec.models.Discipline;
import ru.inno.ec.models.Group;
import ru.inno.ec.security.details.CustomUserDetails;
import ru.inno.ec.services.DisciplinesService;
import ru.inno.ec.services.LearningGroupsService;
import ru.inno.ec.services.UsersService;

@Controller
@RequiredArgsConstructor
public class LearningGroupsController {

    private final UsersService usersService;
    private final DisciplinesService disciplinesService;
    private final LearningGroupsService learningGroupsService;
    @GetMapping("/groups")
    public String getGroupsPage(Model model) {
        model.addAttribute("groups",learningGroupsService.getAllLearningGroups());
        return "learninggroups/learningGroups_page";
    }
    @PostMapping("/groups")
    public String addLearningGroup(Group group) {
        learningGroupsService.addLearningGroup(group);
        return "redirect:/groups";
    }
    @GetMapping("/groups/{group-id}")
    public String getUsersByLearningGroup( @PathVariable("group-id") Long groupId,Model model) {
        model.addAttribute("users",usersService.getUsersByGroupId(groupId));
        return "learninggroups/userlist";
    }
    @GetMapping("/groups/{group-id}/delete")
    public String deleteGroup(@PathVariable("group-id") Long groupId) {
        learningGroupsService.removeLearningGroup(groupId);
        return "redirect:/groups";
    }
}
