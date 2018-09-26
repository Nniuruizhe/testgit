package com.oa.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.oa.entity.SysUser;


public interface User_Service {
	
	

	SysUser doLogin(SysUser user);

	List<SysUser> selectUserListByOrgId(long orgId);

}
