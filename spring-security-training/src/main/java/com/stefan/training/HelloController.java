package com.stefan.training;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

    @RequestMapping("/admin")
    public ModelAndView admin() {
        return new ModelAndView("/admin", "welcomeMessage", "Welcome to Admin Page !!");
    }





//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String loginPost()
//    {
//        System.out.println("!!!!!!!!!!!!!!Inside login POST");
//        return "login";
//    }
//
//    private boolean isValid(String username, String password) {
//        return username.charAt(0) == password.charAt(0);
//    }


}
