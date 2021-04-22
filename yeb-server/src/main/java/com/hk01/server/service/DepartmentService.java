package com.hk01.server.service;

import com.hk01.server.pojo.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hk01.server.pojo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nnnNN
 * @since 2021-04-04
 */
public interface DepartmentService extends IService<Department> {
    /**
     * 获取所有部门
     * @return
     */
    List<Department> getAllDepartments();

    /**
     * 添加部门
     * @param department
     * @return
     */
    RespBean addDep(Department department);

    /**
     * 删除部门
     * @param id
     * @return
     */
    RespBean deleteDep(Integer id);
}
