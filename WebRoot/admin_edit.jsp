<!DOCTYPE html>
<!--[if IE 8]>
<%@page import="pojo.impl.LoginImpl"%>
<%@page import="dao.impl.LoginDaoImpl"%>
<%@page import="dao.LoginDao"%>
<%@page import="pojo.impl.NewsImpl"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="pojo.Login"%>
<%@page import="pojo.impl.TimeTypec"%>
<%@page import="pojo.impl.TypeImpl"%>
<%@page import="dao.impl.TypeDaoImpl"%>
<%@page import="dao.TypeDao"%>
<%@page import="util.MyLog"%>
<%@page import="pojo.News"%>
<%@page import="java.util.List"%>
<%@page import="db.DBHelper"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.impl.NewsDaoImpl"%>
<%@page import="dao.NewsDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" class="ie8 wp-toolbar"  lang="zh-CN">
<![endif]-->
<!--[if !(IE 8) ]><!-->
<%@page import="dao.impl.NewsDaoImpl"%>
<%@page import="dao.NewsDao"%>
<%@page import="pojo.impl.NewsImpl"%>
<%@page import="pojo.impl.TypeImpl"%>
<%@page import="java.util.List"%>
<%@page import="dao.impl.TypeDaoImpl"%>
<%@page import="db.DBHelper"%>
<%@page import="dao.TypeDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="util.MyLog"%>
<html xmlns="http://www.w3.org/1999/xhtml" class="wp-toolbar"  lang="zh-CN">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>文章 &lsaquo; 未来车平台 &#8212; WordPress</title>
<script type="text/javascript">
addLoadEvent = function(func){if(typeof jQuery!="undefined")jQuery(document).ready(func);else if(typeof wpOnload!='function'){wpOnload=func;}else{var oldonload=wpOnload;wpOnload=function(){oldonload();func();}}};
var ajaxurl = '/wp-admin/admin-ajax.php',
	pagenow = 'edit-post',
	typenow = 'post',
	adminpage = 'edit-php',
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
<link rel='stylesheet' id='poststates-css'  href='https://weilaiche.cc/wp-content/plugins/post-state-tags/css/poststates.css?ver=4.7.53' type='text/css' media='all' />
<style id='poststates-inline-css' type='text/css'>
/* Post Status Tags */
.post-state .states {
		font-size:10px;
		padding:3px 8px 3px 8px;
		-moz-border-radius:2px;
		-webkit-border-radius:2px;
		border-radius:2px;
		background:#999; /* default colors */
		color:#fff;
		white-space: nowrap;
}
/* Post Status Tags Icons */
.post-state .states .dashicons {
	width: inherit;
	height: inherit;
	font-size: inherit;
	vertical-align: -1px;
	margin-right:3px;
}

#the-list .status-publish th.check-column { border-left:4px solid #7ad03a; }
#the-list .status-publish th.check-column input { margin-left:4px; }
#the-list .status-publish th, #the-list .status-publish td { background-color:#f7fcf3; }
.post-state .publish {background:#7ad03a;color:#fff;}
#the-list .status-future th.check-column { border-left:4px solid #aaaaaa; }
#the-list .status-future th.check-column input { margin-left:4px; }
#the-list .status-future th, #the-list .status-future td { background-color:#f7f7f7; }
.post-state .scheduled {background:#aaaaaa;color:#fff;}
#the-list .status-draft th.check-column { border-left:4px solid #aaaaaa; }
#the-list .status-draft th.check-column input { margin-left:4px; }
#the-list .status-draft th, #the-list .status-draft td { background-color:#f7f7f7; }
.post-state .draft {background:#aaaaaa;color:#fff;}
#the-list .status-pending th.check-column { border-left:4px solid #ffba00; }
#the-list .status-pending th.check-column input { margin-left:4px; }
#the-list .status-pending th, #the-list .status-pending td { background-color:#fffbf0; }
.post-state .pending {background:#ffba00;color:#fff;}
#the-list .status-private th.check-column { border-left:4px solid #dd3333; }
#the-list .status-private th.check-column input { margin-left:4px; }
#the-list .status-private th, #the-list .status-private td { background-color:#fdf2f2; }
.post-state .private {background:#dd3333;color:#fff;}
.post-state .trash {background:;color:#fff;}
#the-list .post-password-required th.check-column { border-left:4px solid #d54e21; }
#the-list .post-password-required th.check-column input { margin-left:4px; }
#the-list .post-password-required th, #the-list .post-password-required td { background-color:#fdf5f2; }
.post-state .protected {background:#d54e21;color:#fff;}
.post-state .sticky {background:#9859b9;color:#fff;}
#the-list .status-page_on_front th.check-column { border-left:4px solid #000000; }
#the-list .status-page_on_front th.check-column input { margin-left:4px; }
#the-list .status-page_on_front th, #the-list .status-page_on_front td { background-color:#f7f7f7; }
.post-state .page_on_front {background:#000000;color:#fff;}
#the-list .status-page_for_posts th.check-column { border-left:4px solid #000000; }
#the-list .status-page_for_posts th.check-column input { margin-left:4px; }
#the-list .status-page_for_posts th, #the-list .status-page_for_posts td { background-color:#f7f7f7; }
.post-state .page_for_posts {background:#000000;color:#fff;}

</style>
<link rel='stylesheet' id='acp-sorting-css'  href='https://weilaiche.cc/wp-content/plugins/admin-columns-pro/classes/Sorting/assets/css/table.css?ver=4.3.8' type='text/css' media='all' />
<link rel='stylesheet' id='jquery-qtip2-css'  href='https://weilaiche.cc/wp-content/plugins/admin-columns-pro/admin-columns/external/qtip2/jquery.qtip.min.css?ver=3.2.7' type='text/css' media='all' />
<link rel='stylesheet' id='ac-table-css'  href='https://weilaiche.cc/wp-content/plugins/admin-columns-pro/admin-columns/assets/css/table.css?ver=3.2.7' type='text/css' media='all' />
<link rel='stylesheet' id='ac-table-screen-option-css'  href='https://weilaiche.cc/wp-content/plugins/admin-columns-pro/assets/css/table-screen-options.css?ver=4.3.8' type='text/css' media='all' />
<link rel='stylesheet' id='acp-layouts-css'  href='https://weilaiche.cc/wp-content/plugins/admin-columns-pro/assets/css/layouts-listings-screen.css?ver=4.3.8' type='text/css' media='all' />
<link rel='stylesheet' id='acp-table-css'  href='https://weilaiche.cc/wp-content/plugins/admin-columns-pro/assets/css/table.css?ver=3.2.7' type='text/css' media='all' />
<link rel='stylesheet' id='acp-filtering-table-css'  href='https://weilaiche.cc/wp-content/plugins/admin-columns-pro/classes/Filtering/assets/css/table.css?ver=4.3.8' type='text/css' media='all' />
<link rel='stylesheet' id='acp-export-listscreen-css'  href='https://weilaiche.cc/wp-content/plugins/admin-columns-pro/classes/Export/assets/css/listscreen.css?ver=4.3.8' type='text/css' media='all' />
<link rel='stylesheet' id='pods-styles-css'  href='https://weilaiche.cc/wp-content/plugins/pods/ui/styles/dist/pods.css?ver=2.7.1' type='text/css' media='all' />
<script type="text/javascript" src="static/jquery/3.2.1/jquery-1.8.3.js"></script>
		<script type="text/javascript">
			window._wpemojiSettings = {"baseUrl":"https:\/\/s.w.org\/images\/core\/emoji\/2.2.1\/72x72\/","ext":".png","svgUrl":"https:\/\/s.w.org\/images\/core\/emoji\/2.2.1\/svg\/","svgExt":".svg","source":{"concatemoji":"https:\/\/weilaiche.cc\/wp-includes\/js\/wp-emoji-release.min.js?ver=4.7.53"}};
			!function(a,b,c){function d(a){var b,c,d,e,f=String.fromCharCode;if(!k||!k.fillText)return!1;switch(k.clearRect(0,0,j.width,j.height),k.textBaseline="top",k.font="600 32px Arial",a){case"flag":return k.fillText(f(55356,56826,55356,56819),0,0),!(j.toDataURL().length<3e3)&&(k.clearRect(0,0,j.width,j.height),k.fillText(f(55356,57331,65039,8205,55356,57096),0,0),b=j.toDataURL(),k.clearRect(0,0,j.width,j.height),k.fillText(f(55356,57331,55356,57096),0,0),c=j.toDataURL(),b!==c);case"emoji4":return k.fillText(f(55357,56425,55356,57341,8205,55357,56507),0,0),d=j.toDataURL(),k.clearRect(0,0,j.width,j.height),k.fillText(f(55357,56425,55356,57341,55357,56507),0,0),e=j.toDataURL(),d!==e}return!1}function e(a){var c=b.createElement("script");c.src=a,c.defer=c.type="text/javascript",b.getElementsByTagName("head")[0].appendChild(c)}var f,g,h,i,j=b.createElement("canvas"),k=j.getContext&&j.getContext("2d");for(i=Array("flag","emoji4"),c.supports={everything:!0,everythingExceptFlag:!0},h=0;h<i.length;h++)c.supports[i[h]]=d(i[h]),c.supports.everything=c.supports.everything&&c.supports[i[h]],"flag"!==i[h]&&(c.supports.everythingExceptFlag=c.supports.everythingExceptFlag&&c.supports[i[h]]);c.supports.everythingExceptFlag=c.supports.everythingExceptFlag&&!c.supports.flag,c.DOMReady=!1,c.readyCallback=function(){c.DOMReady=!0},c.supports.everything||(g=function(){c.readyCallback()},b.addEventListener?(b.addEventListener("DOMContentLoaded",g,!1),a.addEventListener("load",g,!1)):(a.attachEvent("onload",g),b.attachEvent("onreadystatechange",function(){"complete"===b.readyState&&c.readyCallback()})),f=c.source||{},f.concatemoji?e(f.concatemoji):f.wpemoji&&f.twemoji&&(e(f.twemoji),e(f.wpemoji)))}(window,document,window._wpemojiSettings);
		</script>
		<script type='text/javascript'>
/* <![CDATA[ */
var AC = {"list_screen":"post","layout":null,"column_types":{"5cb165b970a37":"column-status","title":"title","5cb168afcc30c":"column-author_name","categories":"categories","tags":"tags","date":"date"},"ajax_nonce":"1f607bb6a7","table_id":"#the-list","screen":"edit-post"};
/* ]]> */
</script>

<script type='text/javascript'>
/* <![CDATA[ */
var userSettings = {"url":"\/","uid":"811","time":"1557806066","secure":"1"};/* ]]> */
</script>
<script type='text/javascript' src='https://weilaiche.cc/wp-admin/load-scripts.php?c=0&amp;load%5B%5D=jquery-core,jquery-migrate,utils,jquery-ui-core&amp;ver=4.7.53'></script>
<script type='text/javascript' src='https://weilaiche.cc/wp-content/plugins/admin-columns-pro/classes/Sorting/assets/js/table.js?ver=4.3.8'></script>
<script type='text/javascript' src='https://weilaiche.cc/wp-content/plugins/admin-columns-pro/admin-columns/external/qtip2/jquery.qtip.min.js?ver=3.2.7'></script>
<script type='text/javascript' src='https://weilaiche.cc/wp-content/plugins/admin-columns-pro/admin-columns/assets/js/table.js?ver=3.2.7'></script>
<script type='text/javascript' src='https://weilaiche.cc/wp-content/plugins/admin-columns-pro/assets/js/table-screen-options.js?ver=4.3.8'></script>
<script type='text/javascript' src='https://weilaiche.cc/wp-content/plugins/admin-columns-pro/classes/Export/assets/js/table-screen-options.js?ver=4.3.8'></script>
<script type='text/javascript' src='https://weilaiche.cc/wp-content/plugins/admin-columns-pro/assets/js/layouts-listings-screen.js?ver=4.3.8'></script>
<script type='text/javascript' src='https://weilaiche.cc/wp-includes/js/jquery/ui/datepicker.min.js?ver=1.11.4'></script>
<script type='text/javascript'>
jQuery(document).ready(function(jQuery){jQuery.datepicker.setDefaults({"closeText":"\u5173\u95ed","currentText":"\u4eca\u5929","monthNames":["\u4e00\u6708","\u4e8c\u6708","\u4e09\u6708","\u56db\u6708","\u4e94\u6708","\u516d\u6708","\u4e03\u6708","\u516b\u6708","\u4e5d\u6708","\u5341\u6708","\u5341\u4e00\u6708","\u5341\u4e8c\u6708"],"monthNamesShort":["1\u6708","2\u6708","3\u6708","4\u6708","5\u6708","6\u6708","7\u6708","8\u6708","9\u6708","10\u6708","11\u6708","12\u6708"],"nextText":"\u7ee7\u7eed","prevText":"\u4e0a\u4e00\u4e2a","dayNames":["\u661f\u671f\u65e5","\u661f\u671f\u4e00","\u661f\u671f\u4e8c","\u661f\u671f\u4e09","\u661f\u671f\u56db","\u661f\u671f\u4e94","\u661f\u671f\u516d"],"dayNamesShort":["\u5468\u65e5","\u5468\u4e00","\u5468\u4e8c","\u5468\u4e09","\u5468\u56db","\u5468\u4e94","\u5468\u516d"],"dayNamesMin":["\u65e5","\u4e00","\u4e8c","\u4e09","\u56db","\u4e94","\u516d"],"dateFormat":"yy\u5e74mm\u6708d\u65e5","firstDay":1,"isRTL":false});});
</script>
<script type='text/javascript' src='https://weilaiche.cc/wp-content/plugins/admin-columns-pro/classes/Filtering/assets/js/table.js?ver=4.3.8'></script>
<script type='text/javascript'>
/* <![CDATA[ */
var ACP_Export = {"total_num_items":"${sessionScope.sumNews }","i18n":{"Export":"Export","Export to CSV":"Export to CSV","Exporting current list of items.":"Exporting current list of items.","Processed {0} of {1} items ({2}%).":"Processed {0} of {1} items ({2}%).","Export completed ({0} items). Your download will start automatically. If this does not happen, you can download the file again: ":"Export completed ({0} items). Your download will start automatically. If this does not happen, you can download the file again: ","Download File":"Download File"}};
/* ]]> */
</script>
<script type='text/javascript' src='https://weilaiche.cc/wp-content/plugins/admin-columns-pro/classes/Export/assets/js/listscreen.js?ver=4.3.8'></script>
<!-- Set Adminimize metabox post options -->
<style type="text/css">#screen-options-link-wrap,#slugdiv,#edit-slug-box,#commentstatusdiv,#trackbacks, #trackbacksdiv, th.column-trackbacks, td.trackbacks,#postcustom, #postcustomdiv, th.column-postcustom, td.postcustom,#format, #formatdiv, th.column-format, td.format,#postimagediv,#nf_admin_metaboxes_appendaform {display:none !important;}</style>
	<link id="wp-admin-canonical" rel="canonical" href="https://weilaiche.cc/wp-admin/edit.php" />
	<script>
		if ( window.history.replaceState ) {
			window.history.replaceState( null, null, document.getElementById( 'wp-admin-canonical' ).href + window.location.hash );
		}
	</script>
<script type="text/javascript">var _wpColorScheme = {"icons":{"base":"#82878c","focus":"#00a0d2","current":"#fff"}};</script>
<style type="text/css" media="print">#wpadminbar { display:none; }</style>

		<style>
			@media screen and (min-width: 783px) {
			.ac-post .wrap table th.column-5cb165b970a37 { width: 5% !important; }body.acp-overflow-table.ac-post .wrap th.column-5cb165b970a37 { min-width: 5% !important; }.ac-post .wrap table th.column-5cb168afcc30c { width: 8% !important; }body.acp-overflow-table.ac-post .wrap th.column-5cb168afcc30c { min-width: 8% !important; }.ac-post .wrap table th.column-categories { width: 15% !important; }body.acp-overflow-table.ac-post .wrap th.column-categories { min-width: 15% !important; }.ac-post .wrap table th.column-tags { width: 15% !important; }body.acp-overflow-table.ac-post .wrap th.column-tags { min-width: 15% !important; }			}
		</style>

		</head>
<body class="wp-admin wp-core-ui no-js  ac-post ac-hide-export-button edit-php auto-fold admin-bar post-type-post branch-4-7 version-4-7-53 admin-color-fresh locale-zh-cn no-customize-support no-svg">
<script type="text/javascript">
	document.body.className = document.body.className.replace('no-js','js');
</script>

<script type="text/javascript">
 var selectdelete; //得到文本框选中的内容
 var datavalue; //得到选中checkbox的值
 var checkboxb;//checkbox
 var boxname;//得到checkbox的name
 var flag;
 var alldatavalue="";//得到所有选中checkbox的值,拼接为字符串
 function oncheckbox()
 {
	 var nid=document.getElementsByName("nid");
 	boxname=document.getElementsByName("checkboxname");
 	for(var i=0;i<boxname.length;i++)
 	{
	 	if(boxname[i].checked)
	 	{
	 	datavalue=boxname[i].value+",";
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
 	nid.value=alldatavalue;
 } 
 
 function deletenews()
  	 {
		     
		         if(""!=alldatavalue)
				   {
					    $.ajax({
					        type:"POST",
					        url:"news.do?param=removeToRecycle",
					        data:"nid="+alldatavalue,
					        success:function(returnval)
							     {
								     if("true"==returnval)
								     {							  	
								     window.location.href="edit.jsp";
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
	<li class="wp-has-submenu wp-has-current-submenu wp-menu-open menu-top menu-icon-post open-if-no-js menu-top-first menu-top-last" id="menu-posts">
	<a href='edit.php' class="wp-has-submenu wp-has-current-submenu wp-menu-open menu-top menu-icon-post open-if-no-js menu-top-first menu-top-last" ><div class="wp-menu-arrow"><div></div></div><div class='wp-menu-image dashicons-before dashicons-admin-post'><br /></div><div class='wp-menu-name'>文章</div></a>
	<ul class='wp-submenu wp-submenu-wrap'><li class='wp-submenu-head' aria-hidden='true'>文章</li><li class="wp-first-item current"><a href='edit.jsp' class="wp-first-item current">所有文章</a></li><li></li></ul></li>
	<li class="wp-not-current-submenu wp-menu-separator" aria-hidden="true"><div class="separator"></div></li>
	<li class="wp-has-submenu wp-not-current-submenu menu-top menu-icon-users menu-top-first" id="menu-users">
	<a href='profile.php' class="wp-has-submenu wp-not-current-submenu menu-top menu-icon-users menu-top-first" aria-haspopup="true"><div class="wp-menu-arrow"><div></div></div><div class='wp-menu-image dashicons-before dashicons-admin-users'><br /></div><div class='wp-menu-name'>个人资料</div></a>
	<ul class='wp-submenu wp-submenu-wrap'><li class='wp-submenu-head' aria-hidden='true'>个人资料</li><li class="wp-first-item"><a href='profile.jsp' class="wp-first-item">我的个人资料</a></li><li><a href='profile.jsp'>金钱 历史记录</a></li><li><a href='profile.php?page=ludou-phone-menu'>修改手机号</a></li><li><a href='profile.php?page=shiming-renzheng'>实名认证</a></li></ul></li>
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
		<li id="wp-admin-bar-site-name" class="menupop"><a class="ab-item" aria-haspopup="true" href="MainShow.jsp">未来车平台</a><div class="ab-sub-wrapper"><ul id="wp-admin-bar-site-name-default" class="ab-submenu">
		<li id="wp-admin-bar-view-site"><a class="ab-item" href="MainShow.jsp">查看站点</a>		</li></ul></div>		</li>
		<li id="wp-admin-bar-comments"><a class="ab-item" href="https://weilaiche.cc/wp-admin/edit-comments.php"><span class="ab-icon"></span><span class="ab-label awaiting-mod pending-count count-0" aria-hidden="true">0</span><span class="screen-reader-text">0条评论待审</span></a>		</li>
		<li id="wp-admin-bar-new-content" class="menupop"><a class="ab-item" aria-haspopup="true" href="https://weilaiche.cc/post.new.jsp"><span class="ab-icon"></span><span class="ab-label">新建</span></a><div class="ab-sub-wrapper"><ul id="wp-admin-bar-new-content-default" class="ab-submenu">
		<li id="wp-admin-bar-new-post"><a class="ab-item" href="post.new.jsp">文章</a>		</li></ul></div>		</li></ul><ul id="wp-admin-bar-top-secondary" class="ab-top-secondary ab-top-menu">
		<li id="wp-admin-bar-my-account" class="menupop with-avatar"><a class="ab-item" aria-haspopup="true" href="https://weilaiche.cc/wp-admin/profile.php">欢迎来到超级管理员界面<img alt='' src='https://secure.gravatar.com/avatar/989d4d63bcd4bd0c59f6d2edd762ed80?s=26&#038;d=wavatar&#038;r=g' srcset='https://secure.gravatar.com/avatar/989d4d63bcd4bd0c59f6d2edd762ed80?s=52&amp;d=wavatar&amp;r=g 2x' class='avatar avatar-26 photo' height='26' width='26' /></a><div class="ab-sub-wrapper"><ul id="wp-admin-bar-user-actions" class="ab-submenu">
		<li id="wp-admin-bar-user-info"><a class="ab-item" tabindex="-1" href="https://weilaiche.cc/wp-admin/profile.php"><img alt='' src='https://secure.gravatar.com/avatar/989d4d63bcd4bd0c59f6d2edd762ed80?s=64&#038;d=wavatar&#038;r=g' srcset='https://secure.gravatar.com/avatar/989d4d63bcd4bd0c59f6d2edd762ed80?s=128&amp;d=wavatar&amp;r=g 2x' class='avatar avatar-64 photo' height='64' width='64' /><span class='display-name'>${listc.typename }</span></a>		</li>
		<li id="wp-admin-bar-edit-profile"><a class="ab-item" href="https://weilaiche.cc/wp-admin/profile.php">编辑我的个人资料</a>		</li>
		<li id="wp-admin-bar-logout"><a class="ab-item" href="login.jsp?action=logout&#038;_wpnonce=5144bf0ac7">登出</a>		</li></ul><ul id="wp-admin-bar-my-account-default" class="ab-submenu">
		<li id="wp-admin-bar-mycred-account" class="menupop ab-sub-secondary"><div class="ab-item ab-empty-item" aria-haspopup="true">余额</div><div class="ab-sub-wrapper"><ul id="wp-admin-bar-mycred-account-default" class="ab-submenu">
		<li id="wp-admin-bar-mycred-account-balance-mycred-money"><div class="ab-item ab-empty-item">金钱: ￥ 20 元</div>		</li>
		<li id="wp-admin-bar-mycred-account-history-mycred-money"><a class="ab-item" href="https://weilaiche.cc/wp-admin/users.php?page=mycred_money-history">金钱 历史记录</a>		</li></ul></div>		</li></ul></div>		</li></ul>			</div>
						<a class="screen-reader-shortcut" href="login.jsp?action=logout&#038;_wpnonce=5144bf0ac7">登出</a>
					</div>

		
<div id="wpbody" role="main">

<div id="wpbody-content" aria-label="主内容" tabindex="0">
		<div id="screen-meta" class="metabox-prefs">

			<div id="contextual-help-wrap" class="hidden" tabindex="-1" aria-label="“上下文帮助”选项卡">
				<div id="contextual-help-back"></div>
				<div id="contextual-help-columns">
					<div class="contextual-help-tabs">
						<ul>
						
							<li id="tab-link-overview" class="active">
								<a href="#tab-panel-overview" aria-controls="tab-panel-overview">
									概述								</a>
							</li>
						
							<li id="tab-link-screen-content">
								<a href="#tab-panel-screen-content" aria-controls="tab-panel-screen-content">
									页面内容								</a>
							</li>
						
							<li id="tab-link-action-links">
								<a href="#tab-panel-action-links" aria-controls="tab-panel-action-links">
									可进行的操作								</a>
							</li>
						
							<li id="tab-link-bulk-actions">
								<a href="#tab-panel-bulk-actions" aria-controls="tab-panel-bulk-actions">
									批量操作								</a>
							</li>
												</ul>
					</div>

										<div class="contextual-help-sidebar">
						<p><strong>更多信息：</strong></p><p><a href="https://codex.wordpress.org/Posts_Screen">管理文章文档</a></p><p><a href="https://wordpress.org/support/">支持论坛</a></p>					</div>
					
					<div class="contextual-help-tabs-wrap">
						
							<div id="tab-panel-overview" class="help-tab-content active">
								<p>本页面提供文章相关的所有功能。您可以自定义页面的样式来使工作更顺手。</p>							</div>
						
							<div id="tab-panel-screen-content" class="help-tab-content">
								<p>您可以通过以下方法来自定义本页面内容的显示方式：</p><ul><li>您可在“显示选项”中依据您的需要隐藏或显示每页显示的文章数量。</li><li>您可以通过点击列表上方的文字链接来过滤列表显示的项目——全部、已发布、草稿、回收站。默认视图中，显示所有文章。</li><li>您可以使用简单标题列表来查看文章，或是在显示选项面板种加入摘要。</li><li>通过在文章列表上方的下拉菜单中选择，您可单独查看显示某一分类中的文章，或是某月发布的文章。点击列表中作者、分类，或标签也可令列表只显示那些内容。</li></ul>							</div>
						
							<div id="tab-panel-action-links" class="help-tab-content">
								<p>将鼠标光标悬停在文章列表中的某一行，操作链接将会显示出来，您可以通过它们快速管理文章。您可进行下列操作：</p><ul><li>点击<strong>编辑</strong>可在编辑器中编辑该文章。直接点击文章标题也可以达到同样的效果。</li><li>点击<strong>快速编辑</strong>，您无须跳转到其它页面，在本页内就能对文章属性进行更改。</li><li>点击<strong>移至回收站</strong>，该文章将会从列表中删除，并自动移至回收站。在回收站中，您可永久删除它。</li><li>点击<strong>预览/查看</strong>，您的浏览器将跳转到前台，为您展示文章发布后的效果，或访问已经发布的这篇文章。</li></ul>							</div>
						
							<div id="tab-panel-bulk-actions" class="help-tab-content">
								<p>您也可以一次删除/回收多个文件。使用文章左侧的复选框，选择您需要操作的文件，然后从“批量操作”下拉菜单中选择您的操作类型。点击“应用”，操作即生效。</p><p>在使用“批量编辑”时，您可以一次编辑这些文章的多个属性（分类目录、作者等）。要从待编辑文章中移除某篇，请在“批量编辑”区域中点击其标题旁边的“x”。</p>							</div>
											</div>
				</div>
			</div>
		<div id="screen-options-wrap" class="hidden" tabindex="-1" aria-label="“显示选项”选项卡">
<form id='adv-settings' method='post'>
		<fieldset class="metabox-prefs">
		<legend>栏目</legend>
		<label><input class="hide-column-tog" name="5cb165b970a37-hide" type="checkbox" id="5cb165b970a37-hide" value="5cb165b970a37" checked='checked' />状态</label>
<label><input class="hide-column-tog" name="5cb168afcc30c-hide" type="checkbox" id="5cb168afcc30c-hide" value="5cb168afcc30c" checked='checked' />作者</label>
<label><input class="hide-column-tog" name="categories-hide" type="checkbox" id="categories-hide" value="categories" checked='checked' />分类目录</label>
<label><input class="hide-column-tog" name="tags-hide" type="checkbox" id="tags-hide" value="tags" checked='checked' />标签</label>
<label><input class="hide-column-tog" name="date-hide" type="checkbox" id="date-hide" value="date" checked='checked' />日期</label>
		</fieldset>
				<fieldset class="screen-options">
		<legend>分页</legend>
							<label for="edit_post_per_page">每页的项目数：</label>
				<input type="number" step="1" min="1" max="999" class="screen-per-page" name="wp_screen_options[value]"
					id="edit_post_per_page" maxlength="3"
					value="20" />
							<input type="hidden" name="wp_screen_options[option]" value="edit_post_per_page" />
		</fieldset>
				<fieldset class="metabox-prefs view-mode">
		<legend>查看模式</legend>
				<label for="list-view-mode">
					<input id="list-view-mode" type="radio" name="mode" value="list"  checked='checked' />
					列表视图				</label>
				<label for="excerpt-view-mode">
					<input id="excerpt-view-mode" type="radio" name="mode" value="excerpt"  />
					摘要视图				</label>
		</fieldset>

		<fieldset class='acp-screen-option-prefs'>
			<legend>Admin Columns</legend>
			<div class="checkbox-labels checkbox-labels"><label name="acp_overflow_list_screen_table" id="acp_overflow_list_screen_table"><input name="acp_overflow_list_screen_table" id="acp_overflow_list_screen_table-yes" type="checkbox" value="yes">Horizontal Scrolling</label></div><div class="checkbox-labels checkbox-labels"><label name="acp_export_show_export_button" id="acp_export_show_export_button"><input name="acp_export_show_export_button" id="acp_export_show_export_button-yes" type="checkbox" value="yes">Show Export Button</label></div>		</fieldset>

		<p class="submit"><input type="submit" name="screen-options-apply" id="screen-options-apply" class="button button-primary" value="应用"  /></p>
<input type="hidden" id="screenoptionnonce" name="screenoptionnonce" value="231dcac900" />
</form>
</div>		</div>
				<div id="screen-meta-links">
					<div id="contextual-help-link-wrap" class="hide-if-no-js screen-meta-toggle">
			<button type="button" id="contextual-help-link" class="button show-settings" aria-controls="contextual-help-wrap" aria-expanded="false">帮助</button>
			</div>
					<div id="screen-options-link-wrap" class="hide-if-no-js screen-meta-toggle">
			<button type="button" id="show-settings-link" class="button show-settings" aria-controls="screen-options-wrap" aria-expanded="false">显示选项</button>
			</div>
				</div>
		<div class="wrap">
<h1 class="wp-heading-inline">文章</h1>

 <a href="./post.new.jsp" class="page-title-action">写文章</a>
<hr class="wp-header-end">


<h2 class='screen-reader-text'>过滤文章列表</h2><ul class='subsubsub'>
</ul>

<%
	   NewsDao nd=new NewsDaoImpl();
	 TypeDao td=new TypeDaoImpl();
	   Connection conn=DBHelper.getConnection();
	//每页显示文章数量
	int maxSize=5;
	  pageContext.setAttribute("maxSize", maxSize);
	//最大页数
	//int maxPage=nd.getMaxPage(conn, maxSize);
	int maxPage=nd.selectAllNewsMaxPageForAdmin(conn, maxSize);
	//总的文章数
	int sumNews=nd.getAllNewsSum(conn,1);
	MyLog.log.debug("maxPage="+maxPage);
	request.getSession().setAttribute("sumNews", sumNews);
	
	//当前页数
	int pageNo=0;
	if(request.getParameter("pageNo")==null){
	 pageNo=1;
	}else{
	pageNo=Integer.valueOf(request.getParameter("pageNo"));
	}
	pageContext.setAttribute("pageNo", pageNo);
	   List<NewsImpl> list=null;
	   
	   list=nd.selectAllNewsForAdmin(conn, pageNo, maxSize);
	  
	MyLog.log.debug("maxPage"+maxPage);
	
	
	 
	  request.setAttribute("list", list);
	pageContext.setAttribute("maxPage", maxPage);
	DBHelper.closeCon(conn);
	 %>

<form id="posts-filter" method="get" action="news.do">

<input type="hidden"  value="title" /><input type="hidden"  value="desc" /><p class="search-box">
	<label class="screen-reader-text" for="post-search-input">搜索文章:</label>
	<input type="search" id="post-search-input"  value="" />
	<input type="submit" id="search-submit" class="button" value="搜索文章"  /></p>

<input type="hidden"  class="post_status_page" value="all" />
<input type="hidden"  class="post_type_page" value="post" />

<input type="hidden" id="_wpnonce"  value="dcf7b0bb0c" /><input type="hidden" name="_wp_http_referer" value="/wp-admin/edit.php" />	<div class="tablenav top">

				<div class="alignleft actions bulkactions">
			<label for="bulk-action-selector-top" class="screen-reader-text">选择批量操作</label><select name="action" id="bulk-action-selector-top">
	<option value="trash">移至回收站</option>
</select>
<input type="hidden" name="param" value="removeToRecycle"/>
<input type="hidden" name="nid" />
<input type="button" id="doaction" class="button action" value="应用"  onclick="deletenews()"/>
		</div>
				 <div class="alignleft actions">
					<label for="filter-by-date" class="screen-reader-text">按日期筛选</label>
		<select  id="filter-by-date">
			<option selected='selected' value="0">全部日期</option>
<c:forEach items="${requestScope.timetype }" var="timetypec" varStatus="cb">
<option  value='201710'>${timetypec.timec }</option>
	</c:forEach>
		</select>
<label class="screen-reader-text" for="cat">按分类过滤</label><select   id='cat' class='postform' >
<%
		Connection conn2=DBHelper.getConnection();
		TypeDao td2=new TypeDaoImpl();
		List<TypeImpl> type=td2.selectAllTypeInDB(conn2);
		request.setAttribute("typec", type);
		DBHelper.closeCon(conn);
		 %>
	<option value='0'>所有分类目录</option>
	
	<c:forEach items="${requestScope.type }" var="typec" varStatus="cb">
	<option class="level-0" value="173">${typec.tname }</option>
	</c:forEach>
</select>

		<label for=" acp-filter-5cb165b970a37" class="screen-reader-text">
			Filter by 全部状态		</label>

		
			<select  id="acp-filter-5cb165b970a37" class="postform acp-filter" data-current="d41d8cd98f00b204e9800998ecf8427e">
				<option value="" selected="selected" data-value="d41d8cd98f00b204e9800998ecf8427e">全部状态</option>
<option value="publish" data-value="9b6d0bb3102b87fae57bc4a39149518e">已发布</option>
<option value="pending" data-value="7c6c2e5d48ab37a007cbf70d3ea25fa4">待审核</option>
<option value="draft" data-value="f91b2829bf8603e358094e1dedb6f947">草稿</option>
			</select>
			
		

		
			
			<input type="submit" name="filter_action" id="post-query-submit" class="button" value="筛选"  />	</div>
	<h2 class='screen-reader-text'>文章列表导航</h2><div class='tablenav-pages'><span class="displaying-num">${sessionScope.sumNews }篇文章</span>
		<br class="clear" />
		
		
		
		
		
	</div>
<h2 class='screen-reader-text'>文章列表</h2><table class="wp-list-table widefat fixed striped posts">
	<thead>
	<tr>
	
		<td  id='cb' class='manage-column column-cb check-column'><label class="screen-reader-text" for="cb-select-all-1">全选</label><input id="cb-select-all-1" type="checkbox" /></td><th scope="col" id='5cb165b970a37' class='manage-column column-5cb165b970a37'>状态</th><th scope="col" id='title' class='manage-column column-title column-primary sorted desc'><a href="https://weilaiche.cc/wp-admin/edit.php?orderby=title&#038;order=asc"><span>标题</span><span class="sorting-indicator"></span></a></th><th scope="col" id='5cb168afcc30c' class='manage-column column-5cb168afcc30c'>作者</th><th scope="col" id='categories' class='manage-column column-categories sortable desc'><a href="https://weilaiche.cc/wp-admin/edit.php?orderby=categories&#038;order=asc"><span>分类目录</span><span class="sorting-indicator"></span></a></th><th scope="col" id='tags' class='manage-column column-tags sortable desc'><a href="https://weilaiche.cc/wp-admin/edit.php?orderby=tags&#038;order=asc"><span>标签</span><span class="sorting-indicator"></span></a></th><th scope="col" id='date' class='manage-column column-date sortable asc'><a href="https://weilaiche.cc/wp-admin/edit.php?orderby=date&#038;order=desc"><span>日期</span><span class="sorting-indicator"></span></a></th>	</tr>
		
	</thead>

	<tbody id="the-list">
	
	
	
	<c:forEach items="${requestScope.list }" var="listc" varStatus="cb">
	  <c:if test="${!empty listc }">
	    
		<tr id="post-486356" class="iedit author-self level-0 post-486356 type-post status-pending format-standard hentry category-jstw">
			<th scope="row" class="check-column">			<label class="screen-reader-text" for="cb-select-486356">${listc.title }</label>
			<input id="cb-select-486356" type="checkbox" name="checkboxname" value="${listc.nid }" onclick="oncheckbox()"/>
			<div class="locked-indicator">
				<span class="locked-indicator-icon" aria-hidden="true"></span>
				<span class="screen-reader-text">“${listc.title }”已被锁定</span>
			</div>
		</th>
		<td class='5cb165b970a37 column-5cb165b970a37' data-colname="状态">待审核</td>
		<td class="title column-title has-row-actions column-primary page-title" data-colname="标题"><div class="locked-info"><span class="locked-avatar"></span> <span class="locked-text"></span></div>
<strong><a class="row-title" href="https://weilaiche.cc/wp-admin/post.php?post=486356&amp;action=edit" aria-label="“${listc.title }”（编辑）">${listc.title }</a> <span class="post-state"><span class="pending states">
		<span class="dashicons dashicons-format-chat"></span>待审核
</span></span>
</strong>
		


<div class="hidden" id="inline_486356">
	<div class="post_title">${listc.title }</div><div class="post_name"></div>
	<div class="post_author">811</div>
	<div class="comment_status">open</div>
	<div class="ping_status">closed</div>
	<div class="_status">pending</div>
	<div class="jj">24</div>
	<div class="mm">04</div>
	<div class="aa">2019</div>
	<div class="hh">10</div>
	<div class="mn">37</div>
	<div class="ss">44</div>
	<div class="post_password"></div><div class="page_template">default</div><div class="post_category" id="category_486356">170</div>
	<div class="tags_input" id="post_tag_486356"></div><div class="sticky"></div>
	<div class="post_format"></div></div><div class="row-actions"><span class='edit'>
	<a href="post.jsp?nid=${listc.nid }&ntitle=${listc.title}&" aria-label="查看“${listc.title }”">查看
	</a> | <a href="news.do?param=updateNewsCheckPath&nid=${listc.nid }" aria-label="查看“${listc.title }”">通过审核
	</a> | <a href="news.do?param=updateNewsCheckNo&nid=${listc.nid }" aria-label="查看“${listc.title }”">审核不通过</a></span>
	<span class='inline hide-if-no-js'>
	 | </span>
	
	<span class='view'><a href="https://weilaiche.cc/?p=486356&#038;preview=true" rel="permalink" aria-label="预览“wuhao078F35坠毁后，两关键部件不知所踪，美媒神甩锅：两国嫌疑最大yangxvbing”">预览</a></span></div><button type="button" class="toggle-row"><span class="screen-reader-text">显示详情</span></button></td><td class='5cb168afcc30c column-5cb168afcc30c' data-colname="作者"><a href="edit.php?post_type=post&#038;author=811"  >${listc.uname }</a></td><td class='categories column-categories' data-colname="分类目录"><a href="edit.php?category_name=jstw">${listc.typename }</a></td><td class='tags column-tags' data-colname="标签"><span aria-hidden="true">&#8212;</span><span class="screen-reader-text">没有标签</span></td><td class='date column-date' data-colname="日期">最后修改<br /><abbr title="2019/04/24 10:37:44">${listc.namend_time }</abbr></td>		</tr>
	
	
	  </c:if>
	</c:forEach>	
			</tbody>


</table>
	
	当前是第${pageNo }页&nbsp;&nbsp;总共有${maxPage }页&nbsp;&nbsp;
   <a href="admin_edit.jsp?pageNo=${1 }&pageSize=${maxSize }&typec=${typec }&timetypec=${timetypecName}"> 首页</a>&nbsp;&nbsp;
    <c:if test="${pageNo ge 2 }">
   <a href="admin_edit.jsp?pageNo=${pageNo-1 }&pageSize=${maxSize }&typec=${typec }&timetypec=${timetypecName}"> 上一页</a>
   </c:if>
   
   <c:forEach begin="1" end="${maxPage }" var="i">
      <c:if test="${i ge pageNo-2 and i le pageNo+2 }">
        <a class='page-numbers' href="admin_edit.jsp?pageNo=${i }&pageSize=${maxSize }&typec=${typec }&timetypec=${timetypecName}"><span class="meta-nav screen-reader-text">页 </span>${i }</a>&nbsp;&nbsp;
      </c:if>
   </c:forEach>
   
   <c:if test="${pageNo le maxPage-1 }">
   <a href="admin_edit.jsp?pageNo=${pageNo+1 }&pageSize=${maxSize }&typec=${typec }&timetypec=${timetypecName}"> 下一页</a>&nbsp;&nbsp;
   </c:if>
   <a href="admin_edit.jsp?pageNo=${maxPage }&pageSize=${maxSize }&typec=${typec }&timetypec=${timetypecName}"> 尾页</a>&nbsp;&nbsp;

</form>


		<form method="get"><table style="display: none"><tbody id="inlineedit">
			
				<tr id="inline-edit" class="inline-edit-row inline-edit-row-post inline-edit-post quick-edit-row quick-edit-row-post inline-edit-post" style="display: none"><td colspan="7" class="colspanchange">

					<fieldset class="inline-edit-col-left">
						<legend class="inline-edit-legend">快速编辑</legend>
						<div class="inline-edit-col">
							
									<label>
										<span class="title">标题</span>
										<span class="input-text-wrap"><input type="text" name="post_title" class="ptitle" value="" /></span>
									</label>

									<label>
										<span class="title">别名</span>
										<span class="input-text-wrap"><input type="text" name="post_name" value="" /></span>
									</label>

	
	<fieldset class="inline-edit-date">
		<legend><span class="title">日期</span></legend>
		<div class="timestamp-wrap"><label><span class="screen-reader-text">年</span><input type="text" name="aa" value="2019" size="4" maxlength="4" autocomplete="off" /></label>-<label><span class="screen-reader-text">月份</span><select name="mm">
			<option value="01" data-text="1月" >1月</option>
			<option value="02" data-text="2月" >2月</option>
			<option value="03" data-text="3月"  selected='selected'>3月</option>
			<option value="04" data-text="4月" >4月</option>
			<option value="05" data-text="5月" >5月</option>
			<option value="06" data-text="6月" >6月</option>
			<option value="07" data-text="7月" >7月</option>
			<option value="08" data-text="8月" >8月</option>
			<option value="09" data-text="9月" >9月</option>
			<option value="10" data-text="10月" >10月</option>
			<option value="11" data-text="11月" >11月</option>
			<option value="12" data-text="12月" >12月</option>
</select></label>-<label><span class="screen-reader-text">日期</span><input type="text" name="jj" value="01" size="2" maxlength="2" autocomplete="off" /></label> @ <label><span class="screen-reader-text">小时</span><input type="text" name="hh" value="09" size="2" maxlength="2" autocomplete="off" /></label>:<label><span class="screen-reader-text">分钟</span><input type="text" name="mn" value="56" size="2" maxlength="2" autocomplete="off" /></label></div><input type="hidden" id="ss" name="ss" value="10" />	</fieldset>
	<br class="clear" />
	
			
</div></fieldset>


	<fieldset class="inline-edit-col-center inline-edit-categories"><div class="inline-edit-col">

		
			<span class="title inline-edit-categories-label">分类目录</span>
			<input type="hidden" name="post_category[]" value="0" />
			<ul class="cat-checklist category-checklist">
				
<li id='category-3736'><label class="selectit"><input value="3736" type="checkbox" name="post_category[]" id="in-category-3736" /> BCD摆成都</label></li>

<li id='category-1809' class="popular-category"><label class="selectit"><input value="1809" type="checkbox" name="post_category[]" id="in-category-1809" /> CCC旅游图文</label></li>

<li id='category-5081'><label class="selectit"><input value="5081" type="checkbox" name="post_category[]" id="in-category-5081" /> LSJ-JS图文</label></li>

<li id='category-1020'><label class="selectit"><input value="1020" type="checkbox" name="post_category[]" id="in-category-1020" /> LSJ-旅游图文</label></li>

<li id='category-1019' class="popular-category"><label class="selectit"><input value="1019" type="checkbox" name="post_category[]" id="in-category-1019" /> LSJ-汽车图文</label></li>

<li id='category-6517' class="popular-category"><label class="selectit"><input value="6517" type="checkbox" name="post_category[]" id="in-category-6517" /> MMC</label></li>

<li id='category-1018'><label class="selectit"><input value="1018" type="checkbox" name="post_category[]" id="in-category-1018" /> MMC军事</label></li>

<li id='category-7144'><label class="selectit"><input value="7144" type="checkbox" name="post_category[]" id="in-category-7144" /> QZBP</label></li>

<li id='category-2726'><label class="selectit"><input value="2726" type="checkbox" name="post_category[]" id="in-category-2726" /> TCY企鹅</label></li>

<li id='category-170' class="popular-category"><label class="selectit"><input value="170" type="checkbox" name="post_category[]" id="in-category-170" /> TCY军事图文</label></li>

<li id='category-219'><label class="selectit"><input value="219" type="checkbox" name="post_category[]" id="in-category-219" /> TCY历史图文</label></li>

<li id='category-232' class="popular-category"><label class="selectit"><input value="232" type="checkbox" name="post_category[]" id="in-category-232" /> TCY旅游图文</label></li>

<li id='category-2' class="popular-category"><label class="selectit"><input value="2" type="checkbox" name="post_category[]" id="in-category-2" /> TCY汽车图文</label></li>

<li id='category-181'><label class="selectit"><input value="181" type="checkbox" name="post_category[]" id="in-category-181" /> TG-旅游推广</label></li>

<li id='category-177'><label class="selectit"><input value="177" type="checkbox" name="post_category[]" id="in-category-177" /> TG-汽车推广</label></li>

<li id='category-195' class="popular-category"><label class="selectit"><input value="195" type="checkbox" name="post_category[]" id="in-category-195" /> TG-综合图文</label></li>

<li id='category-169' class="popular-category"><label class="selectit"><input value="169" type="checkbox" name="post_category[]" id="in-category-169" /> TXWLC</label></li>

<li id='category-6238'><label class="selectit"><input value="6238" type="checkbox" name="post_category[]" id="in-category-6238" /> WXT军事图文</label></li>

<li id='category-1017'><label class="selectit"><input value="1017" type="checkbox" name="post_category[]" id="in-category-1017" /> WXT旅游图文</label></li>

<li id='category-477'><label class="selectit"><input value="477" type="checkbox" name="post_category[]" id="in-category-477" /> YTB</label></li>

<li id='category-7693'><label class="selectit"><input value="7693" type="checkbox" name="post_category[]" id="in-category-7693" /> 世界之最</label></li>

<li id='category-7690'><label class="selectit"><input value="7690" type="checkbox" name="post_category[]" id="in-category-7690" /> 分析军事</label></li>

<li id='category-7692'><label class="selectit"><input value="7692" type="checkbox" name="post_category[]" id="in-category-7692" /> 分析旅游</label></li>

<li id='category-7691'><label class="selectit"><input value="7691" type="checkbox" name="post_category[]" id="in-category-7691" /> 分析汽车</label></li>

<li id='category-237'><label class="selectit"><input value="237" type="checkbox" name="post_category[]" id="in-category-237" /> 天下有警视频</label></li>

<li id='category-3592'><label class="selectit"><input value="3592" type="checkbox" name="post_category[]" id="in-category-3592" /> 抖音视频</label></li>

<li id='category-1' class="popular-category"><label class="selectit"><input value="1" type="checkbox" name="post_category[]" id="in-category-1" /> 未分类</label></li>

<li id='category-478'><label class="selectit"><input value="478" type="checkbox" name="post_category[]" id="in-category-478" /> 未来车军事-其他</label></li>

<li id='category-1482'><label class="selectit"><input value="1482" type="checkbox" name="post_category[]" id="in-category-1482" /> 未来车军事-海外</label></li>

<li id='category-167' class="popular-category"><label class="selectit"><input value="167" type="checkbox" name="post_category[]" id="in-category-167" /> 未来车军事-素版</label></li>

<li id='category-296'><label class="selectit"><input value="296" type="checkbox" name="post_category[]" id="in-category-296" /> 未来车汽车-独家</label></li>

<li id='category-371'><label class="selectit"><input value="371" type="checkbox" name="post_category[]" id="in-category-371" /> 油管分析</label></li>

<li id='category-7696'><label class="selectit"><input value="7696" type="checkbox" name="post_category[]" id="in-category-7696" /> 海外测试版勿动</label></li>

<li id='category-7694'><label class="selectit"><input value="7694" type="checkbox" name="post_category[]" id="in-category-7694" /> 王尧标题</label></li>

<li id='category-519'><label class="selectit"><input value="519" type="checkbox" name="post_category[]" id="in-category-519" /> 虾兵械将</label></li>

<li id='category-7695'><label class="selectit"><input value="7695" type="checkbox" name="post_category[]" id="in-category-7695" /> 詹际琳企鹅</label></li>

<li id='category-173'><label class="selectit"><input value="173" type="checkbox" name="post_category[]" id="in-category-173" /> 青岛</label></li>
			</ul>

		
	</div></fieldset>


<fieldset class="inline-edit-col-right"><div class="inline-edit-col">

	
		
		
												<label class="inline-edit-tags">
						<span class="title">标签</span>
						<textarea data-wp-taxonomy="post_tag" cols="22" rows="1" name="tax_input[post_tag]" class="tax_input_post_tag"></textarea>
					</label>
				
			
		
		
		<div class="inline-edit-group wp-clearfix">
							<label class="alignleft">
					<input type="checkbox" name="comment_status" value="open" />
					<span class="checkbox-title">允许评论</span>
				</label>
						<label class="alignleft">
				<input type="checkbox" name="ping_status" value="open" />
				<span class="checkbox-title">允许ping</span>
			</label>
			</div>

	
<div class="inline-edit-group wp-clearfix">
	<label class="inline-edit-status alignleft">
		<span class="title">状态</span>
		<select name="_status">
									<option value="pending">等待审核</option>
			<option value="draft">草稿</option>
		</select>
	</label>

	
</div>


</div></fieldset>

		<p class="submit inline-edit-save">
			<button type="button" class="button cancel alignleft">取消</button>
			<input type="hidden" id="_inline_edit" name="_inline_edit" value="2c8a7cd844" />				<button type="button" class="button button-primary save alignright">更新</button>
				<span class="spinner"></span>
						<input type="hidden" name="post_view" value="list" />
			<input type="hidden" name="screen" value="edit-post" />
						<span class="error" style="display:none"></span>
			<br class="clear" />
		</p>
	</td></tr>
	
				<tr id="bulk-edit" class="inline-edit-row inline-edit-row-post inline-edit-post bulk-edit-row bulk-edit-row-post bulk-edit-post" style="display: none"><td colspan="7" class="colspanchange">

					<fieldset class="inline-edit-col-left">
						<legend class="inline-edit-legend">批量编辑</legend>
						<div class="inline-edit-col">
																<div id="bulk-title-div">
										<div id="bulk-titles"></div>
									</div>

								

			
</div></fieldset>


<fieldset class="inline-edit-col-right"><div class="inline-edit-col">

	
		
		
		
			<div class="inline-edit-group wp-clearfix">
									<label class="alignleft">
						<span class="title">评论</span>
						<select name="comment_status">
							<option value="">&mdash;无更改&mdash;</option>
							<option value="open">允许</option>
							<option value="closed">不允许</option>
						</select>
					</label>
								<label class="alignright">
					<span class="title">Ping通告</span>
					<select name="ping_status">
						<option value="">&mdash;无更改&mdash;</option>
						<option value="open">允许</option>
						<option value="closed">不允许</option>
					</select>
				</label>
					</div>

	
<div class="inline-edit-group wp-clearfix">
	<label class="inline-edit-status alignleft">
		<span class="title">状态</span>
		<select name="_status">
							<option value="-1">&mdash;无更改&mdash;</option>
									<option value="pending">等待审核</option>
			<option value="draft">草稿</option>
		</select>
	</label>

	
</div>

	<label class="alignleft">
		<span class="title">形式</span>
		<select name="post_format">
			<option value="-1">&mdash;无更改&mdash;</option>
			<option value="0">标准</option>
								<option value="aside">日志</option>
										<option value="image">图像</option>
										<option value="video">视频</option>
										<option value="quote">引语</option>
										<option value="link">链接</option>
										<option value="gallery">相册</option>
										<option value="status">状态</option>
										<option value="audio">音频</option>
										<option value="chat">聊天</option>
							</select></label>
		
</div></fieldset>

		<p class="submit inline-edit-save">
			<button type="button" class="button cancel alignleft">取消</button>
			<input type="submit" name="bulk_edit" id="bulk_edit" class="button button-primary alignright" value="更新"  />			<input type="hidden" name="post_view" value="list" />
			<input type="hidden" name="screen" value="edit-post" />
						<span class="error" style="display:none"></span>
			<br class="clear" />
		</p>
	</td></tr>
	</tbody></table></form>

<div id="ajax-response"></div>
<br class="clear" />
</div>


<div class="clear"></div></div><!-- wpbody-content -->
<div class="clear"></div></div><!-- wpbody -->
<div class="clear"></div></div><!-- wpcontent -->

		<form action="" method="post" id="acp-export">
			<input type="hidden" id="_wpnonce" name="_wpnonce" value="a0f52f2db0" />			<input type="submit" class="button button-secondary"/>
		</form>
				<div id="ac-table-actions" class="ac-table-actions">

					
			<div id="wp-auth-check-wrap" class="hidden">
		<div id="wp-auth-check-bg"></div>
		<div id="wp-auth-check">
			<button type="button" class="wp-auth-check-close button-link"><span class="screen-reader-text">关闭对话框</span></button>
							<div id="wp-auth-check-form" class="loading" data-src="login.jsp?interim-login=1"></div>
							<div class="wp-auth-fallback">
				<p><b class="wp-auth-fallback-expired" tabindex="0">会话已过期</b></p>
				<p><a href="login.jsp" target="_blank">请重新登录。</a>
					登录页会在新窗口中打开，在登录后您可关闭该窗口并返回本页。</p>
				</div>
			</div>
		</div>
		
<script type='text/javascript'>
/* <![CDATA[ */
var commonL10n = {"warnDelete":"\u60a8\u5c06\u6c38\u4e45\u5220\u9664\u8fd9\u4e9b\u9879\u76ee\u3002\n\u70b9\u51fb\u201c\u53d6\u6d88\u201d\u505c\u6b62\uff0c\u70b9\u51fb\u201c\u786e\u5b9a\u201d\u5220\u9664\u3002","dismiss":"\u5ffd\u7565\u6b64\u901a\u77e5\u3002","collapseMenu":"\u6298\u53e0\u4e3b\u83dc\u5355","expandMenu":"\u5c55\u5f00\u4e3b\u83dc\u5355"};var uiAutocompleteL10n = {"noResults":"\u672a\u627e\u5230\u7ed3\u679c\u3002","oneResult":"\u627e\u52301\u4e2a\u7ed3\u679c\u3002\u4f7f\u7528\u4e0a\u4e0b\u65b9\u5411\u952e\u6765\u5bfc\u822a\u3002","manyResults":"\u627e\u5230%d\u4e2a\u7ed3\u679c\u3002\u4f7f\u7528\u4e0a\u4e0b\u65b9\u5411\u952e\u6765\u5bfc\u822a\u3002","itemSelected":"\u5df2\u9009\u62e9\u9879\u76ee\u3002"};var tagsSuggestL10n = {"tagDelimiter":"\u3001","removeTerm":"\u79fb\u9664","termSelected":"\u9009\u62e9\u4e86\u9879\u76ee\u3002","termAdded":"\u6dfb\u52a0\u4e86\u9879\u76ee\u3002","termRemoved":"\u79fb\u9664\u4e86\u9879\u76ee\u3002"};var inlineEditL10n = {"error":"\u4fdd\u5b58\u66f4\u6539\u65f6\u53d1\u751f\u9519\u8bef\u3002","ntdeltitle":"\u4ece\u6279\u91cf\u7f16\u8f91\u4e2d\u79fb\u9664","notitle":"(\u65e0\u6807\u9898)","comma":"\u3001","saved":"\u4fee\u6539\u5df2\u4fdd\u5b58\u3002"};var heartbeatSettings = {"nonce":"254a75e02b"};var authcheckL10n = {"beforeunload":"\u60a8\u7684\u767b\u5f55\u4f1a\u8bdd\u5df2\u8fc7\u671f\uff0c\u8bf7\u91cd\u65b0\u767b\u5f55\u3002","interval":"180"};var wpColorPickerL10n = {"clear":"\u6e05\u7a7a","defaultString":"\u9ed8\u8ba4","pick":"\u9009\u62e9\u989c\u8272","current":"\u5f53\u524d\u989c\u8272"};/* ]]> */
</script>
<script type='text/javascript' src='https://weilaiche.cc/wp-admin/load-scripts.php?c=0&amp;load%5B%5D=hoverIntent,common,admin-bar,jquery-ui-widget,jquery-ui-position,jquery-ui-menu,wp-a11y,jquery-ui-autocomplete,tags-suggest,inli&amp;load%5B%5D=ne-edit-post,heartbeat,svg-painter,wp-auth-check,jquery-ui-mouse,jquery-ui-draggable,jquery-ui-slider,jquery-touch-punch,iris,wp&amp;load%5B%5D=-color-picker&amp;ver=4.7.53'></script>
<script type='text/javascript' src='https://weilaiche.cc/wp-content/plugins/site-announcements/admin/js/cw-site-announcements-admin.js?ver=1.0.3'></script>

<div class="clear"></div></div><!-- wpwrap -->
<script type="text/javascript">if(typeof wpOnload=='function')wpOnload();</script>
</body>
</html>
