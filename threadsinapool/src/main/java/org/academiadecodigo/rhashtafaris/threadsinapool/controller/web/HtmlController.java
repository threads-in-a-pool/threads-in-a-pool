package org.academiadecodigo.rhashtafaris.threadsinapool.controller.web;

import org.academiadecodigo.rhashtafaris.threadsinapool.controller.converter.UserToUserDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.UserDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.serverExceptions.NotFoundEx;
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

    @GetMapping({"", "/"})
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/tickets/{id}")
    public String login(@PathVariable Integer id) {

        if (id > 5 || id < 1){
            return "404";
        }
        
        return "swipeEvent" + id;
    }

    @GetMapping("/register")
    public String signUp() {
        return "register";
    }

    @GetMapping("/profile/{id}")
    public String userProfile(@PathVariable Integer id, Model model) {

        try {
            UserDto userDto = userToUserDto.convert(userService.getById(id));
            model.addAttribute("user", userDto);
            return "profile";
        } catch (NotFoundEx notFoundEx) {
            return "404";
        }
    }
}
