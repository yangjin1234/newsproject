<!DOCTYPE html>
<%@page import="util.MyLog"%>
<%@page import="pojo.News"%>
<%@page import="java.util.List"%>
<%@page import="db.DBHelper"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.impl.NewsImpl"%>
<%@page import="dao.NewsDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN" class="no-js">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width">
	<link rel="profile" href="http://gmpg.org/xfn/11">
	<link rel="pingback" href="https://weilaiche.cc/xmlrpc.php">
	<!--[if lt IE 9]>
	<script src="https://weilaiche.cc/wp-content/themes/twentyfifteen/js/html5.js"></script>
<![endif]-->
<script>(function(html){html.className = html.className.replace(/\bno-js\b/,'js')})(document.documentElement);</script>
<title>未来车平台 &#8211; 新媒体创作者服务平台</title>
<meta name='robots' content='noindex,follow' />
<link rel='dns-prefetch' href='//fonts.googleapis.com' />
<link rel='dns-prefetch' href='//s.w.org' />
<link href='https://fonts.gstatic.com' crossorigin rel='preconnect' />
<link rel="alternate" type="application/rss+xml" title="未来车平台 &raquo; Feed" href="https://weilaiche.cc/feed" />
<link rel="alternate" type="application/rss+xml" title="未来车平台 &raquo; 评论Feed" href="https://weilaiche.cc/comments/feed" />
		<script type="text/javascript">
			window._wpemojiSettings = {"baseUrl":"https:\/\/s.w.org\/images\/core\/emoji\/2.2.1\/72x72\/","ext":".png","svgUrl":"https:\/\/s.w.org\/images\/core\/emoji\/2.2.1\/svg\/","svgExt":".svg","source":{"concatemoji":"https:\/\/weilaiche.cc\/wp-includes\/js\/wp-emoji-release.min.js?ver=4.7.53"}};
			!function(a,b,c){function d(a){var b,c,d,e,f=String.fromCharCode;if(!k||!k.fillText)return!1;switch(k.clearRect(0,0,j.width,j.height),k.textBaseline="top",k.font="600 32px Arial",a){case"flag":return k.fillText(f(55356,56826,55356,56819),0,0),!(j.toDataURL().length<3e3)&&(k.clearRect(0,0,j.width,j.height),k.fillText(f(55356,57331,65039,8205,55356,57096),0,0),b=j.toDataURL(),k.clearRect(0,0,j.width,j.height),k.fillText(f(55356,57331,55356,57096),0,0),c=j.toDataURL(),b!==c);case"emoji4":return k.fillText(f(55357,56425,55356,57341,8205,55357,56507),0,0),d=j.toDataURL(),k.clearRect(0,0,j.width,j.height),k.fillText(f(55357,56425,55356,57341,55357,56507),0,0),e=j.toDataURL(),d!==e}return!1}function e(a){var c=b.createElement("script");c.src=a,c.defer=c.type="text/javascript",b.getElementsByTagName("head")[0].appendChild(c)}var f,g,h,i,j=b.createElement("canvas"),k=j.getContext&&j.getContext("2d");for(i=Array("flag","emoji4"),c.supports={everything:!0,everythingExceptFlag:!0},h=0;h<i.length;h++)c.supports[i[h]]=d(i[h]),c.supports.everything=c.supports.everything&&c.supports[i[h]],"flag"!==i[h]&&(c.supports.everythingExceptFlag=c.supports.everythingExceptFlag&&c.supports[i[h]]);c.supports.everythingExceptFlag=c.supports.everythingExceptFlag&&!c.supports.flag,c.DOMReady=!1,c.readyCallback=function(){c.DOMReady=!0},c.supports.everything||(g=function(){c.readyCallback()},b.addEventListener?(b.addEventListener("DOMContentLoaded",g,!1),a.addEventListener("load",g,!1)):(a.attachEvent("onload",g),b.attachEvent("onreadystatechange",function(){"complete"===b.readyState&&c.readyCallback()})),f=c.source||{},f.concatemoji?e(f.concatemoji):f.wpemoji&&f.twemoji&&(e(f.twemoji),e(f.wpemoji)))}(window,document,window._wpemojiSettings);
		</script>
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
<link rel='stylesheet' id='dashicons-css'  href='https://weilaiche.cc/wp-includes/css/dashicons.min.css?ver=4.7.53' type='text/css' media='all' />
<link rel='stylesheet' id='admin-bar-css'  href='https://weilaiche.cc/wp-includes/css/admin-bar.min.css?ver=4.7.53' type='text/css' media='all' />
<link rel='stylesheet' id='cw-site-announcements-css'  href='https://weilaiche.cc/wp-content/plugins/site-announcements/public/css/cw-site-announcements-public.css?ver=1.0.3' type='text/css' media='all' />
<link rel='stylesheet' id='cw-site-announcementsanimate-css'  href='https://weilaiche.cc/wp-content/plugins/site-announcements/public/css/animate.css?ver=1.0.3' type='text/css' media='all' />
<link rel='stylesheet' id='twentyfifteen-fonts-css'  href='https://fonts.googleapis.com/css?family=Noto+Sans%3A400italic%2C700italic%2C400%2C700%7CNoto+Serif%3A400italic%2C700italic%2C400%2C700%7CInconsolata%3A400%2C700&#038;subset=latin%2Clatin-ext' type='text/css' media='all' />
<link rel='stylesheet' id='genericons-css'  href='https://weilaiche.cc/wp-content/themes/twentyfifteen/genericons/genericons.css?ver=3.2' type='text/css' media='all' />
<link rel='stylesheet' id='twentyfifteen-style-css'  href='https://weilaiche.cc/wp-content/themes/twentyfifteen/style.css?ver=4.7.53' type='text/css' media='all' />
<!--[if lt IE 9]>
<link rel='stylesheet' id='twentyfifteen-ie-css'  href='https://weilaiche.cc/wp-content/themes/twentyfifteen/css/ie.css?ver=20141010' type='text/css' media='all' />
<![endif]-->
<!--[if lt IE 8]>
<link rel='stylesheet' id='twentyfifteen-ie7-css'  href='https://weilaiche.cc/wp-content/themes/twentyfifteen/css/ie7.css?ver=20141010' type='text/css' media='all' />
<![endif]-->
<link rel='stylesheet' id='mycred-front-css'  href='https://weilaiche.cc/wp-content/plugins/mycred/assets/css/mycred-front.css?ver=1.7.9.1' type='text/css' media='all' />
<link rel='stylesheet' id='mycred-notifications-css'  href='https://weilaiche.cc/wp-content/plugins/mycred/addons/notifications/assets/css/notify.css?ver=1.1.2.2' type='text/css' media='all' />
<script type='text/javascript' src='https://weilaiche.cc/wp-content/plugins/site-announcements/public/js/js.cookie.js?ver=1.0.3'></script>
<script type='text/javascript' src='https://weilaiche.cc/wp-includes/js/jquery/jquery.js?ver=1.12.4'></script>
<script type='text/javascript' src='https://weilaiche.cc/wp-includes/js/jquery/jquery-migrate.min.js?ver=1.4.1'></script>
<link rel='https://api.w.org/' href='https://weilaiche.cc/wp-json/' />
<link rel="EditURI" type="application/rsd+xml" title="RSD" href="https://weilaiche.cc/xmlrpc.php?rsd" />
<link rel="wlwmanifest" type="application/wlwmanifest+xml" href="https://weilaiche.cc/wp-includes/wlwmanifest.xml" /> 
<meta name="generator" content="WordPress 4.7.53" />
<meta name="generator" content="Custom Login v3.2.8" />
	<style type="text/css" id="twentyfifteen-header-css">
			.site-header {

			/*
			 * No shorthand so the Customizer can override individual properties.
			 * @see https://core.trac.wordpress.org/ticket/31460
			 */
			background-image: url(https://imgs.weilaiche.cc/2018/11/top-bg-18-05-26.jpg);
			background-repeat: no-repeat;
			background-position: 50% 50%;
			-webkit-background-size: cover;
			-moz-background-size:    cover;
			-o-background-size:      cover;
			background-size:         cover;
		}

		@media screen and (min-width: 59.6875em) {
			body:before {

				/*
				 * No shorthand so the Customizer can override individual properties.
				 * @see https://core.trac.wordpress.org/ticket/31460
				 */
				background-image: url(https://imgs.weilaiche.cc/2018/11/top-bg-18-05-26.jpg);
				background-repeat: no-repeat;
				background-position: 100% 50%;
				-webkit-background-size: cover;
				-moz-background-size:    cover;
				-o-background-size:      cover;
				background-size:         cover;
				border-right: 0;
			}

			.site-header {
				background: transparent;
			}
		}
		</style>
	<style type="text/css" id="custom-background-css">
body.custom-background { background-image: url("https://imgs.weilaiche.cc/2018/11/bg-18-11.jpg"); background-position: center center; background-size: cover; background-repeat: no-repeat; background-attachment: fixed; }
</style>
<style type="text/css" media="print">#wpadminbar { display:none; }</style>
<style type="text/css" media="screen">
	html { margin-top: 32px !important; }
	* html body { margin-top: 32px !important; }
	@media screen and ( max-width: 782px ) {
		html { margin-top: 46px !important; }
		* html body { margin-top: 46px !important; }
	}
</style>
<script src="/static/jquery/3.2.1/jquery.min.js"></script>
<link href="/static/semantic-ui/2.3.1/components/icon.min.css" rel="stylesheet">
<link href="/static/semantic-ui/2.3.1/components/message.min.css" rel="stylesheet">
<link href="/static/semantic-ui/2.3.1/components/table.min.css" rel="stylesheet">
</head>

<body class="home blog logged-in admin-bar no-customize-support custom-background">
	<div id="page" class="hfeed site">
		<a class="skip-link screen-reader-text" href="#content">跳至正文</a>

		<div id="sidebar" class="sidebar">
			<header id="masthead" class="site-header" role="banner">
				<div class="site-branding">
											<h1 class="site-title"><a href="https://weilaiche.cc/" rel="home"><font color="#006699">未来车平台</font></a></h1>
											<p class="site-description"><font color="#006699">新媒体创作者服务平台</font></p>
										<button class="secondary-toggle">菜单和挂件</button>
				</div><!-- .site-branding -->
			</header><!-- .site-header -->

				<div id="secondary" class="secondary">

					<nav id="site-navigation" class="main-navigation" role="navigation">
				<div class="menu-%e9%a1%b6%e9%83%a8%e8%8f%9c%e5%8d%95-container"><ul id="menu-%e9%a1%b6%e9%83%a8%e8%8f%9c%e5%8d%95" class="nav-menu"><li id="menu-item-192" class="menu-item menu-item-type-custom menu-item-object-custom current-menu-item current_page_item menu-item-192"><a href="/">首页</a></li>
<li id="menu-item-193" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-193"><a href="https://weilaiche.cc/gonggao">投稿须知(必读)</a></li>
<li id="menu-item-291" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-291"><a href="/wp-admin/edit.php">全部文章</a></li>
<li id="menu-item-2621" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-2621"><a href="https://weilaiche.cc/getrmb">申请提现</a></li>
<li id="menu-item-248644" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-248644"><a href="https://weilaiche.cc/nav">功能大全</a></li>
</ul></div>			</nav><!-- .main-navigation -->
		
		
					<div id="widget-area" class="widget-area" role="complementary">
				<aside id="search-2" class="widget widget_search"><form role="search" method="get" class="search-form" action="https://weilaiche.cc/">
				<label>
					<span class="screen-reader-text">搜索：</span>
					<input type="search" class="search-field" placeholder="搜索&hellip;" value="" name="s" />
				</label>
				<input type="submit" class="search-submit screen-reader-text" value="搜索" />
			</form></aside><aside id="mycred_widget_wallet-3" class="widget widget-my-wallet"><h2 class="widget-title">我的账户</h2><div class="myCRED-balance mycred-balance-mycred_default">经验: 449 点</div><div class="myCRED-balance mycred-balance-mycred_money">金钱: ￥ 20 元</div></aside><aside id="calendar-2" class="widget widget_calendar"><div id="calendar_wrap" class="calendar_wrap"><table id="wp-calendar">
	<caption>2019年五月</caption>
	<thead>
	<tr>
		<th scope="col" title="星期一">一</th>
		<th scope="col" title="星期二">二</th>
		<th scope="col" title="星期三">三</th>
		<th scope="col" title="星期四">四</th>
		<th scope="col" title="星期五">五</th>
		<th scope="col" title="星期六">六</th>
		<th scope="col" title="星期日">日</th>
	</tr>
	</thead>

	<tfoot>
	<tr>
		<td colspan="3" id="prev"><a href="https://weilaiche.cc/p/date/2019/04">&laquo; 4月</a></td>
		<td class="pad">&nbsp;</td>
		<td colspan="3" id="next" class="pad">&nbsp;</td>
	</tr>
	</tfoot>

	<tbody>
	<!-- 测试查找新闻 -->
	<%
	   NewsDao nd=new NewsImpl();
	   Connection conn=DBHelper.getConnection();
	   List<News> list=nd.selectAllNews(1, conn, 1, 5);
	 request.setAttribute("list", list);
	 MyLog.log.debug("list:"+list.get(0).toString());
	 %>
	<tr>
		<td colspan="2" class="pad">&nbsp;</td><td><a href="https://weilaiche.cc/p/date/2019/05/01" aria-label="于2019年5月1日上发布的文章">1</a></td><td><a href="https://weilaiche.cc/p/date/2019/05/02" aria-label="于2019年5月2日上发布的文章">2</a></td><td><a href="https://weilaiche.cc/p/date/2019/05/03" aria-label="于2019年5月3日上发布的文章">3</a></td><td><a href="https://weilaiche.cc/p/date/2019/05/04" aria-label="于2019年5月4日上发布的文章">4</a></td><td><a href="https://weilaiche.cc/p/date/2019/05/05" aria-label="于2019年5月5日上发布的文章">5</a></td>
	</tr>
	<tr>
		<td><a href="https://weilaiche.cc/p/date/2019/05/06" aria-label="于2019年5月6日上发布的文章">6</a></td><td><a href="https://weilaiche.cc/p/date/2019/05/07" aria-label="于2019年5月7日上发布的文章">7</a></td><td><a href="https://weilaiche.cc/p/date/2019/05/08" aria-label="于2019年5月8日上发布的文章">8</a></td><td><a href="https://weilaiche.cc/p/date/2019/05/09" aria-label="于2019年5月9日上发布的文章">9</a></td><td id="today"><a href="https://weilaiche.cc/p/date/2019/05/10" aria-label="于2019年5月10日上发布的文章">10</a></td><td>11</td><td>12</td>
	</tr>
	<tr>
		<td>13</td><td>14</td><td>15</td><td>16</td><td>17</td><td>18</td><td>19</td>
	</tr>
	<tr>
		<td>20</td><td>21</td><td>22</td><td>23</td><td>24</td><td>25</td><td>26</td>
	</tr>
	<tr>
		<td>27</td><td>28</td><td>29</td><td>30</td><td>31</td>
		<td class="pad" colspan="2">&nbsp;</td>
	</tr>
	</tbody>
	</table></div></aside><aside id="categories-2" class="widget widget_categories"><h2 class="widget-title">分类目录</h2>		<ul>
	<li class="cat-item cat-item-3736"><a href="https://weilaiche.cc/c/bcd%e6%91%86%e6%88%90%e9%83%bd" >BCD摆成都</a> (101)
</li>
	<li class="cat-item cat-item-1809"><a href="https://weilaiche.cc/c/ccc%e6%97%85%e6%b8%b8%e5%9b%be%e6%96%87" >CCC旅游图文</a> (2,702)
</li>
	<li class="cat-item cat-item-5081"><a href="https://weilaiche.cc/c/lsj-js%e5%9b%be%e6%96%87" >LSJ-JS图文</a> (3)
</li>
	<li class="cat-item cat-item-1020"><a href="https://weilaiche.cc/c/lsj-%e6%97%85%e6%b8%b8%e5%9b%be%e6%96%87" >LSJ-旅游图文</a> (1,844)
</li>
	<li class="cat-item cat-item-1019"><a href="https://weilaiche.cc/c/lsj-%e6%b1%bd%e8%bd%a6%e5%9b%be%e6%96%87" >LSJ-汽车图文</a> (3,000)
</li>
	<li class="cat-item cat-item-6517"><a href="https://weilaiche.cc/c/mmc" >MMC</a> (2,516)
</li>
	<li class="cat-item cat-item-1018"><a href="https://weilaiche.cc/c/mmc%e5%86%9b%e4%ba%8b" >MMC军事</a> (1,388)
</li>
	<li class="cat-item cat-item-7144"><a href="https://weilaiche.cc/c/qzbp" >QZBP</a> (50)
</li>
	<li class="cat-item cat-item-2726"><a href="https://weilaiche.cc/c/tcy%e4%bc%81%e9%b9%85" >TCY企鹅</a> (112)
</li>
	<li class="cat-item cat-item-170"><a href="https://weilaiche.cc/c/jstw" >TCY军事图文</a> (25,634)
</li>
	<li class="cat-item cat-item-219"><a href="https://weilaiche.cc/c/tcy%e5%8e%86%e5%8f%b2%e5%9b%be%e6%96%87" >TCY历史图文</a> (718)
</li>
	<li class="cat-item cat-item-232"><a href="https://weilaiche.cc/c/tcy%e6%97%85%e6%b8%b8%e5%9b%be%e6%96%87" >TCY旅游图文</a> (5,030)
</li>
	<li class="cat-item cat-item-2"><a href="https://weilaiche.cc/c/cars" >TCY汽车图文</a> (9,329)
</li>
	<li class="cat-item cat-item-181"><a href="https://weilaiche.cc/c/tg-%e6%97%85%e6%b8%b8%e6%8e%a8%e5%b9%bf" >TG-旅游推广</a> (645)
</li>
	<li class="cat-item cat-item-177"><a href="https://weilaiche.cc/c/tgcar" >TG-汽车推广</a> (2,765)
</li>
	<li class="cat-item cat-item-195"><a href="https://weilaiche.cc/c/tg-%e7%bb%bc%e5%90%88%e5%9b%be%e6%96%87" >TG-综合图文</a> (4,690)
</li>
	<li class="cat-item cat-item-169"><a href="https://weilaiche.cc/c/txwlc" >TXWLC</a> (7,106)
</li>
	<li class="cat-item cat-item-6238"><a href="https://weilaiche.cc/c/wxt%e5%86%9b%e4%ba%8b%e5%9b%be%e6%96%87" >WXT军事图文</a> (617)
</li>
	<li class="cat-item cat-item-1017"><a href="https://weilaiche.cc/c/wxt%e6%97%85%e6%b8%b8%e5%9b%be%e6%96%87" >WXT旅游图文</a> (775)
</li>
	<li class="cat-item cat-item-477"><a href="https://weilaiche.cc/c/ytb" >YTB</a> (203)
</li>
	<li class="cat-item cat-item-7690"><a href="https://weilaiche.cc/c/%e5%88%86%e6%9e%90%e5%86%9b%e4%ba%8b" >分析军事</a> (237)
</li>
	<li class="cat-item cat-item-7692"><a href="https://weilaiche.cc/c/%e5%88%86%e6%9e%90%e6%97%85%e6%b8%b8" >分析旅游</a> (113)
</li>
	<li class="cat-item cat-item-7691"><a href="https://weilaiche.cc/c/%e5%88%86%e6%9e%90%e6%b1%bd%e8%bd%a6" >分析汽车</a> (51)
</li>
	<li class="cat-item cat-item-237"><a href="https://weilaiche.cc/c/%e5%a4%a9%e4%b8%8b%e6%9c%89%e8%ad%a6%e8%a7%86%e9%a2%91" >天下有警视频</a> (1,909)
</li>
	<li class="cat-item cat-item-3592"><a href="https://weilaiche.cc/c/douyin" >抖音视频</a> (3)
</li>
	<li class="cat-item cat-item-1"><a href="https://weilaiche.cc/c/uncategorized" >未分类</a> (15,548)
</li>
	<li class="cat-item cat-item-478"><a href="https://weilaiche.cc/c/%e6%9c%aa%e6%9d%a5%e8%bd%a6%e5%86%9b%e4%ba%8b-%e5%85%b6%e4%bb%96" >未来车军事-其他</a> (706)
</li>
	<li class="cat-item cat-item-1482"><a href="https://weilaiche.cc/c/%e6%9c%aa%e6%9d%a5%e8%bd%a6%e5%86%9b%e4%ba%8b-%e6%b5%b7%e5%a4%96" >未来车军事-海外</a> (439)
</li>
	<li class="cat-item cat-item-167"><a href="https://weilaiche.cc/c/%e6%9c%aa%e6%9d%a5%e8%bd%a6%e5%86%9b%e4%ba%8b" >未来车军事-素版</a> (4,478)
</li>
	<li class="cat-item cat-item-296"><a href="https://weilaiche.cc/c/%e6%9c%aa%e6%9d%a5%e8%bd%a6%e6%b1%bd%e8%bd%a6-%e7%8b%ac%e5%ae%b6" >未来车汽车-独家</a> (866)
</li>
	<li class="cat-item cat-item-371"><a href="https://weilaiche.cc/c/%e6%b2%b9%e7%ae%a1%e5%88%86%e6%9e%90" >油管分析</a> (332)
</li>
	<li class="cat-item cat-item-7696"><a href="https://weilaiche.cc/c/%e6%b5%b7%e5%a4%96%e6%b5%8b%e8%af%95%e7%89%88%e5%8b%bf%e5%8a%a8" >海外测试版勿动</a> (8)
</li>
	<li class="cat-item cat-item-7694"><a href="https://weilaiche.cc/c/%e7%8e%8b%e5%b0%a7%e6%a0%87%e9%a2%98" >王尧标题</a> (59)
</li>
	<li class="cat-item cat-item-519"><a href="https://weilaiche.cc/c/%e8%99%be%e5%85%b5%e6%a2%b0%e5%b0%86" >虾兵械将</a> (130)
</li>
	<li class="cat-item cat-item-7695"><a href="https://weilaiche.cc/c/%e8%a9%b9%e9%99%85%e7%90%b3%e4%bc%81%e9%b9%85" >詹际琳企鹅</a> (35)
</li>
	<li class="cat-item cat-item-173"><a href="https://weilaiche.cc/c/%e9%9d%92%e5%b2%9b" >青岛</a> (259)
</li>
		</ul>
</aside><aside id="archives-2" class="widget widget_archive"><h2 class="widget-title">文章归档</h2>		<ul>
			<li><a href='https://weilaiche.cc/p/date/2019/05'>2019年五月</a>&nbsp;(6166)</li>
	<li><a href='https://weilaiche.cc/p/date/2019/04'>2019年四月</a>&nbsp;(14499)</li>
	<li><a href='https://weilaiche.cc/p/date/2019/03'>2019年三月</a>&nbsp;(10461)</li>
	<li><a href='https://weilaiche.cc/p/date/2019/02'>2019年二月</a>&nbsp;(4799)</li>
	<li><a href='https://weilaiche.cc/p/date/2019/01'>2019年一月</a>&nbsp;(10354)</li>
	<li><a href='https://weilaiche.cc/p/date/2018/12'>2018年十二月</a>&nbsp;(7708)</li>
	<li><a href='https://weilaiche.cc/p/date/2018/11'>2018年十一月</a>&nbsp;(6266)</li>
	<li><a href='https://weilaiche.cc/p/date/2018/10'>2018年十月</a>&nbsp;(4917)</li>
	<li><a href='https://weilaiche.cc/p/date/2018/09'>2018年九月</a>&nbsp;(6940)</li>
	<li><a href='https://weilaiche.cc/p/date/2018/08'>2018年八月</a>&nbsp;(5402)</li>
	<li><a href='https://weilaiche.cc/p/date/2018/07'>2018年七月</a>&nbsp;(3083)</li>
	<li><a href='https://weilaiche.cc/p/date/2018/06'>2018年六月</a>&nbsp;(5084)</li>
	<li><a href='https://weilaiche.cc/p/date/2018/05'>2018年五月</a>&nbsp;(4183)</li>
	<li><a href='https://weilaiche.cc/p/date/2018/04'>2018年四月</a>&nbsp;(1955)</li>
	<li><a href='https://weilaiche.cc/p/date/2018/03'>2018年三月</a>&nbsp;(1004)</li>
	<li><a href='https://weilaiche.cc/p/date/2018/02'>2018年二月</a>&nbsp;(242)</li>
	<li><a href='https://weilaiche.cc/p/date/2018/01'>2018年一月</a>&nbsp;(187)</li>
	<li><a href='https://weilaiche.cc/p/date/2017/12'>2017年十二月</a>&nbsp;(315)</li>
	<li><a href='https://weilaiche.cc/p/date/2017/11'>2017年十一月</a>&nbsp;(466)</li>
	<li><a href='https://weilaiche.cc/p/date/2017/10'>2017年十月</a>&nbsp;(318)</li>
		</ul>
		</aside>			</div><!-- .widget-area -->
		
	</div><!-- .secondary -->

		</div><!-- .sidebar -->

		<div id="content" class="site-content">

<div id="primary" class="content-area">
	<main id="main" class="site-main" role="main">

	<c:forEach items="${requestScope.list }" var="listc" varStatus="cb">
	  <c:if test="${!empty listc }">
	<%MyLog.log.debug("aaa"); %>
	     <footer class="entry-footer">
	<span class="posted-on"><span class="screen-reader-text">发布于 </span><a href="/p/date/2019/05/08" rel="bookmark"><time class="entry-date published" datetime="2019-05-08T16:52:16+00:00">${listc.nupload_time}</time><time class="updated" datetime="2019-05-09T17:34:24+00:00">2019年05月09日 17:34</time></a></span><span class="byline"><span class="author vcard"><span class="screen-reader-text">作者 </span><a class="url fn n" href="https://weilaiche.cc/p/author/1996">1996</a></span></span><span class="cat-links"><span class="screen-reader-text">分类 </span><a href="https://weilaiche.cc/c/jstw" rel="category tag">TCY军事图文</a></span><span class="comments-link"><a href="https://weilaiche.cc/p/486331#respond"><span class="screen-reader-text">于wuhao070在阿富汗，为何美军不会再主动给小孩发糖?血的教训早就有了liuyu</span>留下评论</a></span>	</footer><!-- .entry-footer -->

</article><!-- #post-## -->
	<article id="post-486354" class="post-486354 post type-post status-publish format-standard hentry category-jstw">
		<header class="entry-header"><span style="color:#ffffff; background-color:#006699;">文号：486354</span><h2 class="entry-title" style="margin-bottom:15px;"><a href="https://weilaiche.cc/p/486354" rel="bookmark">${listc.title }wangyuhan</a></h2><div style="font-size:85%;margin-bottom:10px;"><span class="posted-on"><span class="screen-reader-text">发布于 </span><a href="/p/date/2019/05/08" rel="bookmark"><time class="entry-date published" datetime="2019-05-08T16:51:15+00:00">2019年05月08日 16:51</time><time class="updated" datetime="2019-05-09T17:45:34+00:00">2019年05月09日 17:45</time></a></span><span class="byline"><span class="author vcard"><span class="screen-reader-text">作者 </span><a class="url fn n" href="https://weilaiche.cc/p/author/1996">1996</a></span></span><span class="cat-links"><span class="screen-reader-text">分类 </span><a href="https://weilaiche.cc/c/jstw" rel="category tag">TCY军事图文</a></span><span class="comments-link"><a href="https://weilaiche.cc/p/486354#respond"><span class="screen-reader-text">于wuhao077除了三峡大坝之外，这中国还有两个地方不能动，动就请吃氢弹wangyuhan</span>留下评论</a></span></div>	</header><!-- .entry-header -->
	<div class="entry-content">
		
				<div class="ui tiny icon positive message">
				<i class="trophy icon"></i>
				<div class="content">
				<p>获得稿酬<span style="font-size:32px;">${listc.nsalary }元</span>，请继续加油哦！(实际总稿酬${listc.nsalary }元)</p>
				</div></div><p>${listc.ncontent } &hellip; <a href="https://weilaiche.cc/p/486354" class="more-link">继续阅读<span class="screen-reader-text">${listc.title }wangyuhan</span></a></p>
	</div><!-- .entry-content -->
	  </c:if>
	</c:forEach>	
			
			

	


	

	



	

	


</article><!-- #post-## -->

	<nav class="navigation pagination" role="navigation">
		<h2 class="screen-reader-text">文章导航</h2>
		<div class="nav-links"><span class='page-numbers current'><span class="meta-nav screen-reader-text">页 </span>1</span>
<a class='page-numbers' href='https://weilaiche.cc/page/2'><span class="meta-nav screen-reader-text">页 </span>2</a>
<span class="page-numbers dots">&hellip;</span>
<a class='page-numbers' href='https://weilaiche.cc/page/40'><span class="meta-nav screen-reader-text">页 </span>40</a>
<a class="next page-numbers" href="https://weilaiche.cc/page/2">下一页</a></div>
	</nav>
	</main><!-- .site-main -->
</div><!-- .content-area -->


</div><!-- .site-content -->

<footer id="colophon" class="site-footer" role="contentinfo">
	<div class="site-info">
		<a href="http://www.miitbeian.gov.cn/" rel="nofollow" title="工业和信息化部ICP/IP地址/域名信息备案管理系统">蜀ICP备17008803号</a>
				2019				<a href="https://weilaiche.cc/"> &copy; Copyright 未来车科技成都有限公司 版权所有</a>
			</div><!-- .site-info -->
		</footer><!-- .site-footer -->

	</div><!-- .site -->

	<script type='text/javascript' src='https://weilaiche.cc/wp-includes/js/admin-bar.min.js?ver=4.7.53'></script>
<script type='text/javascript' src='https://weilaiche.cc/wp-content/themes/twentyfifteen/js/skip-link-focus-fix.js?ver=20141010'></script>
<script type='text/javascript'>
/* <![CDATA[ */
var screenReaderText = {"expand":"<span class=\"screen-reader-text\">\u5c55\u5f00\u5b50\u83dc\u5355<\/span>","collapse":"<span class=\"screen-reader-text\">\u6298\u53e0\u5b50\u83dc\u5355<\/span>"};
/* ]]> */
</script>
<script type='text/javascript' src='https://weilaiche.cc/wp-content/themes/twentyfifteen/js/functions.js?ver=20150330'></script>
<script type='text/javascript'>
/* <![CDATA[ */
var myCRED_Notice = {"ajaxurl":"https:\/\/weilaiche.cc\/wp-admin\/admin-ajax.php","duration":"5"};
/* ]]> */
</script>
<script type='text/javascript' src='https://weilaiche.cc/wp-content/plugins/mycred/addons/notifications/assets/js/notify.js?ver=1.1.2.2'></script>
<script type='text/javascript' src='https://weilaiche.cc/wp-includes/js/wp-embed.min.js?ver=4.7.53'></script>
		<div id="wpadminbar" class="nojq nojs">
							<a class="screen-reader-shortcut" href="#wp-toolbar" tabindex="1">跳至工具栏</a>
						<div class="quicklinks" id="wp-toolbar" role="navigation" aria-label="工具栏" tabindex="0">
				<ul id="wp-admin-bar-root-default" class="ab-top-menu">
		<li id="wp-admin-bar-wp-logo" class="menupop"><a class="ab-item" aria-haspopup="true" href="https://weilaiche.cc/wp-admin/about.php"><span class="ab-icon"></span><span class="screen-reader-text">关于WordPress</span></a><div class="ab-sub-wrapper"><ul id="wp-admin-bar-wp-logo-default" class="ab-submenu">
		<li id="wp-admin-bar-about"><a class="ab-item" href="https://weilaiche.cc/wp-admin/about.php">关于WordPress</a>		</li></ul><ul id="wp-admin-bar-wp-logo-external" class="ab-sub-secondary ab-submenu">
		<li id="wp-admin-bar-wporg"><a class="ab-item" href="https://cn.wordpress.org/">WordPress.org</a>		</li>
		<li id="wp-admin-bar-documentation"><a class="ab-item" href="https://codex.wordpress.org/">文档</a>		</li>
		<li id="wp-admin-bar-support-forums"><a class="ab-item" href="http://zh-cn.forums.wordpress.org/">支持论坛</a>		</li>
		<li id="wp-admin-bar-feedback"><a class="ab-item" href="http://zh-cn.forums.wordpress.org/forum/suggestions">反馈</a>		</li></ul></div>		</li>
		<li id="wp-admin-bar-site-name" class="menupop"><a class="ab-item" aria-haspopup="true" href="https://weilaiche.cc/wp-admin/">未来车平台</a><div class="ab-sub-wrapper"><ul id="wp-admin-bar-site-name-default" class="ab-submenu">
		<li id="wp-admin-bar-dashboard"><a class="ab-item" href="https://weilaiche.cc/wp-admin/">仪表盘</a>		</li></ul></div>		</li>
		<li id="wp-admin-bar-comments"><a class="ab-item" href="https://weilaiche.cc/wp-admin/edit-comments.php"><span class="ab-icon"></span><span class="ab-label awaiting-mod pending-count count-0" aria-hidden="true">0</span><span class="screen-reader-text">0条评论待审</span></a>		</li>
		<li id="wp-admin-bar-new-content" class="menupop"><a class="ab-item" aria-haspopup="true" href="https://weilaiche.cc/wp-admin/post-new.php"><span class="ab-icon"></span><span class="ab-label">新建</span></a><div class="ab-sub-wrapper"><ul id="wp-admin-bar-new-content-default" class="ab-submenu">
		<li id="wp-admin-bar-new-post"><a class="ab-item" href="https://weilaiche.cc/wp-admin/post-new.php">文章</a>		</li></ul></div>		</li></ul><ul id="wp-admin-bar-top-secondary" class="ab-top-secondary ab-top-menu">
		<li id="wp-admin-bar-search" class="admin-bar-search"><div class="ab-item ab-empty-item" tabindex="-1"><form action="https://weilaiche.cc/" method="get" id="adminbarsearch"><input class="adminbar-input" name="s" id="adminbar-search" type="text" value="" maxlength="150" /><label for="adminbar-search" class="screen-reader-text">搜索</label><input type="submit" class="adminbar-button" value="搜索"/></form></div>		</li>
		<li id="wp-admin-bar-my-account" class="menupop with-avatar"><a class="ab-item" aria-haspopup="true" href="https://weilaiche.cc/wp-admin/profile.php">嗨，1996<img alt='' src='https://secure.gravatar.com/avatar/989d4d63bcd4bd0c59f6d2edd762ed80?s=26&#038;d=wavatar&#038;r=g' srcset='https://secure.gravatar.com/avatar/989d4d63bcd4bd0c59f6d2edd762ed80?s=52&amp;d=wavatar&amp;r=g 2x' class='avatar avatar-26 photo' height='26' width='26' /></a><div class="ab-sub-wrapper"><ul id="wp-admin-bar-user-actions" class="ab-submenu">
		<li id="wp-admin-bar-user-info"><a class="ab-item" tabindex="-1" href="https://weilaiche.cc/wp-admin/profile.php"><img alt='' src='https://secure.gravatar.com/avatar/989d4d63bcd4bd0c59f6d2edd762ed80?s=64&#038;d=wavatar&#038;r=g' srcset='https://secure.gravatar.com/avatar/989d4d63bcd4bd0c59f6d2edd762ed80?s=128&amp;d=wavatar&amp;r=g 2x' class='avatar avatar-64 photo' height='64' width='64' /><span class='display-name'>1996</span></a>		</li>
		<li id="wp-admin-bar-edit-profile"><a class="ab-item" href="https://weilaiche.cc/wp-admin/profile.php">编辑我的个人资料</a>		</li>
		<li id="wp-admin-bar-logout"><a class="ab-item" href="https://weilaiche.cc/wp-login.php?action=logout&#038;_wpnonce=38afea6a20">登出</a>		</li></ul><ul id="wp-admin-bar-my-account-default" class="ab-submenu">
		<li id="wp-admin-bar-mycred-account" class="menupop ab-sub-secondary"><div class="ab-item ab-empty-item" aria-haspopup="true">余额</div><div class="ab-sub-wrapper"><ul id="wp-admin-bar-mycred-account-default" class="ab-submenu">
		<li id="wp-admin-bar-mycred-account-balance-mycred-default"><div class="ab-item ab-empty-item">经验: 449 点</div>		</li>
		<li id="wp-admin-bar-mycred-account-history-mycred-default"><a class="ab-item" href="https://weilaiche.cc/wp-admin/users.php?page=mycred_default-history">经验 历史记录</a>		</li>
		<li id="wp-admin-bar-mycred-account-balance-mycred-money"><div class="ab-item ab-empty-item">金钱: ￥ 20 元</div>		</li>
		<li id="wp-admin-bar-mycred-account-history-mycred-money"><a class="ab-item" href="https://weilaiche.cc/wp-admin/users.php?page=mycred_money-history">金钱 历史记录</a>		</li></ul></div>		</li></ul></div>		</li></ul>			</div>
						<a class="screen-reader-shortcut" href="https://weilaiche.cc/wp-login.php?action=logout&#038;_wpnonce=38afea6a20">登出</a>
					</div>

		</body>
</html>
