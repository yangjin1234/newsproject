
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
<html lang="zh-CN" class="no-js">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width">
	<link rel="profile" href="http://gmpg.org/xfn/11">
	<link rel="pingback" href="./xmlrpc.php">
	<!--[if lt IE 9]>
	<script src="./wp-content/themes/twentyfifteen/js/html5.js"></script>
<![endif]-->
<script>(function(html){html.className = html.className.replace(/\bno-js\b/,'js')})(document.documentElement);</script>
<title>新媒体平台 &#8211; 新媒体创作者服务平台</title>
<meta name='robots' content='noindex,follow' />
<link rel='dns-prefetch' href='//fonts.googleapis.com' />
<link rel='dns-prefetch' href='//s.w.org' />
<link href='https://fonts.gstatic.com' crossorigin rel='preconnect' />
<link rel="alternate" type="application/rss+xml" title="新媒体平台 &raquo; Feed" href="./feed" />
<link rel="alternate" type="application/rss+xml" title="新媒体平台 &raquo; 评论Feed" href="./comments/feed" />
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
<link rel='stylesheet' id='dashicons-css'  href='./wp-includes/css/dashicons.min.css?ver=4.7.53' type='text/css' media='all' />
<link rel='stylesheet' id='admin-bar-css'  href='./wp-includes/css/admin-bar.min.css?ver=4.7.53' type='text/css' media='all' />
<link rel='stylesheet' id='cw-site-announcements-css'  href='./wp-content/plugins/site-announcements/public/css/cw-site-announcements-public.css?ver=1.0.3' type='text/css' media='all' />
<link rel='stylesheet' id='cw-site-announcementsanimate-css'  href='./wp-content/plugins/site-announcements/public/css/animate.css?ver=1.0.3' type='text/css' media='all' />
<link rel='stylesheet' id='twentyfifteen-fonts-css'  href='https://fonts.googleapis.com/css?family=Noto+Sans%3A400italic%2C700italic%2C400%2C700%7CNoto+Serif%3A400italic%2C700italic%2C400%2C700%7CInconsolata%3A400%2C700&#038;subset=latin%2Clatin-ext' type='text/css' media='all' />
<link rel='stylesheet' id='genericons-css'  href='./wp-content/themes/twentyfifteen/genericons/genericons.css?ver=3.2' type='text/css' media='all' />
<link rel='stylesheet' id='twentyfifteen-style-css'  href='./wp-content/themes/twentyfifteen/style.css?ver=4.7.53' type='text/css' media='all' />
<!--[if lt IE 9]>
<link rel='stylesheet' id='twentyfifteen-ie-css'  href='./wp-content/themes/twentyfifteen/css/ie.css?ver=20141010' type='text/css' media='all' />
<![endif]-->
<!--[if lt IE 8]>
<link rel='stylesheet' id='twentyfifteen-ie7-css'  href='./wp-content/themes/twentyfifteen/css/ie7.css?ver=20141010' type='text/css' media='all' />
<![endif]-->
<link rel='stylesheet' id='mycred-front-css'  href='http://weilaiche.cc/wp-content/plugins/mycred/assets/css/mycred-front.css?ver=1.7.9.1' type='text/css' media='all' />
<link rel='stylesheet' id='mycred-notifications-css'  href='./wp-content/plugins/mycred/addons/notifications/assets/css/notify.css?ver=1.1.2.2' type='text/css' media='all' />
<script type='text/javascript' src='./wp-content/plugins/site-announcements/public/js/js.cookie.js?ver=1.0.3'></script>
<script type='text/javascript' src='./wp-includes/js/jquery/jquery.js?ver=1.12.4'></script>
<script type='text/javascript' src='./wp-includes/js/jquery/jquery-migrate.min.js?ver=1.4.1'></script>
<link rel='https://api.w.org/' href='./wp-json/' />
<link rel="EditURI" type="application/rsd+xml" title="RSD" href="./xmlrpc.php?rsd" />
<link rel="wlwmanifest" type="application/wlwmanifest+xml" href="./wp-includes/wlwmanifest.xml" /> 
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
<script src="http://weilaiche.cc/static/jquery/3.2.1/jquery.min.js"></script>
<link href="http://weilaiche.cc/static/semantic-ui/2.3.1/components/icon.min.css" rel="stylesheet">
<link href="http://weilaiche.cc/static/semantic-ui/2.3.1/components/message.min.css" rel="stylesheet">
<link href="http://weilaiche.cc/static/semantic-ui/2.3.1/components/table.min.css" rel="stylesheet">
</head>

<body class="home blog logged-in admin-bar no-customize-support custom-background">
	<div id="page" class="hfeed site">
		<a class="skip-link screen-reader-text" href="#content">跳至正文</a>

		<div id="sidebar" class="sidebar">
			<header id="masthead" class="site-header" role="banner">
				<div class="site-branding">
											<h1 class="site-title"><a href="./" rel="home"><font color="#006699">新媒体平台</font></a></h1>
											<p class="site-description"><font color="#006699">新媒体创作者服务平台</font></p>
										<button class="secondary-toggle">菜单和挂件</button>
				</div><!-- .site-branding -->
			</header><!-- .site-header -->

				<div id="secondary" class="secondary">

					<nav id="site-navigation" class="main-navigation" role="navigation">
				<div class="menu-%e9%a1%b6%e9%83%a8%e8%8f%9c%e5%8d%95-container"><ul id="menu-%e9%a1%b6%e9%83%a8%e8%8f%9c%e5%8d%95" class="nav-menu"><li id="menu-item-192" class="menu-item menu-item-type-custom menu-item-object-custom current-menu-item current_page_item menu-item-192"><a href=MainShow.jsp>首页</a></li>
<li id="menu-item-193" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-193"><a href="needs.jsp">投稿须知(必读)</a></li>
<li id="menu-item-291" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-291"><a href="edit.jsp">全部文章</a></li>
<li id="menu-item-248644" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-248644"><a href="./nav">功能大全</a></li>
<li id="menu-item-2486" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-2486"><a href="notify.jsp">查看公告</a></li>
</ul></div>			</nav><!-- .main-navigation -->
		
		
					<div id="widget-area" class="widget-area" role="complementary">
				<aside id="search-2" class="widget widget_search"><form role="search" method="get" class="search-form" action="./">
				<label>
					<span class="screen-reader-text">搜索：</span>
					<input type="search" class="search-field" placeholder="搜索&hellip;" value="" name="s" />
				</label>
				<input type="submit" class="search-submit screen-reader-text" value="搜索" />
			</form></aside><aside id="mycred_widget_wallet-3" class="widget widget-my-wallet"><h2 class="widget-title">我的账户</h2><div class="myCRED-balance mycred-balance-mycred_money">已发放: ￥${sessionScope.yesalary } 元</div><div class="myCRED-balance mycred-balance-mycred_money">待发放: ￥${sessionScope.nosalary } 元</div></aside><aside id="calendar-2" class="widget widget_calendar"><div id="calendar_wrap" class="calendar_wrap"><table id="wp-calendar">
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
		<td colspan="3" id="prev"><a href="./p/date/2019/04">&laquo; 4月</a></td>
		<td class="pad">&nbsp;</td>
		<td colspan="3" id="next" class="pad">&nbsp;</td>
	</tr>
	</tfoot>

	<tbody>
	<%
	   NewsDao nd=new NewsDaoImpl();
	 TypeDao td=new TypeDaoImpl();
	   Connection conn=DBHelper.getConnection();
	LoginDao ld=new LoginDaoImpl();
	 List<TypeImpl> list2=td.selectAllType(conn);
	 //得到登录用户
	 LoginImpl log=new LoginImpl();
	 log=(LoginImpl)request.getSession().getAttribute("account");
	 //得到id
	 Login logf=ld.selectUserPassByName(log.getLname(), conn);
	 session.setAttribute("logf", logf);
	 request.setAttribute("type", list2);
	 List<TimeTypec> list3=nd.selectAllByTime(conn, logf.getLid());
	 MyLog.log.debug(list3.toString());
	 request.setAttribute("timetype", list3);
	 String uname=logf.getLname(),upass=logf.getLpass();
	//查出待发放的工资
	double nosalary=nd.selectSumSalaryNo(logf.getLid(), conn,0);
	//查出已发放的工资
	double yesalary=nd.selectSumSalaryNo(logf.getLid(), conn,1);
	request.getSession().setAttribute("nosalary", nosalary);
	request.getSession().setAttribute("yesalary", yesalary);
	MyLog.log.debug("nosalary="+nosalary);
	//每页显示文章数量
	int maxSize=2;
	  pageContext.setAttribute("maxSize", maxSize);
	//最大页数
	//int maxPage=nd.getMaxPage(conn, maxSize);
	int maxPage=nd.getMaxPageByUid(conn, maxSize, logf.getLid());
	
	//当前页数
	int pageNo=0;
	if(request.getParameter("pageNo")==null){
	 pageNo=1;
	}else{
	pageNo=Integer.valueOf(request.getParameter("pageNo"));
	}
	pageContext.setAttribute("pageNo", pageNo);
	   List<NewsImpl> list=null;
	   
	   //按类型分类
	  String typeName=request.getParameter("typec");
	  
	  if(typeName==null||typeName.equals("")){
	   list=nd.selectAllNews(logf.getLid(), conn, pageNo, maxSize);
	   MyLog.log.debug("list="+list.size());
	  }else {
	 // if(!"".equals(typeName)){
	  list=nd.selectNewsByTypeName(logf.getLid(), conn, typeName, pageNo, maxSize);
	  maxPage=nd.selectNewsByTypeNameForMaxSize(logf.getLid(), conn, typeName,maxSize);
	  MyLog.log.debug("typeName="+typeName);
	  request.setAttribute("typec", typeName);
	  MyLog.log.debug("maxPage232="+maxPage);
	  }
	//  }
	//  按时间分类
	  String timetypecName=request.getParameter("timetypec");
	  if(timetypecName!=null){
	  if(!"".equals(timetypecName)){
	  maxPage=nd.selectNewsByTimeForMaxSize(logf.getLid(), conn, timetypecName,maxSize);
	  list=nd.selectNewsByTime(logf.getLid(), conn, timetypecName, pageNo, maxSize);
	  request.setAttribute("timetypecName", timetypecName);
	  MyLog.log.debug("timetypecName="+timetypecName);
	  MyLog.log.debug(list.size());
	  }
	  }
	  
	MyLog.log.debug("maxPage"+maxPage);
	 //存到cookie
	 Cookie c1 = new Cookie("uname",URLEncoder.encode(uname, "UTF-8"));
	    		c1.setDomain("localhost");
	    		c1.setPath("/Newsproject");
	    		c1.setMaxAge(60*60*24);
	    		response.addCookie(c1);
    			Cookie c2 = new Cookie("upass",upass);
	    		c2.setDomain("localhost");
	    		c2.setPath("/Newsproject");
	    		c2.setMaxAge(60*60*24);
	    		response.addCookie(c2);
	    //从请求中拿到cookies
	     Cookie[] cookies = request.getCookies();
    		String valname = null;
    		String valpass = null;
    		//循环所有的cookie，得到我需要的数据
    		if(cookies!=null){
	    		for(Cookie c : cookies){
	    			String key = c.getName();
	    				MyLog.log.debug("key="+key);
	    			if("uname".equals(key)){
	    				valname = c.getValue();
	    				MyLog.log.debug("valname="+valname);
	    				//解码
	    				valname = URLDecoder.decode(valname, "UTF-8");
	    			}
	    			if("upass".equals(key)){
	    				valpass = c.getValue();
	    			}
	    		}
    		}
    		//把用户名存到list中
    for(NewsImpl li:list){
	 li.setUname(uname);
	 }
    
	  request.setAttribute("list", list);
	pageContext.setAttribute("maxPage", maxPage);
	DBHelper.closeCon(conn);
	 %>
	<tr>
		<td colspan="2" class="pad">&nbsp;</td><td><a href="./p/date/2019/05/01" aria-label="于2019年5月1日上发布的文章">1</a></td><td><a href="./p/date/2019/05/02" aria-label="于2019年5月2日上发布的文章">2</a></td><td><a href="./p/date/2019/05/03" aria-label="于2019年5月3日上发布的文章">3</a></td><td><a href="./p/date/2019/05/04" aria-label="于2019年5月4日上发布的文章">4</a></td><td><a href="./p/date/2019/05/05" aria-label="于2019年5月5日上发布的文章">5</a></td>
	</tr>
	<tr>
		<td><a href="./p/date/2019/05/06" aria-label="于2019年5月6日上发布的文章">6</a></td><td><a href="./p/date/2019/05/07" aria-label="于2019年5月7日上发布的文章">7</a></td><td><a href="./p/date/2019/05/08" aria-label="于2019年5月8日上发布的文章">8</a></td><td><a href="./p/date/2019/05/09" aria-label="于2019年5月9日上发布的文章">9</a></td><td><a href="./p/date/2019/05/10" aria-label="于2019年5月10日上发布的文章">10</a></td><td><a href="./p/date/2019/05/11" aria-label="于2019年5月11日上发布的文章">11</a></td><td><a href="./p/date/2019/05/12" aria-label="于2019年5月12日上发布的文章">12</a></td>
	</tr>
	<tr>
		<td id="today"><a href="./p/date/2019/05/13" aria-label="于2019年5月13日上发布的文章">13</a></td><td>14</td><td>15</td><td>16</td><td>17</td><td>18</td><td>19</td>
	</tr>
	<tr>
		<td>20</td><td>21</td><td>22</td><td>23</td><td>24</td><td>25</td><td>26</td>
	</tr>
	<tr>
		<td>27</td><td>28</td><td>29</td><td>30</td><td>31</td>
		<td class="pad" colspan="2">&nbsp;</td>
	</tr>
	</tbody>
	</table></div></aside><aside id="categories-2" class="widget widget_categories"><h2 class="widget-title">分类目录</h2>		<ul><c:forEach items="${requestScope.type }" var="typec" varStatus="cb">
	<li class="cat-item cat-item-173"><a href="MainShow.jsp?typec=${typec.tname }" >${typec.tname }</a> (${typec.number })
</li>
	</c:forEach>
</ul>
</aside><aside id="archives-2" class="widget widget_archive"><h2 class="widget-title">文章归档</h2>		<ul>
	<c:forEach items="${requestScope.timetype }" var="timetypec" varStatus="cb">
	
	<li><a href='MainShow.jsp?timetypec=${timetypec.timec }'>${timetypec.timec}</a>&nbsp;(${timetypec.number })</li>
	</c:forEach></ul>
		</aside>			</div><!-- .widget-area -->
		
	</div><!-- .secondary -->

		</div><!-- .sidebar -->

		<div id="content" class="site-content">

<div id="primary" class="content-area">
	<main id="main" class="site-main" role="main">

		<c:forEach items="${requestScope.list }" var="listc" varStatus="cb">
	  <c:if test="${!empty listc }">
	    


	<article id="post-486354" class="post-486354 post type-post status-publish format-standard hentry category-jstw">
		<header class="entry-header"><span style="color:#ffffff; background-color:#006699;">文号：${listc.nid }</span><h2 class="entry-title" style="margin-bottom:15px;"><a href="./p/486354" rel="bookmark">${listc.title }</a></h2><div style="font-size:85%;margin-bottom:10px;"><span class="posted-on"><span class="screen-reader-text">发布于 </span><a href="/p/date/2019/05/08" rel="bookmark"><time class="entry-date published" datetime="2019-05-08T16:51:15+00:00">2019年05月08日 16:51</time><time class="updated" datetime="2019-05-09T17:45:34+00:00">2019年05月09日 17:45</time></a></span><span class="byline"><span class="author vcard"><span class="screen-reader-text">作者 </span><a class="url fn n" href="./p/author/1996">${listc.uname }</a></span></span><span class="cat-links"><span class="screen-reader-text">分类 </span><a href="./c/jstw" rel="category tag">${listc.typename }</a></span><span class="comments-link"><a href="./p/486354#respond"></span></div>	</header><!-- .entry-header -->
	<div class="entry-content">
		
				<div class="ui tiny icon positive message">
				<i class="trophy icon"></i>
				<div class="content">
				<p>获得稿酬<span style="font-size:32px;">${listc.nsalary }元</span>，请继续加油哦！(实际总稿酬${listc.nsalary }元)</p>
				</div></div><p>${listc.ncontent } &hellip; <span class="screen-reader-text">${listc.title }wangyuhan</span></a></p>
	</div><!-- .entry-content -->
	</article><!-- #post-## -->
	  </c:if>
	</c:forEach>	
	


	<nav class="navigation pagination" role="navigation">
		<h2 class="screen-reader-text">文章导航</h2>
		<div class="nav-links"><!-- <span class='page-numbers current'><span class="meta-nav screen-reader-text">页 </span>1</span>
<a class='page-numbers' href='./page/2'><span class="meta-nav screen-reader-text">页 </span>2</a>
<span class="page-numbers dots">&hellip;</span>
<a class='page-numbers' href='./page/40'><span class="meta-nav screen-reader-text">页 </span>40</a>
<a class="next page-numbers" href="Newsproject.jsp">下一页</a> -->

 当前是第${pageNo }页&nbsp;&nbsp;总共有${maxPage }页&nbsp;&nbsp;
   <a href="MainShow.jsp?pageNo=${1 }&pageSize=${maxSize }&typec=${typec }&timetypec=${timetypecName}"> 首页</a>&nbsp;&nbsp;
    <c:if test="${pageNo ge 2 }">
   <a href="MainShow.jsp?pageNo=${pageNo-1 }&pageSize=${maxSize }&typec=${typec }&timetypec=${timetypecName}"> 上一页</a>
   </c:if>
   
   <c:forEach begin="1" end="${maxPage }" var="i">
      <c:if test="${i ge pageNo-2 and i le pageNo+2 }">
        <a class='page-numbers' href="MainShow.jsp?pageNo=${i }&pageSize=${maxSize }&typec=${typec }&timetypec=${timetypecName}"><span class="meta-nav screen-reader-text">页 </span>${i }</a>&nbsp;&nbsp;
      </c:if>
   </c:forEach>
   
   <c:if test="${pageNo le maxPage-1 }">
   <a href="MainShow.jsp?pageNo=${pageNo+1 }&pageSize=${maxSize }&typec=${typec }&timetypec=${timetypecName}"> 下一页</a>&nbsp;&nbsp;
   </c:if>
   <a href="MainShow.jsp?pageNo=${maxPage }&pageSize=${maxSize }&typec=${typec }&timetypec=${timetypecName}"> 尾页</a>&nbsp;&nbsp;


</div>

	</nav>
	</main><!-- .site-main -->
</div><!-- .content-area -->


</div><!-- .site-content -->

<footer id="colophon" class="site-footer" role="contentinfo">
	<div class="site-info">
		<a href="http://www.miitbeian.gov.cn/" rel="nofollow" title="工业和信息化部ICP/IP地址/域名信息备案管理系统">蜀ICP备17008803号</a>
				2019				<a href="./"> &copy; Copyright 未来车科技成都有限公司 版权所有</a>
			</div><!-- .site-info -->
		</footer><!-- .site-footer -->

	</div><!-- .site -->

	<script type='text/javascript' src='./wp-includes/js/admin-bar.min.js?ver=4.7.53'></script>
<script type='text/javascript' src='http://weilaiche.cc/wp-content/themes/twentyfifteen/js/skip-link-focus-fix.js?ver=20141010'></script>
<script type='text/javascript'>
/* <![CDATA[ */
var screenReaderText = {"expand":"<span class=\"screen-reader-text\">\u5c55\u5f00\u5b50\u83dc\u5355<\/span>","collapse":"<span class=\"screen-reader-text\">\u6298\u53e0\u5b50\u83dc\u5355<\/span>"};
/* ]]> */
</script>
<script type='text/javascript' src='http://weilaiche.cc/wp-content/themes/twentyfifteen/js/functions.js?ver=20150330'></script>
<script type='text/javascript'>
/* <![CDATA[ */
var myCRED_Notice = {"ajaxurl":"https:\/\/weilaiche.cc\/wp-admin\/admin-ajax.php","duration":"5"};
/* ]]> */
</script>
<script type='text/javascript' src='./wp-content/plugins/mycred/addons/notifications/assets/js/notify.js?ver=1.1.2.2'></script>
<script type='text/javascript' src='./wp-includes/js/wp-embed.min.js?ver=4.7.53'></script>
		<div id="wpadminbar" class="nojq nojs">
							<a class="screen-reader-shortcut" href="#wp-toolbar" tabindex="1">跳至工具栏</a>
						<div class="quicklinks" id="wp-toolbar" role="navigation" aria-label="工具栏" tabindex="0">
				<ul id="wp-admin-bar-root-default" class="ab-top-menu">
		<li id="wp-admin-bar-wp-logo" class="menupop"><a class="ab-item" aria-haspopup="true" href="./wp-admin/about.php"><span class="ab-icon"></span><span class="screen-reader-text">关于WordPress</span></a><div class="ab-sub-wrapper"><ul id="wp-admin-bar-wp-logo-default" class="ab-submenu">
		<li id="wp-admin-bar-about"><a class="ab-item" href="./wp-admin/about.php">关于WordPress</a>		</li></ul><ul id="wp-admin-bar-wp-logo-external" class="ab-sub-secondary ab-submenu">
		<li id="wp-admin-bar-wporg"><a class="ab-item" href="https://cn.wordpress.org/">WordPress.org</a>		</li>
		<li id="wp-admin-bar-documentation"><a class="ab-item" href="https://codex.wordpress.org/">文档</a>		</li>
		<li id="wp-admin-bar-support-forums"><a class="ab-item" href="http://zh-cn.forums.wordpress.org/">支持论坛</a>		</li>
		<li id="wp-admin-bar-feedback"><a class="ab-item" href="http://zh-cn.forums.wordpress.org/forum/suggestions">反馈</a>		</li></ul></div>		</li>
		<li id="wp-admin-bar-site-name" class="menupop"><a class="ab-item" aria-haspopup="true" href="./wp-admin/">新媒体平台</a><div class="ab-sub-wrapper"><ul id="wp-admin-bar-site-name-default" class="ab-submenu">
		<li id="wp-admin-bar-dashboard"><a class="ab-item" href="./wp-admin/">仪表盘</a>		</li></ul></div>		</li>
		<li id="wp-admin-bar-comments"><a class="ab-item" href="./wp-admin/edit-comments.php"><span class="ab-icon"></span><span class="ab-label awaiting-mod pending-count count-0" aria-hidden="true">0</span><span class="screen-reader-text">0条评论待审</span></a>		</li>
		<li id="wp-admin-bar-new-content" class="menupop"><a class="ab-item" aria-haspopup="true" href="./post-new.jsp"><span class="ab-icon"></span><span class="ab-label">新建</span></a><div class="ab-sub-wrapper"><ul id="wp-admin-bar-new-content-default" class="ab-submenu">
		<li id="wp-admin-bar-new-post"><a class="ab-item" href="./post-new.jsp">文章</a>		</li></ul></div>		</li></ul><ul id="wp-admin-bar-top-secondary" class="ab-top-secondary ab-top-menu">
		<li id="wp-admin-bar-search" class="admin-bar-search"><div class="ab-item ab-empty-item" tabindex="-1"><form action="./" method="get" id="adminbarsearch"><input class="adminbar-input" name="s" id="adminbar-search" type="text" value="" maxlength="150" /><label for="adminbar-search" class="screen-reader-text">搜索</label><input type="submit" class="adminbar-button" value="搜索"/></form></div>		</li>
		<li id="wp-admin-bar-my-account" class="menupop with-avatar"><a class="ab-item" aria-haspopup="true" href="./wp-admin/profile.php">嗨，${sessionScope.account.lname }<img alt='' src='https://secure.gravatar.com/avatar/989d4d63bcd4bd0c59f6d2edd762ed80?s=26&#038;d=wavatar&#038;r=g' srcset='https://secure.gravatar.com/avatar/989d4d63bcd4bd0c59f6d2edd762ed80?s=52&amp;d=wavatar&amp;r=g 2x' class='avatar avatar-26 photo' height='26' width='26' /></a><div class="ab-sub-wrapper"><ul id="wp-admin-bar-user-actions" class="ab-submenu">
		<li id="wp-admin-bar-user-info"><a class="ab-item" tabindex="-1" href="./wp-admin/profile.php"><img alt='' src='https://secure.gravatar.com/avatar/989d4d63bcd4bd0c59f6d2edd762ed80?s=64&#038;d=wavatar&#038;r=g' srcset='https://secure.gravatar.com/avatar/989d4d63bcd4bd0c59f6d2edd762ed80?s=128&amp;d=wavatar&amp;r=g 2x' class='avatar avatar-64 photo' height='64' width='64' /><span class='display-name'>${sessionScope.account.lname }</span></a>		</li>
		<li id="wp-admin-bar-edit-profile"><a class="ab-item" href="http://localhost:8080/Newsproject/profile1.do?param=selectUser">编辑我的个人资料</a>		</li>
		<li id="wp-admin-bar-logout"><a class="ab-item" href="./login.jsp?action=logout&#038;_wpnonce=ec87a18305">登出</a>		</li></ul><ul id="wp-admin-bar-my-account-default" class="ab-submenu">
		<li id="wp-admin-bar-mycred-account" class="menupop ab-sub-secondary"><div class="ab-item ab-empty-item" aria-haspopup="true">余额</div><div class="ab-sub-wrapper"><ul id="wp-admin-bar-mycred-account-default" class="ab-submenu">
		<li id="wp-admin-bar-mycred-account-balance-mycred-default"><div class="ab-item ab-empty-item">以获得: ￥ ${sessionScope.yesalary }</div>		</li>
		<li id="wp-admin-bar-mycred-account-balance-mycred-money"><div class="ab-item ab-empty-item">待发放: ￥ ${sessionScope.nosalary } 元</div>		</li>
		<li id="wp-admin-bar-mycred-account-history-mycred-money"><a class="ab-item" href="./wp-admin/users.php?page=mycred_money-history">金钱 历史记录</a>		</li></ul></div>		</li></ul></div>		</li></ul>			</div>
						<a class="screen-reader-shortcut" href="./wp-login.php?action=logout&#038;_wpnonce=ec87a18305">登出</a>
					</div>

		</body>
</html>
