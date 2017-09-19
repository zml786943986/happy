package com.cn.hnust.dao;

import java.util.List;
import java.util.Map;

import com.cn.hnust.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    public List<User> userList(Map<String, Object> queryMap);
    
    public Integer countUser(User u);
}