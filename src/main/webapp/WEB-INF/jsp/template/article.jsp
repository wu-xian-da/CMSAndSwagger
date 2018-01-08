<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>雨桐科技 >>文章</title>
</head>
<body>
<div>
    <!--导航条 begin-->
    <jsp:include page="top.jsp"></jsp:include>
    <!--导航条 end-->
    <div class='wrapper_chunbg' align="center">
        <table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="32" background="${pageContext.request.contextPath}/template/resources/skin/dmlIcon/32.gif">
                    <img src="${pageContext.request.contextPath}/template/resources/skin/dmlIcon/jiantou026.gif"
                         border="0" align="absmiddle">
                    当前位置：&nbsp;
                    <a class='LinkPath' href='${pageContext.request.contextPath}/index'>雨桐科技</a>&nbsp;>&nbsp;
                    <a class='LinkPath' href='${pageContext.request.contextPath}/list/${dept.id}'>${dept.name}</a>&nbsp;>&nbsp;
                    <a class='LinkPath' href='javascript:;'>${office.name}</a>
                </td>
            </tr>
            <tr>
                <td height="8"></td>
            </tr>
        </table>
        <table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="250" valign="top" class="biankuan_hui4 bg_bodytop" align="center">
                    <table width="94%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                            <td height="80" align="center" class="title_hei18">${udonBean.title}</td>
                        </tr>
                        <tr>
                            <td height="5">
                                <div class="xian_huixuheng"></div>
                            </td>
                        </tr>
                        <tr>
                            <td height="30" align="center">
                                作者：${udonBean.createName}&nbsp;&nbsp;&nbsp;&nbsp;文章来源：${udonBean.deptName}&nbsp;&nbsp;&nbsp;&nbsp;点击数：${udonBean.count}&nbsp;&nbsp;&nbsp;&nbsp;更新时间：<fmt:formatDate
                                    value="${udonBean.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/><%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
                                <%--<font color='#009999'>★★★</font>--%>
                            </td>
                        </tr>
                        <tr>
                            <td height="5">
                                <div class="xian_huixuheng"></div>
                            </td>
                        </tr>
                        <tr>
                            <td height="35"></td>
                        </tr>
                        <tr>
                            <td height="450" valign="top">
                                ${udonBean.content}
                                <c:forEach items="${files}" var="file">
                                    附件:<a style="color:#C00000;text-decoration:none;"
                                    href="${file[0]}" download="${file[1]}">点击下载：${file[1]}</a>
                                </c:forEach>
                            </td>
                        </tr>


                        <tr>
                            <td height="2">
                                <div class="xian_huixuheng"></div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <table width="100%" border="0" cellpadding="6" cellspacing="0" bgcolor="#F3F8FF">
                                    <tr>
                                        <td width="50%"></td>
                                        <td width="50%"></td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td height="2">
                                <div class="xian_huixuheng"></div>
                            </td>
                        </tr>
                        <tr>
                            <td height="20"></td>
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
</body>
</html>