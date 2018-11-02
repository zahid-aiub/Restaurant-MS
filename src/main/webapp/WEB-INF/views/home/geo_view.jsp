<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dipanjal
  Date: 11/2/18
  Time: 12:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous">
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js" type="text/javascript"></script>

    <script src="<c:url value ="/resources/scripts/jquery.growl.js" />"></script>
    <link rel="stylesheet" type='text/css' href="<c:url value ="/resources/css/jquery.growl.css" />">

    <script>
        var BASEURL = "<c:url value="/" />";
        console.log(BASEURL);
    </script>
</head>

<body>
    <div class="container">
        <h2>Geo Location Test</h2>
        <p>Find Nearby Location From Latitude & Longitude</p>
        <form class="form-inline" action="/action_page.php">
            <div class="form-group">
                <label for="lat">Latitude:</label>
                <input type="text" class="form-control" id="lat" placeholder="Enter Latitude" name="lat">
            </div>
            <div class="form-group">
                <label for="lon">Longitude:</label>
                <input type="text" class="form-control" id="lon" placeholder="Enter Longitude" name="lon">
            </div>
            <div class="form-group">
                <label for="radius">Radious:</label>
                <input type="number" class="form-control" id="radius" placeholder="Radius" name="radius">
            </div>
            <button type="button" id="find-nearby-btn" class="btn btn-default">Nearby</button>
        </form>
        <div id="api-response-holder" class="response-holder">

        </div>
    </div>

    <script>

       $("#find-nearby-btn").on('click',function (event) {
           // console.log(event);
           findNearbyLocation();
       });
       
       function findNearbyLocation() {
           var lat = $("#lat").val();
           var lon = $("#lon").val();
           var radius = $("#radius").val();

           if(isEmptyOrSpaces(lat) || isEmptyOrSpaces(lon)){
               $.growl.warning({ title: "Warning!", message: "Latidute or Longitude is Empty" });
               return false;
           }
           if(isEmptyOrSpaces(radius)){
               $.growl.error({ title: "Error!", message: "Radious can not be Empty" });
               return false;
           }

           $.ajax({
               url: BASEURL+"api/location/near/"+radius,
               data:{
                   latitude:lat,
                   longitude:lon
               },
               success: function(result){
                   console.log(result);
                   // if(result.status==200){
                   //
                   // }

                   $(".response-holder").text(result.data);
               }});
       }

       function isEmptyOrSpaces(str){
           return str === null || str.match(/^ *$/g) !== null;
           // return str === null || str.match('^ *$') !== null;
       }
//         $(document).on('click','#find-nearby-btn',function (event) {
//             console.log(event);
//         })
    </script>
</body>
</html>
