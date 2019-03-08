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
    <%--    <script src='<c:url value="/WEB-INF/resources/jQuery/jQuery-2.1.4.min.js"/>'></script>--%>

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
<div class="container" style="margin-top: 20px">
    <button id="loginButton" type="button" class="btn-sm btn btn-info">Login</button>
</div>


</body>
</html>

<!-- Login Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="exampleModalLongTitle">Login</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <form class="form-horizontal">
                    <fieldset>
                        <div class="form-group">

                            <span>
                                <label for="phoneNumb" class="col-lg-3 control-label">Phone</label>
                            <div class="col-lg-7">
                                <input type="text" class="form-control" id="phoneNumb"><br>
                            </div>
                            </span>

                            <label for="pass" class="col-lg-3 control-label">Password</label>
                            <div class="col-lg-7">
                                <input type="password" class="form-control" id="pass">
                            </div>

                        </div>

                    </fieldset>
                    <a id="registration" href="#"> Create a new one!</a>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button id="loginButton2" type="button" class="btn btn-primary">Login</button>
            </div>
        </div>
    </div>
</div>


<!-- Registration Modal -->
<div class="modal fade" id="registrationModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Registration</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <fieldset>
                        <div class="form-group">
                            <div class="col-lg-12">
                                <span class="help-block">
                                    Login your phone number and password. If you don't have any account please create a new one for extra points.
                                </span>
                            </div>
                            <label for="name" class="col-lg-3 control-label">Name</label>
                            <div class="col-lg-7">
                                <input type="text" class="form-control" id="name"><br>

                            </div>

                            <label for="phone" class="col-lg-3 control-label">Phone</label>
                            <div class="col-lg-7">
                                <input type="text" class="form-control" id="phone"><br>

                            </div>

                            <label for="password" class="col-lg-3 control-label">Password</label>
                            <div class="col-lg-7">
                                <input type="text" class="form-control" id="password"><br>

                            </div>
                            <label for="confirmPass" class="col-lg-3 control-label">Confirm Password</label>
                            <div class="col-lg-7">
                                <input type="text" class="form-control" id="confirmPass"><br>

                            </div>

                            <label for="address" class="col-lg-3 control-label">Address</label>
                            <div class="col-lg-7">
                                <input type="text" class="form-control" id="address"><br>

                            </div>

                        </div>

                    </fieldset>
                </form>

            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button id="submitButton" type="button" class="btn btn-primary">Submit</button>
            </div>
        </div>
    </div>
</div>



<script type="text/javascript">
    var BASEURL = "<c:url value="/" />";
</script>

<script>
    $("#loginButton").click(function () {
        $("#loginModal").modal("show");
    });

    $("#registration").click(function () {
        console.log("aaaaaa.....")
        $("#registrationModal").modal("show");
    });

</script>

<script>
    $("#submitButton").click(function () {
        console.log("clicked...!");
        var name = $('#name').val()
        var phone = $('#phone').val()
        var pass = $('#password').val()
        var confirmPass = $('#confirmPass').val()
        var address = $('#address').val()

        if (name != "" && phone.length==11 && pass == confirmPass) {
            $.ajax({
                method: 'POST',
                url: BASEURL + "registrationProcess",
                data: {
                    name : name,
                    phone : phone,
                    password : pass,
                    address : address
                },
                success: function (response) {
                    $("#registrationModal").modal("hide");
                    // $.growl.warning({message: "You have successfully registried!"});
                    console.log(BASEURL);
                }
            });
        }
        else {
            alert("Something wrong in your process. Please try again!");
        }



    });

</script>

