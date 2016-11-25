<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/diving/";

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
		<link rel="stylesheet" type="text/css" href="css/index.css" />
		<link rel="stylesheet" type="text/css" href="css/animate.min.css" />
		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="js/clicked.js"></script>
		
		
		<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?97c02bc16a95712ff70cd0a99627b1e0";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
		
		
		
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
		
</head>
<body>
	
	<div id="share">
	</div>
	
	<form id="bd" name="bd" method="post">
		<input type="hidden" id="openid" name="fromopenid" value="${share.openid}">
		
		
	</form>
		<div id="page1" class="center" >
			<div id="div-bg"><img src="img/background.jpg" /></div>
			<div id="div-go" class="center animated pulse">
				<img id="btn_go" src="img/button_gogo.png" style="width: 100%;" />
			</div>
		</div>

		<div id="page2" class="center" style="display: none;">
			<div id="div-bg"><img src="img/background2.jpg" /></div>
			<div id="div-num">1.</div>
			<div id="div-title">潜水员需要会</br>游泳吗？</div>
			<div id="div-line"><img src="img/line.png" style="height: 100%; width: 80%;" /></div>
			<div id="p2_div_item1" class="list listword1">
				<div class="item">A.不需要，水下有脚蹼帮忙</div>
				<div id="p2_item_check1" class="check"><img src="img/nochecked.png" style="width: 100%;" /></div>
			</div>
			<div id="p2_div_item2" class="list listword">
				<div class="item">B.需要，考证必备</div>
				<div id="p2_item_check2" class="check"><img src="img/nochecked.png" style="width: 100%;" /></div>
			</div>
		</div>
		<div id="page3" class="center" style="display: none;">
			<div id="div-bg"><img src="img/background2.jpg" /></div>
			<div id="div-num">2.</div>
			<div id="div-title">以下哪一个不是</br>潜水面镜？</div>
			<div id="div-line"><img src="img/line.png" style="height: 100%; width: 80%;" /></div>
			<div id="p3_div_item1" class="list">
				<div class="item"><img src="img/p3-a.png" style="height: 60px;" /></div>
				<div id="p3_item_check1" class="check"><img src="img/nochecked.png" style="width: 100%;" /></div>
			</div>
			<div id="p3_div_item2" class="list">
				<div class="item"><img src="img/p3-b.png" style="height: 60px;" /></div>
				<div id="p3_item_check2" class="check"><img src="img/nochecked.png" style="width: 100%;" /></div>
			</div>
			<div id="p3_div_item3" class="list">
				<div class="item"><img src="img/p3-c.png" style="height: 50px;" /></div>
				<div id="p3_item_check3" class="check"><img src="img/nochecked.png" style="width: 100%;" /></div>
			</div>
		</div>
		<div id="page4" class="center" style="display: none;">
			<div id="div-bg"><img src="img/background2.jpg" /></div>
			<div id="div-num">3.</div>
			<div id="div-title">以下哪一项是</br>潜水结束后可以做的事？</div>
			<div id="div-line"><img src="img/line.png" style="height: 100%; width: 80%;" /></div>

			<div id="p4_div_item1" class="list listword1">
				<div class="item">A.适度运动，休息排氮</div>
				<div id="p4_item_check1" class="check"><img src="img/nochecked.png" style="width: 100%;" /></div>
			</div>
			<div id="p4_div_item2" class="list listword">
				<div class="item">B.归心似箭，立刻登机</div>
				<div id="p4_item_check2" class="check"><img src="img/nochecked.png" style="width: 100%;" /></div>
			</div>
			<div id="p4_div_item3" class="list listword">
				<div class="item">C.旋转跳跃，剧烈运动</div>
				<div id="p4_item_check3" class="check"><img src="img/nochecked.png" style="width: 100%;" /></div>
			</div>
		</div>

		<div id="page5" class="center" style="display: none;">
			<div id="div-bg"><img src="img/background2.jpg" /></div>
			<div id="div-num">4.</div>
			<div id="div-title">OW潜水执照的</br>全称是？</div>
			<div id="div-line"><img src="img/line.png" style="height: 100%; width: 80%;" /></div>

			<div id="p5_div_item1" class="list listword1">
				<div class="item">A.OPEN WATER DIVER</div>
				<div id="p5_item_check1" class="check"><img src="img/nochecked.png" style="width: 100%;" /></div>
			</div>
			<div id="p5_div_item2" class="list listword">
				<div class="item">B.OverWatch</div>
				<div id="p5_item_check2" class="check"><img src="img/nochecked.png" style="width: 100%;" /></div>
			</div>
			<div id="p5_div_item3" class="list listword">
				<div class="item">C.OPEN WINDOW</div>
				<div id="p5_item_check3" class="check"><img src="img/nochecked.png" style="width: 100%;" /></div>
			</div>
		</div>

		<div id="page6" class="center" style="display: none;">
			<div id="div-bg"><img src="img/background2.jpg" /></div>
			<div id="div-num">5.</div>
			<div id="div-title">以下哪一个不是主流的</br>国际潜水执照颁发机构？</div>
			<div id="div-line"><img src="img/line.png" style="height: 100%; width: 80%;" /></div>

			<div id="p6_div_item1" class="list listword1">
				<div class="item">A.PADI</div>
				<div id="p6_item_check1" class="check"><img src="img/nochecked.png" style="width: 100%;" /></div>
			</div>
			<div id="p6_div_item2" class="list listword">
				<div class="item">B.FEFS</div>
				<div id="p6_item_check2" class="check"><img src="img/nochecked.png" style="width: 100%;" /></div>
			</div>
			<div id="p6_div_item3" class="list listword">
				<div class="item">C.CMAS</div>
				<div id="p6_item_check3" class="check"><img src="img/nochecked.png" style="width: 100%;" /></div>
			</div>
		</div>

		<div id="page7" class="center" style="display: none;">
			<div id="div-bg"><img src="img/background2.jpg" /></div>
			<div class="result_1">你&nbsp;&nbsp;&nbsp;是</div>
			<div class="result_2">“&nbsp;棒&nbsp;棒&nbsp;哒&nbsp;潜&nbsp;水&nbsp;员&nbsp;”</div>
			<div class="result_3">击败了99%的潜水新人</div>
			<div class="result_4">上山下海，无所不能！</div>
			<div class="result_5"><img id="page7_go" class="animated pulse" src="img/button_gethb.png" style="width: 33%;" /></div>
			<div class="result_6">偶遇趣游正在</div>
			<div class="result_7">为大家搜寻超值的夏季潜水之旅</div>
			<div class="result_7">最高立减1500元!</div>
		</div>

		<div id="page8" class="center" style="display: none;">
			<div id="div-bg"><img src="img/background2.jpg" /></div>
			<div class="result_1">你&nbsp;&nbsp;&nbsp;是</div>
			<div class="result_2">“&nbsp;萌&nbsp;萌&nbsp;哒&nbsp;潜&nbsp;水&nbsp;玩&nbsp;家&nbsp;”</div>
			<div class="result_3">击败了60%的潜水新人</div>
			<div class="result_4">潜水明日之星，请继续加油！</div>
			<div class="result_5"><img id="page8_go" class="animated pulse" src="img/button_gethb.png" style="width: 33%;" /></div>
			<div class="result_6">偶遇趣游正在</div>
			<div class="result_7">为大家搜寻超值的夏季潜水之旅</div>
			<div class="result_7">最高立减1500元!</div>
		</div>

		<div id="page9" class="center" style="display: none;">
			<div id="div-bg"><img src="img/background2.jpg" /></div>
			<div class="result_1">你&nbsp;&nbsp;&nbsp;是</div>
			<div class="result_2">“&nbsp;酱&nbsp;油&nbsp;的&nbsp;潜&nbsp;水&nbsp;新&nbsp;人&nbsp;”</div>
			<div class="result_3">99%的人击败了你，</div>
			<div class="result_4">请在专业人员的指导下潜水哟～</div>
			<div class="result_5"><img id="page9_go" class="animated pulse" src="img/button_gethb.png" style="width: 33%;" /></div>
			<div class="result_6">偶遇趣游正在</div>
			<div class="result_7">为大家搜寻超值的夏季潜水之旅</div>
			<div class="result_7">最高立减1500元!</div>
		</div>

		<div id="page10" class="center" style="display: none;" >
			<div id="div-bg"><img id="btn_evcode" src="img/background3.jpg" /></div>
			<div id="div_incode"><p id="incode"></p></div>
			<div id="div-evcode" >
				<img src="img/evcode.jpg" style="width: 100%" /> 
			</div>
			
			<div id="div-invitation" class="center animated pulse">
				<img id="btn_invitation" src="img/button_invitation.png" style="width: 100%" />
			</div>
		</div>
		
		 <div id="div_canvas" style="width:100%;height:100%;margin:0px auto;z-index: -1;position: fixed;">
			<canvas width="320" height="480" id="cavs" style="z-index: -1;position: fixed;bottom: 0;" ></canvas>
		  </div>

	<div id="page11" class="center" onclick="$('#page11').hide()" style="display: none;">
	<img id="shareimg" src="img/share.png" style="width: 100%;" />
	</div>
   <script>
	var canvas=document.getElementById("cavs");
	var context=canvas.getContext("2d");
	const WIDTH=canvas.width;
	const HEIGHT=canvas.height;
	
	//初始数据对象
	var start={
		circles:[],
		num:null,
		timer:null,
		DURATION:60,
		begin:function(){//初始化数据
			//
			//调用生成函数
			this.createCircle();
		},
		createCircle:function(){//生成气泡
			for (var i=0;i<WIDTH/40 ;i++ )
			{	
				var c=new Circle()
				this.circles.push(c);
			}
			//调用画圆方法
			setInterval(this.drawCircle.bind(this),this.DURATION);
		},
		drawCircle:function(){
			//刷新屏幕
			context.clearRect(0,0,WIDTH,HEIGHT);
			for(var key in this.circles)//画气泡
			{
				this.circles[key].draw();
			}
		}
	}
	//气泡构造器
	function Circle(){
		//留住this
		var me=this;
		
		//生成随机数的方法
		function rand(){
			//随机r 3~6
			me.attr.r=Math.floor(Math.random()*3+3);
			//随机x r~width-r
			me.attr.x=Math.floor(Math.random()*(window.WIDTH-2*me.attr.r)+me.attr.r);
			//随机y height-100~height-r
			me.attr.y=Math.floor(Math.random()*(100-me.attr.r)+window.HEIGHT-100);
			//随机color
			me.attr.ColR=Math.floor(Math.random()*255);
			me.attr.ColG=Math.floor(Math.random()*255);
			me.attr.ColB=Math.floor(Math.random()*255);
			
			//随机alpha
			me.attr.alpha=Math.random()*0.4+0.05;
			//随机速度增量vector  1~10
			me.attr.vector=Math.floor(Math.random()*8+0.1);
		}

		//生成一个保存circle所有的属性集合的对象attr,同时初始化一次圆的属性
		(function(){
			me.attr={};
			rand();
			//console.log(me.attr.red);
		}());
		//画图的方法
		me.draw=function(){
			//如果透明，则重新生成
			if (me.attr.alpha<0.01)
			{
				rand();
			}
			context.strokeStyle="white"
			context.beginPath();
			context.arc(me.attr.x, me.attr.y, me.attr.r, 0, Math.PI*2);
			context.closePath();

			//彩色
			//context.fillStyle="rgba("+me.attr.ColR+","+ me.attr.ColB +","+me.attr.ColB +","+me.attr.alpha +")";
			
			//context.fillStyle="rgba(255,255,255,100)";
			//context.fill();
			context.stroke();
			me.attr.y-=me.attr.vector;
			me.attr.alpha-=0.008;
		}
	}
   </script>

</body>
</html>