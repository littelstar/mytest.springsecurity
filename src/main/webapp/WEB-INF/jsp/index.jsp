<%--
  Created by IntelliJ IDEA.
  User: 17864
  Date: 2019/6/20
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>商品展示</title>
</head>
<body>
<h1>尊敬的${user}会员，欢迎您</h1>
<security:authorize access="permitAll()">
    <a href="${pageContext.request.contextPath}/product/list">商品展示</a>
</security:authorize>
<security:authorize access="hasAuthority('ROLE_OPERATION')">
    <a href="${pageContext.request.contextPath}/product/save">商品保存</a>
    <a href="${pageContext.request.contextPath}/product/del">商品删除</a>
    <a href="${pageContext.request.contextPath}/product/update">商品更新</a>
</security:authorize>


</body>
</html>
