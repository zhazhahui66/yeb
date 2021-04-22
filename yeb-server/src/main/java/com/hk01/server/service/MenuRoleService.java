package com.hk01.server.service;

import com.hk01.server.pojo.MenuRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hk01.server.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nnnNN
 * @since 2021-04-04
 */
public interface MenuRoleService extends IService<MenuRole> {

    /**
     * 根据角色id更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
