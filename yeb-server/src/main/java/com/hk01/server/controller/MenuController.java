package com.hk01.server.controller;


import com.hk01.server.pojo.Menu;
import com.hk01.server.service.AdminService;
import com.hk01.server.service.MenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nnnNN
 * @since 2021-04-04
 */
@RestController
@RequestMapping("/system/cfg")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "通过用户ID查询菜单列表")
    @GetMapping(value = "/menu")
    public List<Menu> getMenusByAdminId(){
        return menuService.getMenusByAdminId();
    }


}
