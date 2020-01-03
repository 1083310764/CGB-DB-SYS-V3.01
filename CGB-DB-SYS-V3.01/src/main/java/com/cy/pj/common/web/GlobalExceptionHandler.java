package com.cy.pj.common.web;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cy.pj.common.vo.JsonResult;
/**
 * @ControllerAdvice 注解描述的类为异常处理类,
  *  此类中可以定义多个异常处理方法
 */
//@ControllerAdvice
//@ResponseBody
@RestControllerAdvice //==@ControllerAdvice+@ResponseBody
public class GlobalExceptionHandler {
	/**
	 * @ExceptionHandler 用于描述异常处理方法,注解
	   * 内部的异常类型,为方法能处理的异常类型.
	 * @param e
	 * @return
	 */
	@ExceptionHandler(RuntimeException.class)
	public JsonResult doHandleRuntimeException(
			RuntimeException e) {
		//输出异常栈中的信息
		e.printStackTrace();
		//封装异常信息
		return new JsonResult(e);
	}
}
