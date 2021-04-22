package com.hk01.server.mapper;

import com.hk01.server.pojo.MenuRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hk01.server.pojo.RespBean;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author nnnNN
 * @since 2021-04-04
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {
    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     */
    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}
