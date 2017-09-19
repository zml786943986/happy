package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.domain.SysMenu;
import com.cn.hnust.domain.User;

/**
 * 
 * TODOservice
 * <p style="display:none">modifyRecord</p>
 * <p style="display:none">version:V1.0,author:293320,date:2017-1-9 下午5:03:25,content:TODO </p>
 * @author 293320
 * @date 2017-1-9 下午5:03:25
 * @since
 * @version
 */
public interface IUserService {
	public User getUserById(int userId);
	
	public List<User> queryUserList(User u,int currentPage, int pageSize);
	
	public Integer countUser(User u);
	
	public List getAllMenuList(SysMenu menu);
	
}
