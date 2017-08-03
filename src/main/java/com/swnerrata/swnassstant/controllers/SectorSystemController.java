package com.swnerrata.swnassstant.controllers;

import com.swnerrata.swnassstant.models.SectorSystem;
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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by seanburk on 7/28/17.
 */
@Controller
@RequestMapping(value = "sectorsystem")
public class SectorSystemController extends AbstractController {


    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("firstrow", sectorSystemDao.findByRowNumber("000"));
        model.addAttribute("secondrow", sectorSystemDao.findByRowNumber("001"));
        model.addAttribute("thirdrow", sectorSystemDao.findByRowNumber("002"));
        model.addAttribute("fourthrow", sectorSystemDao.findByRowNumber("003"));
        model.addAttribute("fifthrow", sectorSystemDao.findByRowNumber("004"));
        model.addAttribute("sixthrow", sectorSystemDao.findByRowNumber("005"));
        model.addAttribute("seventhrow", sectorSystemDao.findByRowNumber("006"));
        model.addAttribute("eighthrow", sectorSystemDao.findByRowNumber("007"));
        model.addAttribute("ninthrow", sectorSystemDao.findByRowNumber("008"));
        model.addAttribute("tenthrow", sectorSystemDao.findByRowNumber("009"));

        return "/sectorsystem/index";
    }

    @RequestMapping(value = "/create")
    public String createForm(Model model) {
        model.addAttribute(new SectorSystem());
        model.addAttribute("title", "Create System");
        return "sectorsystem/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, @ModelAttribute @Valid SectorSystem sectorSystem, Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create System");
            return "sectorsystem/create";
        }

        sectorSystemDao.save(sectorSystem);

        return "redirect:/sectorsystem";
    }

    @RequestMapping(value = "view/{sectorSystemId}", method = RequestMethod.GET)
    public String viewSystem(Model model, @PathVariable int sectorSystemId) {

        SectorSystem sectorSystem = sectorSystemDao.findOne(sectorSystemId);
        model.addAttribute("sectorSystem", sectorSystem);

        return "sectorsystem/view";
    }

    @RequestMapping(value = "/edit/{sectorSystemId}")
    public String displayEditForm(Model model, @PathVariable int sectorSystemId) {

        SectorSystem sectorSystem = sectorSystemDao.findOne(sectorSystemId);
        model.addAttribute("sectorSystem", sectorSystemId);
        model.addAttribute("title", "Edit System");

        return "sectorsystem/edit";
    }

    @RequestMapping(value = "/edit/{sectorSystemId}", method = RequestMethod.POST)
    public String edit(Model model, @ModelAttribute @Valid SectorSystem sectorSystem, Errors errors, HttpServletRequest request) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Errors Character");
            return "sectorsystem/edit/" + sectorSystem.getUid();
        }

        sectorSystemDao.save(sectorSystem);

        return "redirect:/sectorsystem";
    }
}
