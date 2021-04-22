/**
 * @program: yeb
 * @description: 权限组
 * @author nnnNN
 * @date 2021-04-11 10:31:53
 */

package com.hk01.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hk01.server.pojo.Menu;
import com.hk01.server.pojo.MenuRole;
import com.hk01.server.pojo.RespBean;
import com.hk01.server.pojo.Role;
import com.hk01.server.service.MenuRoleService;
import com.hk01.server.service.MenuService;
import com.hk01.server.service.RoleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/system/basic/permission")
public class PermissionController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private MenuRoleService menuRoleService;
    @ApiOperation(value = "获取所有角色")
    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.list();
    }

    @ApiOperation(value = "添加角色")
    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role){
        if(!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }

        if(roleService.save(role)){
            return RespBean.success("添加成功!");
        }
            return RespBean.error("添加失败!");
    }

   /* @ApiOperation(value = "更新角色")
    @PutMapping("/")
    public RespBean updateRole(@RequestBody Role role){
        if(!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        if(roleService.updateById(role)){
            return RespBean.success("更新成功!");
        }
        return RespBean.error("更新失败!");
    }*/

    @ApiOperation(value = "删除角色")
    @DeleteMapping("/role/{rid}")
    public RespBean deleteRole(@PathVariable Integer rid){
        if(roleService.removeById(rid)){
            return RespBean.success("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @ApiOperation(value = "查询所有菜单")
    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }

    @ApiOperation(value = "根据角色id查询菜单id")
    @GetMapping("/mid/{rid}")
    public List<Integer> getMidByRid(@PathVariable Integer rid){
        return menuRoleService.list(new QueryWrapper<MenuRole>().eq("rid",rid)).stream().map(MenuRole::getMid).collect(Collectors.toList());
    }

    @ApiOperation(value = "更新角色菜单")
    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid,Integer[] mids){
        return menuRoleService.updateMenuRole(rid,mids);
    }
}
