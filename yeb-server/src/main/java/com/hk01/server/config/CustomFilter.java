/**
 * @program: yeb
 * @description: 权限控制
 * 根据请求url分析请求所需的角色
 * 获取可以访问该url的所有角色
 * @author nnnNN
 * @date 2021-04-10 20:16:14
 */

package com.hk01.server.config;

import com.hk01.server.pojo.Menu;
import com.hk01.server.pojo.Role;
import com.hk01.server.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private MenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //获取请求的url
        String requestUrl = ((FilterInvocation)o).getRequestUrl();
        //System.out.println("requestUrl = " + requestUrl);
        //获取菜单
        List<Menu> menus = menuService.getMenusWithRoles();
        //System.out.println("menus = " + menus);
        for (Menu menu : menus) {
            //判断请求的url与菜单角色是否匹配
            if (antPathMatcher.match(menu.getUrl(),requestUrl)){
                //System.out.println("menu = " + menu.getUrl());
                String[] str = menu.getRoles().stream().map(Role::getName).toArray(String[]::new);
                //System.out.println("str = " + str);
                return SecurityConfig.createList(str);
            }
        }

        //没匹配的url默认为登录即可访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
