<%--
  Created by IntelliJ IDEA.
  User: a11
  Date: 27.09.2021
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${param.lang}">
<head>
    <title>Home</title>
</head>
<body>
<fmt:message key="label.chooseSessionLocale"/>
    <div>
        <a href="?lang=en">Home (English)</a> &nbsp;|&nbsp;
        <a href="?lang=no">Home (Norsk)</a> &nbsp;|&nbsp;
        <a href="?lang=es">Home (Spanish)</a> &nbsp;|&nbsp;
    </div>
    <p><fmt:message key="label.text"/>
        <h1>KEK</h1>
    <a href="view/Product.jsp"><fmt:message key="label.productText"/></a>
    </p>
    <c:if test="${not empty param.sessionLocale}">
        <fmt:message key="label.cookieChangeSuccess"/>
        <button><a href="Product.jsp"><fmt:message key="label.productText"/></a></button>
    </c:if>
</body>
</html>

