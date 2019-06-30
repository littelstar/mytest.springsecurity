<%--
  Created by IntelliJ IDEA.
  User: 17864
  Date: 2019/6/22
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录页面</title>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
</head>
<body>
<c:if test="${not empty param.error}">
    <font color="red">密码或用户名错误请重新登陆</font>
</c:if>
<form  id="loginForm" method="post">
   用户名： <input type="text" name="username"><br>
    密码：<input type="password" name="password">
    <br>验证码<input type="text" name="imageCode"><img src="${pageContext.request.contextPath}/imageCode">
    <br>记住我<input type="checkbox" name="remember-me" value="true">
    <br><input type="button" id="loginbtn" value="提交" >
</form>
<script type="text/javascript">
    $(function(){
        $("#loginbtn").click(function () {
            $.post("${pageContext.request.contextPath}/login",$("#loginForm").serialize(),function (data) {
                if(data.success){
                    window.location.href="${pageContext.request.contextPath}/index"
                }else{
                    alert("错误信息"+data.errorMsg);
                }
            },"json")
        })
    })

</script>
</body>
</html>
