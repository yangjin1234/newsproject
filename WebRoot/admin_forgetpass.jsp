<!DOCTYPE html>
	<!--[if IE 8]>
		<html xmlns="http://www.w3.org/1999/xhtml" class="ie8" lang="zh-CN">
	<![endif]-->
	<!--[if !(IE 8) ]><!-->
		<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
	<!--<![endif]-->
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>未来车平台 &lsaquo; 修改密码</title>
			<script>if("sessionStorage" in window){try{for(var key in sessionStorage){if(key.indexOf("wp-autosave-")!=-1){sessionStorage.removeItem(key)}}}catch(e){}};</script>
		<meta name="generator" content="Custom Login v3.2.8" />
<link rel='dns-prefetch' href='//s.w.org' />
<link rel='stylesheet' href='./wp-admin/load-styles.php?c=0&amp;dir=ltr&amp;load%5B%5D=dashicons,buttons,forms,l10n,login&amp;ver=4.7.53' type='text/css' media='all' />
<script type="text/javascript"  src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	
	
	var user_answer;
	var username;
	var user_pwd1;
	var user_question;
	var div;//用户名的div块
    var divpass1;//密码
    var divanswer;
	var user_answerb;
	var usernameb;
	var user_questionb;
	function updatepass(username,user_question,user_answer,user_pwd1){
		this.username=username;
		this.user_question=user_question;
		this.user_answer=user_answer;
		this.user_pwd1=user_pwd1;
	}
	 function judgeusername()
     {
	     username=$("#username").val();
	    // alert(typeof(username));
	     //alert("管理员用户username"+username);
	     //alert("user_pwd2"+user_pwd2);
	     $.ajax({
	     type:"POST",
	     url:"adminjudgeuser.do",
	     data:"data="+username,
	     success:function(returnval)
	     {
	     //alert(returnval);
		     if("true"==returnval)
		     {
		     //alert("用户名已存在");
		     div=document.getElementById("content");
		     div.innerText="用户名存在";
		     div.style.color="green";
		     usernameb="true";
		     }
		     else
		     {
		     div=document.getElementById("content");
		     div.innerText="用户名不存在";
		     div.style.color="red";
		     usernameb="false";
		     }
	     //alert("usernameb="+usernameb);
	     }
	     });
     }
	 function judgeanswer()
  	 {
  	     user_answer=document.getElementById("user_answer").value;
		      if(user_answer=="")
		      {
		      divanswer=document.getElementById("contentanswer");
		      divanswer.innerText="答案不能为空";
		      divanswer.style.color="red";
		      user_answerb="false";
		      }
		      else
		      {
		      divanswer=document.getElementById("contentanswer");
		      divanswer.innerText="通过";
		      divanswer.style.color="green";
		      user_answerb="true";
		      }
  	 } 
	function judgepass1()
     {
	      divpass1=document.getElementById("contentpass1");
	      user_pwd1=$("#user_pwd1").val();
	     //alert("管理员用户密码user_pwd1"+user_pwd1);
	      if(""==user_pwd1)
	      {
	      divpass1.innerText="密码不能为空";
	      divpass1.style.color="red";
	      user_pwd1b="false";
	      }
	      else
	      {
		      if(user_pwd1.length<6)
		      {
		      divpass1.innerText="密码至少大于5";
		      divpass1.style.color="red";
		      user_pwd1b="false";
		      }
		      else
		      {
		      divpass1.innerText="设置密码格式正确";
		      divpass1.style.color="green";
		      user_pwd1b="true";
		      }
	      }
      }
	function ajaxInvoke(){
	//alert("ddjd");
	    user_question=document.getElementById("userquestion").value;
		if(usernameb=="true"&&user_pwd1b=="true"&&user_answerb=="true")
			   {
				    var uu=new updatepass(username,user_question,user_answer,user_pwd1);
			        //alert("uu=="+typeof(uu));
				    //alert(JSON.stringify(uu));
				    $.ajax({
				        type:"POST",
				        url:"adminupdatepass.do",
				        data:"data="+JSON.stringify(uu),
				        success:function(returnval)
						     { 
						         //alert("修改"+returnval);
							     if("true"==returnval)
							     {							  	
							     alert("修改密码成功");	
							     window.location.href="admin_login.jsp";	
							     }
							     else
							     {
							      alert("修改失败");
							      username="";
				                  user_question="";
				                  user_answer="";
				                  user_pwd1="";
				                 // alert("修改失败");
				                  window.location.href="admin_forgetpass.jsp";
							     }
						     }
				        	});
			     }
			       else
			       {
			       alert("请填写正确信息");
			       username="";
				   user_question="";
				   user_answer="";
				   user_pwd1="";
				   //alert("修改失败");
				   window.location.href="admin_forgetpass.jsp";
			       }
		     }
	</script>
<style type="text/css">

/**
 * Custom Login by Austin Passy
 *
 * Plugin URI  : https://frosty.media/plugins/custom-login/
 * Version     : 3.2.8
 * Author URI  : http://austin.passy.co/
 * Extensions  : https://frosty.media/plugin/tag/custom-login-extension/
 */

html {
	background-image: url('./2018/11/bg-18-11.jpg');
	background-position: center top;
	background-repeat: repeat-y;
	
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-ms-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	}
body.login {
	background: transparent;
	}
#login {
	width: 380px;
	}
#login form {
	background-color: rgba(255,255,255,0.7);
	
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	-ms-border-radius: 10px;
	-o-border-radius: 10px;
	border-radius: 10px;
	
	-webkit-box-shadow: 5px 5px 10px #121212;
	-moz-box-shadow: 5px 5px 10px #121212;
	-ms-box-shadow: 5px 5px 10px #121212;
	-o-box-shadow: 5px 5px 10px #121212;
	box-shadow: 5px 5px 10px #121212;
	}
.login h1 a {
	width: 150px !important;
	height: 150px !important;
	background-image: url('./2019/02/weilaiche-logo-843473-oJgaHk3v.png');
	background-position: center top;
	background-repeat: no-repeat;
	
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-ms-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	}
.login label {
	color: #333333;
	}
.login #nav a, .login #backtoblog a {
	color: #ffffff !important;
	}
.login #nav a:hover, .login #backtoblog a:hover {
	color: #dd3333 !important;
	}

</style>
<meta name='robots' content='noindex,follow' />
	<meta name="viewport" content="width=device-width" />
		</head>
	<body class="login login-action-login wp-core-ui  locale-zh-cn">
		<div id="login">
		<h1><a href="." title="新媒体创作者服务平台" tabindex="-1">未来车平台</a></h1>
	<div id="login_error">	本平台仅对内部会员开放<br />
</div>

<form name="loginform" id="loginform" action="login.do" method="post">
	<p>
		<label for="user_login">用户名或电子邮件地址<br />
		<input type="text" name="username" id="username" aria-describedby="login_error" class="input" value="" size="20" onblur="judgeusername()"/><div id="content" style="display:inline"></div></label>
	</p>
	 <p>
      <label for="user_question">请选择问题：<br/>
      <select id="userquestion" style="width: 330px; height: 40px;">
      <option value="您高中所在的母校?" >您高中所在的母校?</option>
      <option value="您小学的校长是谁?">您小学的校长是谁?</option>
      <option value="您初中的班主任是谁?">您初中的班主任是谁?</option>
      </select>
      </label>
   </p>
   <br/>
   <p>
      <label for="user_answer">回答您的问题：<br/>
         <input id="user_answer" class="input" type="text" size="25" value="" name="user_answer" onblur="judgeanswer()" /><div id="contentanswer" style="display:inline"></div>
      </label>
   </p>
   <p>
		<label for="user_pass">请输入您的新密码<br />
		<input type="password" name="user_pwd1" id="user_pwd1" aria-describedby="login_error" class="input" value="" size="20" onblur="judgepass1()"/><div id="contentpass1" style="display:inline"></div></label>
	</p>
	<p class="submit">
		<input type="button" id="wp-submit" class="button button-primary button-large" onclick="ajaxInvoke()" value="确认" />
		<input type="hidden" name="redirect_to" value="./wp-admin/" />
		<input type="hidden" name="testcookie" value="1" />
	</p>
</form>

<p id="nav">
<a href="./admin_register.jsp">注册</a> | 	<a href="./admin_forgetpass">忘记密码？</a>
</p>

<script type="text/javascript">
function wp_attempt_focus(){
setTimeout( function(){ try{
d = document.getElementById('user_login');
d.focus();
d.select();
} catch(e){}
}, 200);
}

wp_attempt_focus();
if(typeof wpOnload=='function')wpOnload();
</script>

	<p id="backtoblog"><a href="./">&larr; 返回到未来车平台</a></p>
	
	</div>

	
		<div class="clear"></div>
	</body>
	</html>
	