package org.academiadecodigo.rhashtafaris.threadsinapool.controller.web;

import org.academiadecodigo.rhashtafaris.threadsinapool.controller.converter.UserToUserDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.UserDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HtmlController {

    @Autowired
    private UserToUserDto userToUserDto;
    @Autowired
    private UserService userService;

    @GetMapping({"" ,"/"})
    public String index(){
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signup")
    public String signUp(){
        return "signup";
    }

    @GetMapping("/profile/{id}")
    public String userProfile(@PathVariable Integer id, Model model){

        UserDto userDto = userToUserDto.convert(userService.getById(id));
        model.addAttribute("user",userDto);
        return "profile";
    }
}
