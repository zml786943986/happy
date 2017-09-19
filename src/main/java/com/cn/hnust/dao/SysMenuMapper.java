package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.domain.SysMenu;

public interface SysMenuMapper {
	/**
	 * 根据条件查询menu
	 * 
	 * @param sysMenu
	 * @return List<Menu> 返回菜单集合
	 */
	public List<SysMenu> accordionMenuList(SysMenu sysMenu);

}
