package com.swnerrata.swnassstant.controllers;

import com.swnerrata.swnassstant.models.GameCharacter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by seanburk on 8/3/17.
 */
@Controller
@RequestMapping(value = "gmapproval")
public class GMApprovalController extends AbstractController {

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("unapprovedcharacters", gameCharacterDao.findByApprovedAndAncestor(false, false));
        model.addAttribute("unapprovedgear", gearDao.findByApproved(false));
        model.addAttribute("unapprovedpsychicdisciplines", psychicDisciplineDao.findByApproved(false));
        model.addAttribute("unapprovedskills", skillDao.findByApproved(false));
        return "/gmapproval/index";
    }

    @RequestMapping(value = "characterapproval/{gameCharacterId}", method = RequestMethod.GET)
    public String viewCharacterSubmission(Model model, @PathVariable int gameCharacterId) {


        GameCharacter proposedGameCharacter = gameCharacterDao.findOne(gameCharacterId);
        model.addAttribute("proposedgamecharacter", proposedGameCharacter);
        if (proposedGameCharacter.getUidToEdit() != proposedGameCharacter.getUid()) {
            GameCharacter originalGameCharacter = gameCharacterDao.findOne(proposedGameCharacter.getUidToEdit());
            model.addAttribute("originalgamecharacter", originalGameCharacter);

            return "gmapproval/characterapproval";
        } else {
            return "gmapproval/newcharacterapproval";
        }
    }

    @RequestMapping(value = "characterapproval/{gameCharacterId}", method = RequestMethod.POST)
    public String processCharacterSubmission(@RequestParam boolean judgement, Model model, @PathVariable int gameCharacterId, HttpServletRequest request) {
        GameCharacter proposedGameCharacter = gameCharacterDao.findOne(gameCharacterId);
        GameCharacter originalGameCharacter = gameCharacterDao.findOne(proposedGameCharacter.getUidToEdit());
        if (judgement && proposedGameCharacter.getUid() != originalGameCharacter.getUid()) {
            originalGameCharacter.setApproved(false);
            originalGameCharacter.setAncestor(true);
            gameCharacterDao.save(originalGameCharacter);
            proposedGameCharacter.setApproved(true);
            gameCharacterDao.save(proposedGameCharacter);
        } else if (judgement && proposedGameCharacter.getUid() == originalGameCharacter.getUid()) {
            proposedGameCharacter.setApproved(true);
            gameCharacterDao.save(proposedGameCharacter);
        } else if (!judgement) {
            gameCharacterDao.delete(gameCharacterId);
        }

        return "redirect:/gmapproval";

    }


}
