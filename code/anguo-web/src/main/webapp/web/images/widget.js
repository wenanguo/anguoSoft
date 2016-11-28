function JSONscriptRequest(fullUrl) {

    this.fullUrl = fullUrl; 
    this.headLoc = document.getElementsByTagName("head").item(0);
    this.scriptId = 'JscriptId' + JSONscriptRequest.scriptCounter++;
}


JSONscriptRequest.scriptCounter = 1;

JSONscriptRequest.prototype.buildScriptTag = function () {


    this.scriptObj = document.createElement("script");
    
   
    this.scriptObj.setAttribute("type", "text/javascript");
    this.scriptObj.setAttribute("charset", "utf-8");
    this.scriptObj.setAttribute("src", this.fullUrl);
    this.scriptObj.setAttribute("id", this.scriptId);
}
 
JSONscriptRequest.prototype.addScriptTag = function () {

    this.headLoc.appendChild(this.scriptObj);
}

function start(){
	

	var req  = 'http://v.t.qq.com/cgi-bin/check_follow?jsonp=returnJS&name='+tencent_wb_name+'&sign='+tencent_wb_sign; 
	

	bObj = new JSONscriptRequest(req); 
	bObj.buildScriptTag(); 
	bObj.addScriptTag();
	var fileref=document.createElement("link")
  	fileref.setAttribute("rel", "stylesheet")
  	fileref.setAttribute("type", "text/css")
 	fileref.setAttribute("href", "http://v.t.qq.com/follow/css/w.css")
 	document.getElementsByTagName("head")[0].appendChild(fileref)
}

window.onload=function(){
start();
}
	start();

function post_to_url(path, params, method) {
        method = method || "post";

        var form = document.createElement("form");
		if(navigator.appName == "Microsoft Internet Explorer"){
			var ifm = document.createElement('<iframe name="tencent_pForm" style="display:none"/>');
		}else{
			var ifm = document.createElement("iframe");
			ifm.setAttribute("name","tencent_pForm");
			ifm.setAttribute("style","display:none");
		}
		
        form._submit_function_ = form.submit;

        form.setAttribute("method", method);
        form.setAttribute("action", path);
		form.setAttribute("target","tencent_pForm")

        for(var key in params) {
            var hiddenField = document.createElement("input");
            hiddenField.setAttribute("type", "hidden");
            hiddenField.setAttribute("name", key);
            hiddenField.setAttribute("value", params[key]);

            form.appendChild(hiddenField);
        }
		document.body.appendChild(ifm);
        document.body.appendChild(form);
        form._submit_function_(); 
    }


var d = document.getElementById("txWB_W1");

function returnJS(jsonData) {     
  
	var d = document.getElementById("txWB_W1");
	var isidol = jsonData.info.isidol;
	var islogin = jsonData.info.islogin;
	var isreg = jsonData.info.isreg; 
	var isself = jsonData.info.isself;
	var isvip = jsonData.info.isvip;
	var nick = jsonData.info.nick;
	var url = jsonData.info.url;

	if(url == ""){
		url = "http://v.t.qq.com/follow/images/default.png"
	}else{
		url = url + "/50";
	}
	

	if(isidol==1){
		//followed
			
		switch(tencent_wb_style.toString()){
			
		case "1":
			d.innerHTML = '<div><div id="txWb-side-a"></div><div id="txWb_middle"><div id="txWb_main"><img src="'+url+'" id="txWb-header"></img><img src="http://v.t.qq.com/follow/images/wblogo.png" id="txWb_logo"></img><span id="txWb_name"> <b>'+nick+'</b> </span>'+checkVip(isvip)+'<div class="txWb-foBtn"><img src="http://v.t.qq.com/follow/images/foed.png"></img></div></div></div><div id="txWb-side-b"></div></div>';
			break;
		case "2":
			d.innerHTML = "<img src='http://v.t.qq.com/follow/images/fd.png'></img>";
			break;
		case "3":
			d.innerHTML = "<img src='http://v.t.qq.com/follow/images/logo.png' style='vertical-align:middle'></img><span><b>"+ nick+"</b></span> 已收听!";
			break;
		default:
			d.innerHTML = "<img src='http://v.t.qq.com/follow/images/fd.png'></img>";
			break;
		}

	}else{

		switch(tencent_wb_style.toString()){
		case "1":
			d.innerHTML = '<div><div id="txWb-side-a"></div><div id="txWb_middle"><div id="txWb_main"><img src="'+url+'" id="txWb-header"></img><img src="http://v.t.qq.com/follow/images/wblogo.png" id="txWb_logo"></img><span id="txWb_name"> <b>'+nick+'</b> </span>'+checkVip(isvip)+'<div class="txWb-foBtn"><img src="http://v.t.qq.com/follow/images/follow.png" id="tx_foBtn"></img></div></div></div><div id="txWb-side-b"></div></div>';
			break;
		case "2":
			d.innerHTML = "<img src='http://v.t.qq.com/follow/images/gofo.png' id='tx_foBtn'></img>";
			break;
		case "3":
			d.innerHTML = "<img src='http://v.t.qq.com/follow/images/logo.png' style='vertical-align:middle'></img><span><b>"+ nick+"</b></span> <a href='#' id='tx_foBtn'>立即收听</a>";
			break;
		default:
			d.innerHTML = "<img src='http://v.t.qq.com/follow/images/gofo.png' id='tx_foBtn'></img>";
			break;
		
		}
		
		var el = document.getElementById('tx_foBtn');
		
		
		if(islogin==1){
			//logined 

			if(isreg==1){
				//reg

				if(isself==1){
					//self
				
					el.onclick = showPopup;
					
				}else{
					//not self
					el.onclick = submitForm;

				}
			}else{
				//new user
				el.onclick = newUser;

			}
		}else{

			//login
			el.onclick = loginInto;
		}


	}
   
  }


function checkVip(v){

	if(v==1){
	 return '<img src="http://v.t.qq.com/follow/images/vip.png" id="txWb_vip"></img>'
	}else{
	return '';
	}

}

function showPopup() {
	alert("不能收听自己哦.")
}

function newUser() {
	alert("您还未开通腾讯微博，请先注册。")
	window.open("http://t.qq.com/reg/index.php");
}

function loginInto() {
	//alert("您未登录腾讯微博，请先登录")
	window.open("http://t.qq.com/"+tencent_wb_name);
}

function submitForm() {
	//post_to_url("http://v.t.qq.com/cgi-bin/follow", { name: tencent_wb_name ,sign:tencent_wb_sign});
	window.open("http://t.qq.com/"+tencent_wb_name);

}