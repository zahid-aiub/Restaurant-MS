<%--
  Created by IntelliJ IDEA.
  User: zahidul
  Date: 3/9/19
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>

<div id="loginModal" class="modal fade" role="dialog">
    <div class="modal-dialog modal-md" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                <h3 class="modal-title">Login</h3>
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
                    <a id="registration" href="#" data-toggle="modal" data-target="#registrationModal"> Create a new one!</a>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-outline-primary" id="loginBtn">Login</button>
                <button type="button" class="btn btn-default " data-dismiss="modal">Close</button>
            </div>

        </div><!-- /.modal-content -->
    </div>
</div>



<!-- Registration Modal -->


<div id="registrationModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-md" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                <h3 class="modal-title">Registration</h3>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <fieldset>
                        <div class="form-group">
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
                <a href="#" class="btn btn-primary" id="registrationBtn">Confirm</a>
                <button type="button" class="btn btn-default " data-dismiss="modal">Close</button>
            </div>

        </div><!-- /.modal-content -->
    </div>
</div>



<%-- Add to card modal--%>

<div id="addToCardModal" class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                <h3 class="modal-title">Add to Card</h3>
            </div>
            <div class="modal-body">
                <table class="table table-borderless" id="addToCardTable">
                    <thead id="tblHead">
                    <tr>
                        <th hidden></th>
                        <th>Image</th>
                        <th>Name</th>
                        <th>Qty.</th>
                        <th>Unit Price</th>
                        <th>Total Price</th>
<%--                        <th class="text-right">Mean</th>--%>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td hidden id="foodTypeId">${foodItem.id}</td>
                        <td><img src="/resources/images/${foodItem.image}" class="img img-responsive" id="confirmCardImg"></td>
                        <td id="itemTypeName">${foodItem.typeName}</td>
                        <td><input class="col-xs-2" id="qtyInput" type="number" min="1" value="1" style="text-align: center; border-radius:unset; width:100px "></td>
                        <td id="itemPrice">${foodItem.price}</td>
                        <td id="totalPrice">${foodItem.price}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <input id="imageInput" hidden type="text" value="${foodItem.image}" >
            <div class="modal-footer">
                <a class="btn btn-success" id="confirmBtn"><span class="glyphicon glyphicon-shopping-cart"></span>Confirm</a>
                <button type="button" class="btn btn-default " data-dismiss="modal">Close</button>
            </div>

        </div><!-- /.modal-content -->
    </div>
</div>

<script>
    $('#qtyInput').keyup(function () {
        var quantity = $("#qtyInput").val();
        if (quantity < 0 ){
            quantity = quantity * (-1);
            $('#qtyInput').val(quantity);
        }
        if (quantity > ${foodItem.quantity}) {
            quantity = ${foodItem.quantity};
            $('#qtyInput').val(quantity);
            alert("Out of stoke.")
        }
        else {
            var unitPrice = ${foodItem.price};
            var totalPrice = quantity*unitPrice;
            $("#totalPrice").text(totalPrice);
        }

    });

</script>


<%--

<div id="userPermissionModal" class="modal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Option available for purchase Click here to upgrade your plan </h4>
            </div>
            <div class="modal-body">
                <a class="btn btn-success " href="https://realacquisitions.com/pricing">
                    Go For Purchase
                </a>
                <button type="button" class="btn btn-default " data-dismiss="modal">
                    Close
                </button>
            </div>
            <div class="modal-footer">

            </div>
        </div>

    </div>
</div>

--%>




<%--Payment Modal Start--%>

<div class="card_info modal fade" id="paymentDiv" role="dialog" style="display: none;">
    <div class="modal-dialog modal-md" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                <h3 class="modal-title">Payment</h3>
            </div>
            <div class="modal-body">
                <div class="card-wrapper" style="margin-top: 25px"></div>

                <div class="form-container col active" style="margin-top: 80px">
                    <form>
                        <input type="text" placeholder="Acc No" name="number"/>
                        <input type="text" placeholder="Your Name" name="name">
                        <input type="text" placeholder="mm/yy" name="expiry"/>
                        <input type="text" placeholder="CVC" name="cvc"/>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info">Submit</button>
                <button type="button" class="btn btn-default " data-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>

<%--Payment Modal end--%>

<!-- .modal -->
<div class="modal fade" id="warningModdal" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <div>
                    <p>Are you sure remove the item?</p>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" data-dismiss="modal" class="btn btn-primary" id="remove_yes">Yes</button>
                <button type="button" data-dismiss="modal" id="remove_no" class="btn">No</button>
            </div>

        </div>
    </div>
</div>



