package com.swnerrata.swnassstant.controllers;

import com.swnerrata.swnassstant.models.GameCharacter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by seanburk on 7/28/17.
 */
@Controller
@RequestMapping(value = "characters")
public class GameCharacterController extends AbstractController {



    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("gamecharacters", gameCharacterDao.findAll());
        return "/characters/index";
    }

    @RequestMapping(value = "/create")
    public String createForm(Model model) {
        model.addAttribute(new GameCharacter());
        model.addAttribute("title", "Create GameCharacter");
        return "characters/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, @ModelAttribute @Valid GameCharacter gameCharacter, Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create GameCharacter");
            return "characters/create";
        }

        gameCharacterDao.save(gameCharacter);

        return "redirect:/characters";
    }
}
