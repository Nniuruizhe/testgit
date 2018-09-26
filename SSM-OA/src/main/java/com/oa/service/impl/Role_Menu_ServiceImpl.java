package com.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.entity.SysMenu;
import com.oa.mapper.SysMenuMapper;
import com.oa.service.Role_Menu_Service;

@Service
public class Role_Menu_ServiceImpl implements Role_Menu_Service {

	@Resource
	private SysMenuMapper sysMenuMapper;
	
	
	@Override
	public List<SysMenu> selectMenuByRoleId(List list) {
		// TODO Auto-generated method stub
		return sysMenuMapper.selectMenuByRoleId(list);
	}

}
