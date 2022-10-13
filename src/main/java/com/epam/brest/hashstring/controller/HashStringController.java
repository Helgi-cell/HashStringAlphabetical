package com.epam.brest.hashstring.controller;

import com.epam.brest.hashstring.component.HashString;
import com.epam.brest.hashstring.service.HashStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class HashStringController {
    @Autowired (required = true)
    private HashStringService hashStringService;

    @GetMapping(value = "/hashstrings")
    public final String lectors (Model model) {
        model.addAttribute("hashstrings", hashStringService.getAllHashStrings());
        return "hashstrings";
    }


    @GetMapping(value = "/hashstring/new")
    public String newUser(@ModelAttribute("hashstring") HashString hashString) throws SQLException
    {
        return "newHashString";
    }

    @PostMapping(value = "/newHashString")
    public String create(@ModelAttribute("hashstring") HashString hashString,
                         Model model) throws SQLException {

        HashString hash = new HashString(hashString.getString(),200);
        hashStringService.saveNewHashString(hash);
        //model.addAttribute("string", string);
        return "redirect:/hashstrings";
    }



}
