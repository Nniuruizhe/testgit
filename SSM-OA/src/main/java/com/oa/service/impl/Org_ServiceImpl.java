package com.oa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.entity.SysOrg;
import com.oa.mapper.SysOrgMapper;
import com.oa.service.Org_Service;

@Service
public class Org_ServiceImpl implements Org_Service {

	@Resource
	private SysOrgMapper orgMapper;
	
	/**
	 * 页面显示组织列表信息
	 * @param paramMap
	 * @return
	 */
	@Override
	public Map<String, Object> selectOrgList(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		//起始页记录 每页显示多少条
		paramMap.put("startIndex", Integer.parseInt(paramMap.get("startIndex")+""));
		paramMap.put("pageSize", Integer.parseInt(paramMap.get("pageSize")+""));
		
		//求出所有数据
		List<SysOrg> list = orgMapper.selectOrgByPage(paramMap);
		//z总记录数
		long total = orgMapper.selectTotalCount(paramMap);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orgList", list);
		map.put("total", total);
		
		return map;
	}
	
	/**
	 * 联动查询子组织
	 */
	@Override
	public List<SysOrg> selectOrgListByParentId(long parentId) {
		// TODO Auto-generated method stub
		return orgMapper.selectOrgListByParentId(parentId);
	}

	/**
	 * 新增组织时做组织编号基数
	 */
	@Override
	public long selectOrgId() {
		// TODO Auto-generated method stub
		return orgMapper.selectOrgId();// 查询id 的最大值
	}

	/**
	 * 查询当前组织及父组织
	 */
	@Override
	public SysOrg selectOrgAndParentIdByOrgId(long orgId) {
		// TODO Auto-generated method stub
		return orgMapper.selectOrgAndParentByOrgId(orgId);
	}

	/**
	 * 组织新增
	 */
	@Override
	public int insert(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return orgMapper.insert(paramMap);
	}

	/**
	 * 组织更新
	 */
	@Override
	public int updateByPrimaryKeySelective(SysOrg org) {
		// TODO Auto-generated method stub
		return orgMapper.updateByPrimaryKeySelective(org);
	}

	/**
	 * 组织删除
	 */
	@Override
	public int deleteByPrimaryKey(long orgId) {
		// TODO Auto-generated method stub
		return orgMapper.deleteByPriamryKey(orgId);
	}
	

}
