package com.hk01.server.service;

import com.hk01.server.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hk01.server.pojo.RespBean;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nnnNN
 * @since 2021-04-04
 */
public interface AdminService extends IService<Admin> {

    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @param request
     * @return
     */
    RespBean login(String username, String password,String code, HttpServletRequest request);

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    Admin getAdminByUserName(String username);
}
