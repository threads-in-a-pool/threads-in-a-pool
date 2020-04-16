package org.academiadecodigo.rhashtafaris.threadsinapool.controller.web;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.LoginEntity;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.User;
import org.academiadecodigo.rhashtafaris.threadsinapool.serverExceptions.NotFoundEx;
import org.academiadecodigo.rhashtafaris.threadsinapool.service.AuthenticationService;
import org.academiadecodigo.rhashtafaris.threadsinapool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class LoginController {

    private AuthenticationService authenticationService;
    private UserService userService;

    @ModelAttribute("user")
    public User setupForm() {
        return new User();
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute("user") User user, Model model) {

        try {

            if (authenticationService.authenticateUser(user.getUsername(), user.getPassword())) {

                User loggedUser = userService.getByName(user.getUsername());

                model.addAttribute("user", loggedUser);
                return "index";
            }
            model.addAttribute("message", "Login failed. Try again.");
            return "index";
        } catch (NotFoundEx notFoundEx) {
            model.addAttribute("message", "Login failed. Try again.");
            return "index";
        }
    }

    @Autowired
    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
