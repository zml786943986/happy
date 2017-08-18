package com.cn.hnust.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.UserMapper;
import com.cn.hnust.domain.User;
import com.cn.hnust.service.IUserService;

/**
 * 
 * TODO service 实现
 * <p style="display:none">modifyRecord</p>
 * <p style="display:none">version:V1.0,author:293320,date:2017-1-9 下午5:04:49,content:TODO </p>
 * @author 293320
 * @date 2017-1-9 下午5:04:49
 * @since
 * @version
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
	
	@Resource
	private UserMapper uMapper;
	
	public User getUserById(int userId) {
		return uMapper.selectByPrimaryKey(userId);
	}

}
