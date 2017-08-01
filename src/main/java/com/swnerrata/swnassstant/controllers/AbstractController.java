package com.swnerrata.swnassstant.controllers;

import com.swnerrata.swnassstant.models.User;
import com.swnerrata.swnassstant.models.data.GameCharacterDao;
import com.swnerrata.swnassstant.models.data.GameCharacterDao;
import com.swnerrata.swnassstant.models.data.GearDao;
import com.swnerrata.swnassstant.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by seanburk on 7/27/17.
 */
public abstract class AbstractController {

    @Autowired
    protected UserDao userDao;

    @Autowired
    protected GameCharacterDao gameCharacterDao;

    @Autowired
    protected GearDao gearDao;

    public static final String userSessionKey = "user_id";

    protected User getUserFromSession(HttpSession session) {

        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDao.findOne(userId);
    }

    protected void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getUid());
    }

    @ModelAttribute("userId")
    public Integer getUserIdFromSession(HttpServletRequest request) {
        return (Integer) request.getSession().getAttribute(userSessionKey);
    }
}
