<!DOCTYPE html>
	<!--[if IE 8]>
		<html xmlns="http://www.w3.org/1999/xhtml" class="ie8" lang="zh-CN">
	<![endif]-->
	<!--[if !(IE 8) ]><!-->
		<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
	<!--<![endif]-->
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>未来车平台 &lsaquo; 注册表单</title>
	<meta name="generator" content="Custom Login v3.2.8" />
<link rel='dns-prefetch' href='//s.w.org' />
<link rel='stylesheet' href='./wp-admin/load-styles.php?c=0&amp;dir=ltr&amp;load%5B%5D=dashicons,buttons,forms,l10n,login&amp;ver=4.7.53' type='text/css' media='all' />
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
	background-image: url('https://imgs.weilaiche.cc/2018/11/bg-18-11.jpg');
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
	background-color: rgba(255,255,255,0.8);
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
	background-image: url('https://imgs.weilaiche.cc/2019/02/weilaiche-logo-843473-oJgaHk3v.png');
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
<!-- 自己写的注册代码 -->
<script type="text/javascript" src="static/jquery/3.2.1/jquery-1.8.3.js"></script>
<script type="text/javascript">
     var username;//text中的属性
     var user_pwd1;
     var user_pwd2;
     var user_email;
     var user_answer;
     var user_question;
     var div;//用户名的div块
     var divpass1;//密码
     var divpass2;//确认密码
     var divemail;//邮箱
     var divanswer;//问题答案
     var usernameb;
     var user_pwd1b;
     var user_pwd2b;
     var user_emailb;
     var user_answerb;
     //function uregistermessage(uname,upass,uemail,uquestion,uanswer)
     //{
     //this.uname=uname;
     //this.upass=upass;
     //this.uemail=uemail;
     //this.uquestion=uquestion;
     //this.uanswer=uanswer;
     //}
     function judgeusername()
     {
	     alert("aaa");
	     username=$("#username").val();
	    // alert(typeof(username));
	     //alert("username"+username);
	     user_pwd2=$("#user_pwd2").val();
	     //alert("user_pwd2"+user_pwd2);
	     $.ajax({
	     type:"POST",
	     url:"judgeuser.do",
	     data:"data="+username,
	     success:function(returnval)
	     {
	     //alert(returnval);
		     if("true"==returnval)
		     {
		     //alert("用户名已存在");
		     div=document.getElementById("content");
		     div.innerText="用户名已被占用";
		     div.style.color="red";
		     usernameb="false";
		     }
		     else
		     {
		     div=document.getElementById("content");
		     div.innerText="用户名未被占用";
		     div.style.color="green";
		     usernameb="true";
		     }
	     //alert("usernameb="+usernameb);
	     }
	     });
     }
     function judgepass1()
     {
      divpass1=document.getElementById("contentpass1");
      user_pwd1=$("#user_pwd1").val();
     // alert("user_pwd1"+user_pwd1);
      if(""==user_pwd1)
      {
      divpass1.innerText="密码不能为空";
      divpass1.style.color="red";
      user_pwd1b="false";
      }
      else
      {
	      if(user_pwd1.length<=6)
	      {
	      divpass1.innerText="密码至少大于6";
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
     // alert("user_pwd1b="+user_pwd1b);
      }
     function judgepass2()
     {
       //alert(divpass1.text());
      //alert(divpass1.innerText);
      divpass2=document.getElementById("contentpass2");
      user_pwd2=$("#user_pwd2").val();
      //alert("user_pwd2=="+user_pwd2);
      if(""==user_pwd2)
      {
      divpass2.innerText="密码不能为空";
      divpass2.style.color="red";
      user_pwd2b="false";
      }
      else
      {
	    if(user_pwd1b=="true")
	    {
		      if(user_pwd1==user_pwd2)
		      {
		      divpass2.innerText="匹配成功";
		      divpass2.style.color="green";
		      user_pwd2b="true";
		      }
		      else
		      {
		      divpass2.innerText="输入的两次密码不一致";
		      divpass2.style.color="red";
		      user_pwd2b="false";
		      }
	    }
	   else
	    {
		      if(user_pwd1==user_pwd2)
			  {
		      divpass2.innerText="密码至少大于6";
		      divpass2.style.color="red";
		      user_pwd2b="true";
	          }
		     else
		      {
		      divpass2.innerText="两次输入的密码不一致";
		      divpass2.style.color="red";
		      user_pwd2b="true";
	   	      }
        }
     }
     }
     function judgeemail()
     {
     divemail=document.getElementById("contentemail");
     useremail=$("#user_email").val();
     //alert("useremail"+useremail);
     $.ajax({
     type:"POST",
     url:"judgeuseremail.do",
     data:"data="+useremail,
     success:function(returnval)
     {
     //alert(returnval);
	     if("true"==returnval)
	     {
	      divemail.innerText="邮箱正确";
	      divemail.style.color="green";
	      useremailb="true";
	     }
	     else
	     {
		     if(""==useremail)
		     {
		     divemail.innerText="输入的邮箱不能为空";
		     divemail.style.color="red";
		     useremailb="false";
		     }
		     else
		     {
		     divemail.innerText="输入的邮箱格式有误";
		     divemail.style.color="red";
		     useremailb="false";
	     	 }
	     }
     }
    });
  }
     function changeImage1()
     {
     //location.reload();
			//使用每次带不同的参数来重新请求图片的servlet
			//页面不会刷新，客户体验感更好
			//obj.src = "img?date="+new Date().getTime();
			//alert($("#captcha_img"));
			var a=document.getElementById("captcha_img");
			//alert($("img").src);
			//$("img").src="image.do?data="+new Date().getTime();
			 a.src="image.do?data="+new Date().getTime()+"aaas";
		//	alert(typeof(new String(new Date().getTime())));
			alert(JSON.stringify(typeof(new String(new Date().getTime()))));
				     
     }
     
     function registersub()
     {
      alert("aaa");
      user_question=document.getElementById("userquestion").value;
      alert("question=="+user_question);
      user_answer=document.getElementById("user_answer").value;
      if(user_answer=="")
      {
      divanswer=document.getElementById("contentanswer");
      divanswer.innerText="答案不能为空";
      divanswer.style.color="red";
      }
      else
      {
          divanswer.style.color="green";
	      if(usernameb=="true"&&user_pwd1b=="true"&&user_pwd2b=="true"&&useremailb=="true")
	      {
	      alert(uname);
	      uregistermessage uu=new uregistermessage(username,user_pwd1,user_email,user_question,user_answer)
	      alert("uu=="+typeof(uu));
	      alert(JSON.stringify(uu));
	      //$.ajax({
	      //type:"POST",
	      //url:"getregistermessage.do";
	      //data:"data="+uu;
	      
	     // });
	      }
      }
     }
     
</script>	
	
	
		</head>
	<body class="login login-action-register wp-core-ui  locale-zh-cn">
		<div id="login">
		<h1><a href="." title="新媒体创作者服务平台" tabindex="-1">未来车平台</a></h1>
	<p class="message register">在未来车平台注册账号</p>
<form name="registerform" id="registerform"  novalidate="novalidate">
	<p>
		<label for="user_login">用户名<br />
		<input type="text" name="username" id="username" class="input" value="" size="20" placeholder="可使用英文、数字" onblur="judgeusername()"/><div id="content" style="display:inline"></div></label>
	</p>
	<p>
		<label for="user_email">电子邮件<br />
		<input type="email" name="user_email" id="user_email" class="input" value="" size="25" placeholder="可使用QQ邮箱等" onblur="judgeemail()"/><div id="contentemail" style="display:inline"></div></label>
	</p>
	   <script>
      var ajaxurl = "./wp-admin/admin-ajax.php", pic_no = "./wp-content/plugins/ludou-phone-register/img/no.png", captcha = "./wp-content/plugins/ludou-phone-register/captcha/captcha.php";
   </script>
   <script src="./wp-content/plugins/ludou-phone-register/check.js"></script>
   <p>
      <label for="user_pwd1">密码(至少6位)<br/>
         <input id="user_pwd1" class="input"  type="password" size="25" value="" name="user_pass1" onblur="judgepass1()"/><div id="contentpass1" style="display:inline"></div>
      </label>
   </p>
   <p>
      <label for="user_pwd2">重复密码<br/>
         <input id="user_pwd2" class="input" type="password" size="25" value="" name="user_pass2" onblur="judgepass2()"/><div id="contentpass2" style="display:inline"></div>
      </label>
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
   <p>
      <label for="user_answer">回答问题：<br/>
         <input id="user_answer" class="input" type="text" size="25" value="" name="user_answer" /><div id="contentanswer" style="display:inline"></div>
      </label>
   </p>
   <p>
      <label for="CAPTCHA">图片验证码 &nbsp;<span id="captchaErr" style="color:#ff5c57;font-size: 12px;"></span> <br/>
         <input id="CAPTCHA" style="width:150px;*float:left;" class="input" type="text" size="10" value="" name="captcha_code" autocomplete="off" />
         看不清？
         <a href="javascript:changeImage1()">更换图片</a>
      </label>
   </p>
   <p>
      <label>
         <img id="captcha_img" src="image.do?data="+2019-12-23 />
      </label>
   </p>
   <p>
      <label for="phone">手机号 &nbsp;<span id="sendSmsBtnErr" style="color:#ff5c57;font-size: 12px;"></span> <br/>
         <input id="phone" class="input" type="text" size="15" value="" name="phone" autocomplete="off" />
      </label>
   </p>
   <p>
      <label for="code">短信验证码 &nbsp;<input id="sendSmsBtn" type="button" value="获取短信验证码" class="button button-secondary" />
         <input id="code" class="input" type="text" size="4" value="" name="code" />
      </label>
   </p>
   <input type="hidden" name="token" value="35b77c803a">
   	<p id="reg_passmail"></p>
	<br class="clear" />
	<input type="hidden" name="redirect_to" value="" />
	<p class="submit"><input type="button" name="clickregister" id="clickregister" class="button button-primary button-large" value="注册" onclick="registersub()"/></p>
</form>
<!--  <input type="button" value="点击更换图片" onclick="changeImage1()" />
      <a href="javascript:changeImage1()">更换图片</a>
 -->
<p id="nav">
<a href="./wp-login.php">登录</a> |
<a href="./wp-login.php?action=lostpassword">忘记密码？</a>
</p>

	<p id="backtoblog"><a href="./">&larr; 返回到未来车平台</a></p>
	
	</div>

		<script type="text/javascript">
	try{document.getElementById('user_login').focus();}catch(e){}
	if(typeof wpOnload=='function')wpOnload();
	</script>
	
		<div class="clear"></div>
	</body>
	</html>
	