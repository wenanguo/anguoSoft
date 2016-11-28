<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page trimDirectiveWhitespaces="true"%>




<div id="header" >
    <div class="box">
        <h1 id="logo">
        <c:forEach var="webConfig" items="${webConfigList}">
        	<c:if test="${webConfig.code == 'config.logoImage' }">
        	${webConfig.content}
        	</c:if>
        </c:forEach>
        </h1>
        <div class="weibo"> 
        <c:forEach var="webConfig" items="${webConfigList}">
        	<c:if test="${webConfig.code == 'config.weibo' }">
        	${webConfig.content}
        	</c:if>
        </c:forEach>
        </div>
       
    </div>
    </div>
    
<div class="nav_menu">
	<div class="nav">
		<div class="list" id="navlist">
			<ul id="navfouce">
			 <c:forEach var="menu" items="${indexMenu}">
			 
			 	
			 	
				<li><a href="${menu.content}">${menu.title}</a></li>
			 	
			 	
			 	
			 	
			 </c:forEach>   
			</ul>
		</div>
		<!-- 
		<div class="box" id="navbox" style="height:0px;opacity:0;overflow:hidden;">
			<div class="cont" style="display:none;">
				<ul class="sublist clearfix">
					<li>
						<h3 class="mcate-item-hd"><span>服饰内衣</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">女装</a>
							<a href="http://sc.chinaz.com/jiaoben">男装</a>
							<a href="http://sc.chinaz.com/jiaoben">内衣</a>
							<a href="http://sc.chinaz.com/jiaoben">家居服</a>
							<a href="http://sc.chinaz.com/jiaoben">配件</a>
							<a href="http://sc.chinaz.com/jiaoben">羽绒</a>
							<a href="http://sc.chinaz.com/jiaoben">呢大衣</a>
							<a href="http://sc.chinaz.com/jiaoben">毛衣</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>鞋 箱包</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">女鞋</a>
							<a href="http://sc.chinaz.com/jiaoben">男鞋</a>
							<a href="http://sc.chinaz.com/jiaoben">箱包</a>
							<a href="http://sc.chinaz.com/jiaoben">女包</a>
							<a href="http://sc.chinaz.com/jiaoben">男包</a>
							<a href="http://sc.chinaz.com/jiaoben">旅行箱</a>
							<a href="http://sc.chinaz.com/jiaoben">钱包 </a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>珠宝、手表</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">饰品</a>
							<a href="http://sc.chinaz.com/jiaoben">项链</a>
							<a href="http://sc.chinaz.com/jiaoben">珠宝</a>
							<a href="http://sc.chinaz.com/jiaoben">钻石</a>
							<a href="http://sc.chinaz.com/jiaoben">手表</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>化妆品</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">护肤</a>
							<a href="http://sc.chinaz.com/jiaoben">彩妆</a>
							<a href="http://sc.chinaz.com/jiaoben">香水</a>
							<a href="http://sc.chinaz.com/jiaoben">男士</a>
							<a href="http://sc.chinaz.com/jiaoben">精油</a>
							<a href="http://sc.chinaz.com/jiaoben">假发</a>
							<a href="http://sc.chinaz.com/jiaoben">美体</a>
							<a href="http://sc.chinaz.com/jiaoben">试用服务</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>运动 户外</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">运动鞋</a>
							<a href="http://sc.chinaz.com/jiaoben">运动服</a>
							<a href="http://sc.chinaz.com/jiaoben">运动用品</a>
							<a href="http://sc.chinaz.com/jiaoben">户外</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>手机 数码</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">手机</a>
							<a href="http://sc.chinaz.com/jiaoben">笔记本</a>
							<a href="http://sc.chinaz.com/jiaoben">相机</a>
							<a href="http://sc.chinaz.com/jiaoben">平板电脑</a>
							<a href="http://sc.chinaz.com/jiaoben">配件</a>
							<a href="http://sc.chinaz.com/jiaoben">电脑硬件</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>家用电器</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">大家电</a>
							<a href="http://sc.chinaz.com/jiaoben">影音电器</a>
							<a href="http://sc.chinaz.com/jiaoben">生活电器</a>
							<a href="http://sc.chinaz.com/jiaoben">厨房电器</a>
							<a href="http://sc.chinaz.com/jiaoben">健康护理</a>
							<a href="http://sc.chinaz.com/jiaoben">剃须刀</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>家具 建材</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">家具</a>
							<a href="http://sc.chinaz.com/jiaoben">卫浴</a>
							<a href="http://sc.chinaz.com/jiaoben">地板</a>
							<a href="http://sc.chinaz.com/jiaoben">灯具</a>
							<a href="http://sc.chinaz.com/jiaoben">五金</a>
							<a href="http://sc.chinaz.com/jiaoben">开关</a>
							<a href="http://sc.chinaz.com/jiaoben">装修设计</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>家纺 居家</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">家纺</a>
							<a href="http://sc.chinaz.com/jiaoben">磨毛套件</a>
							<a href="http://sc.chinaz.com/jiaoben">羽绒被</a>
							<a href="http://sc.chinaz.com/jiaoben">枕头</a>
							<a href="http://sc.chinaz.com/jiaoben">软饰</a>
							<a href="http://sc.chinaz.com/jiaoben">居家</a>
							<a href="http://sc.chinaz.com/jiaoben">厨房</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>食品</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">零食</a>
							<a href="http://sc.chinaz.com/jiaoben">进口</a>
							<a href="http://sc.chinaz.com/jiaoben">茶叶</a>
							<a href="http://sc.chinaz.com/jiaoben">冲饮</a>
							<a href="http://sc.chinaz.com/jiaoben">酒水</a>
							<a href="http://sc.chinaz.com/jiaoben">粮油</a>
							<a href="http://sc.chinaz.com/jiaoben">干货</a>
							<a href="http://sc.chinaz.com/jiaoben">生鲜</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>医药保健</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">保健</a>
							<a href="http://sc.chinaz.com/jiaoben">滋补</a>
							<a href="http://sc.chinaz.com/jiaoben">蛋白粉</a>
							<a href="http://sc.chinaz.com/jiaoben">阿胶</a>
							<a href="http://sc.chinaz.com/jiaoben">药品</a>
							<a href="http://sc.chinaz.com/jiaoben">血压仪</a>
							<a href="http://sc.chinaz.com/jiaoben">计生</a>
							<a href="http://sc.chinaz.com/jiaoben">体检</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>母婴用品</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">玩具</a>
							<a href="http://sc.chinaz.com/jiaoben">宝宝食品</a>
							<a href="http://sc.chinaz.com/jiaoben">用品</a>
							<a href="http://sc.chinaz.com/jiaoben">童装</a>
							<a href="http://sc.chinaz.com/jiaoben">孕装</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>汽车 配件</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">新车</a>
							<a href="http://sc.chinaz.com/jiaoben">座垫</a>
							<a href="http://sc.chinaz.com/jiaoben">脚垫</a>
							<a href="http://sc.chinaz.com/jiaoben">GPS</a>
							<a href="http://sc.chinaz.com/jiaoben">车衣</a>
							<a href="http://sc.chinaz.com/jiaoben">洗车机</a>
							<a href="http://sc.chinaz.com/jiaoben">水枪</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>文化 玩乐</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">电子凭证</a>
							<a href="http://sc.chinaz.com/jiaoben">图书</a>
							<a href="http://sc.chinaz.com/jiaoben">乐器</a>
							<a href="http://sc.chinaz.com/jiaoben">旅游</a>
							<a href="http://sc.chinaz.com/jiaoben">鲜花</a>
						</p>
					</li>
				</ul>
			</div>
			<div class="cont" style="display:none;">
				<ul class="sublist clearfix">
					<li>
						<h3 class="mcate-item-hd"><span>服饰内衣</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">女装</a>
							<a href="http://sc.chinaz.com/jiaoben">男装</a>
							<a href="http://sc.chinaz.com/jiaoben">内衣</a>
							<a href="http://sc.chinaz.com/jiaoben">家居服</a>
							<a href="http://sc.chinaz.com/jiaoben">配件</a>
							<a href="http://sc.chinaz.com/jiaoben">羽绒</a>
							<a href="http://sc.chinaz.com/jiaoben">呢大衣</a>
							<a href="http://sc.chinaz.com/jiaoben">毛衣</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>鞋 箱包</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">女鞋</a>
							<a href="http://sc.chinaz.com/jiaoben">男鞋</a>
							<a href="http://sc.chinaz.com/jiaoben">箱包</a>
							<a href="http://sc.chinaz.com/jiaoben">女包</a>
							<a href="http://sc.chinaz.com/jiaoben">男包</a>
							<a href="http://sc.chinaz.com/jiaoben">旅行箱</a>
							<a href="http://sc.chinaz.com/jiaoben">钱包 </a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>珠宝、手表</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">饰品</a>
							<a href="http://sc.chinaz.com/jiaoben">项链</a>
							<a href="http://sc.chinaz.com/jiaoben">珠宝</a>
							<a href="http://sc.chinaz.com/jiaoben">钻石</a>
							<a href="http://sc.chinaz.com/jiaoben">手表</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>化妆品</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">护肤</a>
							<a href="http://sc.chinaz.com/jiaoben">彩妆</a>
							<a href="http://sc.chinaz.com/jiaoben">香水</a>
							<a href="http://sc.chinaz.com/jiaoben">男士</a>
							<a href="http://sc.chinaz.com/jiaoben">精油</a>
							<a href="http://sc.chinaz.com/jiaoben">假发</a>
							<a href="http://sc.chinaz.com/jiaoben">美体</a>
							<a href="http://sc.chinaz.com/jiaoben">试用服务</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>运动 户外</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">运动鞋</a>
							<a href="http://sc.chinaz.com/jiaoben">运动服</a>
							<a href="http://sc.chinaz.com/jiaoben">运动用品</a>
							<a href="http://sc.chinaz.com/jiaoben">户外</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>手机 数码</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">手机</a>
							<a href="http://sc.chinaz.com/jiaoben">笔记本</a>
							<a href="http://sc.chinaz.com/jiaoben">相机</a>
							<a href="http://sc.chinaz.com/jiaoben">平板电脑</a>
							<a href="http://sc.chinaz.com/jiaoben">配件</a>
							<a href="http://sc.chinaz.com/jiaoben">电脑硬件</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>家用电器</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">大家电</a>
							<a href="http://sc.chinaz.com/jiaoben">影音电器</a>
							<a href="http://sc.chinaz.com/jiaoben">生活电器</a>
							<a href="http://sc.chinaz.com/jiaoben">厨房电器</a>
							<a href="http://sc.chinaz.com/jiaoben">健康护理</a>
							<a href="http://sc.chinaz.com/jiaoben">剃须刀</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>家具 建材</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">家具</a>
							<a href="http://sc.chinaz.com/jiaoben">卫浴</a>
							<a href="http://sc.chinaz.com/jiaoben">地板</a>
							<a href="http://sc.chinaz.com/jiaoben">灯具</a>
							<a href="http://sc.chinaz.com/jiaoben">五金</a>
							<a href="http://sc.chinaz.com/jiaoben">开关</a>
							<a href="http://sc.chinaz.com/jiaoben">装修设计</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>家纺 居家</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">家纺</a>
							<a href="http://sc.chinaz.com/jiaoben">磨毛套件</a>
							<a href="http://sc.chinaz.com/jiaoben">羽绒被</a>
							<a href="http://sc.chinaz.com/jiaoben">枕头</a>
							<a href="http://sc.chinaz.com/jiaoben">软饰</a>
							<a href="http://sc.chinaz.com/jiaoben">居家</a>
							<a href="http://sc.chinaz.com/jiaoben">厨房</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>食品</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">零食</a>
							<a href="http://sc.chinaz.com/jiaoben">进口</a>
							<a href="http://sc.chinaz.com/jiaoben">茶叶</a>
							<a href="http://sc.chinaz.com/jiaoben">冲饮</a>
							<a href="http://sc.chinaz.com/jiaoben">酒水</a>
							<a href="http://sc.chinaz.com/jiaoben">粮油</a>
							<a href="http://sc.chinaz.com/jiaoben">干货</a>
							<a href="http://sc.chinaz.com/jiaoben">生鲜</a>
						</p>
					</li>
				</ul>
			</div>
			<div class="cont" style="display:none;">
				<ul class="sublist clearfix">
					<li>
						<h3 class="mcate-item-hd"><span>服饰内衣</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">女装</a>
							<a href="http://sc.chinaz.com/jiaoben">男装</a>
							<a href="http://sc.chinaz.com/jiaoben">内衣</a>
							<a href="http://sc.chinaz.com/jiaoben">家居服</a>
							<a href="http://sc.chinaz.com/jiaoben">配件</a>
							<a href="http://sc.chinaz.com/jiaoben">羽绒</a>
							<a href="http://sc.chinaz.com/jiaoben">呢大衣</a>
							<a href="http://sc.chinaz.com/jiaoben">毛衣</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>鞋 箱包</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">女鞋</a>
							<a href="http://sc.chinaz.com/jiaoben">男鞋</a>
							<a href="http://sc.chinaz.com/jiaoben">箱包</a>
							<a href="http://sc.chinaz.com/jiaoben">女包</a>
							<a href="http://sc.chinaz.com/jiaoben">男包</a>
							<a href="http://sc.chinaz.com/jiaoben">旅行箱</a>
							<a href="http://sc.chinaz.com/jiaoben">钱包 </a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>珠宝、手表</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">饰品</a>
							<a href="http://sc.chinaz.com/jiaoben">项链</a>
							<a href="http://sc.chinaz.com/jiaoben">珠宝</a>
							<a href="http://sc.chinaz.com/jiaoben">钻石</a>
							<a href="http://sc.chinaz.com/jiaoben">手表</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>化妆品</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">护肤</a>
							<a href="http://sc.chinaz.com/jiaoben">彩妆</a>
							<a href="http://sc.chinaz.com/jiaoben">香水</a>
							<a href="http://sc.chinaz.com/jiaoben">男士</a>
							<a href="http://sc.chinaz.com/jiaoben">精油</a>
							<a href="http://sc.chinaz.com/jiaoben">假发</a>
							<a href="http://sc.chinaz.com/jiaoben">美体</a>
							<a href="http://sc.chinaz.com/jiaoben">试用服务</a>
						</p>
					</li>
					<li>
						<h3 class="mcate-item-hd"><span>运动 户外</span></h3>
						<p class="mcate-item-bd">
							<a href="http://sc.chinaz.com/jiaoben">运动鞋</a>
							<a href="http://sc.chinaz.com/jiaoben">运动服</a>
							<a href="http://sc.chinaz.com/jiaoben">运动用品</a>
							<a href="http://sc.chinaz.com/jiaoben">户外</a>
						</p>
					</li>
				</ul>
			</div>
			<div class="cont" style="display:none;">3<br />3</div>
			<div class="cont" style="display:none;">4<br />3<br />4</div>
			<div class="cont" style="display:none;">5</div>
			<div class="cont" style="display:none;">6<br />3<br />3</div>
			<div class="cont" style="display:none;">7<br />3<br />3<br />3</div>
		</div>
		 -->
	</div>
</div>

<script type="text/javascript">
(function(){

	var time = null;
	var list = $("#navlist");
	var box = $("#navbox");
	var lista = list.find("a");
	
	for(var i=0,j=lista.length;i<j;i++){
		if(lista[i].className == "now"){
			var olda = i;
		}
	}
	
	var box_show = function(hei){
		box.stop().animate({
			height:hei,
			opacity:1
		},400);
	}
	
	var box_hide = function(){
		box.stop().animate({
			height:0,
			opacity:0
		},400);
	}
	
	lista.hover(function(){
		lista.removeClass("now");
		$(this).addClass("now");
		clearTimeout(time);
		var index = list.find("a").index($(this));
		box.find(".cont").hide().eq(index).show();
		var _height = box.find(".cont").eq(index).height()+54;
		box_show(_height)
	},function(){
		time = setTimeout(function(){	
			box.find(".cont").hide();
			box_hide();
		},50);
		lista.removeClass("now");
		lista.eq(olda).addClass("now");
	});
	
	box.find(".cont").hover(function(){
		var _index = box.find(".cont").index($(this));
		lista.removeClass("now");
		lista.eq(_index).addClass("now");
		clearTimeout(time);
		$(this).show();
		var _height = $(this).height()+54;
		box_show(_height);
	},function(){
		time = setTimeout(function(){		
			$(this).hide();
			box_hide();
		},50);
		lista.removeClass("now");
		lista.eq(olda).addClass("now");
	});

})();
</script>
    
   



<div id="info-flash">
    <div id="MainPromotionBanner">
                <div id="SlidePlayer">
                    <ul class="Slides">
                     <c:forEach var="news" items="${indexImgList}">
                        <li style=""><a href="web/newsdetail.htm?id=${news.id}" ><img src="<c:out value="web/images/upload/${news.previewImg}"/>"></a></li>
                     </c:forEach>
                    </ul>
                <ul class="SlideTriggers">
	                <li class="Current">1</li>
	                <li class="">2</li>
	                <li class="">3</li>
	                <li class="">4</li>
                </ul>
                </div>
                <script type="text/javascript">
              TB.widget.SimpleSlide.decoration('SlidePlayer', {eventType:'mouse', effect:'scroll'});
              </script>
            </div>
</div>
