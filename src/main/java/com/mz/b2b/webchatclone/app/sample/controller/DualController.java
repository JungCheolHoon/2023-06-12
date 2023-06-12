package com.mz.b2b.webchatclone.app.sample.controller;

import com.mz.b2b.webchatclone.app.sample.repository.DualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DualController {

    private final DualRepository dualRepository;

    @Autowired
    public DualController(DualRepository dualRepository) {
        this.dualRepository = dualRepository;
    }

    @GetMapping("/index")
    public String dual(Model model) {
        int result = dualRepository.selectOneFromDual();
        model.addAttribute("result", result);
        return "/index";
    }


    @GetMapping("/chat/main")
    public String al() {
        return "/chat/main";
    }

}