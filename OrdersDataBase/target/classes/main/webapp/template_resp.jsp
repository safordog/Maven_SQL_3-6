<%@ page import="main.java.controller.NewClientServlet" %><%--
  Created by IntelliJ IDEA.
  User: safordog
  Date: 06.10.18
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/styles/styles.css"/>
    <title>ORDERS DB</title>
</head>
<body>
    <fieldset>
        <div id="logo">
            <u>MANAGEMENT INTERFACE</u>
        </div>
        <div id="content">
        <br><% if (request.getAttribute("addedClientMessage") != null) {%>
                <%= request.getAttribute("addedClientMessage") %>
           <% } %>
            <% if (request.getAttribute("addedGoodsMessage") != null) {%>
            <%= request.getAttribute("addedGoodsMessage") %>
            <% } %>
            <% if (request.getAttribute("stockRoomMessage") != null) {%>
            <%= request.getAttribute("stockRoomMessage") %>
            <% } %>
            <% if (request.getAttribute("orderCompleteMessage") != null) {%>
            <%= request.getAttribute("orderCompleteMessage") %>
            <% } %>
        </div>
    </fieldset>
</body>
</html>
