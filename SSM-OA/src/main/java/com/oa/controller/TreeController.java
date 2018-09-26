package com.oa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.oa.entity.SysOrg;
import com.oa.service.Org_Service;

@Controller
@RequestMapping("/tree")
public class TreeController extends BaseController {

	@Resource
	private Org_Service orgService;
	
	@RequestMapping("/orgSubList")
	@ResponseBody
	public void subList(HttpServletRequest request,HttpServletResponse response){
		System.out.println("sssssssssss");
		Map<String,Object> map = getParam(request);
		
		String id = (String) map.get("id");
		if(id == null || "".equals(id)){
			id = "-1";
		}
		
		int parentId = Integer.parseInt(id);
		
		List<SysOrg> list = orgService.selectOrgListByParentId(parentId);
		List<Map<String,Object>> resList = new ArrayList<>();
		
		for(SysOrg org:list){
			Map<String,Object> map2 = new HashMap<String,Object>();
			map2.put("id", org.getOrgId());
			map2.put("name", org.getOrgName());
			map2.put("orgPath", org.getOrgPath());
			map2.put("isParent", true);
			
			resList.add(map2);
		}
		Gson gson = new Gson();
		String json = gson.toJson(resList);
		System.out.println(json+"-------------");
		//request.setCharacterEncoding("GBK");
		response.setContentType("json/xml;charset=utf-8");
		super.printJson(response, json);
	}
}
