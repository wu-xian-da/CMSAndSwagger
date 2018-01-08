<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>雨桐科技 >>部门</title>
</head>
<body>
<div>
    <!--导航条 begin-->
    <jsp:include page="top.jsp"></jsp:include>
    <!--导航条 end-->
    <div class=wrapper_chunbg>
        <table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="32" background="${pageContext.request.contextPath}/template/resources/skin/dmlIcon/32.gif">
                    <img src="${pageContext.request.contextPath}/template/resources/skin/dmlIcon/jiantou026.gif"
                         border="0" align="absmiddle">
                    当前位置：&nbsp;
                    <a class='LinkPath' href='${pageContext.request.contextPath}/index'>雨桐科技</a>&nbsp;>&nbsp;
                    <a class='LinkPath' href='javascript:;'>${dept.name}</a>
                </td>
            </tr>
            <tr>
                <td height="8"></td>
            </tr>
        </table>
        <table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td width="226" valign="top">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0"
                           class="dmlIcon_biangkuan bg_phototitle01">
                        <tr>
                            <td height="32"
                                background="${pageContext.request.contextPath}/template/resources/skin/dmlIcon/column_title.gif">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td width="79%" class="dmlIcon_tabletitle3">　栏目导航</td>
                                        <td width="21%"><a href="#"></a></td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td height="50" align="center">
                                <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td height="50" align="center" id="link_tupian2"><br>&nbsp;
                                            <c:forEach items="${dept.list}" var="office">
                                                <a class='childclass' href='${pageContext.request.contextPath}/modelList/${office.id}'
                                                >${office.name}</a><br>&nbsp;
                                            </c:forEach>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </td>
                <td width="8" valign="top">&nbsp;</td>
                <td valign="top">
                    <table width="100%" border="0" cellpadding="0" cellspacing="0"
                           class="dmlIcon_biangkuan bg_phototitle01">
                        <tr>
                            <td height="32"
                                background="${pageContext.request.contextPath}/template/resources/skin/sznc/ss01.gif"
                                class="dmlIcon_tabletitle3">
                                ${dept.name}
                            </td>
                        </tr>
                        <tr>
                            <td height="8"></td>
                        </tr>
                        <tr>
                            <td>
                                <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td>
                                            <table width="100%" cellpadding="0" cellspacing="0" align="center">
                                                <c:forEach items="${dept.newsList}" var="udonBean">
                                                    <tr>
                                                        <td width="10" valign="top" class="bbb">
                                                            <img src="${pageContext.request.contextPath}/template/resources/images/article_common.gif"
                                                                 alt="普通文章">
                                                        </td>
                                                        <td class="bbb">
                                                            <a class="aaa"
                                                               href="${pageContext.request.contextPath}/detail/${udonBean.newsId}">${udonBean.title}</a>
                                                        </td>
                                                        <td align="right" class="bbb"
                                                            width="200">${udonBean.createDate}</td>
                                                    </tr>
                                                </c:forEach>
                                            </table>
                                            <br>
                                            <!--分页插件-->
                                            <%--<div id="page" style="text-align: center"></div>--%>
                                            <%--<div class="show_page">共 <b>437</b> 篇文章&nbsp;&nbsp;&nbsp;首页 | 上一页 | <font
                                                    color="FF0000">1</font> <a href="Index4658.html?page=2">2</a> <a
                                                    href="Index9ba9.html?page=3">3</a> <a
                                                    href="Indexfdb0.html?page=4">4</a> <a
                                                    href="Indexaf4d.html?page=5">5</a> <a
                                                    href="Indexc575.html?page=6">6</a> <a
                                                    href="Index235c.html?page=7">7</a> <a
                                                    href="Indexfdfa.html?page=8">8</a> <a
                                                    href="Index0b08.html?page=9">9</a> | <a
                                                    href='Index4658.html?page=2'>下一页</a> |<a
                                                    href='Index3c09.html?page=22'> 尾页</a>&nbsp;<b>20</b>篇文章/页&nbsp;&nbsp;转到第<Input
                                                    type='text' name='page' size='3' maxlength='5' value='1'
                                                    onKeyPress="if (event.keyCode==13) window.location='Indexa54e.html?page='+this.value;">页
                                            </div>--%>
                                        </td>
                                    </tr>
                                    <%--<tr>
                                        <td height="20"></td>
                                    </tr>--%>
                                </table>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <div class=clear>
        </div>
        <div class=vspace style="height: 1px">
        </div>
        <jsp:include page="bottom.jsp"></jsp:include>
    </div>
</div>
<script>
    layui.use(['laypage', 'layer'], function () {
        var laypage = layui.laypage
            , layer = layui.layer;
        //完整功能
        laypage.render({
            elem: 'page'
            , count: 1000
            , layout: ['prev', 'page', 'next', 'count']
            , jump: function (obj) {
                console.log(obj)
            }
        });
    });
</script>
</body>
</html>