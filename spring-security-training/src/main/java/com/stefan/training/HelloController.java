package com.stefan.training;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping(value = "/home")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("welcome", "This is home page!");
        mv.addObject("principal", getCurrentUser());
        mv.setViewName("/home");
        return mv;
    }

    @RequestMapping("/admin")
    public ModelAndView admin() {
        ModelAndView mv = new ModelAndView("/admin");
        mv.addObject("welcomeMessage", "Welcome to Admin page!!!");
        mv.addObject("principal", getCurrentUser());
        return mv;
    }

    @RequestMapping("/user")
    public ModelAndView user() {
        ModelAndView mv = new ModelAndView("/user");
        mv.addObject("welcomeMessage", "Welcome to User page!!!");
        mv.addObject("principal", getCurrentUser());
        return mv;
    }

    private String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (isAuthenticated()) {
            String username = authentication.getName();
            return username;
        } else {
            return null;
        }
    }

    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.isAuthenticated();
    }


}
