package com.cn.hnust.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.SysMenuMapper;
import com.cn.hnust.dao.UserMapper;
import com.cn.hnust.domain.SysMenu;
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
	
	@Resource
	private SysMenuMapper menuMapper;
	
	public User getUserById(int userId) {
		return uMapper.selectByPrimaryKey(userId);
	}

	public List<User> queryUserList(User u,int currentPage, int pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRows", (currentPage - 1) * pageSize);
		paramMap.put("pageSize", pageSize);
		paramMap.put("user", u);
		return uMapper.userList(paramMap);
	}

	public Integer countUser(User u) {
		return uMapper.countUser(u);
	}
	
	/**
	 * 查询
	 * 
	 * @param param
	 *            查询
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List getAllMenuList(SysMenu param) {
		// 当前id下面的菜单集合 比如upMenuId为1的所有菜单
		List<SysMenu> menuList = this.menuMapper.accordionMenuList(param);
		List<Map<String, Object>> itemsList = new ArrayList<Map<String, Object>>();
		for (SysMenu menu : menuList) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("id", menu.getMenuId());
			if (null == menu.getIconsName()) {
				menu.setIconsName("icon-man");
			}
			item.put("iconCls", menu.getIconsName());
			item.put("text", menu.getMenuName());
			item.put("state", "close");
			item.put("_url", menu.getMenuPath());
			item.put("menuSort", menu.getMenuSort());
			item.put("target", "_self");
			Map<String, Object> attributes = new HashMap<String, Object>();
			attributes.put("_url", menu.getMenuPath());
			attributes.put("target", "_self");
			attributes.put("upMenuId", menu.getUpMenuId());
			attributes.put("menuSort", menu.getMenuSort());
			item.put("attributes", attributes);
			menu.setMenuIds(param.getMenuIds());
			item.put("children", this.getSubMenuObject(menu));
			itemsList.add(item);
		}
		return itemsList;
	}

	/**
	 * 子节点菜单
	 * 
	 * @param menu
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private List getSubMenuObject(SysMenu menu) {
		// 当前节点下面的所有节点
		List<SysMenu> subMenuList = this.menuMapper.accordionMenuList(menu);
		List<Map<String, Object>> itemsList = new ArrayList<Map<String, Object>>();
		for (SysMenu subMenu : subMenuList) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("id", subMenu.getMenuId());
			item.put("state", "open");
			if (null == subMenu.getIconsName()) {
				subMenu.setIconsName("icon-man");
			}
			item.put("iconCls", subMenu.getIconsName());
			item.put("_url", subMenu.getMenuPath());
			item.put("menuSort", subMenu.getMenuSort());
			item.put("target", "_self");
			item.put("text", subMenu.getMenuName());
			Map<String, Object> attributes = new HashMap<String, Object>();
			attributes.put("_url", subMenu.getMenuPath());
			attributes.put("target", "_self");
			attributes.put("UPID", subMenu.getUpMenuId());
			attributes.put("menuSort", subMenu.getMenuSort());
			item.put("attributes", attributes);
			subMenu.setMenuIds(menu.getMenuIds());
			List tempList = getSubMenuObject(subMenu);
			item.put("children", tempList);
			item.put("state", "open");
			itemsList.add(item);
		}
		return itemsList;
	}

}
