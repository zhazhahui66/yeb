/**
 * @program: yeb
 * @description: 管理员工具类
 * @author nnnNN
 * @date 2021-04-11 21:34:04
 */

package com.hk01.server.utils;

import com.hk01.server.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

public class AdminUtils {

    public static Admin getCurrentAdmin(){
        return (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
