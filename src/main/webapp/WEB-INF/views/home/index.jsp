<%--
  Created by IntelliJ IDEA.
  User: zahidul
  Date: 3/7/19
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>

    <script>
        window.menu = '${title}';
        window.contextRoot = '${contextRoot}'
    </script>
    <script type="text/javascript">
        var BASEURL = "<c:url value="/" />";
    </script>
<%--    <script src='<c:url value="/WEB-INF/resources/jQuery/jQuery-2.1.4.min.js"/>'></script>--%>

    <%--<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
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
    <link rel="stylesheet" href="<c:url value="/resources/css/index.css"/> ">

--%>

    <script src="<c:url value="/resources/datatable/jquery.dataTables.js"></c:url> "></script>
    <script src="<c:url value="/resources/datatable/dataTables.bootstrap.js"></c:url> "></script>


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

<%--    <link rel="text/javascript" href="<c:url value="/resources/scripts/helper.js"/> ">--%>

</head>
<body>

<div class="wrapper">

    <%@include file="/WEB-INF/views/shared/navbar.jsp"%>


    <div id="main-body" class="content">
        <c:choose>

            <c:when test="${userClickHome == true }">
                <%@include file="/WEB-INF/views/home.jsp" %>
            </c:when>

            <c:when test="${userClickBurger == true }">
                <%@include file="/WEB-INF/views/burger.jsp" %>
            </c:when>

            <c:when test="${userClickMeatMeal == true }">
                <%@include file="/WEB-INF/views/meatMeal.jsp" %>
            </c:when>

            <c:when test="${userClickPizza == true }">
                <%@include file="/WEB-INF/views/pizza.jsp" %>
            </c:when>

            <c:when test="${userClickRiceMeal == true }">
                <%@include file="/WEB-INF/views/riceMeal.jsp" %>
            </c:when>

            <c:when test="${userClickSnack == true }">
                <%@include file="/WEB-INF/views/meatMeal.jsp" %>
            </c:when>

            <c:when test="${userClickDrink == true }">
                <%@include file="/WEB-INF/views/drink.jsp" %>
            </c:when>

            <c:when test="${userClickSingleItem == true}">
                <%@include file="/WEB-INF/views/shared/itemDetails.jsp" %>
            </c:when>

            <c:otherwise>
                <%@include file="/WEB-INF/views/home.jsp"%>
            </c:otherwise>
        </c:choose>

    </div>

</div>

<%@include file="/WEB-INF/views/modal/helperModal.jsp"%>
<%@include file="/WEB-INF/views/shared/footer.jsp"%>


<script src="/resources/assets/js/jquery.js"></script>
<script src="/resources/assets/js/jquery.dataTables.js"></script>
<script src="/resources/assets/js/bootstrap.js"></script>
<script src="/resources/assets/js/dataTables.bootstrap.js"></script>

<script src="<c:url value="/resources/scripts/helper.js"/>"></script>



</body>
</html>


