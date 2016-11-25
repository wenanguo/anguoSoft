<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/160810/";

String openid = request.getParameter("openId");
%>
<!DOCTYPE html>
<html lang="zh-cn" class="no-js">
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type">
		<meta content="text/html; charset=utf-8">
		<meta charset="utf-8">
		<title>泰森运动会</title>		
		<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="format-detection" content="email=no">
		
		
		<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>

		<!--[if IE]>
			<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
		<![endif]-->


		<link rel="stylesheet" type="text/css" href="css/component.css?v=1" />
		<link rel="stylesheet" type="text/css" href="css/animations.css?v=1" />
		<link rel="stylesheet" type="text/css" href="css/animate.css?v=1">
		<link rel="stylesheet" type="text/css" href="css/main.css?v=1" />
		<link rel="stylesheet" type="text/css" href="css/loaders.css?v=1" />

		<link rel="stylesheet" type="text/css" href="js/bootstrap-3.3.5-dist/css/bootstrap.css" />


		<link rel="stylesheet" type="text/css" href="css/cropper.min.css?v=1">
		<link rel="stylesheet" type="text/css" href="css/mui.min.css?v=1">
		<link rel="stylesheet" type="text/css" href="css/my.css?v=1">

		<link rel="stylesheet" type="text/css" href="js/progress/css/bootstrap-progressbar-3.2.0.min.css">
		<link rel="stylesheet" type="text/css" href="js/progress/css/bootstrap-progressbar-demo.css">




		<script src="js/modernizr.custom.js?v=1"></script>
		<script src="js/touch-0.2.14.min.js?v=1"></script>


		<script src="js/jquery-1.11.3.min.js?v=1"></script>

		<script type="text/javascript"  src="js/progress/js/common.min.js"></script>
		<script type="text/javascript"  src="js/progress/js/bootstrap-progressbar.js"></script>
		<script type="text/javascript"  src="js/progress/js/minddust.min.js"></script>

		<script type="text/javascript" src="js/dist/lrz.all.bundle.js"></script>
		<script type="text/javascript" src="js/cropper.min.js"></script>
		<script type="text/javascript" src="js/getimage.js"></script>

		<script type="text/javascript" src="js/fastclick.js"></script>
	<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?61dc23c6029d21c5656f6cad793b0c77";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
	
	


		<script>
			
			function checkMobile(str) {
				
			    var re = /^1\d{10}$/
			    if (re.test(str)) {
			        return true;
			    } else {
			        return false;
			    }
			}
			
			
			function getShareNumber(){
				var max=1000;
				var min=100;
				return parseInt(Math.random()*(max-min+1)+min,10);
			}
			
			
			function submitForm(){
				if($("#name").val()==""){
					
					alert("请输入昵称!");
					return false;
					
				}
				
				if(!checkMobile($("#phone").val())){
					alert("请输入正确的手机号!");
					return false;
				}



				//显示图层
				$("#loaddiv").show();

				try{

				$.post('http://lb.teamyy.cn/mkl/160521/create.htm', $('#bd').serializeArray(), function(response){

				if(response.code==1601){
				//隐藏图层
				$("#loaddiv").hide();
				alert(response.msg);

				tz();

				}else if(response.code==1602){
				alert(response.msg);
				//隐藏图层
				tz();
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
			
		
			function submitShare(){
				
				
				
				$.post('wine/create.htm', '', function(response){
					
						
						if(response.code==1601){
							
							//alert('分享成功！您是第'+response.page+'位分享者！');
							alert('分享成功！');
							
						}else if(response.code==1602){
							alert(response.msg);
						}else{
							alert('网络出现问题了!');
						}
						
					});
				
				
				
				
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
			    title: '据说洪荒之力的正确打开方式 你的好友都不知道哦~！', // 分享标题
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
		
		
		
		

		//从一个给定的数组arr中,随机返回num个不重复项
		function getArrayItems(arr, num) {
		    //新建一个数组,将传入的数组复制过来,用于运算,而不要直接操作传入的数组;
		    var temp_array = new Array();
		    for (var index in arr) {
		        temp_array.push(arr[index]);
		    }
		    //取出的数值项,保存在此数组
		    var return_array = new Array();
		    for (var i = 0; i<num; i++) {
		        //判断如果数组还有可以取出的元素,以防下标越界
		        if (temp_array.length>0) {
		            //在数组中产生一个随机索引
		            var arrIndex = Math.floor(Math.random()*temp_array.length);
		            //将此随机索引的对应的数组元素值复制出来
		            return_array[i] = temp_array[arrIndex];
		            //然后删掉此索引的数组元素,这时候temp_array变为新的数组
		            temp_array.splice(arrIndex, 1);
		        } else {
		            //数组中数据项取完后,退出循环,比如数组本来只有10项,但要求取出20项.
		            break;
		        }
		    }
		    return return_array;
		}



		function showZf(){
			var ArrList=[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18];
			var showArrList=getArrayItems(ArrList,8);
			for (var index in showArrList) {
		        $('#zf'+showArrList[index]).show();
		    }
			
			
			
		}

	/* 音乐播放控制 */
	function play_music(){
	if ($('#mc_play').hasClass('on')){
	$('#mc_play audio').get(0).pause();
	$('#mc_play').attr('class','stop');
	$('.copy img').attr("src","images/nomusic.png");

	$('.copy img').removeClass("rotateMusic");

	}else{
	$('#mc_play audio').get(0).play();
	$('#mc_play').attr('class','on');
	$('.copy img').attr("src","images/music.png");
	$('.copy img').addClass("rotateMusic");
	}
	}
		
		</script>




	


		
	</head>
	<body>

	<!-- 音乐 -->
	<span id="musicControl">
	<a id="mc_play" class="on" onclick="play_music();">
	<audio id="audio_play" src="" loop="">
	</audio>
	</a>
	</span>
	<div class="copy" onclick="play_music()"><img class="rotateMusic"  src="images/music.png" style="width: 100%;height: auto;display: none;"></div>


	<div id="loaddiv">

		<div class="loading loader-inner line-scale">
			<div></div>
			<div></div>
			<div></div>
			<div></div>
			<div></div>
		</div>

	</div>



	<div id="p0801" onclick='$("#p0801").hide()'>
	<form id="bd" name="bd" method="post">
		<input type="hidden" id="fromopenid" name="fromopenid" value="${share.openid}">
		
		
					
		<input type="hidden" id="fromheadimgurl" name="fromheadimgurl" value="">
		
		
	</form>
	</div>
	
	

	<div id="p0901" >



		<div id="p0902" class="animated pulse infinite">
			<a href="javascript:displayDiv(0);"><img  src="images/8/p01.png" style="width: 100%;height: auto;"></a>
		</div>
		<div id="p0903" >
			<img class="img-circle"  src="${share.fromheadimgurl}" style="width: 100%;height: auto;"></a>
		</div>
	<div id="p0904" >
	<img  src="images/8/p02.png" style="width: 100%;height: 100%;"></a>
	</div>
	</div>




	<div id="pt-main" class="pt-perspective">



	<div id="target" class="pt-page pt-page-1">


	<div id="p0101">
	</div>



	</div>


	<div class="pt-page pt-page-2" >


	<div id="p0202"  >
	<img  src="images/1/p02.png" style="width: 100%;height: auto;">
	</div>
	<div id="p0203"  >
	<img  src="images/1/p03.png" style="width: 100%;height: auto;">
	</div>

	<div id="p0204"  >
	<img  src="images/1/p04.png" style="width: 100%;height: auto;">
	</div>
	<div id="p0205"  >
	<img  src="images/1/p05.png" style="width: 100%;height: auto;">
	</div>


	</div>



	<div class="pt-page pt-page-3">
	<div id="p0301">
	<img  src="images/2/xh.gif" style="width: 100%;height:100%;">
	</div>

	</div>

	<div class="pt-page pt-page-4" >
	<div id="p0401"  >
	<img  src="images/3/p01.png" style="width: 100%;height: auto;">
	</div>
	<div id="p0402"  >
	<img  src="images/3/p02.png" style="width: 100%;height: auto;">
	</div>
	<div id="p0403"  >
	<img  src="images/3/p03.png" style="width: 100%;height: auto;">
	</div>

	</div>
	<div class="pt-page pt-page-5" >


	<div class="idno div_input" id="div_head">
	<input type="file" name="image" id="image" class="inputfile" />
	<label for="image">
	<img id="headimg" name="headimg" class="img_idno" src="images/4/camera.png" style="width:250px; height: 250px;"/>
	</label>
	</div>

	<div id="showEdit" style="display: none;width:100%;height: 100%;position: absolute;top:14%;left: 0;z-index: 101;">
	<div style="width:100%;position: absolute;top:40px;left:0px;">
	<button class="mui-btn" data-mui-style="fab" id='cancleBtn' style="margin-left: 10px;">取消</button>
	<button class="mui-btn" data-mui-style="fab" data-mui-color="primary" id='confirmBtn' style="float:right;margin-right: 10px;">确定</button>
	</div>
	<div id="report">
	<img src="images/default.jpg" style="width: 300px;height:300px">
	</div>
	</div>



	<div id="p0502" ><img src="images/4/p02.png" style="width: 100%;height: 100%;"></div>

	<div id="p0501" class="animated pulse infinite"><a href="javascript:startGame();"><img src="images/4/button.png" style="width: 100%;height: auto;"></a></div>



	</div>
	<div class="pt-page pt-page-6" >

	<div id="p0608"></div>
	<div id="p0601" >
	<img id="i060101" src="images/5/p01.png" style="width: 100%;height: auto;">
	<img id="i060102" src="images/5/p02.png" style="width: 100%;height: auto;">
	<img id="i060103" src="images/5/p03.png" style="width: 100%;height: auto;">
	</div>

	<div id="p0602" class="animated pulse infinite"><a href="javascript:progress();"><img onMouseDown="onMouseDown1();" src="images/5/button.png" style="width: 100%;height: auto;"></a></div>
	<div id="p0603" ><img src="images/5/sweat.png" class="animated pulse infinite"  style="width: 100%;height: auto;"></div>

	<div id="p0604" >

	<div class="fixed-height-250">
	<div class="progress vertical bottom">
	<div id="jdt1" name="jdt1" class="progress-bar progress-bar-danger" role="progressbar" data-transitiongoal-backup="75"></div>
	</div>
	</div>

	</div>

	<div id="p0605" >

	<img src="images/5/jdt.png" style="width: 100%;height: auto;">

	</div>
	<div id="p0606" >
	<img src="images/5/05.png" style="width: 100%;height: auto;opacity: 0;">

	</div>

	<div id="p0607" >

	<img class="img-circle" src="" style="width: 100%;height: auto;">

	</div>

	<div id="p0609" >

	<img src="images/5/p08.png" style="width: 100%;height: auto;">

	</div>
	</div>
	<div class="pt-page pt-page-7" >
	<div id="p0704">
	<img src="images/6/p04.png" style="width: 100%;height: auto;z-index: 80;">
	</div>
	<div id="p0701" class="animated pulse infinite">
	<a  href="javascript:shop();" ><img src="images/6/p01.png" style="width: 100%;height: auto;z-index: 81;"></a>
	</div>
	<div id="p0702" >
	<img src="images/6/p02.png" style="width: 100%;height: auto;z-index: 82;">
	</div>
	<div id="p0703" class="animated pulse infinite">
	<a href="javascript:share();"><img src="images/6/p03.png" style="width: 100%;height: auto;z-index: 83;"></a>
	</div>
	<div id="p0705">
	<img class="img-circle" src="" style="width: 100%;height: auto;">
	</div>

	<div id="p0706">
	<img src="images/6/p05.png" style="width: 100%;height: auto;z-index: 81;">
	</div>

	<div id="p0707">
	<img src="images/6/p07.png" style="width: 100%;height: 100%;">
	</div>

	</div>

	</div>


	<script src="js/jquery.dlmenu.js"></script>
	<script src="js/pagetransitions.js"></script>

	<script src="js/default.js"></script>

	<script>


	function onMouseDown1(){


	}

	var provalue=0;

	/**
	* 点击举重按钮
	**/
	function progress(){

	provalue=provalue + 10;


	$('#jdt1').attr('data-transitiongoal', provalue).progressbar();

	personChange(provalue);

	}

	/**
	* 开始游戏
	*/
	function startGame(){


	if(($("#headimg").attr("src")=="images/4/camera.png")||($("#headimg").attr("src")=="")){
	alert("请点击人脸区域，上传照片");
	return false;
	}

	
	submitAction($("#fromopenid").val(),"startgame");
	
	PageTransitions.moveJdPage(5);
	}


	$(document).ready(function() {



	//初始化进度条
	$('#v-bottom-basic-start').click(function() {
	var $pb = $('#jdt1');
	$pb.attr('data-transitiongoal', $pb.attr('data-transitiongoal-backup'));
	$pb.progressbar();
	});

	});

	/**
	*  分享按钮
	**/
	function share(){

	submitAction($("#fromopenid").val(),"share")
	$("#p0801").show();

	}

	/**
	*  分享按钮
	**/
	function shop(){

	submitAction($("#fromopenid").val(),"shop")
	
	 window.location.href="http://shop.m.jd.com/?shopId=1000015410"; 

	}

	
	
	/**
	* 切换动画
	* @param value
	*/
	function personChange(value){

	if(value==40){
	//切换第二个动画
	//$("#i060101").attr("src","images/5/p02.png");
	$("#i060101").hide();
	$("#i060102").show();
	$("#i060103").hide();
	//改变汗水位置
	$("#p0603").css("top","28%");
	//改变头像位置
	$("#p0607").css("top","27%");
	//$("#p0606 img").attr("src","images/5/06.png");
	}else if(value==90){
	//切换第二个动画
	$("#i060101").hide();
	$("#i060102").hide();
	$("#i060103").show();
	//改变汗水位置
	$("#p0603").css("top","22%");

	//改变头像位置
	$("#p0607").css("top","18.5%");

	$("#p0603").css("left","29%");
	//$("#p0606 img").attr("src","images/5/07.png");


	}else if(value>=100) {

	clearInterval(timer1);
	PageTransitions.moveJdPage(6);

	$("#p0706 img").attr("src","images/6/p06.png");

	}
	}





	</script>

	<script>

	(function() {
	var audio = document.getElementById('audio_play');
	jQuery.ajax({
	url: 'js/ajax.js',
	async: false,
	success: function() {
	var audio = document.getElementById('audio_play');
	audio.play(); // audio will play in iOS before 4.2.1
	}
	});

	document.addEventListener('touchstart', function() {
	if (isTouch == false)
	{
	var audio = document.getElementById('audio_play');
	audio.play();

	isTouch=true;
	}


	}, false);
	})();





	</script>
	
	</body>
</html>