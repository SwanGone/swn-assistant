package com.swnerrata.swnassstant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by seanburk on 8/3/17.
 */
@Controller
@RequestMapping(value = "gmapproval")
public class GMApprovalController {

    @RequestMapping(value = "")
    public String index(Model model) {
        return "index";
    }
}
