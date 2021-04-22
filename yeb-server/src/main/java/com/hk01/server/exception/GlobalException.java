/**
 * @program: yeb
 * @description: 全局异常处理
 * @author nnnNN
 * @date 2021-04-11 01:28:46
 */

package com.hk01.server.exception;

import com.hk01.server.pojo.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(SQLException.class)
    public RespBean mySqlException(SQLException e){
        if(e instanceof SQLIntegrityConstraintViolationException){
            return RespBean.error("该数据有关联数据,操作失败!");
        }
            return RespBean.error("数据库异常,操作失败!");
    }
}
