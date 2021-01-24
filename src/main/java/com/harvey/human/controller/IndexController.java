package com.harvey.human.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 * 
 * @author Harvey
 * @date 2020年12月23日
 */
@Controller
public class IndexController {
	/**
	 * 跳转到登录页
	 * @return
	 */
	@RequestMapping
	public String index() {
		return "login";
	}

	/**
	 * 跳转到首页
	 * @return
	 */
	@RequestMapping("/main")
	public String mainPage() {
		return "pages/index";
	}
}
