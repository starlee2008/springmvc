package cap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class TestController {
    @RequestMapping(value = "test")
    public String test() {
        return "/user/list";
    }

}