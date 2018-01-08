<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>页面顶部</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="Bookmark" href="${pageContext.request.contextPath}/resources/image/favicon.ico">
    <link rel="Shortcut Icon" href="${pageContext.request.contextPath}/resources/image/favicon.ico"/>
    <link href='${pageContext.request.contextPath}/template/resources/skin/skin.css' rel='stylesheet' type='text/css'>
    <link href="${pageContext.request.contextPath}/template/resources/layui/css/layui.css" rel='stylesheet'
          type='text/css'>
    <script src="${pageContext.request.contextPath}/template/resources/layui/layui.js" charset="utf-8"></script>
    <style>
        body {
            margin: 5px;
        }

        .demo-carousel {
            height: 200px;
            line-height: 200px;
            text-align: center;
        }
    </style>
</head>
<div class=wrapper_chunbg>
    <div class=wrapper>
        <div class=retrieve>
            <div class=logo><span class=logo><a href="/index">
                    <img title=雨桐科技 height=77 alt=雨桐科技
                         src="${pageContext.request.contextPath}/template/resources/images/logo.png" width=400></a>
                </span>
            </div>
            <div class=search id=search style="width: 550px">
                <div class=search_top>
                    <div id=ajaxdata2>
                    </div>
                    <div id=ajaxTip>
                    </div>
                    <div class=optionBox>
                        <table>
                            <tr>
                                <td id=weather-date style="PaDDING-RIGHT: 0px" align=right></td>
                            </tr>
                            <tr>
                                <td style="PaDDING-RIGHT: 0px" align=right>
                                    <table align=right>
                                        <tr>
                                            <td id=weather-date style="padding-right: 20px;padding-top: 2px">
                                                <%--<iframe id="fancybox-frame" name="fancybox-frame1511583918660"
                                                        frameborder="0" scrolling="no" hspace="0" width="260"
                                                        height="25"
                                                        src="http://i.tianqi.com/index.php?c=code&a=getcode&id=34&h=25&w=280">
                                                </iframe>--%>
                                                <iframe src="//www.seniverse.com/weather/weather.aspx?uid=UF102139A8&cid=CHHA000000&l=zh-CHS&p=SMART&a=0&u=C&s=4&m=2&x=1&d=1&fc=&bgc=&bc=&ti=0&in=0&li="
                                                        frameborder="0" scrolling="no" width="380" height="25"
                                                        allowTransparency="true">
                                                </iframe>
                                            </td>

                                            <td class="opt">
                                                <a href="${pageContext.request.contextPath}/admin/index"
                                                   tyle="cursor: pointer">网站管理</a>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class=clear>
                    </div>
                </div>
                <div class=dot_line>
                </div>
                <div class=search_bottom>
                    <marquee class="a" width="300px" onmouseover="this.stop()" onmouseout="this.start()" scrolldelay="180">
                        <font color=#ff0000>最新发布:</font>
                        <c:forEach items="${newsList}" var="news">
                            <font color=#ccc>|</font>
                            <a href='${pageContext.request.contextPath}/detail/${news.id}'>${news.title}</a>
                        </c:forEach>
                    </marquee>
                </div>
            </div>
            <div class='clear'>
            </div>
        </div>
    </div>
    <div class=nav_wrapper_back>
        <ul class="layui-nav" style="background-color: #0E4C92">
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/index">首页</a></li>
            <c:forEach items="${menus}" var="menu">
                <li class="layui-nav-item">
                    <c:if test="${fn:length(menu.list)!=0}">
                        <a href="javascript:;">${menu.name}</a>
                    </c:if>
                    <c:if test="${fn:length(menu.list)==0}">
                        <a href="${pageContext.request.contextPath}/list/${menu.id}">${menu.name}</a>
                    </c:if>
                    <c:if test="${fn:length(menu.list)!=0}">
                        <dl class="layui-nav-child">
                            <c:forEach items="${menu.list}" var="menu1">
                                <dd style="text-align: center"><a href="${pageContext.request.contextPath}/list/${menu1.id}">${menu1.name}</a></dd>
                            </c:forEach>
                        </dl>
                    </c:if>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
<script>
    layui.use('element', function () {
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

        //监听导航点击
        element.on('nav(demo)', function (elem) {
            //console.log(elem)
            layer.msg(elem.text());
        });
    });
</script>