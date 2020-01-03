package com.cy.pj.sys.dao;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
  * 基于此DAO操作用户和角色关系数据
 */
@Mapper
public interface SysUserRoleDao {
	   @Delete("delete from sys_user_roles where role_id=#{roleId}")
	   int deleteObjectsByRoleId(Integer roleId);
	   int insertObjects(
				@Param("userId")Integer userId,
				@Param("roleIds")Integer[] roleIds);
	   List<Integer> findRoleIdsByUserId(Integer id);
	   int deleteObjectsByUserId(Integer userId);

}
