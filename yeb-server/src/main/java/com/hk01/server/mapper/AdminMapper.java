package com.hk01.server.mapper;

import com.hk01.server.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hk01.server.pojo.RespBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author nnnNN
 * @since 2021-04-04
 */
public interface AdminMapper extends BaseMapper<Admin> {

    List<Admin> getAllAdmins(@Param("id") Integer id,@Param("keywords") String keywords);


}
