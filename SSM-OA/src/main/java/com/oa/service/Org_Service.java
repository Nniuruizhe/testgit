package com.oa.service;

import java.util.List;
import java.util.Map;

import com.oa.entity.SysOrg;

public interface Org_Service {

	public Map<String, Object> selectOrgList(Map<String, Object> paramMap);
	
	public List<SysOrg> selectOrgListByParentId(long parentId);
	
	public long selectOrgId();
	
	/**
	 * 查询当前组织及父组织
	 */
	SysOrg selectOrgAndParentIdByOrgId(long orgId);

	public int insert(Map<String, Object> paramMap);

	public int updateByPrimaryKeySelective(SysOrg org);

	public int deleteByPrimaryKey(long orgId);
	

}
