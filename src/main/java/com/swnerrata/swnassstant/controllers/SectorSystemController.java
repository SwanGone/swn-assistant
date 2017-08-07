package com.swnerrata.swnassstant.controllers;

import com.swnerrata.swnassstant.models.SectorSystem;
import com.swnerrata.swnassstant.models.Skill;
import com.swnerrata.swnassstant.models.User;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by seanburk on 7/28/17.
 */
@Controller
@RequestMapping(value = "sectorsystem")
public class SectorSystemController extends AbstractController {


    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("firstrow", sectorSystemDao.findByRowNumber("0"));
        model.addAttribute("secondrow", sectorSystemDao.findByRowNumber("1"));
        model.addAttribute("thirdrow", sectorSystemDao.findByRowNumber("2"));
        model.addAttribute("fourthrow", sectorSystemDao.findByRowNumber("3"));
        model.addAttribute("fifthrow", sectorSystemDao.findByRowNumber("4"));
        model.addAttribute("sixthrow", sectorSystemDao.findByRowNumber("5"));
        model.addAttribute("seventhrow", sectorSystemDao.findByRowNumber("6"));
        model.addAttribute("eighthrow", sectorSystemDao.findByRowNumber("7"));
        model.addAttribute("ninthrow", sectorSystemDao.findByRowNumber("8"));
        model.addAttribute("tenthrow", sectorSystemDao.findByRowNumber("9"));

        return "/sectorsystem/index";
    }

    @RequestMapping(value = "/create")
    public String createForm(Model model, HttpServletRequest request) {

        User user = getUserFromSession(request.getSession());
        if (user.isGameMaster()) {
            model.addAttribute(new SectorSystem());
            model.addAttribute("title", "Create System");
            return "sectorsystem/create";
        } else {
            return "redirect:/nopeeking";
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, @ModelAttribute @Valid SectorSystem sectorSystem, Errors errors, HttpServletRequest request) {

        User user = getUserFromSession(request.getSession());
        if (user.isGameMaster()) {
            if (errors.hasErrors()) {
                model.addAttribute("title", "Create System");
                return "sectorsystem/create";
            }

            sectorSystemDao.save(sectorSystem);
            sectorSystem.setUidToEdit(sectorSystem.getUid());
            sectorSystemDao.save(sectorSystem);

            return "redirect:/sectorsystem";
        } else {
            return "redircet:/nopeeking";
        }
    }

    @RequestMapping(value = "view/{sectorSystemId}", method = RequestMethod.GET)
    public String viewSystem(Model model, @PathVariable int sectorSystemId) {

        SectorSystem sectorSystem = sectorSystemDao.findOne(sectorSystemId);
        model.addAttribute("sectorSystem", sectorSystem);

        return "sectorsystem/view";
    }

    @RequestMapping(value = "/edit/{sectorSystemId}")
    public String displayEditForm(Model model, @PathVariable int sectorSystemId, HttpServletRequest request) {

        User user = getUserFromSession(request.getSession());
        if (user.isGameMaster()) {
            SectorSystem sectorSystem = sectorSystemDao.findOne(sectorSystemId);
            model.addAttribute("sectorSystem", sectorSystem);
            model.addAttribute("title", "Edit System");

            return "sectorsystem/edit";
        } else {
            return "redirect:/nopeeking";
        }
    }

    @RequestMapping(value = "/edit/{sectorSystemId}", method = RequestMethod.POST)
    public String edit(Model model,@PathVariable int sectorSystemId, @ModelAttribute @Valid SectorSystem sectorSystem, Errors errors, HttpServletRequest request) {

        User user = getUserFromSession(request.getSession());
        if (user.isGameMaster()) {
            if (errors.hasErrors()) {
                model.addAttribute("title", "Errors Character");
                return "sectorsystem/edit/" + sectorSystem.getUid();
            }

            SectorSystem originalSectorSystem = sectorSystemDao.findOne(sectorSystemId);
            sectorSystemDao.save(sectorSystem);
            sectorSystem.setUidToEdit(sectorSystemId);
            originalSectorSystem.setAncestor(true);
            sectorSystem.setApproved(true);
            sectorSystemDao.save(sectorSystem);
            sectorSystemDao.save(originalSectorSystem);

            return "redirect:/sectorsystem";
        } else {
            return "redirect:/nopeeking";
        }
    }
}
