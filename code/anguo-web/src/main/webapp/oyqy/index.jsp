<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<meta http-equiv="Content-Type" content="textml; charset=UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0,  maximum-scale=1.0, minimum-scale=1.0,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="format-detection" content="telephone=no">
		<title>${share.title}</title>
		<link rel="stylesheet" type="text/css" href="oyqy/css/common.css" />
		<link rel="stylesheet" type="text/css" href="oyqy/css/index.css" />
		<script type="text/javascript" src="oyqy/js/myjs.js"></script>
		<script type="text/javascript" src="oyqy/js/msg_list.js"></script>
		<script type="text/javascript" src="oyqy/js/index.js"></script>
		<script type="text/javascript" src="oyqy/js/jquery-1.11.3.min.js"></script>
		
		
		<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
		<script>
		wx.config({
		    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
		    appId: '${map.appid}', // 必填，公众号的唯一标识
		    timestamp: ${map.timestamp}, // 必填，生成签名的时间戳
		    nonceStr: '${map.nonceStr}', // 必填，生成签名的随机串
		    signature: '${map.signature}',// 必填，签名，见附录1
		    jsApiList: [
		                'checkJsApi',
		                'onMenuShareTimeline',
		                'onMenuShareAppMessage',
		                'onMenuShareQQ',
		                'onMenuShareWeibo',
		                'onMenuShareQZone',
		                'hideMenuItems',
		                'showMenuItems',
		                'hideAllNonBaseMenuItem',
		                'showAllNonBaseMenuItem',
		                'translateVoice',
		                'startRecord',
		                'stopRecord',
		                'onVoiceRecordEnd',
		                'playVoice',
		                'onVoicePlayEnd',
		                'pauseVoice',
		                'stopVoice',
		                'uploadVoice',
		                'downloadVoice',
		                'chooseImage',
		                'previewImage',
		                'uploadImage',
		                'downloadImage',
		                'getNetworkType',
		                'openLocation',
		                'getLocation',
		                'hideOptionMenu',
		                'showOptionMenu',
		                'closeWindow',
		                'scanQRCode',
		                'chooseWXPay',
		                'openProductSpecificView',
		                'addCard',
		                'chooseCard',
		                'openCard'
		              ]
		});
		
		wx.ready(function(){
			//alert(location.href.split('#')[0]);
			
			//发送给朋友
			
			wx.onMenuShareAppMessage({
			      title: '${share.title}',
			      desc: '${share.desc}',
			      link: '${share.link}',
			      imgUrl: '${share.imgUrl}',
			      success: function (res) {
			        //alert('已分享,您是第888位分享者！');
			        submitShare();
			        
			      },
			      cancel: function (res) {
			        alert('已取消');
			      },
			      fail: function (res) {
			        alert(JSON.stringify(res));
			      }
			    });
			    
			 //分享朋友圈
			wx.onMenuShareTimeline({
			    title: '${share.desc}', // 分享标题
			    link: '${share.link}', // 分享链接
			    imgUrl: '${share.imgUrl}', // 分享图标
			    success: function () { 
			        // 用户确认分享后执行的回调函数
			    	submitShare();
			    },
			    cancel: function () { 
			        // 用户取消分享后执行的回调函数
			    }
			});
			 
			 
			 //分享到QQ
			wx.onMenuShareQQ({
			    title: '${share.title}', // 分享标题
			    desc: '${share.desc}', // 分享描述
			    link: '${share.link}', // 分享链接
			    imgUrl: '${share.imgUrl}', // 分享图标
			    success: function () { 
			       // 用户确认分享后执行的回调函数
			    	submitShare();
			    },
			    cancel: function () { 
			       // 用户取消分享后执行的回调函数
			    }
			});
			 
			 //分享到qq空间
			wx.onMenuShareQZone({
			    title: '${share.title}', // 分享标题
			    desc: '${share.desc}', // 分享描述
			    link: '${share.link}', // 分享链接
			    imgUrl: '${share.imgUrl}', // 分享图标
			    success: function () { 
			       // 用户确认分享后执行的回调函数
			    	submitShare();
			    },
			    cancel: function () { 
			        // 用户取消分享后执行的回调函数
			    }
			});
		    
		});
		
		wx.checkJsApi({
		    jsApiList: ['chooseImage'], // 需要检测的JS接口列表，所有JS接口列表见附录2,
		    success: function(res) {
		    	//console.log(res);
		    	//alert('支持');
		        // 以键值对的形式返回，可用的api值true，不可用为false
		        // 如：{"checkResult":{"chooseImage":true},"errMsg":"checkJsApi:ok"}
		    }
		});
		
		
		</script>
		
		
		<script>
		
		//提交旅行表单
		function submitForm(){
			if($("#city").val()==""){
				
				alert("选择一个想去的地方吧！");
				return false;
				
			}
			
			if($("#dosamething").val()==""){
				
				alert("你俩想去做啥呢，可以选一个喔！");
				return false;
				
			}
			

			try{

				$.post('http://${share.domain}/encounterr-web/oyqyTravel/create.htm', $('#bd').serializeArray(), function(response){

					if(response.code==1601){
				
						//切换页面
						$("#page1").hide();
						showresult($("#city").val(),$("#dosamething").val());
						$("#page3").show();
		
					}else if(response.code==1602){
						
						alert(response.msg);
						//隐藏图层
		
					}else{
						alert('网络出现问题了!');
						//隐藏图层
					}

				});


			}
			catch(e)
			{

			alert(e);


			}finally {


			}
		}
		
		
		//获得旅行列表
		function loadtravel(){
			

			try{

				$.post('http://${share.domain}/encounterr-web/oyqyTravel/list.htm?rows=5&toopenid='+$("#toopenid").val()+'&fromopenid='+$("#fromopenid").val(),  function(response){

					if(response.code==1200){
				
						//alert(response.msg);
						setList(response.rows);
					
					}else{
						alert('网络出现问题了!');
					}

				});


			}
			catch(e)
			{

			alert(e);


			}finally {


			}
		}
		
		
		
		/**
		 * 点赞
		 */
		function like(travelId){
			try{

				$.post('http://${share.domain}/encounterr-web/oyqyLike/create.htm?openid='+$("#toopenid").val()+'&travelId='+travelId,  function(response){

					if(response.code==1601){
				
						loadtravel();
					
					}else{
						alert('网络出现问题了!');
					}

				});


			}
			catch(e)
			{

			alert(e);


			}finally {


			}
		}

		/**
		 * 取消点赞
		 */
		function unlike(travelId){
			try{

				$.post('http://${share.domain}/encounterr-web/oyqyLike/delete.htm?openid='+$("#toopenid").val()+'&travelId='+travelId,  function(response){

					if(response.code==1611){
				
						loadtravel();
					
					}else{
						alert('网络出现问题了!');
					}

				});


			}
			catch(e)
			{

			alert(e);


			}finally {


			}
		}
		</script>
		
</head>
<body>

<div id="page1">
			<div class="dv_center" id="top">
				<div id="div_headmsg">
					<div id="div_head">
						<img id="img_head" src="${param.headimgurl}" style="width: 100%;height: 100%;" alt="头像"/>
					</div>
					<div id="div_msg">
						<label id="labal_talk" name="labal_talk">我想和${from.fromnickname}去</label>
					</div>
				</div>
	
				<div id="input">
				<form id="bd" name="bd" method="post">
					<div class="div_input">
						<input type="text" maxlength="30" id="city" name="city" />
					</div>
					<div class="div_input">
						<input type="text" maxlength="30" id="dosamething" name="dosamething" />
					</div>
					<input type="hidden" id="fromopenid" name="fromopenid" value="${from.fromopenid}">
					<input type="hidden" id="fromnickname" name="fromnickname" value="${from.fromnickname}">
					<input type="hidden" id="fromsex" name="fromsex" value="${from.fromsex}">
					<input type="hidden" id="fromheadimgurl" name="fromheadimgurl" value="${from.fromheadimgurl}">
					
					
					
					<input type="hidden" id="toopenid" name="toopenid" value="${param.openid}">
					<input type="hidden" id="tonickname" name="tonickname" value="${param.nickname}">
					<input type="hidden" id="tosex" name="tosex" value="${param.sex}">
					<input type="hidden" id="toheadimgurl" name="toheadimgurl" value="${param.headimgurl}">
				</form>
				</div>
				<div id="div_page1">
					<div class="div_city">
						<div id="city1" class="div_tag">成都</div>
						<div id="city2" class="div_tag">呼伦贝尔</div>
						<div id="city3" class="div_tag">东莞</div>
						<div id="city4" class="div_tag">斐济</div>
						
					</div>
					
					<div class="div_city">
						<div id="city5" class="div_tag">埃及</div>
						<div id="city6" class="div_tag">特罗姆瑟</div>
						<div id="city7" class="div_tag">希腊</div>
						<div id="city8" class="div_tag">拉斯维加斯</div>
					</div>
				</div>
				
				<div id="div_page2" style="display: none">
					<div class="div_city">
						<div id="event1" class="div_tag">吃火锅</div>
						<div id="event2" class="div_tag">骑马</div>
						<div id="event3" class="div_tag">看AV</div>
						<div id="event4" class="div_tag">看日出</div>
					</div>
					
					<div class="div_city">
						<div id="event5" class="div_tag">看极光</div>
						<div id="event6" class="div_tag">泡温泉</div>
						<div id="event7" class="div_tag">做马杀鸡</div>
						<div id="event8" class="div_tag">求婚</div>
					</div>
				</div>
				
				<div>
					<input type="button" id="button_go" onclick="submitForm()"/>
				</div>
			</div>
	
			<div id="dv_bottom">
				<label id="label_lang">其他小伙伴也想和${param.fromnickname}一起浪</label>
				<div id="dv_list">
				</div>
			</div>
		</div>
		<div id="page2" style="display: none;">
			<div id="div_page2_top" class="dv_center">
				<div id="div_logo" class="dv_center"><img src="oyqy/images/logo.png" style="width: 100%;height: 100%;" /></div>
				<div id="div_downinfo" class="dv_center">5.0分&nbsp;&nbsp;&nbsp;58万次下载&nbsp;&nbsp;&nbsp;&nbsp;18.3MB</div>
				<div id="div_down" class="dv_center"><a href="https://itunes.apple.com/cn/app/ou-yu-qu-you-lu-xing-shi-he/id1119574979?l=en&mt=8"><img src="oyqy/images/down_button_down.png" style="width: 100%;height: 100%;" /></a></div>
			</div>
	
			<div class="nav">
				<div id="div_page2_bottom" class="dv_center">
					<img src="oyqy/images/down_bottom.png" style="width: 100%;height:90%;" />
				</div>
			</div>
		</div>
		
		<div id="page3" style="display: none;">
			<div id="div_page3_top" class="dv_center">
				<img src="oyqy/images/face/face10.png" style="width: 50%;" />
			</div>
			<div id="div_page3_other">
				<img src="oyqy/images/triangle.png" style="width:18px;" />
				<label id="label_otherwant">其他小伙伴也想和${param.fromnickname}一起浪</label>
				<img src="oyqy/images/triangle.png" style="width:18px;" />
			</div>
			<div id="dv_page3_list"></div>
		</div>
		
		<div id="share">
			<img  src="oyqy/images/share_top.png" style="width: 80%; margin-top: 20px;" />
		</div>
		
		<div id="div_button_bottom" class="nav">
			<div id="play"></div>
			<div id="down"></div>
		</div>
















</body>
</html>