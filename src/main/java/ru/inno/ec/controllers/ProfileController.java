package ru.inno.ec.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.inno.ec.models.Marks;
import ru.inno.ec.models.Schedule;
import ru.inno.ec.models.User;
import ru.inno.ec.security.details.CustomUserDetails;
import ru.inno.ec.services.MarksService;
import ru.inno.ec.services.ProfileService;
import ru.inno.ec.services.ScheduleService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Controller
public class ProfileController {

    private final ProfileService profileService;
    private final ScheduleService scheduleService;
    private final MarksService marksService;

    @GetMapping("/")
    public String getRoot() {
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String getProfile(@AuthenticationPrincipal CustomUserDetails userDetails,
                             Model model) {
        model.addAttribute("user", profileService.getCurrentUser(userDetails));
        model.addAttribute("role",userDetails.getUser().getRole());
        return "profile/profile_page";
    }
    @GetMapping("/profile/marks")
    public String getMarks(@AuthenticationPrincipal CustomUserDetails userDetails,
                             Model model) {
        Long userId = userDetails.getUser().getId();
        List<Marks> result = marksService.getAllMarks();
        List<Marks> usermarks = new ArrayList<>();
        result.forEach(marks -> {
            if (marks.getUserId().getId()==userId){
                usermarks.add(marks);
            }
        });
        usermarks.sort((a,b)-> a.getLesson().getDate().compareTo(b.getLesson().getDate()));
        Collections.reverse(usermarks);
        model.addAttribute("marks",usermarks);
        return "profile/marks_page";
    }
    @GetMapping("/profile/schedule")
    public String getSchedule(@AuthenticationPrincipal CustomUserDetails userDetails,
                           Model model) {
        model.addAttribute("user", profileService.getCurrentUser(userDetails));
        List<Schedule> scheduleList = scheduleService.getSchedule();

        List<Schedule> result = scheduleList.stream().filter(schedule -> schedule.getGroupId().equals(userDetails.getUser().getLearning())).toList();
        Map<Date,List<Schedule>> scheduleGroupped = result.stream().collect(Collectors.groupingBy(Schedule::getDate));
        scheduleGroupped.forEach((date, schedules) -> schedules.sort((a,b)->a.getLessonNumber()-b.getLessonNumber()));

        Map<Date,List<Schedule>> prepearedMap = new TreeMap<>();
        scheduleGroupped.forEach((date, schedules) -> prepearedMap.put(date,schedules) );
        model.addAttribute("schedule",prepearedMap);

        return "profile/profile_schedule_page";
    }
}
