<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" charset="utf-8">
	/**
	 * @author 
	 * 
	 * @requires jQuery,EasyUI,jQuery cookie plugin
	 * 
	 * 更换EasyUI主题的方法
	 * 
	 * @param themeName
	 * 主题名称
	 */
	function changeThemeFun(themeName) {
		if ($.cookie('easyuiThemeName')) {
			$('#layout_north_pfMenu').menu('setIcon', {
				target : $('#layout_north_pfMenu div[title=' + $.cookie('easyuiThemeName') + ']')[0],
				iconCls : 'emptyIcon'
			});
		}
		$('#layout_north_pfMenu').menu('setIcon', {
			target : $('#layout_north_pfMenu div[title=' + themeName + ']')[0],
			iconCls : 'tick'
		});

		var $easyuiTheme = $('#easyuiTheme');
		var url = $easyuiTheme.attr('href');
		var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';
		$easyuiTheme.attr('href', href);

		var $iframe = $('iframe');
		if ($iframe.length > 0) {
			for ( var i = 0; i < $iframe.length; i++) {
				var ifr = $iframe[i];
				try {
					$(ifr).contents().find('#easyuiTheme').attr('href', href);
				} catch (e) {
					try {
						ifr.contentWindow.document.getElementById('easyuiTheme').href = href;
					} catch (e) {
					}
				}
			}
		}

		$.cookie('easyuiThemeName', themeName, {
			expires : 7
		});

	};

	function logoutFun(b) {
	
	$.messager.confirm('提示', '确认要退出登录吗？', function(r) {
					if (r) {
					
		parent.location.replace('${pageContext.request.contextPath}/j_spring_security_logout');
					}});
						
		
	}
	
	
	/**
	 * 密码修改方法
	 */
	function editCurrentUserPwd(){
		
		
		$('#passwordWindow').show().dialog({
			modal:true,
			title:'密码修改',
			href:'jsp/layout/updatePassword.jsp',
			cache:false,
			toolbar:[{  
				text:'提交',  
				iconCls:'tick',  
				handler:function(){
					$('#editCurrentUserPwdForm').form('submit',{
						url:'commonSysUser/updatePassword.htm',  
						onSubmit: function(){
							
							
							var isValid = $('#editForm').form('validate');
							if (!isValid){
								return false;	
							}else if($('#password').val()!=$('#repassword').val()){
								alert("密码不一致")
								return false;
							}
						},
						success:function(data){
							var obj = eval('('+ data +')');
							$('#passwordWindow').dialog('close');
							$.messager.show({
								title:'提示',  
								msg:obj.msg
							});
						}  
					});
				}
			},{
				text:'关闭',
				iconCls:'cancel',  
				handler:function(){
					$('#passwordWindow').dialog('close');
				}
			}]
		});
		
	}

	function editCurrentUserPwd2() {
		parent.$.modalDialog({
			title : '修改密码',
			width : 500,
			height : 450,
			href : '${pageContext.request.contextPath}/jsp/layout/updatePassword.jsp',
			buttons : [ {
				text : '修改',
				handler : function() {
					var f = parent.$.modalDialog.handler.find('#editCurrentUserPwdForm');
					f.submit();
				}
			} ]
		});
	}
	
	
	function currentUserRole() {
		parent.$.modalDialog({
			title : '我的角色',
			width : 300,
			height : 250,
			href : '${pageContext.request.contextPath}/userController/currentUserRolePage'
		});
	}
	function currentUserResource() {
		parent.$.modalDialog({
			title : '我可以访问的权限',
			width : 300,
			height : 250,
			href : '${pageContext.request.contextPath}/userController/currentUserResourcePage'
		});
	}
</script>
<!-- 
<div id="sessionInfoDiv" style="position: absolute; right: 0px; top: 0px;" class="alert alert-info">
	<c:if test="${sessionInfo.id != null}">[<strong>${sessionInfo.name}</strong>]，欢迎你！您使用[<strong>${sessionInfo.ip}</strong>]IP登录！</c:if>
</div>
 -->
<div style="position: absolute; right: 0px; bottom: 0px;">
	<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_pfMenu',iconCls:'cog'">更换皮肤</a> <a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_kzmbMenu',iconCls:'cog'">控制面板</a> <a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_zxMenu',iconCls:'cog'">注销</a>
</div>
<div id="layout_north_pfMenu" style="width: 120px; display: none;">
	<div onclick="changeThemeFun('default');" title="default">default</div>
	<div onclick="changeThemeFun('gray');" title="gray">gray</div>
	<div onclick="changeThemeFun('metro');" title="metro">metro</div>
	<div onclick="changeThemeFun('bootstrap');" title="bootstrap">bootstrap</div>
	<div onclick="changeThemeFun('black');" title="black">black</div>
	<div class="menu-sep"></div>
	<div onclick="changeThemeFun('cupertino');" title="cupertino">cupertino</div>
	<div onclick="changeThemeFun('dark-hive');" title="dark-hive">dark-hive</div>
	<div onclick="changeThemeFun('pepper-grinder');" title="pepper-grinder">pepper-grinder</div>
	<div onclick="changeThemeFun('sunny');" title="sunny">sunny</div>
	<div class="menu-sep"></div>
	<div onclick="changeThemeFun('metro-blue');" title="metro-blue">metro-blue</div>
	<div onclick="changeThemeFun('metro-gray');" title="metro-gray">metro-gray</div>
	<div onclick="changeThemeFun('metro-green');" title="metro-green">metro-green</div>
	<div onclick="changeThemeFun('metro-orange');" title="metro-orange">metro-orange</div>
	<div onclick="changeThemeFun('metro-red');" title="metro-red">metro-red</div>
</div>

<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
	<div onclick="editCurrentUserPwd();">修改密码</div>
	<!-- 
	<div class="menu-sep"></div>
	<div onclick="currentUserRole();">我的角色</div>
	<div class="menu-sep"></div>
	<div onclick="currentUserResource();">我的权限</div>
	 -->
</div>
 
<div id="layout_north_zxMenu" style="width: 100px; display: none;">
	<div onclick="logoutFun(true);">退出系统</div>
</div>