package org.launchcode.controllers;

import org.launchcode.models.User;
import org.launchcode.models.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;


@Controller
@RequestMapping("user")
public class UserController {


    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("users", UserData.getAll());
        model.addAttribute("title", "Cheese App Users");
        return "user/index";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String dispayAddUserForm(Model model) {
        model.addAttribute("title", "User Sign Up");
        model.addAttribute(new User());
        return "user/add";
    }

    //use model binding instead of the @RequestParam
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddUserForm(@ModelAttribute  @Valid User newUser,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Register");
            return "user/add";
        }

        UserData.add(newUser);
        model.addAttribute("name", newUser.getUsername());
        return "redirect:";
    }

    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public String profile(Model model) {
        model.addAttribute("title", "User Profile");
        return "user/profile";
    }




}
