package cap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("user")
public class TestController {
    @RequestMapping("test")
    public String test(@ModelAttribute("user") String user, Model model) {
        if (user == null)
            return "login";
        else
            model.addAttribute("u", user);
        return "/user/list";

    }

    @RequestMapping("/test1")
    public String test(Model model, HttpSession session) {
        Object user = (Object) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("data", "对不起请登陆");
            return "login";
        }
        model.addAttribute("u", user);
        return "/user/list";
    }
}
