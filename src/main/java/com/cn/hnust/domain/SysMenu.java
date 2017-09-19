package com.cn.hnust.domain;


/**
 * 系统菜单对象
 * 
 * @author QinYetao
 * @date 2016-2-29
 * @since 2016-03-12
 * @version 1.0
 */
public class SysMenu{

	/**
	 * 菜单ID
	 */
	private String menuId;

	/**
	 * 上级菜单ID
	 */
	private String upMenuId;

	/**
	 * 菜单名称
	 */
	private String menuName;

	/**
	 * 菜单路径
	 */
	private String menuPath;

	/**
	 * 菜单图标
	 */
	private String iconsName;

	/**
	 * 是否有效菜单
	 */
	private String active;

	/**
	 * 菜单层级
	 */
	private int mLevel;

	/**
	 * 菜单排序
	 */
	private int menuSort;

	/**
	 * 辅助字段
	 */
	private String menuIds;

	/**
	 * @return menuId 菜单ID
	 */
	public String getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId
	 *            菜单ID
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return upMenuId 上级菜单ID
	 */
	public String getUpMenuId() {
		return upMenuId;
	}

	/**
	 * @param upMenuId
	 *            上级菜单ID
	 */
	public void setUpMenuId(String upMenuId) {
		this.upMenuId = upMenuId;
	}

	/**
	 * @return menuName 菜单名称
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * @param menuName
	 *            菜单名称
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * @return menuPath 菜单路径
	 */
	public String getMenuPath() {
		return menuPath;
	}

	/**
	 * @param menuPath
	 *            菜单路径
	 */
	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}

	/**
	 * @return active 是否有效
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active
	 *            是否有效
	 */
	public void setActive(String active) {
		this.active = active;
	}

	/**
	 * @return mLevel 菜单层级
	 */
	public int getmLevel() {
		return mLevel;
	}

	/**
	 * @param mLevel
	 *            菜单等级
	 */
	public void setmLevel(int mLevel) {
		this.mLevel = mLevel;
	}

	/**
	 * @return menuSort 菜单排序
	 */
	public int getMenuSort() {
		return menuSort;
	}

	/**
	 * @param menuSort
	 *            菜单排序
	 */
	public void setMenuSort(int menuSort) {
		this.menuSort = menuSort;
	}

	/**
	 * @return menuIds
	 */
	public String getMenuIds() {
		return menuIds;
	}

	/**
	 * @param menuIds
	 *            setMenuIds
	 */
	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}

	/**
	 * @return 菜单图标
	 */
	public String getIconsName() {
		return this.iconsName;
	}

	/**
	 * @param iconsName
	 *            菜单图标
	 */
	public void setIconsName(String iconsName) {
		this.iconsName = iconsName;
	}

}
