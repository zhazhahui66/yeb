package com.hk01.server.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hk01.server.pojo.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hk01.server.pojo.RespPageBean;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author nnnNN
 * @since 2021-04-04
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

     IPage<Employee> getEmployeeByPage(Page<Employee> page, @Param("employee") Employee employee,
                                       @Param("beginDateScope") LocalDate[] beginDateScope);

    List<Employee> getEmployee(Integer id);
}
