/**
 * @program: yeb
 * @description: 分頁公共返回對象
 * @author nnnNN
 * @date 2021-04-11 22:40:48
 */

package com.hk01.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespPageBean {

    /**
     * 总条数
     */
    private Long total;
    /**
     * 数据list
     */
    private List<?> data;
}
