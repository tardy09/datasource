package com.zzm.datasource.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @Author: james
 * @Description: This is description
 * @Date: created in 10:40 2018/8/30
 * @Modified By:
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {
    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 具体内容 */
    private T data;
}
