package com.cy.pj.sys.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import com.cy.pj.common.config.PageProperties;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;
/**
 *  BO:(业务对象)
  *    日志业务对象(负责日志核心业务以及拓展的处理)
 * @author Administrator
 */
@Service
public class SysLogServiceImpl implements SysLogService {
	@Autowired
	private SysLogDao sysLogDao;
	@Autowired
	private PageProperties pageProperties;
	
	@Override
	public int deleteObjects(Integer... ids) {
	  //1.参数有效性校验
	  if(ids==null||ids.length==0)
	  throw new IllegalArgumentException("请先选择");
	  //2.执行删除操作
	  int rows=sysLogDao.deleteObjects(ids);
	  //3.判定结果并返回
	  if(rows==0)
	  throw new ServiceException("记录可能已经不存在");
	  return rows;
	}
	
	@Override
	public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
		//1.验证参数的合法性
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("页码值不正确");
		//2.查询总记录数
		int rowCount=sysLogDao.getRowCount(username);
		if(rowCount==0)
		throw new ServiceException("没有对应的记录");
		
		//3.查询当前页要呈现的记录
		int pageSize=pageProperties.getPageSize();
		System.out.println("pageSize="+pageSize);
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysLog> records=
		sysLogDao.findPageObjects(username, startIndex, pageSize);
		//4.封装查询结果
		return new PageObject<>(records, rowCount, pageCurrent, pageSize);
	}
}








