package com.swnerrata.swnassstant.controllers;

import com.swnerrata.swnassstant.models.Gear;
import com.swnerrata.swnassstant.models.Skill;
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
@RequestMapping(value = "skill")
public class SkillController extends AbstractController {


    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("skills", skillDao.findAll());
        return "/skill/index";
    }

    @RequestMapping(value = "/create")
    public String createForm(Model model) {
        model.addAttribute(new Skill());
        model.addAttribute("title", "Create Skill");
        return "skill/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, @ModelAttribute @Valid Skill skill, Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Skill");
            return "skill/create";
        }

        skillDao.save(skill);

        return "redirect:/skill";
    }

    @RequestMapping(value = "view/{skillId}", method = RequestMethod.GET)
    public String viewSkill(Model model, @PathVariable int skillId) {

        Skill skill = skillDao.findOne(skillId);
        model.addAttribute("skill", skill);

        return "skill/view";
    }

    @RequestMapping(value = "/edit/{skillId}")
    public String displayEditForm(Model model, @PathVariable int skillId) {

        Skill skill = skillDao.findOne(skillId);
        model.addAttribute("skill", skill);
        model.addAttribute("title", "Edit Skill");

        return "skill/edit";
    }

    @RequestMapping(value = "/edit/{skillId}", method = RequestMethod.POST)
    public String edit(Model model, @ModelAttribute @Valid Skill skill, Errors errors, HttpServletRequest request) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Errors Character");
            return "skill/edit/" + skill.getUid();
        }

        skillDao.save(skill);

        return "redirect:/skill";
    }
}
