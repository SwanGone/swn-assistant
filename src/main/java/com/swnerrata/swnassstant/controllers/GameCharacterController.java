package com.swnerrata.swnassstant.controllers;

import com.swnerrata.swnassstant.models.GameCharacter;
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
@RequestMapping(value = "characters")
public class GameCharacterController extends AbstractController {


    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("gamecharacters", gameCharacterDao.findByApprovedAndAncestor(true, false));
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
            model.addAttribute("title", "Create Character");
            return "characters/create";
        }

        User owner = getUserFromSession(request.getSession());
        gameCharacter.setOwner(owner);

        gameCharacterDao.save(gameCharacter);
        gameCharacter.setUidToEdit(gameCharacter.getUid());
        gameCharacterDao.save(gameCharacter);

        return "redirect:/characters";
    }

    @RequestMapping(value = "view/{gameCharacterId}", method = RequestMethod.GET)
    public String viewGameCharacter(Model model, @PathVariable int gameCharacterId, HttpServletRequest request) {

        User user = getUserFromSession(request.getSession());
        GameCharacter gameCharacter = gameCharacterDao.findOne(gameCharacterId);
        model.addAttribute("isOwnerOrGM", user.isGameMaster() || user.equals(gameCharacter.getOwner()));
        model.addAttribute("gamecharacter", gameCharacter);

        return "characters/view";
    }

    @RequestMapping(value = "/edit/{gameCharacterId}")
    public String displayEditForm(Model model, @PathVariable int gameCharacterId, HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());
        GameCharacter gameCharacter = gameCharacterDao.findOne(gameCharacterId);
        if (user.isGameMaster() || gameCharacter.getOwner().equals(user)) {

            model.addAttribute("gameCharacter", gameCharacter);
            model.addAttribute("title", "Edit Character");

            return "characters/edit";
        } else {
            return "redirect:/nopeeking";
        }
    }

    @RequestMapping(value = "/edit/{gameCharacterId}", method = RequestMethod.POST)
    public String edit(Model model, @PathVariable int gameCharacterId,
                       @ModelAttribute @Valid GameCharacter gameCharacter, Errors errors, HttpServletRequest request) {

        User user = getUserFromSession(request.getSession());
        GameCharacter gameCharacterOwned = gameCharacterDao.findOne(gameCharacterId);
        if (user.isGameMaster() || gameCharacterOwned.getOwner().equals(user)) {

            if (errors.hasErrors()) {
                model.addAttribute("title", "Errors Character");
                return "characters/edit/" + gameCharacter.getUid();
            }


            gameCharacterDao.save(gameCharacter);
            gameCharacter.setUidToEdit(gameCharacterId);
            gameCharacter.setOwner(user);
            gameCharacterDao.save(gameCharacter);

            return "redirect:/characters";

        } else {
            return "redirect:/nopeeking";
        }
    }
}
