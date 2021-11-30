package com.gzk.dao;

import com.gzk.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //获取全部用户
    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);
    User getUserById2(int id);

    //增加用户
    int addUser(User user);
    int addUser2(Map<String,Object> map);
    //修改用户
    int updateUser(User user);

    //删除用户
    int deleUser(int id);

    //分页
    List<User> getUserLimit(Map<String,Integer> map);
}
