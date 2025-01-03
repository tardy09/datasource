package com.zzm.datasource.service;

import com.zzm.datasource.entity.Users;
import com.zzm.datasource.repository.UsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>@Author: james</p>
 * <p>@Description: 用户业务层</P>
 * <p>@Date: 创建日期 2018/10/24 10:23</P>
 * <p>@version V1.0</p>
 **/
@Service
@Slf4j
public class UserService {

    @Autowired
    private UsersMapper usersMapper;

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: java.util.List<com.zzm.datasource.entity.Users></P>
     * <p>@date: 2018/10/24 11:55</P>
     * <p>@description: 查询所有的用户</p>
     */
    public List<Users> selectAll() throws RuntimeException{
        return usersMapper.selectAll();
    }

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/24 11:54</P>
     * <p>@description: 新增用户</p>
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public boolean save(Users users){
        return usersMapper.save(users) == 1;
    }


    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/24 12:31</P>
     * <p>@description: 删除用户</p>
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public boolean delete(Users users){
        return usersMapper.deleteById(users) == 1;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/24 12:33</P>
     * <p>@description: 修改</p>
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public boolean update(Users users){
        return usersMapper.update(users) == 1;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/24 12:35</P>
     * <p>@description: 获取单个值</p>
     */
    public Users selectById(Users users){
        return usersMapper.selectById(users);
    }
}
