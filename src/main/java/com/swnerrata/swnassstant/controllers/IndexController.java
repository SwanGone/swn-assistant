package com.swnerrata.swnassstant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by seanburk on 7/27/17.
 */
@Controller
public class IndexController extends AbstractController {

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "SWN Assistant");
        return "index";
    }
}
