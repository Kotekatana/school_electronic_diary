package ru.inno.ec.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.inno.ec.dto.ScheduleForm;
import ru.inno.ec.models.Marks;
import ru.inno.ec.models.Schedule;
import ru.inno.ec.models.User;
import ru.inno.ec.security.details.CustomUserDetails;
import ru.inno.ec.services.DisciplinesService;
import ru.inno.ec.services.LearningGroupsService;
import ru.inno.ec.services.MarksService;
import ru.inno.ec.services.ScheduleService;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;
    private final DisciplinesService disciplinesService;
    private final MarksService marksService;
    private final LearningGroupsService learningGroupsService;
    @GetMapping("/schedule")
    public String getSchedulePage(@AuthenticationPrincipal CustomUserDetails userDetails,Model model) {
        List<Schedule> scheduleList = scheduleService.getSchedule();
        List<Schedule> result = scheduleList;
        Map<Date,List<Schedule>> scheduleGroupped = result.stream().collect(Collectors.groupingBy(Schedule::getDate));
        scheduleGroupped.forEach((date, schedules) -> schedules.sort((a,b)->a.getLessonNumber()-b.getLessonNumber()));

        Map<Date,List<Schedule>> prepearedMap = new TreeMap<>();
        scheduleGroupped.forEach((date, schedules) -> prepearedMap.put(date,schedules) );
        model.addAttribute("schedule",prepearedMap);
        model.addAttribute("role",userDetails.getUser().getRole());
        model.addAttribute("disciplines",disciplinesService.getAllDisciplines());
        model.addAttribute("groups",learningGroupsService.getAllLearningGroups());
        return "schedule/schedule_page";
    }
    @PostMapping("/schedule")
    public String addSchedule(ScheduleForm schedule) {
        scheduleService.addSchedule(schedule);
        return "redirect:/schedule";
    }
    @GetMapping("/schedule/{schedule-id}")
    public String getUserPage(@AuthenticationPrincipal CustomUserDetails userDetails, @PathVariable("schedule-id") Long id, Model model) {

        List<User> userList = scheduleService.getUsersByScheduleId(id);
        List<Marks> marksList = marksService.getMarksByLessonId(id);
        marksList.forEach(marks -> {
            userList.remove(marks.getUserId());
        });
        model.addAttribute("role",userDetails.getUser().getRole());
        model.addAttribute("users",userList);
        model.addAttribute("marks",marksService.getMarksByLessonId(id));
        model.addAttribute("schedule",scheduleService.getOneScheduleById(id));
        return "schedule/schedul_page";
    }
    @PostMapping("/schedule/{schedule-id}")
    public String addMark(@PathVariable("schedule-id") Long id, Marks mark) {
        marksService.addMark(id,mark);
        return "redirect:/schedule/"+id;
    }
    @GetMapping("/schedule/{schedule-id}/delete")
    public String deleteSchedule(@PathVariable("schedule-id") Long scheduleId) {
        scheduleService.removeSchedule(scheduleId);
        return "redirect:/schedule";
    }
    @GetMapping("/marks/{mark-id}/delete")
    public String deleteMark(@PathVariable("mark-id") Long id) {
        Long lid = marksService.getScheduleByMarkId(id).getId();
        marksService.removeMark(id);
        return "redirect:/schedule/"+lid;
    }
}
