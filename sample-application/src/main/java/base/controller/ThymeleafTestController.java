package base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class ThymeleafTestController {

    // to access this method the request path must by .../hello/ <- won't work without the / at the end
    // so better use either controller level mapping or method only mapping
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView hello(ModelAndView mv) {
        mv.addObject("message", "Hello Wojtek!!!");
        return mv;
    }
}
