package com.pj.quest.springboot.controller;

import com.pj.quest.data.QuestDataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@SuppressWarnings("unused")
@Controller
public class QuestController {

    @Autowired
    private QuestDataManager dataManager;

    @RequestMapping("/")
    public String home(ModelMap model) {

        model.addAttribute("ninetyTwoClubTotal", dataManager.getNinetyTwoClubTotal());
        model.addAttribute("divisions", dataManager.getDivisions());
        return "home";
    }
}
