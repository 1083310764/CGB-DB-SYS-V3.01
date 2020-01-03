package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.service.SysRoleService;

@RestController
@RequestMapping("/role/")
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;
	
	@RequestMapping("doSaveObject")
	public JsonResult doSaveObject(SysRole entity,
			Integer[]menuIds) {
		sysRoleService.saveObject(entity, menuIds);
		return new JsonResult("save ok");
	}
	
	@RequestMapping("doDeleteObject")
	public JsonResult doDeleteObject(Integer id) {
		sysRoleService.deleteObject(id);
		return new JsonResult("delete ok");
	}
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(
			String name,Integer pageCurrent) {
		PageObject<SysRole> pageObject=
		sysRoleService.findPageObjects(name, pageCurrent);
		return new JsonResult(pageObject);
	}
	@RequestMapping("doFindObjectById")
	@ResponseBody
	 public JsonResult doFindObjectById(Integer id){
	    	return new JsonResult(sysRoleService.findObjectById(id));
	 }
	@RequestMapping("doUpdateObject")
	public JsonResult doUpdateObject(SysRole entity,Integer[] menuIds){
			  sysRoleService.updateObject(entity,menuIds);
	 return new JsonResult("update ok");
	 
}
	@RequestMapping("doFindRoles")
	 public JsonResult doFindRoles() {
		 return new JsonResult(sysRoleService.findObjects());
	 }

}









