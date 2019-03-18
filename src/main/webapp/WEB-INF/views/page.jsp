<%--
  Created by IntelliJ IDEA.
  User: zahidul
  Date: 3/8/19
  Time: 12:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%--
<spring:url var="css" value="../bootstrap/css" />
<spring:url var="js" value="../bootstrap/js" />
<spring:url var="images" value="/images" />
--%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Restaurant</title>

    <script>
        window.menu = '${title}';
        window.contextRoot = '${contextRoot}'

    </script>

<%--    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstarp Readable theme -->
    &lt;%&ndash; <link href="${css}/bootstarp-readable-theme.css" rel="stylesheet"> &ndash;%&gt;

    <!-- Bootstarp dataTable -->
    <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/myapp.css" rel="stylesheet">--%>
<%--//---------------------------------------------------------------------------------------%>

    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <link rel="stylesheet" type='text/css' href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" type='text/css' href="https://cdn.datatables.net/responsive/2.1.1/css/responsive.bootstrap.min.css">

    <link rel="stylesheet" type='text/css' href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>

<body>

<div class="wrapper">
    <!-- Navigation -->
    <%@include file="./shared/navbar.jsp" %>

    <!-- Page Content -->

    <div class="content">
        <!-- HomePage -->
        <c:if test="${userClickHome == true }">
            <%@include file="home.jsp" %>
        </c:if>

        <c:if test="${userClickAbout == true }">
            <%@include file="burger.jsp" %>
        </c:if>

        <c:if test="${userClickContact == true }">
            <%@include file="pizza.jsp" %>
        </c:if>

        <c:if test="${userClickAllProducts == true or userClickCategoryProducts==true }">
            <%@include file="drink.jsp" %>
        </c:if>

    </div>

    <!-- Footer -->
    <%@include file="./shared/footer.jsp" %>

    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.js"></script>
    <script src="${js}/bootstrap.min.js"></script>

    <!-- Jquery DataTables Plugin -->
    <script src="${js}/jquery.dataTables.js"></script>


    <!-- Jquery DataTables Plugin -->
    <script src="${js}/dataTables.bootstrap.js"></script>


    <script src="${js}/myapp.js"></script>

</div>

</body>

</html>
