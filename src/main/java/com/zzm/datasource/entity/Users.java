package com.zzm.datasource.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * <p>@Author: james</p>
 * <p>@Description: 添加说明</P>
 * <p>@Date: 创建日期 2018/10/24 9:29</P>
 * <p>@version V1.0</p>
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users {

    @NotBlank(message = "id不能为空")
    private String id;

    @NotBlank(message = "name不能为空")
    private String name;

    @NotBlank(message = "age不能为空")
    private String age;

    @NotBlank(message = "status不能为空")
    private String status;
}
