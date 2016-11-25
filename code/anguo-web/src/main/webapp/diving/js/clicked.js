function $$(id) {
	return document.getElementById(id);
}

var count = 0;
var checkedimg = "<img src='img/checked.png' style='width: 100%;height: 100%;' />";
var timercount = 0;

window.onload = function init() {
	initall();
	start.begin();
}

function initall() {
	$$("btn_invitation").onclick = function() {

		var page11 = $$("page11");
		page11.style.display = "";

	}

	var page1 = $$("page1");
	var page2 = $$("page2");
	var page3 = $$("page3");
	var page4 = $$("page4");
	var page5 = $$("page5");
	var page6 = $$("page6");
	var page7 = $$("page7");
	var page8 = $$("page8");
	var page9 = $$("page9");
	var page10 = $$("page10");

	$$("btn_go").onclick = function() {
		//start.begin();
		$.ajax({
			url: '../oyqyInvitationcode/load.htm?openid=' + $("#openid").val(),
			data: {},
			cache: false,
			dataType: 'json',
			success: function(data) {
				if(data.code == 1601) 
				{
					page1.style.display = "none";
					page10.style.display = "";
					alert("您已参加过本次活动!");
					setcode(data.msg);
				}else{
					page1.style.display = "none";
					page2.style.display = "";
				}
			},
			error: function() {
				
			}
		});
		
		/*page1.style.display = "none";
		page2.style.display = "";*/
	}

	$$("p2_div_item1").onclick = function() {
		$$("p2_item_check1").innerHTML = checkedimg;
		setTimeout(function() {
			page2.style.display = "none";
			page3.style.display = "";
		}, 200);

	}
	$$("p2_div_item2").onclick = function() {
		count++; //第1题  答案B
		$$("p2_item_check2").innerHTML = checkedimg;
		setTimeout(function() {
			page2.style.display = "none";
			page3.style.display = "";
		}, 200);
	}

	$$("p3_div_item1").onclick = function() {
		$$("p3_item_check1").innerHTML = checkedimg;
		setTimeout(function() {
			page3.style.display = "none";
			page4.style.display = "";
		}, 200);
	}
	$$("p3_div_item2").onclick = function() {
		$$("p3_item_check2").innerHTML = checkedimg;
		setTimeout(function() {
			page3.style.display = "none";
			page4.style.display = "";
		}, 200);
	}
	$$("p3_div_item3").onclick = function() {
		//第2题  答案C
		count++;
		$$("p3_item_check3").innerHTML = checkedimg;
		setTimeout(function() {
			page3.style.display = "none";
			page4.style.display = "";
		}, 200);
	}

	$$("p4_div_item1").onclick = function() {
		count++; //第3题  答案A
		$$("p4_item_check1").innerHTML = checkedimg;
		setTimeout(function() {
			page4.style.display = "none";
			page5.style.display = "";
		}, 200);
	}
	$$("p4_div_item2").onclick = function() {
		$$("p4_item_check2").innerHTML = checkedimg;
		setTimeout(function() {
			page4.style.display = "none";
			page5.style.display = "";
		}, 200);
	}
	$$("p4_div_item3").onclick = function() {
		$$("p4_item_check3").innerHTML = checkedimg;
		setTimeout(function() {
			page4.style.display = "none";
			page5.style.display = "";
		}, 200);
	}

	$$("p5_div_item1").onclick = function() {
		count++; //第4题  答案A
		$$("p5_item_check1").innerHTML = checkedimg;
		setTimeout(function() {
			page5.style.display = "none";
			page6.style.display = "";
		}, 200);
	}
	$$("p5_div_item2").onclick = function() {
		$$("p5_item_check2").innerHTML = checkedimg;
		setTimeout(function() {
			page5.style.display = "none";
			page6.style.display = "";
		}, 200);
	}
	$$("p5_div_item3").onclick = function() {
		$$("p5_item_check3").innerHTML = checkedimg;
		setTimeout(function() {
			page5.style.display = "none";
			page6.style.display = "";
		}, 200);
	}

	$$("p6_div_item1").onclick = function() {
		$$("p6_item_check1").innerHTML = checkedimg;
		setTimeout(function() {
			getresult();
		}, 200);
	}
	$$("p6_div_item2").onclick = function() {
		count++; //第5题  答案B
		$$("p6_item_check2").innerHTML = checkedimg;
		setTimeout(function() {
			getresult();
		}, 200);
	}
	$$("p6_div_item3").onclick = function() {
		$$("p6_item_check3").innerHTML = checkedimg;
		setTimeout(function() {
			getresult();
		}, 200);
	}

	$$("page7_go").onclick = function() {
		page7.style.display = "none";
		setcode("");
	}
	$$("page8_go").onclick = function() {
		page8.style.display = "none";
		setcode("");
	}
	$$("page9_go").onclick = function() {
		page9.style.display = "none";
		setcode("");
	}
	
	//长按
	/*var evcode = $$("div-evcode");

	function touchStart(event) {
		alert("");
		timercount = 0;
		t1 = setInterval(getjs, 1000);
	}

	function touchEnd(event) {
		window.clearInterval(t1);
	}
	evcode.addEventListener("touchstart", touchStart, false);
	evcode.addEventListener("touchend", touchEnd, false);*/

	//initclick(4,3,1,page4,page5);
	
	
	//jqurey中实现长按
	var timeout ;  
	 $("#div-evcode").mousedown(function() {  
	     timeout = setTimeout(function() {  
	         window.location.replace("https://weidian.com/s/257773124?wfr=c");
	     }, 2000);  
	 });  
	    
	 $("#div-evcode").mouseup(function() {  
	     clearTimeout(timeout);   
	 });  
	   
	 $("#div-evcode").mouseout(function() {  
	     clearTimeout(timeout);  
	 });  

}

/*var t1;
function getjs() {
	console.log(timercount);
	timercount++;
	if (timercount >= 2) {
		window.clearInterval(t1);
		window.location.replace("https://weidian.com/s/257773124?wfr=c");
	}
}*/

function getresult() {
	page6.style.display = "none";
	if(count >= 4) {
		page7.style.display = "";
	} else if(count >= 2) {
		page8.style.display = "";
	} else {
		page9.style.display = "";
	}

}

//保存邀请码数据
function setcode(code){
	if(code==""){
		var scode = randomString(10);
		$$("incode").innerHTML=scode;
		
		$.ajax({
			url: '../oyqyInvitationcode/create.htm?openid=' + $("#openid").val()+'&invitationcode='+scode,
			data: {},
			cache: false,
			dataType: 'json',
			success: function(data) {
				page10.style.display = "";
			},
			error: function() {
				alert("数据保存异常!");
			}
		});
		
	}else{
		$$("incode").innerHTML=code;
	}
}


function randomString(len) {
　　len = len || 32;
　　var $chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678';    /****默认去掉了容易混淆的字符oOLl,9gq,Vv,Uu,I1****/
　　var maxPos = $chars.length;
　　var pwd = '';
　　for (i = 0; i < len; i++) {
　　　　pwd += $chars.charAt(Math.floor(Math.random() * maxPos));
　　}
　　return pwd;
}

//下面方法不能正常使用。
function initclick(pagecount, count, answer, hidepage, showpage) {
	for(var i = 1; i <= count; i++) {
		var a = "p" + pagecount + "_div_item" + i;
		//alert(a);
		$$(a).onclick = function() {
			count++;
			if(i = answer) {
				alert(i + "--" + answer);
				count++;
			}
			$$("p" + pagecount + "_item_check" + i).innerHTML = checkedimg;
			setTimeout(function() {
				hidepage.style.display = "none";
				showpage.style.display = "";
			}, 300);
		}
	}
}