package com.swnerrata.swnassstant.controllers;

import com.swnerrata.swnassstant.models.PsychicDiscipline;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by seanburk on 7/28/17.
 */
@Controller
@RequestMapping(value = "psychicdiscipline")
public class PsychicDisciplineController extends AbstractController {


    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("psychicdisciplines", psychicDisciplineDao.findAll());
        return "psychicdiscipline/index";
    }

    @RequestMapping(value = "/create")
    public String createForm(Model model) {
        model.addAttribute(new PsychicDiscipline());
        model.addAttribute("title", "Create Discipline");
        return "psychicdiscipline/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, @ModelAttribute @Valid PsychicDiscipline psychicDiscipline, Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Discipline");
            return "psychicdiscipline/create";
        }

        psychicDisciplineDao.save(psychicDiscipline);

        return "redirect:/psychicdiscipline";
    }

    @RequestMapping(value = "view/{psychicDisciplineId}", method = RequestMethod.GET)
    public String viewPsychicDiscipline(Model model, @PathVariable int psychicDisciplineId) {

        PsychicDiscipline psychicDiscipline  = psychicDisciplineDao.findOne(psychicDisciplineId);
        model.addAttribute("psychicDiscipline", psychicDiscipline);

        return "psychicdiscipline/view";
    }

    @RequestMapping(value = "/edit/{psychicDisciplineId}")
    public String displayEditForm(Model model, @PathVariable int psychicDisciplineId) {

        PsychicDiscipline psychicDiscipline = psychicDisciplineDao.findOne(psychicDisciplineId);
        model.addAttribute("psychicDiscipline", psychicDiscipline);
        model.addAttribute("title", "Edit Discipline");

        return "psychicdiscipline/edit";
    }

    @RequestMapping(value = "/edit/{psychicDisciplineId}", method = RequestMethod.POST)
    public String edit(Model model, @ModelAttribute @Valid PsychicDiscipline psychicDiscipline,
                       Errors errors, HttpServletRequest request) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Errors Character");
            return "psychicdscipline/edit/" + psychicDiscipline.getUid();
        }

        psychicDisciplineDao.save(psychicDiscipline);

        return "redirect:/psychicdiscipline";
    }
}
