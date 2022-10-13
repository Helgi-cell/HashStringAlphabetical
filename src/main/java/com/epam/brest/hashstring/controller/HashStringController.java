package com.epam.brest.hashstring.controller;

import com.epam.brest.hashstring.service.HashStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HashStringController {
    @Autowired (required = true)
    HashStringService hashStringService;

    @GetMapping(value = "/hashstrings")
    public final String lectors (Model model) {
        model.addAttribute("strings", hashStringService.getAllHashStrings());
        return "hashstrings";
    }


}
