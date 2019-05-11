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
<link rel='stylesheet' href='https://weilaiche.cc/wp-admin/load-styles.php?c=0&amp;dir=ltr&amp;load%5B%5D=dashicons,buttons,forms,l10n,login&amp;ver=4.7.53' type='text/css' media='all' />
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
<script type="text/javascript">
     var username,
     var user_pwd1,
     var user_pwd2;
     function judgeusername()
     {
     username=$("#username").val();
     user_pwd1=$("#user_pwd1").val();
     user_pwd2=$("#user_pwd2").val();
     $.ajax({
     type:"POST",
     url:"judgeuser.do",
     data:"date="+JSON.stringify(username),
     success:function(returnval)
     {
     alert(returnval);
     }
     
     })
     }
     function registersub()
     {
     if
     
     }
</script>	
	
	
		</head>
	<body class="login login-action-register wp-core-ui  locale-zh-cn">
		<div id="login">
		<h1><a href="https://weilaiche.cc" title="新媒体创作者服务平台" tabindex="-1">未来车平台</a></h1>
	<p class="message register">在未来车平台注册账号</p>
<form name="registerform" id="registerform"  novalidate="novalidate">
	<p>
		<label for="user_login">用户名<br />
		<input type="text" name="username" id="username" class="input" value="" size="20" placeholder="可使用英文、数字" onblur="judgeusername()"/></label>
	</p>
	<p>
		<label for="user_email">电子邮件<br />
		<input type="email" name="user_email" id="user_email" class="input" value="" size="25" placeholder="可使用QQ邮箱等" /></label>
	</p>
	   <script>
      var ajaxurl = "https://weilaiche.cc/wp-admin/admin-ajax.php", pic_no = "https://weilaiche.cc/wp-content/plugins/ludou-phone-register/img/no.png", captcha = "https://weilaiche.cc/wp-content/plugins/ludou-phone-register/captcha/captcha.php";
   </script>
   <script src="/static/jquery/3.2.1/jquery.min.js"></script>
   <script src="https://weilaiche.cc/wp-content/plugins/ludou-phone-register/check.js"></script>
   <p>
      <label for="user_pwd1">密码(至少6位)<br/>
         <input id="user_pwd1" class="input" type="password" size="25" value="" name="user_pass" />
      </label>
   </p>
   <p>
      <label for="user_pwd2">重复密码<br/>
         <input id="user_pwd2" class="input" type="password" size="25" value="" name="user_pass2" />
      </label>
   </p>
   <p>
      <label for="CAPTCHA">图片验证码 &nbsp;<span id="captchaErr" style="color:#ff5c57;font-size: 12px;"></span> <br/>
         <input id="CAPTCHA" style="width:150px;*float:left;" class="input" type="text" size="10" value="" name="captcha_code" autocomplete="off" />
         看不清？<a href="javascript:void(0)" onclick="document.getElementById('captcha_img').src = 'https://weilaiche.cc/wp-content/plugins/ludou-phone-register/captcha/captcha.php?' + Math.random();document.getElementById('CAPTCHA').focus();return false;">点击更换</a>
      </label>
   </p>
   <p>
      <label>
         <img id="captcha_img" src="https://weilaiche.cc/wp-content/plugins/ludou-phone-register/captcha/captcha.php" title="看不清?点击更换" alt="看不清?点击更换" onclick="document.getElementById('captcha_img').src = 'https://weilaiche.cc/wp-content/plugins/ludou-phone-register/captcha/captcha.php?' + Math.random();document.getElementById('CAPTCHA').focus();return false;" />
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

<p id="nav">
<a href="https://weilaiche.cc/wp-login.php">登录</a> |
<a href="https://weilaiche.cc/wp-login.php?action=lostpassword">忘记密码？</a>
</p>

	<p id="backtoblog"><a href="https://weilaiche.cc/">&larr; 返回到未来车平台</a></p>
	
	</div>

		<script type="text/javascript">
	try{document.getElementById('user_login').focus();}catch(e){}
	if(typeof wpOnload=='function')wpOnload();
	</script>
	
		<div class="clear"></div>
	</body>
	</html>
	