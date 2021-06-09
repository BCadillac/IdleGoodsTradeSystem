<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>购买</title>
    <style>
        .showMessage{
            text-align: center;
        }
    </style>

</head>

<body>
    <%@include file="top.jsp" %>
    <div class="showMessage">
        <p style='color:green'>${successMessage }</p>
        <p style='color:red'>${failMessage }</p>
        
    </div>

</body>

</html>