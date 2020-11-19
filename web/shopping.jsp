<%-- 
    Document   : Shopping
    Created on : Oct 20, 2020, 1:15:57 PM
    Author     : Tan DaT
--%>

<%@page import="java.util.List"%>
<%@page import="datvt.tblitem.tblItemDTO"%>
<%@page import="datvt.tblitem.tblItemDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Market</title>
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
        <a href="view">View Cart</a>||
        <a href="logout">Logout</a>
        <h1>Book Market</h1>

        <form action="searchitem">
            Search Item <input type="text" name="txtkey" value="${param.txtkey}" />
            <input type="submit" value="Search Item" name="btAction" />
        </form>

        <c:set var="searchValue" value="${param.txtkey}"/>
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCHITEM}"/>
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Add Item</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                        <form action="additem">

                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.id}
                                    <input type="hidden" name="txtid" value="${dto.id}" />
                                </td>
                                <td>${dto.name}
                                    <input type="hidden" name="txtname" value="${dto.name}" />
                                </td>
                                <td>${dto.price}
                                    <input type="hidden" name="txtprice" value="${dto.price}" />
                                </td>
                                <td>
                                    <input type="submit" value="Add Item" name="btAction" />
                                    <input type="hidden" name="lastSearchValue" value="${searchValue}" />
                                </td>
                            </tr>

                        </form>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>
        <c:choose>
            <c:when test="${null == result}" >
                <h1> No result </h1>
            </c:when>

        </c:choose>
    </c:if>

    
</body>
</html>
