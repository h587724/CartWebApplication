<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="T" uri="http://tomcat.apache.org/example-taglib" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="messages"/>

<html lang="${cookie['lang'].value}">
<head>
    <title>Title</title>
</head>
<body>
<div>
    <a href="?cookieLocale=en">English</a> &nbsp;|&nbsp;
    <a href="?cookieLocale=no">Norsk</a> &nbsp;|&nbsp;
    <a href="?cookieLocale=es">Spanish</a>
</div>
<c:set var="langCode"><fmt:message key="lang"/></c:set>
    <table border="1">
        <tr>
            <th><fmt:message key="productName"/></th>
            <th><fmt:message key="description"/></th>
            <th><fmt:message key="price"/></th>
            <th><fmt:message key="quantity"/></th>
            <th><fmt:message key="total"/></th>
        </tr>
        <jsp:useBean id="cart" scope="session" class="DAO.Cart"/>
        <c:if test="${cart.isEmpty()}">
            <tr>
                <td>
                    <fmt:message key="cartIsEmpty"/>
                </td>
            </tr>
        </c:if>
        <c:forEach var="cartItem" items="${cart.products}" varStatus="status">
            <form method="post" action="/CartController">
                    <td>
                        <c:out value="${cartItem.key.pName}"/>
                    </td>
                    <td>
                        <T:shortText limit="10"><c:out value="${descriptions[status.index].text}"/></T:shortText>
                    </td>
                    <td>
                        <c:if test="${langCode == 'en'}">
                            <c:out value="${cartItem.key.convertCurrencyToLb()}"/>
                        </c:if>
                        <c:if test="${langCode == 'no'}">
                            <c:out value="${cartItem.key.convertCurrencyToNok()}"/>
                        </c:if>
                        <c:if test="${langCode == 'es'}">
                            <c:out value="${cartItem.key.convertCurrencyToEur()}"/>
                        </c:if>
                        <fmt:message key="currency"/>
                    </td>
                    <td>
                        <c:out value="${cartItem.value}"></c:out>
                    </td>
                    <td>
                        <c:if test="${langCode == 'en'}">
                            <c:out value="${cartItem.key.convertCurrencyToLb() * cartItem.value}"/>
                        </c:if>
                        <c:if test="${langCode == 'no'}">
                            <c:out value="${cartItem.key.convertCurrencyToNok() * cartItem.value}"/>
                        </c:if>
                        <c:if test="${langCode == 'es'}">
                            <c:out value="${cartItem.key.convertCurrencyToEur() * cartItem.value}"/>
                        </c:if>
                        <fmt:message key="currency"/>
                    </td>
                </tr>
            </form>
        </c:forEach>
    </table>
<a href url="http://localhost:8080/Oblig2"><fmt:message key="goHome"/></a>&nbsp;|&nbsp;
<a href url="/view/Product.jsp"><fmt:message key="goToProducts"/></a>
</body>
</html>
