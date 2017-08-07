package com.swnerrata.swnassstant.controllers;

import com.swnerrata.swnassstant.models.Gear;
import com.swnerrata.swnassstant.models.User;
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
@RequestMapping(value = "gear")
public class GearController extends AbstractController {


    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("gear", gearDao.findAll());
        return "/gear/index";
    }

    @RequestMapping(value = "/create")
    public String createForm(Model model, HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());
        if (user.isGameMaster()) {
            model.addAttribute(new Gear());
            model.addAttribute("title", "Create Gear");
            return "gear/create";
        } else {
            return "redirect:/nopeeking";
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, @ModelAttribute @Valid Gear gear, Errors errors, HttpServletRequest request) {

        User user = getUserFromSession(request.getSession());
        if (user.isGameMaster()) {
            if (errors.hasErrors()) {
                model.addAttribute("title", "Create Gear");
                return "gear/create";
            }

            gearDao.save(gear);
            gear.setUidToEdit(gear.getUid());
            gear.setApproved(true);
            gearDao.save(gear);

            return "redirect:/gear";
        } else {
            return "redirect:/nopeeking";
        }
    }

    @RequestMapping(value = "view/{gearId}", method = RequestMethod.GET)
    public String viewGameCharacter(Model model, @PathVariable int gearId) {

        Gear gear = gearDao.findOne(gearId);
        model.addAttribute("gear", gear);

        return "gear/view";
    }

    @RequestMapping(value = "/edit/{gearId}")
    public String displayEditForm(Model model, @PathVariable int gearId, HttpServletRequest request) {

        User user = getUserFromSession(request.getSession());
        if (user.isGameMaster()) {
            Gear gear = gearDao.findOne(gearId);
            model.addAttribute("gear", gear);
            model.addAttribute("title", "Edit Gear");

            return "gear/edit";
        } else {
            return "redirect:/nopeeking";
        }
    }

    @RequestMapping(value = "/edit/{gearId}", method = RequestMethod.POST)
    public String edit(Model model,@PathVariable int gearId, @ModelAttribute @Valid Gear gear, Errors errors, HttpServletRequest request) {

        User user = getUserFromSession(request.getSession());
        if (user.isGameMaster()) {
            if (errors.hasErrors()) {
                model.addAttribute("title", "Errors Character");
                return "gear/edit/" + gear.getUid();
            }

            Gear originalGear = gearDao.findOne(gearId);
            gearDao.save(gear);
            gear.setUidToEdit(gearId);
            originalGear.setAncestor(true);
            gear.setApproved(true);
            gearDao.save(gear);
            gearDao.save(originalGear);

            return "redirect:/gear";
        } else {
            return "redirect:/nopeeking";
        }
    }
}
