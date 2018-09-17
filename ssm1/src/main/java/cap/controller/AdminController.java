package cap.controller;

import cap.service.AdminService;
import cap.model.Admin;
import cap.util.PageBean;
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

    @RequestMapping(value = "/lists", method = RequestMethod.GET)
    public ModelAndView findByPage(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNo) {
        ModelAndView mv = new ModelAndView();
        PageBean pageBean = adminService.findByPage(pageNo, 5);
        mv.addObject("pageBean", pageBean);
        mv.setViewName("lists");
        return mv;
    }

}

