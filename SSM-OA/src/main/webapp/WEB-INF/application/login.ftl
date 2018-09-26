<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Basic Form - jQuery EasyUI Demo</title>
	
	<link rel="stylesheet" type="text/css" href="${c.contextPath}/static/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${c.contextPath}/static/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${c.contextPath}/static/easyui/demo.css">
	<script type="text/javascript" src="${c.contextPath}/static/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${c.contextPath}/static/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${c.contextPath}/js/jquery-1.11.0.js "></script>
<script type="text/javascript" src="${c.contextPath}/js/json2.js "></script>
</head>
<body bgcolor="#c3f0a9">
	<div align="center">
	<div style="margin:180px 0;"></div>
	<div class="easyui-panel" title="登录" style="width:100%;max-width:400px;padding:30px 60px;">
		<form  id="form0" name="form0"  method="post" action="${c.contextPath}/user/login">
			<div id="userName" style="margin-bottom:20px">
			
				<input name="userName" id="userName" type="text" class="easyui-textbox" maxlength="50" data-options="label:'Name:',required:true"
				    		onkeydown="keypress(this);" placeholder="用户名">
			</div>
			<div id="userPassword" style="margin-bottom:20px">
				<input name="userPassword" id="userPassword" type="password" class="easyui-textbox" maxlength="16" data-options="label:'Email:',required:true,validType:'email'"
							onkeydown="keypress(this);" placeholder="密码"  autocomplete="off">
			</div>
			<div class="code_input">
						<input id="checkCode" class="easyui-textbox"
							name="checkCodeText" maxlength="4" type="text" onkeydown="keypress(this);"
							placeholder="验证码,不区分大小写" />
						<img title="看不清楚，换一个" src="" name="checkCodeImg"  
							width="65" height="28" id="checkCodeImg" onclick="changePicture()"  class="vtop"/>
					</div>
			<div class="lgi_btn">
			<a href="#" onclick="return doLogin();">登录</a>
			</div>	
		</form>
		<div style="text-align:center;padding:5px 0">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">登录</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">取消</a>
		</div>
	</div>
	</div>
	<script>
		function submitForm(){
			document.getElementById("ff").submit();
		}
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
</body>
<script type="text/javascript">
function check(){
	return true;
}
function doLogin(){
	if(!check()) return false;
		//var checkCodeText = document.forms[0].checkCode.value.toLowerCase();
		//if(checkCodeText==""||checkCodeText=="验证码,不区分大小写"){
			alert("请输入验证码!");
			//document.forms[0].checkCode.focus();	
			//return false;
		//}
		var userName = document.forms[0].userName.value;
		var userPassword = document.forms[0].userPassword.value;
		var url="${c.contextPath}/user/login";
		document.getElementById("form0").submit();
	}

</script>









</html>