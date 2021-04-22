package com.hk01.server.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hk01.server.pojo.MenuRole;
import com.hk01.server.mapper.MenuRoleMapper;
import com.hk01.server.pojo.RespBean;
import com.hk01.server.service.MenuRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nnnNN
 * @since 2021-04-04
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements MenuRoleService {
    @Autowired
    private MenuRoleMapper menuRoleMapper;
    @Override
    @Transactional
    public RespBean updateMenuRole(@Param("rid") Integer rid, Integer[] mids) {
        menuRoleMapper.delete(new QueryWrapper<MenuRole>().eq("rid",rid));
        if(mids==null||mids.length==0){
            return RespBean.success("更新成功!");
        }
        Integer result = menuRoleMapper.insertRecord(rid, mids);
        if(result==mids.length){
        return RespBean.success("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
}
