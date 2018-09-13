package cap.cap.controller;

import cap.service.AdminService;
import cap.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/")
public class AdminController {
    @Resource
    private AdminService adminService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(@RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNo) {
        PageBean pageBean = adminService.findByPage(pageNo, 5);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageBean", pageBean);
        modelAndView.setViewName("list");
        return modelAndView;

    }
}
