package com.cy.pj.sys.vo;
import java.io.Serializable;
import java.util.List;
import com.cy.pj.sys.entity.SysRole;

import lombok.Data;
/**
 * VO：通过此对象封装角色以及角色对应的菜单id
 * @author ta
 */
@Data
public class SysRoleMenuVo implements Serializable{
private static final long serialVersionUID = 3609240922718345518L;
/**角色id*/
	private Integer id;
	/**角色名称*/
	private String name;
/**角色备注*/
	private String note;
	/**角色对应的菜单id*/
	private List<Integer> menuIds;
}