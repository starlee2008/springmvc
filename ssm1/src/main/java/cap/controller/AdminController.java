package cap.controller;

import cap.cap.service.AdminService;
import cap.model.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/")
public class AdminController {
    @Resource
    private AdminService adminService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        List<Admin> adminList = adminService.selectAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("admins", adminList);
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String del(@RequestParam(value = "id") Integer id) {
        int res = adminService.deleteAdmin(id);
        if (res > 0)
            return "redirect:/list";
        else
            return "error";


    }

}

