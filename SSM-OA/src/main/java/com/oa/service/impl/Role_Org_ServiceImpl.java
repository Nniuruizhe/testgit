package com.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.mapper.SysRoleMenuRelMapper;
import com.oa.mapper.SysRoleOrgRelMapper;
import com.oa.service.Role_Org_Service;

@Service
public class Role_Org_ServiceImpl implements Role_Org_Service {

	@Resource
	private SysRoleOrgRelMapper sysRoleOrgRelMapper;
	
	@Override
	public String selectOrgIdByRoleId(Long orgId) {
		// TODO Auto-generated method stub
		return sysRoleOrgRelMapper.selectOrgIdByRoleId(orgId);
	}

}
