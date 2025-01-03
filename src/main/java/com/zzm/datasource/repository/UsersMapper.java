package com.zzm.datasource.repository;

import com.zzm.datasource.annotation.DataSource;
import com.zzm.datasource.entity.Users;

import java.util.List;

/**
 * <p>@Author: james</p>
 * <p>@Description: 添加说明</P>
 * <p>@Date: 创建日期 2018/10/24 9:34</P>
 * <p>@version V1.0</p>
 **/
public interface UsersMapper {

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/24 9:35</P>
     * <p>@description: 根据id，删除相应的数据，使用默认数据源</p>
     */
    @DataSource
    int deleteById(Users users);

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/24 9:37</P>
     * <p>@description: 新增用户，使用默认数据源</p>
     */
    @DataSource
    int save(Users users);

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/24 9:38</P>
     * <p>@description: 修改，使用默认数据源</p>
     */
    @DataSource
    int update(Users users);

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/24 9:39</P>
     * <p>@description: 根据id查询相应的数据，使用slave1这个数据源</p>
     */
    @DataSource("slave1")
    Users selectById(Users users);

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/24 9:37</P>
     * <p>@description:  查询所有的用户，使用slave2这个数据源</p>
     */
    @DataSource("slave2")
    List<Users> selectAll();
}
