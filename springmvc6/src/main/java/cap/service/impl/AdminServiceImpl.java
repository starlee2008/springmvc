package cap.service.impl;

import cap.dao.AdminDAO;
import cap.model.Admin;
import cap.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDAO adminDAO;

    @Override
    public Admin login(Admin admin) {
        return adminDAO.login(admin);
    }
}
