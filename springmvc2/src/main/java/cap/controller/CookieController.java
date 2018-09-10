package cap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class CookieController {
    @RequestMapping(value = "/cookie", method = RequestMethod.GET)
    public String cookie(Model model,
                         @CookieValue(value = "name", required = false) String name,
                         @CookieValue(value = "age", required = false) String age) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "readcookie";
    }

    @RequestMapping(value = "show", method = RequestMethod.GET)
    public String header(Model model,
                         @RequestHeader("host") String hostName,
                         @RequestHeader("Accept") String acceptType,
                         @RequestHeader("Accept-Language") String acceptLang,
                         @RequestHeader("Accept-Encoding") String acceptEnc,
                         @RequestHeader("Cookie") String cookie,
                         @RequestHeader("User-Agent") String userAgent) {

        model.addAttribute("hostName", hostName);
        model.addAttribute("acceptType", acceptType);
        model.addAttribute("acceptLang", acceptLang);
        model.addAttribute("cookie", cookie);
        model.addAttribute("userAgent", userAgent);
        return "showHeader";
    }
}
