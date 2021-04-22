package com.hk01.server.service.Impl;

import com.hk01.server.pojo.Department;
import com.hk01.server.mapper.DepartmentMapper;
import com.hk01.server.pojo.RespBean;
import com.hk01.server.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nnnNN
 * @since 2021-04-04
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartments(-1);
    }

    @Override
    public RespBean addDep(Department department) {
        department.setEnabled(true);
        departmentMapper.addDep(department);
       if(department.getResult()==1){
           return  RespBean.success("添加成功",department);
       }
       return RespBean.error("添加失败");
    }



    @Override
    public RespBean deleteDep(Integer id) {
        Department department = new Department();
        department.setId(id);
        departmentMapper.deleteDep(department);
        if (-2 == department.getResult()){
            return RespBean.error("该部门下有子部门，删除失败！");
        }
        if (-1 == department.getResult()){
            return RespBean.error("该部门下有员工，删除失败！");
        }
        if (1 == department.getResult()){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败");
    }
}
