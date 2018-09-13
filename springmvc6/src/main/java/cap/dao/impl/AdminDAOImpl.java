package cap.dao.impl;

import cap.dao.AdminDAO;
import cap.model.Admin;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "adminDAO")
public class AdminDAOImpl implements AdminDAO {
    private JdbcTemplate jdbcTemplate;

    @Resource(name = "jdbcTemplate")
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Admin login(Admin admin) {
        String sql = "select * from admin where username=? and password=?";
        return this.jdbcTemplate.queryForObject(sql, new Object[]{admin.getUsername(), admin.getPassword()}, ParameterizedBeanPropertyRowMapper.newInstance(Admin.class));

    }

    @Override
    public List<Admin> findByPage(int pageNo, int pageSize) {
        String sql = "select * from admin limit ?,?";
        int start = (pageNo - 1) * pageSize;
        return this.jdbcTemplate.query(sql, new Object[]{start, pageSize}, ParameterizedBeanPropertyRowMapper.newInstance(Admin.class));
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(*) from admin";
        return jdbcTemplate.queryForObject(sql, Integer.class);

    }
}
