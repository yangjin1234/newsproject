<%@page import="pojo.impl.Userinformation"%>
<%@page import="dao.impl.UserDaoImpl"%>
<%@page import="dao.UserDao"%>
<%@page import="pojo.impl.SalaryTableImpl"%>
<%@page import="dao.impl.LoginDaoImpl"%>
<%@page import="dao.LoginDao"%>
<%@page import="dao.impl.UserinformationDaoImpl"%>
<%@page import="dao.UserinformationDao"%>
<%@page import="pojo.Login"%>
<%@page import="pojo.impl.LoginImpl"%>
<%@page import="pojo.News"%>
<%@page import="pojo.SalaryTable"%>
<%@page import="dao.impl.UserSalaryImpl"%>
<%@page import="dao.UserSalaryDao"%>
<%@page import="db.DBHelper"%>
<%@page import="java.sql.Connection"%>
<%@page import="util.MyLog"%>
<%@page import="dao.impl.NewsDaoImpl"%>
<%@page import="dao.NewsDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<!--[if IE 8]>
<html xmlns="http://www.w3.org/1999/xhtml" class="ie8 wp-toolbar"  lang="zh-CN">
<![endif]-->
<!--[if !(IE 8) ]><!-->
<html xmlns="http://www.w3.org/1999/xhtml" class="wp-toolbar"  lang="zh-CN">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>管理员 管理 用户 &lsaquo; 新媒体平台 &#8212; WordPress</title>
<script type="text/javascript" src="static/jquery/3.2.1/jquery-1.8.3.js"></script>
<script type="text/javascript">
 var selectdelete; //得到文本框选中的内容
 var datavalue; //得到选中checkbox的值
 var checkboxb;//checkbox
 var boxname;//得到checkbox的name
 var flag;
 var alldatavalue="";//得到所有选中checkbox的值,拼接为字符串
 function oncheckbox()
 {
 	boxname=document.getElementsByName("checkboxname");
 	for(var i=0;i<boxname.length;i++)
 	{
	 	if(boxname[i].checked)
	 	{
	 	datavalue=boxname[i].value+",";
	 	//alert("if=="+alldatavalue.indexOf(boxname[i].value,0));
		 	if(alldatavalue.indexOf(boxname[i].value, 0)==-1)
		 	{
		 	alldatavalue+=datavalue;
		 	}
	 	
	 	}
	 	else
	 	{
		 	if(alldatavalue.indexOf(boxname[i].value, 0)!=-1)
			{
			alldatavalue=alldatavalue.replace(boxname[i].value+",","");
			}
		}
 	}
 } 
 
 function deletenews(sh)
  	 {
  	          var show=sh;
  	          selectdelete=document.getElementById("textvalue").value;
		      if(selectdelete=="删除")
		      {
		         if(""!=alldatavalue)
				   {
					    $.ajax({
					        type:"POST",
					        url:"deletenewsmessage.do",
					        data:"data="+alldatavalue,
					        success:function(returnval)
							     {
								     if("true"==returnval)
								     {							  	
								     alert("删除成功");	
								     window.location.href="profile.jsp?show="+show;
								     alert("更新成功");
								     } 
								     else
								     {
								     alert("删除失败");
								     }
							     }
					        	});
				     }
				     else
				     {
				     alert("请选择你要删除的数据");
				     }
			      }
			       else
			       {
			       alert("请选择文本框的类型");
			       }
  	 } 
  	 
  	  
	  	 function updatestate(ob)
	  	 {
	  	 alert("ob=="+ob);
	  	 var sid=ob;
	  	 alert("类型为："+typeof(sid));
	  	 $.ajax({
					        type:"POST",
					        url:"adminsalarystate.do",
					        data:"data="+sid,
					        success:function(returnval)
							     {
								     if("true"==returnval)
								     {							  	
								     alert("修改成功");	
								     window.location.href="adminprofile.jsp";
								     } 
								     else
								     {
								     alert("修改失败");
								     }
							     }
					        	});
	  	 
	  	 }
  	 
</script>

<script type="text/javascript">
addLoadEvent = function(func){if(typeof jQuery!="undefined")jQuery(document).ready(func);else if(typeof wpOnload!='function'){wpOnload=func;}else{var oldonload=wpOnload;wpOnload=function(){oldonload();func();}}};
var ajaxurl = '/wp-admin/admin-ajax.php',
	pagenow = 'profile_page_mycred_money-history',
	typenow = '',
	adminpage = 'profile_page_mycred_money-history',
	thousandsSeparator = ',',
	decimalPoint = '.',
	isRtl = 0;
</script>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<link rel='dns-prefetch' href='//s.w.org' />
<style type="text/css">
img.wp-smiley,
img.emoji {
	display: inline !important;
	border: none !important;
	box-shadow: none !important;
	height: 1em !important;
	width: 1em !important;
	margin: 0 .07em !important;
	vertical-align: -0.1em !important;
	background: none !important;
	padding: 0 !important;
}
</style>
<link rel='stylesheet' href='https://weilaiche.cc/wp-admin/load-styles.php?c=0&amp;dir=ltr&amp;load%5B%5D=dashicons,admin-bar,common,forms,admin-menu,dashboard,list-tables,edit,revisions,media,themes,about,nav-menus,widgets,site-icon,&amp;load%5B%5D=l10n,buttons,wp-auth-check,wp-color-picker&amp;ver=4.7.53' type='text/css' media='all' />
<!--[if lte IE 7]>
<link rel='stylesheet' id='ie-css'  href='https://weilaiche.cc/wp-admin/css/ie.min.css?ver=4.7.53' type='text/css' media='all' />
<![endif]-->
<link rel='stylesheet' id='pods-styles-css'  href='https://weilaiche.cc/wp-content/plugins/pods/ui/styles/dist/pods.css?ver=2.7.1' type='text/css' media='all' />
		<script type="text/javascript">
			window._wpemojiSettings = {"baseUrl":"https:\/\/s.w.org\/images\/core\/emoji\/2.2.1\/72x72\/","ext":".png","svgUrl":"https:\/\/s.w.org\/images\/core\/emoji\/2.2.1\/svg\/","svgExt":".svg","source":{"concatemoji":"https:\/\/weilaiche.cc\/wp-includes\/js\/wp-emoji-release.min.js?ver=4.7.53"}};
			!function(a,b,c){function d(a){var b,c,d,e,f=String.fromCharCode;if(!k||!k.fillText)return!1;switch(k.clearRect(0,0,j.width,j.height),k.textBaseline="top",k.font="600 32px Arial",a){case"flag":return k.fillText(f(55356,56826,55356,56819),0,0),!(j.toDataURL().length<3e3)&&(k.clearRect(0,0,j.width,j.height),k.fillText(f(55356,57331,65039,8205,55356,57096),0,0),b=j.toDataURL(),k.clearRect(0,0,j.width,j.height),k.fillText(f(55356,57331,55356,57096),0,0),c=j.toDataURL(),b!==c);case"emoji4":return k.fillText(f(55357,56425,55356,57341,8205,55357,56507),0,0),d=j.toDataURL(),k.clearRect(0,0,j.width,j.height),k.fillText(f(55357,56425,55356,57341,55357,56507),0,0),e=j.toDataURL(),d!==e}return!1}function e(a){var c=b.createElement("script");c.src=a,c.defer=c.type="text/javascript",b.getElementsByTagName("head")[0].appendChild(c)}var f,g,h,i,j=b.createElement("canvas"),k=j.getContext&&j.getContext("2d");for(i=Array("flag","emoji4"),c.supports={everything:!0,everythingExceptFlag:!0},h=0;h<i.length;h++)c.supports[i[h]]=d(i[h]),c.supports.everything=c.supports.everything&&c.supports[i[h]],"flag"!==i[h]&&(c.supports.everythingExceptFlag=c.supports.everythingExceptFlag&&c.supports[i[h]]);c.supports.everythingExceptFlag=c.supports.everythingExceptFlag&&!c.supports.flag,c.DOMReady=!1,c.readyCallback=function(){c.DOMReady=!0},c.supports.everything||(g=function(){c.readyCallback()},b.addEventListener?(b.addEventListener("DOMContentLoaded",g,!1),a.addEventListener("load",g,!1)):(a.attachEvent("onload",g),b.attachEvent("onreadystatechange",function(){"complete"===b.readyState&&c.readyCallback()})),f=c.source||{},f.concatemoji?e(f.concatemoji):f.wpemoji&&f.twemoji&&(e(f.twemoji),e(f.wpemoji)))}(window,document,window._wpemojiSettings);
		</script>
		
<script type='text/javascript'>
/* <![CDATA[ */
var userSettings = {"url":"\/","uid":"811","time":"1558160588","secure":"1"};/* ]]> */
</script>
<script type='text/javascript' src='https://weilaiche.cc/wp-admin/load-scripts.php?c=0&amp;load%5B%5D=jquery-core,jquery-migrate,utils&amp;ver=4.7.53'></script>
	<link id="wp-admin-canonical" rel="canonical" href="https://weilaiche.cc/wp-admin/profile.php?page=mycred_money-history" />
	<script>
		if ( window.history.replaceState ) {
			window.history.replaceState( null, null, document.getElementById( 'wp-admin-canonical' ).href + window.location.hash );
		}
	</script>
<script type="text/javascript">var _wpColorScheme = {"icons":{"base":"#82878c","focus":"#00a0d2","current":"#fff"}};</script>
<style type="text/css" media="print">#wpadminbar { display:none; }</style>
</head>
<body class="wp-admin wp-core-ui no-js  profile_page_mycred_money-history folded auto-fold admin-bar branch-4-7 version-4-7-53 admin-color-fresh locale-zh-cn no-customize-support no-svg">
<script type="text/javascript">
	document.body.className = document.body.className.replace('no-js','js');
</script>
<script type="text/javascript">
jQuery(function($) {
	$( '.toggle-exporter' ).click(function(){
		$( '#export-log-history' ).toggle();
	});
});
</script><script type="text/javascript">
jQuery(function($) {
	$( '.toggle-exporter' ).click(function(){
		$( '#export-log-history' ).toggle();
	});
});
</script>

<div id="wpwrap">

<div id="adminmenumain" role="navigation" aria-label="主页">
<a href="#wpbody-content" class="screen-reader-shortcut">跳至主内容</a>
<a href="#wp-toolbar" class="screen-reader-shortcut">跳至工具栏</a>
<div id="adminmenuback"></div>
<div id="adminmenuwrap">
<ul id="adminmenu">


	<li class="wp-first-item wp-not-current-submenu menu-top menu-top-first menu-icon-dashboard menu-top-last" id="menu-dashboard">
	<a href='index.php' class="wp-first-item wp-not-current-submenu menu-top menu-top-first menu-icon-dashboard menu-top-last" ><div class="wp-menu-arrow"><div></div></div><div class='wp-menu-image dashicons-before dashicons-dashboard'><br /></div><div class='wp-menu-name'>仪表盘</div></a></li>
	<li class="wp-not-current-submenu wp-menu-separator" aria-hidden="true"><div class="separator"></div></li>
	<li class="wp-has-submenu wp-not-current-submenu menu-top menu-icon-post open-if-no-js menu-top-first menu-top-last" id="menu-posts">
	<a href='edit.php' class="wp-has-submenu wp-not-current-submenu menu-top menu-icon-post open-if-no-js menu-top-first menu-top-last" aria-haspopup="true"><div class="wp-menu-arrow"><div></div></div><div class='wp-menu-image dashicons-before dashicons-admin-post'><br /></div><div class='wp-menu-name'>文章</div></a>
	<ul class='wp-submenu wp-submenu-wrap'><li class='wp-submenu-head' aria-hidden='true'>文章</li><li class="wp-first-item"><a href='edit.php' class="wp-first-item">所有文章</a></li><li><a href='post-new.php'>写文章</a></li></ul></li>
	<li class="wp-not-current-submenu wp-menu-separator" aria-hidden="true"><div class="separator"></div></li>
	<li class="wp-has-submenu wp-has-current-submenu wp-menu-open menu-top menu-icon-users menu-top-first" id="menu-users">
	<a href='profile.php' class="wp-has-submenu wp-has-current-submenu wp-menu-open menu-top menu-icon-users menu-top-first" ><div class="wp-menu-arrow"><div></div></div><div class='wp-menu-image dashicons-before dashicons-admin-users'><br /></div><div class='wp-menu-name'>个人资料</div></a>
	<ul class='wp-submenu wp-submenu-wrap'><li class='wp-submenu-head' aria-hidden='true'>个人资料</li><li class="wp-first-item"><a href='profile.php' class="wp-first-item">我的个人资料</a></li><li><a href='profile.php?page=mycred_default-history'>经验 历史记录</a></li><li class="current"><a href='profile.php?page=mycred_money-history' class="current">金钱 历史记录</a></li><li><a href='profile.php?page=ludou-phone-menu'>修改手机号</a></li><li><a href='profile.php?page=shiming-renzheng'>实名认证</a></li></ul></li>
	<li class="wp-not-current-submenu menu-top menu-icon-tools menu-top-last" id="menu-tools">
	<a href='tools.php' class="wp-not-current-submenu menu-top menu-icon-tools menu-top-last" ><div class="wp-menu-arrow"><div></div></div><div class='wp-menu-image dashicons-before dashicons-admin-tools'><br /></div><div class='wp-menu-name'>工具</div></a></li><li id="collapse-menu" class="hide-if-no-js"><button type="button" id="collapse-button" aria-label="折叠主菜单" aria-expanded="true"><span class="collapse-button-icon" aria-hidden="true"></span><span class="collapse-button-label">收起菜单</span></button></li></ul>
</div>
</div>
<div id="wpcontent">

		<div id="wpadminbar" class="nojq nojs">
						<div class="quicklinks" id="wp-toolbar" role="navigation" aria-label="工具栏" tabindex="0">
				<ul id="wp-admin-bar-root-default" class="ab-top-menu">
		<li id="wp-admin-bar-menu-toggle"><a class="ab-item" href="#"><span class="ab-icon"></span><span class="screen-reader-text">菜单</span></a>		</li>
		<li id="wp-admin-bar-wp-logo" class="menupop"><a class="ab-item" aria-haspopup="true" href="https://weilaiche.cc/wp-admin/about.php"><span class="ab-icon"></span><span class="screen-reader-text">关于WordPress</span></a><div class="ab-sub-wrapper"><ul id="wp-admin-bar-wp-logo-default" class="ab-submenu">
		<li id="wp-admin-bar-about"><a class="ab-item" href="https://weilaiche.cc/wp-admin/about.php">关于WordPress</a>		</li></ul><ul id="wp-admin-bar-wp-logo-external" class="ab-sub-secondary ab-submenu">
		<li id="wp-admin-bar-wporg"><a class="ab-item" href="https://cn.wordpress.org/">WordPress.org</a>		</li>
		<li id="wp-admin-bar-documentation"><a class="ab-item" href="https://codex.wordpress.org/">文档</a>		</li>
		<li id="wp-admin-bar-support-forums"><a class="ab-item" href="http://zh-cn.forums.wordpress.org/">支持论坛</a>		</li>
		<li id="wp-admin-bar-feedback"><a class="ab-item" href="http://zh-cn.forums.wordpress.org/forum/suggestions">反馈</a>		</li></ul></div>		</li>
		<li id="wp-admin-bar-site-name" class="menupop"><a class="ab-item" aria-haspopup="true" href="https://weilaiche.cc/">未来车平台</a><div class="ab-sub-wrapper"><ul id="wp-admin-bar-site-name-default" class="ab-submenu">
		<li id="wp-admin-bar-view-site"><a class="ab-item" href="https://weilaiche.cc/">查看站点</a>		</li></ul></div>		</li>
		<li id="wp-admin-bar-comments"><a class="ab-item" href="https://weilaiche.cc/wp-admin/edit-comments.php"><span class="ab-icon"></span><span class="ab-label awaiting-mod pending-count count-0" aria-hidden="true">0</span><span class="screen-reader-text">0条评论待审</span></a>		</li>
		<li id="wp-admin-bar-new-content" class="menupop"><a class="ab-item" aria-haspopup="true" href="https://weilaiche.cc/wp-admin/post-new.php"><span class="ab-icon"></span><span class="ab-label">新建</span></a><div class="ab-sub-wrapper"><ul id="wp-admin-bar-new-content-default" class="ab-submenu">
		<li id="wp-admin-bar-new-post"><a class="ab-item" href="https://weilaiche.cc/wp-admin/post-new.php">文章</a>		</li></ul></div>		</li></ul><ul id="wp-admin-bar-top-secondary" class="ab-top-secondary ab-top-menu">
		<li id="wp-admin-bar-my-account" class="menupop with-avatar"><a class="ab-item" aria-haspopup="true" href="">嗨,${loginname}<img alt='' src='https://secure.gravatar.com/avatar/989d4d63bcd4bd0c59f6d2edd762ed80?s=26&#038;d=wavatar&#038;r=g' srcset='https://secure.gravatar.com/avatar/989d4d63bcd4bd0c59f6d2edd762ed80?s=52&amp;d=wavatar&amp;r=g 2x' class='avatar avatar-26 photo' height='26' width='26' /></a><div class="ab-sub-wrapper"><ul id="wp-admin-bar-user-actions" class="ab-submenu">
		<li id="wp-admin-bar-user-info"><a class="ab-item" tabindex="-1" href="https://weilaiche.cc/wp-admin/profile.php"><img alt='' src='https://secure.gravatar.com/avatar/989d4d63bcd4bd0c59f6d2edd762ed80?s=64&#038;d=wavatar&#038;r=g' srcset='https://secure.gravatar.com/avatar/989d4d63bcd4bd0c59f6d2edd762ed80?s=128&amp;d=wavatar&amp;r=g 2x' class='avatar avatar-64 photo' height='64' width='64' /><span class='display-name'>${loginname }</span></a>		</li>
		<li id="wp-admin-bar-edit-profile"><a class="ab-item" href="profile1.jsp">编辑我的个人资料</a>		</li>
		<li id="wp-admin-bar-logout"><a class="ab-item" href="login.jsp?action=logout&#038;_wpnonce=57ebb2a207">登出</a>		</li></ul><ul id="wp-admin-bar-my-account-default" class="ab-submenu">
		<li id="wp-admin-bar-mycred-account" class="menupop ab-sub-secondary"><div class="ab-item ab-empty-item" aria-haspopup="true">余额</div><div class="ab-sub-wrapper"><ul id="wp-admin-bar-mycred-account-default" class="ab-submenu">
		<li id="wp-admin-bar-mycred-account-balance-mycred-default"><div class="ab-item ab-empty-item">经验: 457 点</div>		</li>
		<li id="wp-admin-bar-mycred-account-history-mycred-default"><a class="ab-item" href="https://weilaiche.cc/wp-admin/users.php?page=mycred_default-history">经验 历史记录</a>		</li>
		<li id="wp-admin-bar-mycred-account-balance-mycred-money"><div class="ab-item ab-empty-item">金钱: ￥ 29 元</div>		</li>
		<li id="wp-admin-bar-mycred-account-history-mycred-money"><a class="ab-item" href="https://weilaiche.cc/wp-admin/users.php?page=mycred_money-history">金钱 历史记录</a>		</li></ul></div>		</li></ul></div>		</li></ul>			</div>
						<a class="screen-reader-shortcut" href="https://weilaiche.cc/wp-login.php?action=logout&#038;_wpnonce=57ebb2a207">登出</a>
					</div>

		
<div id="wpbody" role="main">

<div id="wpbody-content" aria-label="主内容" tabindex="0">
		<div id="screen-meta" class="metabox-prefs">

			<div id="contextual-help-wrap" class="hidden no-sidebar" tabindex="-1" aria-label="“上下文帮助”选项卡">
				<div id="contextual-help-back"></div>
				<div id="contextual-help-columns">
					<div class="contextual-help-tabs">
						<ul>
												</ul>
					</div>

					
					<div class="contextual-help-tabs-wrap">
											</div>
				</div>
			</div>
		<div id="screen-options-wrap" class="hidden" tabindex="-1" aria-label="“显示选项”选项卡">
<form id='adv-settings' method='post'>
		<fieldset class="screen-options">
		<legend>分页</legend>
							<label for="mycred_epp_mycred_money-history">条目</label>
				<input type="number" step="1" min="1" max="999" class="screen-per-page" name="wp_screen_options[value]"
					id="mycred_epp_mycred_money-history" maxlength="3"
					value="10" />
							<input type="hidden" name="wp_screen_options[option]" value="mycred_epp_mycred_money-history" />
		</fieldset>
		<p class="submit"><input type="submit" name="screen-options-apply" id="screen-options-apply" class="button button-primary" value="应用"  /></p>
<input type="hidden" id="screenoptionnonce" name="screenoptionnonce" value="1c8f9a0686" />
</form>
</div>		</div>
				<div id="screen-meta-links">
					<div id="screen-options-link-wrap" class="hide-if-no-js screen-meta-toggle">
			<button type="button" id="show-settings-link" class="button show-settings" aria-controls="screen-options-wrap" aria-expanded="false">显示选项</button>
			</div>
				</div>
		<div class="wrap" id="myCRED-wrap">
	<h1>管理员 管理 用户 </h1>

	<div style="display:none;" class="clear" id="export-log-history">
	<strong>出口:</strong>
	<div>
<a href="https://weilaiche.cc/wp-admin/admin.php?page=mycred_money-history&#038;mycred-action=export&#038;_token=a0e9c511dc&#038;set=user" class="btn btn-primary button button-secondary">Export History</a> 	</div>
	<p><span class="description">日志条目导出到CSV文件，根据所选条目的数量，这个过程可能需要几秒钟。</span></p>
</div>

   <%
    
    Connection conn=DBHelper.getConnection();
	UserDao user=new UserDaoImpl();
	List<Userinformation> list=new ArrayList<Userinformation>();
    String pn=request.getParameter("pageNo");
    String ps=request.getParameter("pageSize");
    int pageNo=0;
    int max=0;
    int pageSize=0;
    int n=0;
	    if(ps==null)
	    {
	   	    pageSize=15;
	    }
	    else
	    {
		    pageSize=Integer.parseInt(ps);
		    if(pageSize<1)
		    {
		    pageSize=15;       
		    }
		    if(pageSize>20)
		    {
		    pageSize=20;
		    }
		}
		//计算最大页码数
		
		max=user.getUserMaxPage(conn, pageSize);
		MyLog.log.debug("max11213=="+max);
		if(pn==null){
			//第一次进入页面
			pageNo = 1;
		}else{
			pageNo = Integer.parseInt(pn);
			//如果获得的页码大于最大页码
			if(pageNo>max){
				pageNo = max;
			}
			//如果获得的页码小于1
			if(pageNo<1){
				pageNo=1;
			}
		}
		
		
		//分页查询出每页的用户
		list = user.selectAllUser(conn, pageNo, pageSize);
		MyLog.log.debug("list1231=="+list.size());
		//得到用户数
	    n=user.selectUserCount(conn);
		MyLog.log.debug("n12313=="+n);
		pageContext.setAttribute("list", list);
		pageContext.setAttribute("pageNo", pageNo);
		pageContext.setAttribute("pageSize", pageSize);
		pageContext.setAttribute("max", max);
		pageContext.setAttribute("newscount", n);
		
		
	%>
	<form method="get" action="" name="mycred-mylog-form" novalidate>
		<input type="hidden" name="page" value="mycred_money-history" />
		<div class="tablenav top">

				<h2 class="screen-reader-text sr-only">Log entries navigation</h2>
			<div class="tablenav-pages">

<span class="displaying-num">${newscount } entries</span>
<span class='pagination-links'><span class="tablenav-pages-navspan" aria-hidden="true">&laquo;</span>
<a class='next-page' href="admin_manageuser.jsp?pageNo=${pageNo-1 }&pageSize=${pageSize } "><span class='screen-reader-text'>上一页</span><span aria-hidden="true">&lsaquo;</span></a>
<span class="paging-input">第<label for="current-page-selector" class="screen-reader-text">当前页</label><input class='current-page' id='current-page-selector' type='text' name='paged' value='${pageNo }' size='5' aria-describedby='table-paging' />页，共<span class='total-pages'>${max }</span>页</span>
<a class='next-page' href="admin_manageuser.jsp?pageNo=${pageNo+1 }&pageSize=${pageSize }"><span class='screen-reader-text'>下一页</span><span aria-hidden='true'>&rsaquo;</span></a>
<a class='last-page' href="admin_manageuser.jsp?pageNo=${max}&pageSize=${pageSize }"><span class='screen-reader-text'>尾页</span><span aria-hidden='true'>&raquo;</span></a></span>
			</div>
			<br class="clear" />
		</div>
		
			<table class="mycred-table wp-list-table widefat fixed striped users" cellspacing="0" cellspacing="0">
			<thead>
			<tr>
					<th scope="col" id="ref" class="manage-column column-ref">状态</th>
					<th scope="col" id="creds" class="manage-column column-creds">所有作者</th>
					<th scope="col" id="entry" class="manage-column column-entry"><label>标签</label></th>
					<th scope="col" id="entry" class="manage-column column-entry">&nbsp;&nbsp;&nbsp;&nbsp;删除/查看</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${list }" var="user">
			<tr height="50px;">
			<c:if test="${user.ustate eq 1 }">
		    <td class='5cb165b970a37 column-5cb165b970a37' data-colname="状态">未删除</td>
	    	</c:if>
	    	<c:if test="${user.ustate eq 0 }">
		    <td class='5cb165b970a37 column-5cb165b970a37' data-colname="状态">已删除</td>
	    	</c:if>
					<th  scope="col" class="manage-column column-ref">${user.uname }</th>
					<th scope="col" class="manage-column column-time">--</th>
					<th scope="col" class="manage-column column-creds"><input type="button" value="删除" onclick="deleteuser('${user.uid}')"/>&nbsp;&nbsp;<a href="showarticle.jsp?news=${user.uid }">查看</a></th>	
			</tr>
			</tbody>
			</c:forEach>
		   </table>
		<div class="tablenav bottom">
        <h2 class="screen-reader-text sr-only">Log entries navigation</h2>
	    <div class="tablenav-pages">

				<span class="displaying-num">${newscount } entries</span>
<span class='pagination-links'><span class="tablenav-pages-navspan" aria-hidden="true">&laquo;</span>
<a class='next-page' href="admin_profile.jsp?pageNo=${pageNo-1 }&pageSize=${pageSize }"><span class='screen-reader-text'>上一页</span><span aria-hidden="true">&lsaquo;</span></a>
<span class="screen-reader-text">当前页</span><span id="table-paging" class="paging-input">第${pageNo }页，共<span class='total-pages'>${max }</span>页</span>
<a class='nessxt-page' href="admin_profile.jsp?pageNo=${pageNo+1 }&pageSize=${pageSize }"><span class='screen-reader-text'>下一页</span><span aria-hidden='true'>&rsaquo;</span></a>
<a class='last-page' href="admin_profile.jsp?pageNo=${max}&pageSize=${pageSize }"><span class='screen-reader-text'>尾页</span><span aria-hidden='true'>&raquo;</span></a></span>
			</div>
			<br class="clear" />
			
		</div>

		
	</form>

	
</div>

<div class="clear"></div></div><!-- wpbody-content -->
<div class="clear"></div></div><!-- wpbody -->
<div class="clear"></div></div><!-- wpcontent -->

<div id="wpfooter" role="contentinfo">
		<p id="footer-left" class="alignleft">
		<span id="footer-thankyou">感谢使用<a href="https://cn.wordpress.org/">WordPress</a>进行创作。</span>	</p>
	<p id="footer-upgrade" class="alignright">
		4.7.53版本	</p>
	<div class="clear"></div>
</div>
	<div id="wp-auth-check-wrap" class="hidden">
		<div id="wp-auth-check-bg"></div>
		<div id="wp-auth-check">
			<button type="button" class="wp-auth-check-close button-link"><span class="screen-reader-text">关闭对话框</span></button>
							<div id="wp-auth-check-form" class="loading" data-src="https://weilaiche.cc/wp-login.php?interim-login=1"></div>
							<div class="wp-auth-fallback">
				<p><b class="wp-auth-fallback-expired" tabindex="0">会话已过期</b></p>
				<p><a href="https://weilaiche.cc/wp-login.php" target="_blank">请重新登录。</a>
					登录页会在新窗口中打开，在登录后您可关闭该窗口并返回本页。</p>
				</div>
			</div>
		</div>
		
<script type='text/javascript'>
/* <![CDATA[ */
var commonL10n = {"warnDelete":"\u60a8\u5c06\u6c38\u4e45\u5220\u9664\u8fd9\u4e9b\u9879\u76ee\u3002\n\u70b9\u51fb\u201c\u53d6\u6d88\u201d\u505c\u6b62\uff0c\u70b9\u51fb\u201c\u786e\u5b9a\u201d\u5220\u9664\u3002","dismiss":"\u5ffd\u7565\u6b64\u901a\u77e5\u3002","collapseMenu":"\u6298\u53e0\u4e3b\u83dc\u5355","expandMenu":"\u5c55\u5f00\u4e3b\u83dc\u5355"};var heartbeatSettings = {"nonce":"8106199cfa"};var authcheckL10n = {"beforeunload":"\u60a8\u7684\u767b\u5f55\u4f1a\u8bdd\u5df2\u8fc7\u671f\uff0c\u8bf7\u91cd\u65b0\u767b\u5f55\u3002","interval":"180"};var wpColorPickerL10n = {"clear":"\u6e05\u7a7a","defaultString":"\u9ed8\u8ba4","pick":"\u9009\u62e9\u989c\u8272","current":"\u5f53\u524d\u989c\u8272"};/* ]]> */
</script>
<script type='text/javascript' src='https://weilaiche.cc/wp-admin/load-scripts.php?c=0&amp;load%5B%5D=hoverIntent,common,admin-bar,svg-painter,heartbeat,wp-auth-check,jquery-ui-core,jquery-ui-widget,jquery-ui-mouse,jquery-ui-dragg&amp;load%5B%5D=able,jquery-ui-slider,jquery-touch-punch,iris,wp-color-picker&amp;ver=4.7.53'></script>
<script type='text/javascript' src='https://weilaiche.cc/wp-content/plugins/site-announcements/admin/js/cw-site-announcements-admin.js?ver=1.0.3'></script>

<div class="clear"></div></div><!-- wpwrap -->
<script type="text/javascript">if(typeof wpOnload=='function')wpOnload();</script>

</body>
</html>
