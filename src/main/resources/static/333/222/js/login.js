$(function () {
    alert(1);
    //$("#txt_Search").focus();
})
function denglu(){
	
	if ($("#username").val()==""||$("#pwd").val()=="") {
		alert("账号密码不能为空！");
	}
	else{
		var parm={"username":$("#username").val(),"pwd":$("#pwd").val()};
		$.get("/denglu", parm,function (ret) {
	       alert(ret);
			if(ret=="1"){
	    	   window.location.href="./index.html";
	       }
	       else{
	    	   alert("账号密码错误！");
	       }
	    });
	}
}
