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


<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="messages"/>

<html lang="${cookie['lang'].value}">
<head>
    <title>Home</title>
</head>
<body>
    <h1>Kaffekopper AS</h1>
    <div>
        <a href="?cookieLocale=en">Home (English) </a> &nbsp;|&nbsp;
        <a href="?cookieLocale=no">Home (Norsk)  </a> &nbsp;|&nbsp;
        <a href="?cookieLocale=es">Home (Spanish)  </a>
    </div><br>
    <img alt="Store image" src="http://localhost:8080/Oblig2/view/images/store.jpg" width="35%" height="40%"/>
    <p><fmt:message key="homeText"/>
        <a href="http://localhost:8080/Oblig2/HomeController"><fmt:message key="homeProduct"/></a>
    </p>
</body>
</html>

