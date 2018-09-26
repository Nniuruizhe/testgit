package com.oa.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oa.entity.SysMenu;
import com.oa.entity.SysUser;
import com.oa.service.Menu_Service;
import com.oa.service.Role_Org_Service;
import com.oa.service.Role_User_Service;
import com.oa.service.User_Service;


@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private User_Service userService;
	
	@Resource
	private Role_User_Service userRoleService;
	
	@Resource 
	private Role_Org_Service userOrgService;
	
	@Resource
	private Menu_Service MenuService;
	
	@RequestMapping("/show")
	public String showFtl(HttpServletRequest request){
		
		//request.setAttribute("u", "小乔");
		
		return "login";
	}
	@RequestMapping("/show1")
	public String showFtl1(HttpServletRequest request){
		
		//request.setAttribute("u", "小乔");
		
		return "login";
	}
	@RequestMapping("login")
	public String login(SysUser user,HttpSession session){
		
		 SysUser user1 = userService.doLogin(user);
		if(user1 != null){
			session.setAttribute("u", user1);
			//用户id
			long id = user1.getUserId();
			//角色id
			String roleIds=  userRoleService.selectRoleIdByUserId(id);
			//组织id
			String orgId= userOrgService.selectOrgIdByRoleId(user1.getOrgId());
			
			String ids = roleIds.concat(",").concat(orgId);
			
			String [] isString = ids.split(",");
			
			List list = Arrays.asList(isString);
			//菜单列表
			List<SysMenu> menuList1 = MenuService.selectMenuByRoleId(list);
			for(SysMenu menu:menuList1){
				System.out.println("--------------"+menu.getMenuName());
			}
			session.setAttribute("menuList",menuList1);
			return "main";
		}
		
		return "login";
		
		
		
	}
	
}
