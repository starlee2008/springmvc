package cap.controller;

import cap.model.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class FormController {
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView();
        Admin admin = new Admin();
        admin.setUsername("star");
        admin.setAge(22);
        admin.setSelected(true);
        List<String> roles = new ArrayList<String>();
        roles.add("role2");
        roles.add("role3");
        admin.setRoles(roles);
        admin.setSex(1);
        admin.setIntroduction("大家好。，。。。。。。。 ");
        admin.setFavorite(4);

        Map<String, String> roleMap = new HashMap<String, String>();
        roleMap.put("role1", "角色 1");
        roleMap.put("role2", "角色 2");
        roleMap.put("role3", "角色 3");

        Map<Integer, String> ballMap = new HashMap<Integer, String>();
        ballMap.put(1, "篮球");
        ballMap.put(2, "足球");
        ballMap.put(3, "乒乓球");
        ballMap.put(4, "羽毛球");
        ballMap.put(5, "排球");


        modelAndView.addObject("admin", admin);
        modelAndView.addObject("roleMap", roleMap);
        modelAndView.addObject("ballMap", ballMap);
        modelAndView.setViewName("form");


        return modelAndView;

    }
}
