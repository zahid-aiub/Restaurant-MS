<%@ page import="com.workspaceit.entity.Customer" %>
<%@ page import="com.workspaceit.entity.Admin" %>
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
        var URL = "<c:url value='${window.location.href}'/>";
        var BASEURL = '${pageContext.request.contextPath}';
        console.log(URL);
        console.log(BASEURL);
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
    <link rel="stylesheet" href="<c:url value="/resources/css/index.css"/> ">
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="<c:url value="/resources/css/jquery.growl.css"/> ">
    <script src="<c:url value="/resources/scripts/jquery.growl.js"></c:url> "></script>


</head>
<body>

<%--<%
    if (session.getAttribute("name") ==null)
        response.sendRedirect("redirect.jsp");
%>--%>

<%
    int id = 0;
    String phone = "";
    String name = "";
    if (session.getAttribute("user") != null){
        Customer session_val = (Customer) session.getAttribute("user");
        id = session_val.getId();
        name = session_val.getName();
        phone = session_val.getPhone();
    }
    else {
        if(session.getAttribute("admin") != null) {
            Admin admin_session_val = (Admin) session.getAttribute("admin");
            id = -1;
            name = admin_session_val.getName();
        }
    }
%>


<div class="wrapper">

    <%@include file="/WEB-INF/views/shared/navbar.jsp"%>

    <script type="text/javascript">
        var id = '<%=id%>';
        var name= '<%=name%>';
        console.log("Id: "+ id +" --- Login user: "+ name);
        if (id >0) {
            $('#nameSpace').text("Welcome "+name);
            $('#profile').show();
            $('#signInBtn').hide();
            $('#addProduct').hide();
            $('#adminLogout').hide();
        }
        else if (id < 0)  {
            $('#profile').hide();
            $('#signInBtn').hide();
            $('#adminLogout').show();
            $('#nameSpace').text("Hi "+name);
            $('#nameSpace').show();
            $('#addProduct').show();
        }
        else {
            $('#nameSpace').hide();
            $('#signInBtn').show();
            $('#profile').hide();
            $('#adminLogout').hide();
            $('#addProduct').hide();
        }
    </script>


    <div id="main-body" class="content">
        <c:choose>

            <c:when test="${userClickHome == true || userClickLogout == true}">
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
                <%@include file="/WEB-INF/views/snack.jsp" %>
            </c:when>

            <c:when test="${userClickDrink == true }">
                <%@include file="/WEB-INF/views/drink.jsp" %>
            </c:when>

            <c:when test="${userClickSingleItem == true}">
                <%@include file="/WEB-INF/views/shared/itemDetails.jsp" %>
            </c:when>

            <c:when test="${userClickCart == true}">
                <%@include file="/WEB-INF/views/myCart.jsp" %>
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
<script src="/resources/assets/js/jqueryCard.js"></script>

<link rel="stylesheet" href="<c:url value="/resources/css/jquery.growl.css"/> ">
<script src="<c:url value="/resources/scripts/jquery.growl.js"></c:url> "></script>

<script src="<c:url value="/resources/scripts/helper.js"/>"></script>




</body>
</html>