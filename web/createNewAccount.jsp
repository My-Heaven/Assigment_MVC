<%-- 
    Document   : createNewAccount
    Created on : Nov 2, 2020, 1:33:33 PM
    Author     : Tan DaT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
        <link rel="stylesheet" href="css/layout.css" />
    </head>
    <body>
        <h1>Create New Account</h1>
        <form action="create" method="POST">
            <c:set var="errors" value="${requestScope.CREATEERR}"/>
            Username*<input type="text" name="txtusername" value="${param.txtusername}" /></br>
            <c:if test="${not empty errors.usernameLengError}">
                <font color="red">
                ${errors.usernameLengError}
                </font>  </br>
            </c:if>
            Password* <input type="password" name="txtpassword" value="" /></br>
            <c:if test="${not empty errors.passwordLengError}">
                <font color="red">
                ${errors.passwordLengError}
                </font>  </br>
            </c:if>
            Confirm* <input type="password" name="txtconfirm" value="" /></br>
            <c:if test="${not empty errors.confirmNotMatched}">
                <font color="red">
                ${errors.confirmNotMatched}
                </font>  </br>
            </c:if>
            Full name* <input type="text" name="txtfullname" value="${param.txtfullname}" /></br>
            <c:if test="${not empty errors.fullnameLengError}">
                <font color="red">
                ${errors.fullnameLengError}
                </font></br>
            </c:if>
            <input type="submit" value="Create New Account" name="btAction" />
            <input type="reset" value="Reset" /></br>
            <c:if test="${not empty errors.usernameIsExisted}">
                <font color="red">
                ${errors.usernameIsExisted}
                </font>  
            </c:if>
        </form>
        <a href="loginP">Go to login</a>
    </body>
</html>
