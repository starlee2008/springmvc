package cap.mapper;

import cap.model.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    Admin selectById(Integer id);

    List<Admin> selectAll();

    int addAdmin(Admin admin);

    int updateAdmin(Admin admin);

    int deleteAdmin(Integer id);

    List<Admin> findByPage(@Param(value = "start") int start, @Param(value = "pageSize") int pageSize);

    int getTotalCount();
}
