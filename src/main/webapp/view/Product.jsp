<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="messages"/>

<html lang="${cookie['lang'].value}">
<head>
    <title>Products</title>
</head>
<body>
    <div>
        <a href="?cookieLocale=en">English</a> &nbsp;|&nbsp;
        <a href="?cookieLocale=no">Norsk</a> &nbsp;|&nbsp;
        <a href="?cookieLocale=es">Spanish</a>
    </div>
    <c:set var="langCode"><fmt:message key="lang"/></c:set>
    <c:set var="addToCart"><fmt:message key="addToCart"/></c:set>
    <c:forEach items="${products}" var="product" varStatus="status">
        <form action="/ProductsController" method="post">
        <h2><c:out value="${status.index + 1}"/>. <c:out value="${product.pName}"/></h2>
        <input type="hidden" name="productNo" value="${status.index}"/>
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
        <fmt:message key="description"/>: <c:out value="${descriptions[status.index].text}"/><br>
        <input type="hidden" name="action" value="add">
        <input type="submit" name="addToCart" value="${addToCart}">
        <br><br><br>
        </form>
    </c:forEach>
    <a href url="http://localhost:8080/Oblig2/"><fmt:message key="goHome"/></a>&nbsp;|&nbsp;
    <a href url="http://localhost:8080/Oblig2/ProductsController"><fmt:message key="goToCart"/></a>
</body>
</html>
