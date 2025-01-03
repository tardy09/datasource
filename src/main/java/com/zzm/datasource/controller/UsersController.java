package com.zzm.datasource.controller;

import com.zzm.datasource.entity.Result;
import com.zzm.datasource.entity.Users;
import com.zzm.datasource.enums.ResultEnum;
import com.zzm.datasource.service.UserService;
import com.zzm.datasource.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

/**
 * <p>@Author: james</p>
 * <p>@Description: 添加说明</P>
 * <p>@Date: 创建日期 2018/10/24 10:29</P>
 * <p>@version V1.0</p>
 **/
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: com.zzm.datasource.entity.Result</P>
     * <p>@date: 2018/10/24 12:36</P>
     * <p>@description: 查询所有</p>
     */
    @PostMapping("/selectAll")
    public Result selectAll() {
        return ResultUtil.success(userService.selectAll());
    }

    /***
     * <p>@author: James</p>
     * <p>@param: [users]</P>
     * <p>@return: com.zzm.datasource.entity.Result</P>
     * <p>@date: 2018/10/24 12:36</P>
     * <p>@description: 查询单个值</p>
     */
    @PostMapping("/selectById")
    public Result selectById(@RequestBody @Valid Users users,BindingResult results) {
        System.out.println(users.getId() == null);
        return ResultUtil.success(userService.selectById(users));
    }

    /***
     * <p>@author: James</p>
     * <p>@param: [users]</P>
     * <p>@return: com.zzm.datasource.entity.Result</P>
     * <p>@date: 2018/10/24 12:36</P>
     * <p>@description: 新增</p>
     */
    @PostMapping("/save")
    public Result save(Users users) {
        //数据源默认为写入数据
        String id = UUID.randomUUID().toString().replaceAll("-","");
        Users user = new Users();
        user.setName("test");
        user.setAge("22");
        user.setId(id);
        user.setStatus("0");
        if(userService.save(user)){
            return ResultUtil.success(ResultEnum.SUCCESS);
        }else{
            return ResultUtil.error(ResultEnum.FILE);
        }
    }

    /***
     * <p>@author: James</p>
     * <p>@param: [users]</P>
     * <p>@return: com.zzm.datasource.entity.Result</P>
     * <p>@date: 2018/10/24 12:36</P>
     * <p>@description: 删除</p>
     */
    @PostMapping("/delete")
    public Result delete(Users users) {
        if(userService.delete(users)){
            return ResultUtil.success(ResultEnum.SUCCESS);
        }else{
            return ResultUtil.error(ResultEnum.FILE);
        }
    }

    /***
     * <p>@author: James</p>
     * <p>@param: [users]</P>
     * <p>@return: com.zzm.datasource.entity.Result</P>
     * <p>@date: 2018/10/24 12:36</P>
     * <p>@description: 修改</p>
     */
    @PostMapping("/update")
    public Result update(Users users) {
        if(userService.delete(users)){
            return ResultUtil.success(ResultEnum.SUCCESS);
        }else{
            return ResultUtil.error(ResultEnum.FILE);
        }
    }
}
