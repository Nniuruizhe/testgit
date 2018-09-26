<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<table width="100%" border="1"	cellpadding="0" cellspacing="0">

	<tr>
		<th>组织名称</th>
		<th>是否创建</th>
		<th>创建时间</th>
		<th>操作</th>
	</tr>
	
<#if orgList??>
	<#list orgList as org>
	<tr>
		<td><#if org.orgName??>${org.orgName}</#if></td>
		<td><#if org.state==1>可用</#if><#if org.state==2>不可用</#if></td>
		<td><#if org.createDate??>${org.creatDate?string("yyyy-mm-dd hh:mm:ss")}</#if></td>
		<td><a href="javascript:orgOper.updateAndQueryOrg('${org.orgId}','up');" style="coursor:pointer;">编辑</a>
			<a href="javascript:orgOper.updateAndQueryOrg('${org.orgId}','query');" style="coursor:pointer;">查看</a>
			<a href="javascript:orgOper.delete('${org.orgId}')" style="cursor:pointer;">删除</a></td>
	</tr>
	</#list>
	
<#else>
	<tr>
		<td colspan="4" style="text-aligin:center;">暂无信息列表</td>
	</tr>
</#if>
	
</table>

<script type="text/javascript">
	totalCount = "<#if total??>${total}</#if>";
</script>

</body>
</html>