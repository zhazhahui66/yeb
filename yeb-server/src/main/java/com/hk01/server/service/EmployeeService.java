package com.hk01.server.service;

import com.hk01.server.pojo.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hk01.server.pojo.RespBean;
import com.hk01.server.pojo.RespPageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nnnNN
 * @since 2021-04-04
 */
public interface EmployeeService extends IService<Employee> {
    /**
     * 获取所有员工(分页)
     * @param currentPage
     * @param size
     * @param employee
     * @param beginDateScope
     * @return
     */
    RespPageBean getEmployeeByPage(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDateScope);



    /**
      *添加员工
     * @param employee
     * @return
     */
    RespBean addEmp(Employee employee);

    /**
     * 获取工号
     * @return
     */
    RespBean maxWorkID();

    /**
     * 查询员工信息
     * @param id
     */
    List<Employee> getEmployee(Integer id);
}
