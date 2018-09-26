package com.oa.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;


public class BaseController {
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public Map<String,Object> getParam(HttpServletRequest request){
		
		Map<String,Object> resultMap = new HashMap<String, Object>();
		 
		Enumeration<String> keys = request.getParameterNames();
		
		while(keys.hasMoreElements()){
			String key = keys.nextElement();
			String value= request.getParameter(key);
			
			resultMap.put(key, value);
		}
		return resultMap;
	}
	/**
	 * 
	 * @param startIndex 起始页
	 * @param pageSize 每页数量
	 * @param total 总数量
	 * @param result 返回结果
	 * @return
	 */
	public ModelAndView getPageNoInfo(int startIndex,int pageSize,int total,ModelAndView result){
		//Math.ceil整数则为该整数，Math.ceil小数则为靠近大的整数
		int current = (int) Math.ceil((startIndex+1.0)/pageSize); //当前页显示
		
		result.addObject("current", current);
		result.addObject("startIndex",startIndex );
		result.addObject("pageSize",pageSize );
		result.addObject("total", total);
		if(total>0){
			int page = (int)Math.ceil(total/pageSize);//总数除以每页页数=总页数;
		
			double totald = total;
			
			if(totald/pageSize>total/pageSize){
				page+=1;
			}
		result.addObject("page", page);
		
		int startPage=0;
		int endPage=0;
		
		if(page<8){
			startPage = 1;
			endPage = page;
		}else{
			if(current<5){//展示前六页
				startPage = 1;
				endPage = 6;
			}else if(page-current<6){//展示后六页
				startPage = page-5;
				endPage = page;
			}else{
				startPage = current - 2;
				endPage = current + 2;
			}
		}
		result.addObject("startPage", startPage);
		result.addObject("endPage", endPage);
		}else{
			result.addObject("page",0);
		}
		
		return result;
	}

	public void printJson(HttpServletResponse response,String content ){
		response.setContentType("application/json;chartset=utf-8");
	
			try {
				response.getWriter().println(content);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
}
