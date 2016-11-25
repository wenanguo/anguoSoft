<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

String path = request.getContextPath();

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/160707/";

String openid = request.getParameter("openId");

%>
<!DOCTYPE html>
<html lang="zh-cn" class="no-js">
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type">
		<meta content="text/html; charset=utf-8">
		<meta charset="utf-8">
		<title>${share.title}</title>		
		<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="format-detection" content="email=no">
		
		
		<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>

		<link rel="stylesheet" type="text/css" href="css/default.css?v=1" />
		<link rel="stylesheet" type="text/css" href="css/reset.css?v=1" />
		<link rel="stylesheet" type="text/css" href="css/component.css?v=1" />
		<link rel="stylesheet" type="text/css" href="css/animations.css?v=1" />
		<link rel="stylesheet" type="text/css" href="css/animate.css?v=1">
		<link rel="stylesheet" type="text/css" href="css/main.css?v=1" />
		<link rel="stylesheet" type="text/css" href="css/loaders.css?v=1" />

		<!-- 新 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="css/bootstrap-3.3.5-dist/css/bootstrap.min.css">





		<script src="js/modernizr.custom.js"></script>
		<script src="js/touch-0.2.14.min.js"></script>


		<script src="js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="js/iscroll.js"></script>
		
		

		<script>



	function subtext(text) {
	var displayLength = 8;
	if (!text) return "";

	var result = "";
	var count = 0;
	for (var i = 0; i < displayLength; i++) {
	var _char = text.charAt(i);
	if (count >= displayLength)  break;
	if (/[^x00-xff]/.test(_char))  count++;  //双字节字符，//[u4e00-u9fa5]中文

	result += _char;
	count++;
	}
	if (result.length < text.length) {
	result += "...";
	}
	return result;
	}





	var myScroll;

	

	//document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);





	function download(){
			window.location = "http://lb.teamyy.cn/encounterr-web/160606/index.html";
		}
		
		/**
		 * 点赞
		 */
		function like(travelId){
			try{

				$.post('../oyqyHistoryLike/create.htm?openid='+$("#toopenid").val()+'&travelId='+travelId,  function(response){

					if(response.code==1601){
				
						//loadHistory();
						
					loadyj(response.rows);
					
						//</td><td width='10%'><div  style='font-size: 0.4em;'>+"+response.rows.likednum+"</div></td>
						
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
		* 更新眼睛
		*/
		function loadyj(data){
			
			var yjimg="";
			var yjnum="";
			
			if((data.ismyliked==0) && (data.likednum>0)){
				
				yjimg = yjimg+"<img src='images/1/5.png' style='width: 100%;height: auto;' onclick='like("+data.id+")'>";
				yjnum = yjnum+"<div  style='font-size: 0.4em;'>+"+data.likednum+"</div>";
			}else if((data.ismyliked==0) ){
				
				yjimg = yjimg+"<img src='images/1/5.png' style='width: 100%;height: auto;' onclick='like("+data.id+")'>";
			}
			else{
				yjimg = yjimg+"<img src='images/1/6.png' style='width: 100%;height: auto;' onclick='unlike("+data.id+")'>";
				yjnum = yjnum+"<div  style='font-size: 0.4em;'>+"+data.likednum+"</div>";
			}
			
			$("#"+data.id+"yjimg").html("");
			$("#"+data.id+"yjimg").html(yjimg);
			
			$("#"+data.id+"num").html("");
			$("#"+data.id+"num").html(yjnum);
			
			
			//myScroll = new IScroll('#p107', { mouseWheel: true ,preventDefault:false});
			
			
		}

		/**
		 * 取消点赞
		 */
		function unlike(travelId){
			try{

				$.post('../oyqyHistoryLike/delete.htm?openid='+$("#toopenid").val()+'&travelId='+travelId,  function(response){

					if(response.code==1611){
				
						loadyj(response.rows);
					
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
			
		//获得旅行列表
		function loadHistory(){
			

			try{

				$.post('../oyqyhistory/list.htm?rows=10&toopenid='+$("#toopenid").val()+'&fromopenid='+$("#fromopenid").val(),  function(response){

					if(response.code==1200){
				
						showlist(response.rows,"scroller");
						
						myScroll.refresh();
					
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
		
		
		
		

			function submitForm(){
				if($("#city").val()==""){
					
					alert("请输入地点!");
					return false;
					
				}
				
				if($("#dosamething").val()==""){
					alert("请输入做了什么事!");
					return false;
				}



				//显示图层
				$("#loaddiv").show();

				try{

				$.post('../oyqyhistory/create.htm', $('#bd').serializeArray(), function(response){

				if(response.code==1601){
					//隐藏图层
					$("#loaddiv").hide();
					
					PageTransitions.moveJdPage(0);
					
					loadHistory();
					
					
					

				}else if(response.code==1602){
					alert(response.msg);
					//隐藏图层
					$("#loaddiv").hide();

				}else{
					alert('网络出现问题了!');
					//隐藏图层
					$("#loaddiv").hide();
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
	* 切换头像
	*/
	function switchHeadImg(flag){


	var nextIndex=1;



	if(flag){
	if($("#currsex").val()==7){

	nextIndex=1;

	}else{
	nextIndex=Number($("#currsex").val())+1;
	}
	}else{
	if($("#currsex").val()==1){

	nextIndex=7;

	}else{
	nextIndex=Number($("#currsex").val())-1;
	}
	}

	$("#headimg").attr('src',"images/2/4_"+nextIndex+".png");

	$("#tosex").val(nextIndex);

	$("#currsex").val(nextIndex);



	}
			

		
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
			    title: '${share.title}', // 分享标题
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
		
		
		function loadis(){
			myScroll = new IScroll('#p107', { mouseWheel: true ,preventDefault:false});
			console.log("滑动加载");
		}
		



		</script>




	


		
	</head>
	<body >

	<div id="loaddiv">

		<div class="loading loader-inner line-scale">
			<div></div>
			<div></div>
			<div></div>
			<div></div>
			<div></div>
		</div>

	</div>




	<div id="pt-main" class="pt-perspective">

		<div id="target" class="pt-page pt-page-1">



			<div id="p102" ><img src="images/1/1.png" style="width: 100%;height: auto;"></div>
			<div id="p103" ></div>
			<div id="p104" ><img src="${from.fromheadimgurl}"  class="img-circle" style="width: 100%;height: auto;"></div>

			<div id="p105" onclick="PageTransitions.moveJdPage(1);"><img src="images/1/2.png" style="width: 100%;height: auto;"></div>
			<div id="p106" onclick="$('#sharediv').show();"><img src="images/1/3.png" style="width: 100%;height: auto;"></div>


			<div id="p107" >
				<div id="scroller">
				
	            </div>
			
			</div>

			<div id="p108" onclick="download()"><img src="images/logo.png" style="width: 100%;height: auto;"></div>




		</div>


		<div class="pt-page pt-page-2" >

			<div id="p201" ><img src="images/1/1.png" style="width: 100%;height: auto;"></div>
			<div id="p202" ></div>
			<div id="p203" ><img src="${from.fromheadimgurl}"  class="img-circle" style="width: 100%;height: auto;"></div>


			<div id="p2041" style="width: 100%;align-content: center;text-align:center;">

			<div id="p204" >我曾和${from.fromnickname}</div>
			<div id="p205" >
				<form id="bd" name="bd" method="post">
				<table width="100%" border="0">
					<tr>
						<td width="15%"><img src="images/2/2_01.png" style="width: 100%;height: auto;"></td>
						<td width="30%"><input type="text" name="city" id="city" placeholder="地点" style="border:1px;"></td>
						<td width="5%"><img src="images/2/2_03.png" style="width: 100%;height: auto;"></td>
						<td width="50%"><input type="text" name="dosamething" id="dosamething" placeholder="做过什么" style="border:1px;"></td>
					</tr>
				</table>
					<input type="hidden" id="fromopenid" name="fromopenid" value="${from.fromopenid}">
					<input type="hidden" id="fromnickname" name="fromnickname" value="${from.fromnickname}">
					<input type="hidden" id="fromsex" name="fromsex" value="${from.fromsex}">
					<input type="hidden" id="fromheadimgurl" name="fromheadimgurl" value="${from.fromheadimgurl}">
					
					<input type="hidden" id="toopenid" name="toopenid" value="${param.openid}">
					<input type="hidden" id="tonickname" name="tonickname" value="${param.nickname}">
					<input type="hidden" id="tosex" name="tosex" value="${param.sex}">
					<input type="hidden" id="toheadimgurl" name="toheadimgurl" value="${param.headimgurl}">
					<input type="hidden" id="currsex" name="currsex" value="1">
				</form>




			</div>
			<div id="p206" onclick="submitForm()"><img src="images/2/3.png" style="width: 100%;height: auto;"></div>



			<div id="p207" >
				<table width="100%" border="0" style="align-content: center;">
					<tr>
						<td width="10%" style="padding-top: 10%;"></td>
						<td width="20%"><img src="images/2/5.png" style="width: 80%;height: auto;" onclick="switchHeadImg(true)"></td>
						<td width="40%" style="margin: 0 auto;"><img id="headimg" name="headimg"  src="images/2/4_1.png" style="width: 60%;height: auto;"></td>
						<td width="20%"><img src="images/2/6.png" style="width: 100%;height: auto;" onclick="switchHeadImg(false)"></td>
						<td width="10%"></td>
					</tr>


				</table>
			</div>
			</div>
			<div id="p208" onclick="download()"><img src="images/logo.png" style="width: 100%;height: auto;"></div>


		</div>



		<div id="sharediv" name="sharediv" onclick='$("#sharediv").hide();'>

		</div>
	</div>


	<script src="js/jquery.dlmenu.js"></script>
	<script src="js/pagetransitions.js"></script>

	<script src="js/default.js"></script>
	</body>
</html>