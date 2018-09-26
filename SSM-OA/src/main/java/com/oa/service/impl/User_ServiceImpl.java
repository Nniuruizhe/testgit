package com.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.entity.SysUser;
import com.oa.mapper.SysUserMapper;
import com.oa.service.User_Service;

@Service
public class User_ServiceImpl implements User_Service {

	@Resource
	private SysUserMapper sysUserMapper;
	
	
	@Override
	public SysUser doLogin(SysUser user) {
		
		return sysUserMapper.login(user);
	}


	@Override
	public List<SysUser> selectUserListByOrgId(long orgId) {
		// TODO Auto-generated method stub
		return null;
	}






}
