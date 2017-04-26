package com.stefan.training;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

//    @RequestMapping("/welcome")
//    public ModelAndView hello() {
//        String welcomeMessage = "Hello Controller -  Message";
//        return new ModelAndView("hello", "welcomeMessage", welcomeMessage);
//    }

    @RequestMapping(value = "/home")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("welcome", "This is home page!");
        mv.setViewName("/home");
        return mv;
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("username", "u");
        mv.addObject("password", "p");
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("username") String username, @ModelAttribute("password") String password) {
        if (isValid(username, password)) {
            return "home";
        } else {
            return "login?error";
        }
    }

    private boolean isValid(String username, String password) {
        return username.charAt(0) == password.charAt(0);
    }


}
