package com.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.mapper.SysRoleUserRelMapper;
import com.oa.service.Role_User_Service;

@Service
public class Role_User_ServiceImpl implements Role_User_Service {

	@Resource
	private SysRoleUserRelMapper  sysRoleUserRelMapper;
	@Override
	public String selectRoleIdByUserId(long id) {
		// TODO Auto-generated method stub
		return sysRoleUserRelMapper.selectRoleIdByUserId(id);
	}

}
