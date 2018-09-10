package cap.controller;

import cap.bean.Admin;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class RegisterController {
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(new Admin());
        modelAndView.setViewName("register");
        return modelAndView;

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Validated Admin admin, BindingResult result) {

        if (result.hasErrors()) {
            return "/register";
        } else
            return "welcome";

    }

}
