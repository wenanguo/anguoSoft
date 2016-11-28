var BD_BRIDGE_OPEN = 1;
var BD_BRIDGE_ROOT = "http://qiao.baidu.com/";
var BD_BRIDGE_RCV_ROOT = "http://rqiao.baidu.com/";
var BD_BRIDGE_DATA = {mainid : "120009336",siteid : "694572",SITE_ID : "d4c7e0ca6781f36edcc12d9a0c8b3359"};
var BD_BRIDGE_ICON_CONFIG = {
	background : {
		color : "",
		url   : "http://qiao.baidu.com/site//982/d4c7e0ca6781f36edcc12d9a0c8b3359/iconbg.jpg"
	},
	head : {
		url    : "http://qiao.baidu.com/res/iconhead/09.png",
		width  : 147,
		height : 70
	},
	button : {
		color : "#f7bd84",
		url   : "",
		text  : "#bd4b13"
	},
	flow     : 1,
	position : 2,
	special : "0"
};
var BD_BRIDGE_INVITE_CONFIG = {
	background : {
		color : "",
		url   : "http://qiao.baidu.com/res/invitebg/01.jpg"
	},
	head : {
		show : 1,
		size : 1,
		url  : "http://qiao.baidu.com/res/invitehead/01_big.jpg"
	},
	text   : "欢迎您，有什么可以帮助您的么？",
	button : "#f87a1a",
	mode   : 0,
	special : "0"
};
var BD_BRIDGE_INVITE = {
	invitetype   : 0,
	inviterepeat : 0,
	invitetime   : 30
};
var BD_BRIDGE_PIGEON_SOUL = {
	disableMess     : 0,
	messType        : 0,
	messFloatType   : 0,
	language        : 0,
	position        : 0,
	backgroundColor : "#6cadde",
	messItemName    : 1,
	messItemPhone   : 1,
	messItemAddress : 1,
	messItemEmail   : 0,
	extraMessItems  : [] 
};
if ((BD_BRIDGE_OPEN == 1) && (typeof window["BD_BRIDGE_LOADED"] == "undefined")) {
	window["BD_BRIDGE_LOADED"] = 1;
	var script = document.createElement("script");
    script.type="text/javascript";
    script.charset = "UTF-8";
    script.src = BD_BRIDGE_ROOT + "asset/js/bw.js?v=2363";
    document.getElementsByTagName("head")[0].appendChild(script);
}