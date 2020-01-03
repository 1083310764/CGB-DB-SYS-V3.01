package com.cy.pj.sys.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 基于此Controller对象处理项目中所有页面请求
 * @author Administrator
 */
@Controller
@RequestMapping("/")
public class PageController {
	/**返回首页页面*/
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "starter";
	}
	/**返回分页页面*/
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}
	/**返回日志列表页面*/
//	@RequestMapping("log/log_list")
//	public String doLogUI() {
//		return "sys/log_list";
//	}
	/**返回菜单列表页面*/
//	@RequestMapping("menu/menu_list")
//	public String doMenuUI() {
//		return "sys/menu_list";
//	}
	/**rest风格(软件架构风格)的url映射:
	 * 其中:
	 * 1){}表示rest表达式,在这个表达式
	 * 中用变量的形式表示url
	 * 2)@PathVariable注解描述方法参数时
	 * 表示这个参数的值可以取自url中某个变量的值*/
	@RequestMapping("{module}/{moduleUI}")
	public String doModuleUI(
			@PathVariable String moduleUI){
		return "sys/"+moduleUI;
	}

}







