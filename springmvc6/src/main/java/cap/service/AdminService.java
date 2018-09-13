package cap.service;

import cap.model.Admin;
import cap.util.PageBean;

public interface AdminService {
    Admin login(Admin admin);

    PageBean findByPage(int pageNo, int pageSize);
}
