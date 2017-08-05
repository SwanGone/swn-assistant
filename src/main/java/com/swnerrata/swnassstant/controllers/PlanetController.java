package com.swnerrata.swnassstant.controllers;

import com.swnerrata.swnassstant.models.GameCharacter;
import com.swnerrata.swnassstant.models.Planet;
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
@RequestMapping(value = "planet")
public class PlanetController extends AbstractController {


    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("planets", planetDao.findByApprovedAndAncestor(true, false));
        return "/planet/index";
    }

    @RequestMapping(value = "/create")
    public String createForm(Model model) {
        model.addAttribute(new Planet());
        model.addAttribute("title", "Create Planet");
        return "planet/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, @ModelAttribute @Valid Planet planet, Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Planet");
            return "planet/create";
        }


        planetDao.save(planet);
        planet.setUidToEdit(planet.getUid());
        planet.setApproved(true);
        planetDao.save(planet);

        return "redirect:/planet";
    }

    @RequestMapping(value = "view/{planetId}", method = RequestMethod.GET)
    public String viewPlanet(Model model, @PathVariable int planetId) {

        Planet planet = planetDao.findOne(planetId);
        model.addAttribute("planet", planet);
        model.addAttribute("title", "Edit Planet");

        return "planet/view";
    }

    @RequestMapping(value = "/edit/{planetId}")
    public String displayEditForm(Model model, @PathVariable int planetId) {

        Planet planet = planetDao.findOne(planetId);
        model.addAttribute("planet", planet);
        model.addAttribute("title", "Edit Planet");

        return "planet/edit";
    }

    @RequestMapping(value = "/edit/{planetId}", method = RequestMethod.POST)
    public String edit(Model model, @PathVariable int planetId,
                       @ModelAttribute @Valid Planet planet, Errors errors, HttpServletRequest request) {



        if (errors.hasErrors()) {
            model.addAttribute("title", "Errors Character");
            return "planet/edit/" + planet.getUid();
        }



        Planet originalplanet = planetDao.findOne(planetId);
        planetDao.save(planet);
        planet.setUidToEdit(planetId);
        originalplanet.setAncestor(true);
        planet.setApproved(true);
        planetDao.save(planet);

        return "redirect:/planet";
    }
}
