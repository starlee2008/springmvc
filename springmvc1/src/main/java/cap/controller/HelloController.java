package cap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class HelloController {
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("data","SpringMVC");
        return "test";
    }
}
