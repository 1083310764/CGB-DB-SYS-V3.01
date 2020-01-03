package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.common.vo.CheckBox;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.vo.SysRoleMenuVo;

@Mapper
public interface SysRoleDao {//PageDao
	
	  /**
	   * 负责将角色自身信息写入到数据库
	   * @param entity
	   * @return
	   */
	  int insertObject(SysRole entity);
	
	  /**
	      * 基于id删除角色自身信息
	   * @param id
	   * @return
	   */
	  @Delete("delete from sys_roles where id=#{id}")
	  int deleteObject(Integer id);
	
	  /**
	      *  查询角色总记录数
	   * @param name 角色名称
	   * @return
	   */
	  int getRowCount(@Param("name")String name);
	  
	  
	  
	  
	  int updateObject(SysRole entity);
	  /**
	      * 分页查询当前页记录
	   * @param name 角色名称
	   * @param startIndex 起始位置
	   * @param pageSize  页面大小
	   * @return
	   */
	  List<SysRole> findPageObjects(
			  @Param("name")String name,
			  @Param("startIndex")Integer startIndex,
			  @Param("pageSize")Integer pageSize);
	  SysRoleMenuVo findObjectById(Integer id);
	  List<CheckBox> findObjects();
}
