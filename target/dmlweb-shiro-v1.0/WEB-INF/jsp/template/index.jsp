<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>雨桐科技 >>首页</title>
</head>
<body>
<div>
    <!--导航条 begin-->
    <jsp:include page="top.jsp"></jsp:include>
    <!--导航条 end-->
    <div class=wrapper_chunbg>
        <div class=wrapper id=SUBD1381214931076128>
            <img src="${pageContext.request.contextPath}/template/resources/images/top_banner.jpg" width="100%"
                 alt="全景图"/>
        </div>
        <div class=vspace style="height: 15px">
        </div>
        <div class=wrapper id=SUBD1381215937510740>
            <div class=col_w660 id=SUBD1381215944667744>
                <div class="layui-carousel" id="carousel">
                    <div carousel-item="">
                        <c:forEach items="${bannerImgs}" var="bannerImg">
                            <div align="center"><img style="height: 100%;"
                                                     src="${pageContext.request.contextPath}${bannerImg.loadpath}">
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <script>
                    layui.use(['carousel', 'form'], function () {
                        var carousel = layui.carousel
                            , form = layui.form;
                        //图片轮播
                        carousel.render({
                            elem: '#carousel'
                            , width: '540px'
                            , height: '350px'
                            , interval: 3000
                        });
                    });
                </script>
            </div>
        </div>
        <div class=col_w320 id=subd1381215944667745>
            <div class=headline>
                <div class=elmt1383789430582535>
                    <div class="hd_text" style="height: 190px;margin-top: 10px;">
                        <h3>
                            <a style="color: #b71900;" href="${pageContext.request.contextPath}/modelList/${offices.get(0).id}"
                            >新闻动态</a>
                            <span class=hr>
                                <a href="${pageContext.request.contextPath}/modelList/${offices.get(0).id}" >更多&nbsp;&nbsp;</a>
                            </span>
                        </h3>
                        <h4>
                            <div class="title_list t03">
                                <table width="100%" cellpadding="0" cellspacing="0">
                                    <c:forEach items="${offices.get(0).newsList}" var="news">
                                        <tr>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/detail/${news.id}" >${news.title}</a>
                                                    <%--<img src="${pageContext.request.contextPath}/template/resources/images/new.gif"
                                                         alt="最新文章">--%>
                                            </td>
                                            <td align="right" style="background: url('')" width="40"><font
                                                <%--color="red"--%>>${news.createDate}</font></td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </h4>
                    </div>
                </div>
                <div class=elmt1383789430582535>
                    <div class="hd_text" style="height: 190px">
                        <h3>
                            <a style="color: #b71900;" href="${pageContext.request.contextPath}/modelList/${offices.get(1).id}"
                               >通知通报</a>
                            <span class=hr>
                                <a href="${pageContext.request.contextPath}/modelList/${offices.get(1).id}" >更多&nbsp;&nbsp;</a>
                            </span>
                        </h3>
                        <h4>
                            <div class="title_list t03">
                                <table width="100%" cellpadding="0" cellspacing="0">
                                    <c:forEach items="${offices.get(1).newsList}" var="news">
                                        <tr>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/detail/${news.id}" >${news.title}</a>
                                                    <%--<img src="${pageContext.request.contextPath}/template/resources/images/new.gif"
                                                         alt="最新文章">--%>
                                            </td>
                                            <td align="right" style="background: url('')" width="40"><font
                                                <%--color="red"--%>>${news.createDate}</font></td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </h4>
                    </div>
                </div>
            </div>
        </div>
        <div class=clear>
        </div>
    </div>
    <div class=vspace style="height: 1px">
    </div>
    <div class=wrapper id=subd1381309447140184>
        <c:forEach items="${depts}" var="dept" varStatus="status">
        <c:if test="${status.count<=3}">
        <c:if test="${status.count==1}">
        <div class="col_w320_fl" id=subd1381309472005197>
            </c:if>
            <c:if test="${status.count==2}">
            <div class="col_w320_m" id=subd1381309472005197>
                </c:if>
                <c:if test="${status.count==3}">
                <div class="col_w3201" id=subd1381309472005197>
                    </c:if>
                    <div class=elmt1381388552781535>
                        <div class=model>
                            <div class=mhd id=subd1381388552785537>
                        <span class=thd>
                            <a href="${pageContext.request.contextPath}/list/${dept.deptId}" >${dept.code}</a>
                        </span>
                            </div>
                            <div class=mbd id=subd1381388552785538>
                                <div class=elmt1381388975863877>
                                    <div class=vspace style="height: 1px"></div>
                                    <ul class=channel>
                                        <li class=chan02>
                                            <div class=box>
                                                <c:forEach items="${dept.list}" var="office">
                                                    <a href="${pageContext.request.contextPath}/modelList/${office.id}"
                                                       >${office.name}</a><b>|</b>
                                                </c:forEach>
                                                <a class=all href="${pageContext.request.contextPath}/list/${dept.deptId}" >全部栏目&gt;&gt;</a>
                                            </div>
                                        </li>
                                    </ul>
                                    <div class="title_list t03">
                                        <table width="100%" cellpadding="0" cellspacing="0">
                                            <c:forEach items="${dept.newsList}" var="udonBean">
                                                <tr>
                                                    <td>
                                                        <a href="${pageContext.request.contextPath}/detail/${udonBean.newsId}"
                                                           >${udonBean.title}</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </c:if>
                </c:forEach>
                <div class=clear>
                </div>
                <div class=vspace style="height: 1px">
                </div>
            </div>
        </div>
    </div>
    <div class=wrapper id=subd1381309447140184>
        <c:forEach items="${depts}" var="dept" varStatus="status">
        <c:if test="${status.count>3 and status.count <=6}">
        <c:if test="${status.count==4}">
        <div class="col_w320_fl" id=subd1381309472005197>
            </c:if>
            <c:if test="${status.count==5}">
            <div class="col_w320_m" id=subd1381309472005197>
                </c:if>
                <c:if test="${status.count==6}">
                <div class="col_w3201" id=subd1381309472005197>
                    </c:if>
                    <div class=elmt1381388552781535>
                        <div class=model>
                            <div class=mhd id=subd1381388552785537>
                        <span class=thd>
                            <a href="${pageContext.request.contextPath}/list/${dept.deptId}" >${dept.code}</a>
                        </span>
                            </div>
                            <div class=mbd id=subd1381388552785538>
                                <div class=elmt1381388975863877>
                                    <div class=vspace style="height: 1px"></div>
                                    <ul class=channel>
                                        <li class=chan02>
                                            <div class=box>
                                                <c:forEach items="${dept.list}" var="office">
                                                    <a href="${pageContext.request.contextPath}/modelList/${office.id}"
                                                       >${office.name}</a><b>|</b>
                                                </c:forEach>
                                                <a class=all href="${pageContext.request.contextPath}/list/${dept.deptId}" >全部栏目&gt;&gt;</a>
                                            </div>
                                        </li>
                                    </ul>
                                    <div class="title_list t03">
                                        <table width="100%" cellpadding="0" cellspacing="0">
                                            <c:forEach items="${dept.newsList}" var="udonBean">
                                                <tr>
                                                    <td>
                                                        <a href="${pageContext.request.contextPath}/detail/${udonBean.newsId}"
                                                        >${udonBean.title}</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </c:if>
                </c:forEach>
                <div class=clear>
                </div>
                <div class=vspace style="height: 1px">
                </div>
            </div>
        </div>
    </div>

    <div class=wrapper id=subd1381462002146821>
        <div class=elmt1381462064696863>
            <div class="model mod03">
                <div class=mhd>
                    <span class=title>
                        <a href="hdfb/showclass07e1.html?classid=26" >专题活动</a>
                    </span>
                </div>
                <div class=mbd>
                    <div class=scrollbox id=scrollbox07>
                        <div class=scrollmid1>
                            <div class="mlist mlist01" style=" text-align:center;">
                                <a href="xwzx/showclass30b7.html?classid=169" target="_blank">
                                    <img src="${pageContext.request.contextPath}/template/resources/images/zhuanti.jpg"
                                         width="990" height="237"/>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class=vspace style="height: 14px">
    </div>
    <div class=wrapper id=subd1381309447140184>
        <c:forEach items="${depts}" var="dept" varStatus="status">
        <c:if test="${status.count>6 and status.count <=9}">
        <c:if test="${status.count==7}">
        <div class="col_w320_fl" id=subd1381309472005197>
            </c:if>
            <c:if test="${status.count==8}">
            <div class="col_w320_m" id=subd1381309472005197>
                </c:if>
                <c:if test="${status.count==9}">
                <div class="col_w3201" id=subd1381309472005197>
                    </c:if>
                    <div class=elmt1381388552781535>
                        <div class=model>
                            <div class=mhd id=subd1381388552785537>
                        <span class=thd>
                            <a href="${pageContext.request.contextPath}/list/${dept.id}" >${dept.code}</a>
                        </span>
                            </div>
                            <div class=mbd id=subd1381388552785538>
                                <div class=elmt1381388975863877>
                                    <div class=vspace style="height: 1px"></div>
                                    <ul class=channel>
                                        <li class=chan02>
                                            <div class=box>
                                                <c:forEach items="${dept.list}" var="office">
                                                    <a href="${pageContext.request.contextPath}/modelList/${office.id}"
                                                       >${office.name}</a><b>|</b>
                                                </c:forEach>
                                                <a class=all href="${pageContext.request.contextPath}/list/${dept.deptId}" >全部栏目&gt;&gt;</a>
                                            </div>
                                        </li>
                                    </ul>
                                    <div class="title_list t03">
                                        <table width="100%" cellpadding="0" cellspacing="0">
                                            <c:forEach items="${dept.newsList}" var="udonBean">
                                                <tr>
                                                    <td>
                                                        <a href="${pageContext.request.contextPath}/detail/${udonBean.newsId}"
                                                        >${udonBean.title}</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </c:if>
                </c:forEach>
                <div class=clear>
                </div>
                <div class=vspace style="height: 1px">
                </div>
            </div>
        </div>
    </div>
    <div>
        <jsp:include page="bottom.jsp"></jsp:include>
    </div>
</div>
</body>
</html>