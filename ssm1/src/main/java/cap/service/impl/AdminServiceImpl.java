package cap.service.impl;

import cap.service.AdminService;
import cap.mapper.AdminMapper;
import cap.model.Admin;
import cap.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin selectById(Integer id) {
        return adminMapper.selectById(id);
    }

    @Override
    public List<Admin> selectAll() {
        return adminMapper.selectAll();
    }

    @Override
    public int addAdmin(Admin admin) {
        return adminMapper.addAdmin(admin);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }

    @Override
    public int deleteAdmin(Integer id) {
        return adminMapper.deleteAdmin(id);
    }

    @Override
    public PageBean findByPage(int pageNo, int pageSize) {
        PageBean pageBean = new PageBean();
        List<Admin> adminList = adminMapper.findByPage((pageNo - 1) * pageSize, pageSize);
        int total = adminMapper.getTotalCount();
        pageBean.setTotalRecords(total);
        pageBean.setList(adminList);
        pageBean.setPageSize(pageSize);
        pageBean.setPageNo(pageNo);
        return pageBean;
    }
}
