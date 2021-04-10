package com.hk01.server.service.Impl;

import com.hk01.server.pojo.Admin;
import com.hk01.server.pojo.Menu;
import com.hk01.server.mapper.MenuMapper;
import com.hk01.server.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenusByAdminId() {

        return menuMapper.getMenusByAdminId(
                ((Admin)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }
}
