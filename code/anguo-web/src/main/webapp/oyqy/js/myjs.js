function $$$(id){
	return document.getElementById(id);
}

function ifnull(value){
	if (value == null || value == undefined || value == '') 
		return true;
	else
		return false;
}
