<%-- 
    Document   : view
    Created on : Oct 20, 2020, 10:18:06 PM
    Author     : Tan DaT
--%>

<%@page import="datvt.tblitem.tblItemDTO"%>
<%@page import="java.util.Map"%>
<%@page import="datvt.tblitem.CartObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
        <link rel="stylesheet" href="css/layout.css" />
    </head>
    <body>
        <c:set var="username" value="${USERNAME}"/>
        <c:if test="${empty username}">
            <c:redirect url="logout"/>
        </c:if>
        <font color =" green ">
        Welcome, ${sessionScope.FULLNAME}
        </font>||
        <a href="searchP">Search Account</a>||
        <a href="logout">Logout</a>
        <h1>Your Cart</h1>
        <c:set var="cart" value="${sessionScope.CUSTCART1}" />
        <c:if test="${not empty cart}">
            <c:set var="item" value="${cart.item}"/>
            <c:if test="${not empty item}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Total</th>
                            <th>Quantity</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <form action="removeitem">
                        <tbody>

                            <c:forEach var="dto" items="${item}" varStatus="counter">
                                <tr>
                                    <td>${counter.count}</th>
                                    <td>${dto.key}</td>
                                    <td>${dto.value.name}</td>
                                    <td>${dto.value.price*dto.value.quantity}</td>
                                    <td>${dto.value.quantity}</td>
                                    <td>
                                        <input type="checkbox" name="chkitem" 
                                               value="${dto.key}" />
                                    </td>
                                </tr>

                                <c:set var="total" value="${total + dto.value.price*dto.value.quantity}"></c:set>
                            </c:forEach>


                        <td colspan="5">

                            <a href="shopping"> Add more book to cart</a>

                        </td>
                        <td>
                            <input type="submit" value="Remove Selected Book" name="btAction" />
                        </td>                                                            
                        </tbody>
                    </form>
                </table>
                
                <c:url var="urlRewriting" value="checkout">
                    <%--<c:param name="btAction" value="checkout"></c:param>--%>
                </c:url>
                <h1>Total: ${total} || <a href="${urlRewriting}">CheckOut</a> </h1>
                
            </c:if>

            <c:choose>
                <c:when test="${empty item}">
                    <h1> Cart have no item</h1> 
                    <a href="shopping"> Add book to cart</a>
                </c:when>

            </c:choose> 
        </c:if>
        <c:choose>
            <c:when test="${empty cart}">
                <h2> Cart have no item</h2> 
                <a href="shopping"> Add more book to cart</a>
            </c:when>

        </c:choose> 
    </body>
</html>
