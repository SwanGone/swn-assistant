package com.swnerrata.swnassstant.controllers;

import com.swnerrata.swnassstant.models.GameCharacter;
import com.swnerrata.swnassstant.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by seanburk on 8/3/17.
 */
@Controller
@RequestMapping(value = "gmapproval")
public class GMApprovalController extends AbstractController {

    @RequestMapping(value = "")
    public String index(Model model,  HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());
        if (user.isGameMaster()) {
            model.addAttribute("unapprovedcharacters", gameCharacterDao.findByApprovedAndAncestor(false, false));
            model.addAttribute("unapprovedgear", gearDao.findByApproved(false));
            model.addAttribute("unapprovedpsychicdisciplines", psychicDisciplineDao.findByApproved(false));
            model.addAttribute("unapprovedskills", skillDao.findByApproved(false));
            return "/gmapproval/index";
        } else {
            return "redirect:/nopeeking";
        }
    }

    @RequestMapping(value = "characterapproval/{gameCharacterId}", method = RequestMethod.GET)
    public String viewCharacterSubmission(Model model, @PathVariable int gameCharacterId, HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());
        if (user.isGameMaster()) {
            GameCharacter proposedGameCharacter = gameCharacterDao.findOne(gameCharacterId);
            model.addAttribute("proposedgamecharacter", proposedGameCharacter);
            if (proposedGameCharacter.getUidToEdit() != proposedGameCharacter.getUid()) {
                GameCharacter originalGameCharacter = gameCharacterDao.findOne(proposedGameCharacter.getUidToEdit());
                model.addAttribute("originalgamecharacter", originalGameCharacter);

                return "gmapproval/characterapproval";
            } else {
                return "gmapproval/newcharacterapproval";
            }
        } else {
            return "redirect:/nopeeking";
        }
    }

    @RequestMapping(value = "characterapproval/{gameCharacterId}", method = RequestMethod.POST)
    public String processCharacterSubmission(@RequestParam boolean judgement, Model model, @PathVariable int gameCharacterId, HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());
        if (user.isGameMaster()) {

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

        } else {
        return "redirect:/nopeeking";
        }


    }
}
