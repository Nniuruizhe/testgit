package com.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.entity.SysMenu;
import com.oa.mapper.SysMenuMapper;
import com.oa.service.Menu_Service;

@Service
public class Menu_ServiceImpl implements Menu_Service {

	@Resource
	private SysMenuMapper sysMenuMapper;
	
	
	public List<SysMenu> selectMenuByRoleId(List list) {
		// TODO Auto-generated method stub
		return sysMenuMapper.selectMenuByRoleId(list);
	}

}
