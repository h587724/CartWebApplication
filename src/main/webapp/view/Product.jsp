<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: a11
  Date: 27.09.2021
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="messages"/>

<html lang="${cookie['lang'].value}">
<head>
    <title>Products</title>
</head>
<body>
    <div>
        <a href="?cookieLocale=en">Home (English) </a> &nbsp;|&nbsp;
        <a href="?cookieLocale=no">Home (Norsk)  </a> &nbsp;|&nbsp;
        <a href="?cookieLocale=es">Home (Spanish)  </a>
    </div>
    <c:set var="langCode"><fmt:message key="lang"/></c:set>

    <c:forEach items="${products}" var="product" varStatus="status">
        <h2><c:out value="${status.index + 1}"/>. <c:out value="${product.pName}"/></h2>
        <img alt="Store image" align="left" src="http://localhost:8080/Oblig2/view/images/${product.imageFile}" width="10%" height="10%"/>
        <fmt:message key="productName"/>: <c:out value="${product.pName}"/><br>
        <fmt:message key="price"/>:
            <c:if test="${langCode == 'en'}">
                <c:out value="${product.convertCurrencyToLb()}"/>
            </c:if>
            <c:if test="${langCode == 'no'}">
                <c:out value="${product.convertCurrencyToNok()}"/>
            </c:if>
            <c:if test="${langCode == 'es'}">
                <c:out value="${product.convertCurrencyToEur()}"/>
            </c:if>
        <fmt:message key="currency"/><br>
        <c:out value="${descriptions[status.index].text}"/><br><br><br>
    </c:forEach>
    <a href="http://localhost:8080/Oblig2/ProductsController">Show products</a>
</body>
</html>
