var pageSize = 3;
var totalCount = 0;
$(function(){
	loadOrgData(0);
	
	/**
	 * 查询按钮添加点击事件
	 * queryButton
	 */
	$("#queryButton").click(function(){
		
		loadOrgData(0);
	});
	/**
	 * 查询条件重置
	 */
	$("#resetButton").click(function(){
		$("#qry_orgId").val("");
		$("#qry_orgName").val("");
		$("#state").val("");
		
	});
});

function loadOrgReturnNumber(current){
	loadOrgData(current);
}

function loadOrgData(current){
	
	//加载数据
	$.ajax({
		data:{startIndex:current*pageSize,pageSize:pageSize,parentId:$("#qry_orgId").val(),state:$("#state").val()},
		url:path+"/org/orgList",
		success:function(responseText){
			
			$("#loadOrgListData").html(responseText);
			
			loadOrgNumber(current);
		}
	});
}

function loadOrgNumber(current){
	
	$.ajax({
		data:{startIndex:current*pageSize,pageSize:pageSize,total:totalCount},//条件查询得条件
		url:path+"/org/orgNumber",
		dataType:"text",
		success:function(responseText){
			
			$("loadOrgNumber").html(responseText);
		}
	});
}