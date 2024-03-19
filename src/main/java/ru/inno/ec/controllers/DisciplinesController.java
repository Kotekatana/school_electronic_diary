package ru.inno.ec.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.inno.ec.models.Discipline;
import ru.inno.ec.services.DisciplinesService;

@Controller
@RequiredArgsConstructor
public class DisciplinesController {
    private final DisciplinesService disciplinesService;

    @GetMapping("/disciplines")
    public String getDisciplinesPage(Model model) {
        model.addAttribute("disciplines",disciplinesService.getAllDisciplines());
        return "discipline/discipline_page";
    }
    @PostMapping("/disciplines")
    public String addDiscipline(Discipline discipline) {
        disciplinesService.addDiscipline(discipline);
        return "redirect:/disciplines";
    }
    @GetMapping("/disciplines/{discipline-id}/delete")
    public String deleteDiscipline(@PathVariable("discipline-id") Long disciplineId) {
        disciplinesService.removeDiscipline(disciplineId);
        return "redirect:/disciplines";
    }
}
