package com.stefan.training;


import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HelloController {

    @RequestMapping(value = "/home")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("welcome", "This is home page!");
        mv.addObject("principal", getCurrentUser());
        mv.addObject("roles", getRoles());
        mv.setViewName("/home");
        return mv;
    }

    @RequestMapping("/admin")
    public ModelAndView admin() {
        ModelAndView mv = new ModelAndView("/admin");
        mv.addObject("welcomeMessage", "Welcome to Admin page!!!");
        mv.addObject("principal", getCurrentUser());
        mv.addObject("roles", getRoles());
        return mv;
    }

    @RequestMapping("/user")
    public ModelAndView user() {
        ModelAndView mv = new ModelAndView("/user");
        mv.addObject("welcomeMessage", "Welcome to User page!!!");
        mv.addObject("principal", getCurrentUser());
        mv.addObject("roles", getRoles());
        return mv;
    }

    private String getRoles() {
        if (isLoggedIn()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String roles = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.joining(", "));
            return roles;
        } else {
            return "";
        }
    }

    private String getCurrentUser() {
        if (isLoggedIn()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            return username;
        } else {
            return null;
        }
    }

    private boolean isLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated()
                && !(authentication instanceof AnonymousAuthenticationToken);
    }


}
