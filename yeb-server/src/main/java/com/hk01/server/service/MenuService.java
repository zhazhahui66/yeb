package com.hk01.server.service;

import com.hk01.server.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nnnNN
 * @since 2021-04-04
 */
public interface MenuService extends IService<Menu> {
    /**
     * 通过用户ID查询菜单列表
     * @return
     */
    List<Menu> getMenusByAdminId();
}
