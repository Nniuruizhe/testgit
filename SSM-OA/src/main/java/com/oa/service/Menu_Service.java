package com.oa.service;

import java.util.List;

import com.oa.entity.SysMenu;

public interface Menu_Service {

	List<SysMenu> selectMenuByRoleId(List list);

}
