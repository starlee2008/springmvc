package cap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, HttpServletRequest request,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password) {
        if (username.equals("admin") && password.equals("admin")) {
            HttpSession session = request.getSession();
            session.setAttribute("u", username);
            model.addAttribute("user", username);
            return "/user/admin";
        } else {
            return "redirect:/login";
        }
    }
}
