
$( document ).ready(function() {

    var checkedOrNot;

    // $("#signInBtn").click(function () {
    //     console.log("okkkk...!!!");
    //     //$("#loginModal").modal("show");
    // });

    $("#registration").click(function () {
        console.log("aaaaaa.....");
        //$("#registrationModal").show();
    });

    $("#offer").click(function () {
        //$("#profile").hide();
        console.log(id);
    });


    $("#loginBtn").click(function () {
        var username = $('#phoneNumb').val();
        var password = $('#pass').val();

        if (username == 'admin') {
            console.log("admin login");
            $.ajax({
                method: 'POST',
                url: BASEURL + "/admin/loginProcess",
                data: {
                    uname : username,
                    pass : password
                },

                success: function (response) {
                    if(response.status == 200){

                        console.log("its work...!!");
                        location. reload(true);
                        $.growl.notice({ message: "Login Successfull!" });
                    }
                    else {
                        $.growl.error({ message: "Invalid username or poassword!" });
                        console.log("error");
                    }
                },

            });
        }

        else if (!username=="" && !password=="" ){
            console.log(BASEURL);
            $.ajax({
                method: 'POST',
                url: BASEURL + "/user/loginProcess",
                data: {
                    uname : username,
                    pass : password
                },

                success: function (response) {
                    if(response.status == 200){

                        console.log("its work...!!");
                        location. reload(true);
                        $.growl.warning({message: "Logiin Successfull!"});
                        $('#loginModal').hide();
                    }
                    else {
                        $.growl.error({ message: "Invalid username or poassword!" });
                        console.log("error1");
                    }
                },
            });

        }
        else {
            $.growl.warning({ message: "Please fill up all section!" });
        }

    });



    $("#registrationBtn").click(function () {
        console.log("clicked...!");
        var name = $('#name').val();
        var phone = $('#phone').val();
        var pass = $('#password').val();
        var confirmPass = $('#confirmPass').val();
        var address = $('#address').val();

        if (name != "" && phone.length==11 && pass == confirmPass) {
            $.ajax({
                method: 'POST',
                url: "/user/registrationProcess",
                data: {
                    name : name,
                    phone : phone,
                    password : pass,
                    address : address
                },
                success: function (response) {
                    if(response.status == 200){
                        console.log("yes...!!");
                        $.growl.notice({ message: "You are registred successfully!" });
                        $("#registrationModal").modal("hide");

                    }
                    else {
                        $.growl.error({ message: "Registration Failed!" });
                    }
                }
            });
        }
        else {
            alert("Something wrong in your process. Please try again!");
        }

    });

    $('#logout').click(function () {
        sessionStorage.removeItem('user');
        console.log("logout");
    });

    $('#adminLogout').click(function () {
        sessionStorage.removeItem('admin');
        console.log("logout");
    });

    //For Meat Meal

    var meatMealTable = $("#meatMealDataTable").DataTable({

        "processing": false,
        "searching":true,
        "scrollX": true,
        "order": false,/*[[0, "desc"]]*/
        "ajax": {
            "url":BASEURL+ "meatMeal/meatMeal-item-list",
            "type": "POST",
            "dataSrc": ''
        }
        ,
        "columns": [

            {"data": "id"},
            {"data": "image"},
            {"data": "typeName"},
            {"data": "quantity"},
            {"data": "price"},
            {"data": "id"},
            {"data": null}

        ],
        columnDefs: [
            {
                targets: 0,
                "sortable":false,
                render: function (data, type, row, meta) {
                    return data;
                }
            },
            {
                targets: 1,
                "sortable":false,
                render: function (data, type, row, meta) {
                    if (data!= null){
                        console.log(data);
                        return '<img src="/resources/images/'+data+'" alt="MeatMeal" class="img img-responsive" id="dataTableImg">';
                    }
                    return "N/A";
                }
            },
            {
                targets: 3,
                "sortable":false,
                render: function (data, type, row, meta) {
                    if (data!= null){
                        return '<span class="badge badge-pill badge-light">'+data+'</span>';
                    }
                    return "N/A";
                }
            },
            {
                targets: [4],
                render: function (data, type, row, meta) {
                    if (data!= null){
                        return '<span class="badge badge-secondary">'+data+' tk</span>';
                    }
                    else {
                        return "N/A";
                    }
                }
            },
            {
                targets: [5],
                render: function (data, type, row, meta) {
                    if (id < 0) {
                        return "";
                    }
                    else {
                        return '<a href="'+window.contextRoot+ '/details/'+data+'/single-item" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160'+
                            '<a href="#" class="btn btn-warning"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
                    }
                }
            },
            {
                targets: [6],
                render: function (data, type, row, meta) {
                    if (id < 0) {
                        return '<input id="productStatus" type="checkbox" onchange="changeProductStatus(this)" checked data-toggle="toggle" data-style="ios"> ' +
                            '<a data-toggle="modal" data-target="#updateProductModal" id="editBtn" onclick="editItems(this)"> <span class="glyphicon glyphicon-cog"></span> </a>';
                    }
                    else {
                        return "";
                    }
                }
            },

        ]
    });
    meatMealTable.column(0).visible(false);


    var burgerTable = $("#burgerDataTable").DataTable({

        "processing": false,
        "searching":true,
        "scrollX": true,
        "order": false,/*[[0, "desc"]]*/
        "ajax": {
            "url":BASEURL+ "burger/burger-item-list",
            "type": "POST",
            "dataSrc": ''
        }
        ,
        "columns": [

            {"data": "id"},
            {"data": "image"},
            {"data": "typeName"},
            {"data": "quantity"},
            {"data": "price"},
            {"data": "id"},
            {"data": null}

        ],
        columnDefs: [
            {
                targets: 0,
                "sortable":false,
                render: function (data, type, row, meta) {
                    return data;
                }
            },
            {
                targets: 1,
                "sortable":false,
                render: function (data, type, row, meta) {
                    if (data!= null){
                        console.log(data);
                        return '<img src="/resources/images/'+data+'" alt="Bugrer" class="img img-responsive" id="dataTableImg">';
                    }
                    return "N/A";
                }
            },
            {
                targets: 3,
                "sortable":false,
                render: function (data, type, row, meta) {
                    if (data!= null){
                        return '<span class="badge badge-pill badge-light">'+data+'</span>';
                    }
                    return "N/A";
                }
            },
            {
                targets: [4],
                render: function (data, type, row, meta) {
                    if (data!= null){
                        return '<span class="badge badge-secondary">'+data+' tk</span>';
                    }
                    else {
                        return "N/A";
                    }
                }
            },
            {
                targets: [5],
                render: function (data, type, row, meta) {
                    if (id < 0) {
                        return "";
                    }
                    else {
                        return '<a href="'+window.contextRoot+ '/details/'+data+'/single-item" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160'+
                            '<a href="#" class="btn btn-warning"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
                    }
                }
            },
            {
                targets: [6],
                render: function (data, type, row, meta) {
                    if (id < 0) {
                        return '<input id="productStatus" type="checkbox" onchange="changeProductStatus(this)" checked data-toggle="toggle" data-style="ios"> ' +
                            '<a data-toggle="modal" data-target="#updateProductModal" id="editBtn" onclick="editItems(this)"> <span class="glyphicon glyphicon-cog"></span> </a>';
                    }
                    else {
                        return "";
                    }
                }
            },

        ]
    });
    burgerTable.column(0).visible(false);


    var pizzaTable = $("#pizzaDataTable").DataTable({

        "processing": false,
        "searching":true,
        "scrollX": true,
        "order": false,/*[[0, "desc"]]*/
        "ajax": {
            "url":BASEURL+ "pizza/pizza-item-list",
            "type": "POST",
            "dataSrc": ''
        }
        ,
        "columns": [

            {"data": "id"},
            {"data": "image"},
            {"data": "typeName"},
            {"data": "quantity"},
            {"data": "price"},
            {"data": "id"},
            {"data": null}

        ],
        columnDefs: [
            {
                targets: 0,
                "sortable":false,
                render: function (data, type, row, meta) {
                    return data;
                }
            },
            {
                targets: 1,
                "sortable":false,
                render: function (data, type, row, meta) {
                    if (data!= null){
                        console.log(data);
                        return '<img src="/resources/images/'+data+'" alt="Pizza" class="img img-responsive" id="dataTableImg">';
                    }
                    return "N/A";
                }
            },
            {
                targets: 3,
                "sortable":false,
                render: function (data, type, row, meta) {
                    if (data!= null){
                        return '<span class="badge badge-pill badge-light">'+data+'</span>';
                    }
                    return "N/A";
                }
            },
            {
                targets: [4],
                render: function (data, type, row, meta) {
                    if (data!= null){
                        return '<span class="badge badge-secondary">'+data+' tk</span>';
                    }
                    else {
                        return "N/A";
                    }
                }
            },
            {
                targets: [5],
                render: function (data, type, row, meta) {
                    if (id < 0) {
                        return "";
                    }
                    else {
                        return '<a href="'+window.contextRoot+ '/details/'+data+'/single-item" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160'+
                            '<a href="#" class="btn btn-warning"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
                    }
                }
            },
            {
                targets: [6],
                render: function (data, type, row, meta) {
                    if (id < 0) {
                        return '<input id="productStatus" type="checkbox" onchange="changeProductStatus(this)" checked data-toggle="toggle" data-style="ios"> ' +
                            '<a data-toggle="modal" data-target="#updateProductModal" id="editBtn" onclick="editItems(this)"> <span class="glyphicon glyphicon-cog"></span> </a>';
                    }
                    else {
                        return "";
                    }
                }
            },

        ]
    });
    pizzaTable.column(0).visible(false);

    var riceMeal = $("#riceMealDataTable").DataTable({

        "processing": false,
        "searching":true,
        "scrollX": true,
        "order": false,/*[[0, "desc"]]*/
        "ajax": {
            "url":BASEURL+ "riceMeal/riceMeal-item-list",
            "type": "POST",
            "dataSrc": ''
        }
        ,
        "columns": [

            {"data": "id"},
            {"data": "image"},
            {"data": "typeName"},
            {"data": "quantity"},
            {"data": "price"},
            {"data": "id"},
            {"data": null}

        ],
        columnDefs: [
            {
                targets: 0,
                "sortable":false,
                render: function (data, type, row, meta) {
                    return data;
                }
            },
            {
                targets: 1,
                "sortable":false,
                render: function (data, type, row, meta) {
                    if (data!= null){
                        console.log(data);
                        return '<img src="/resources/images/'+data+'" alt="RiceMeal" class="img img-responsive" id="dataTableImg">';
                    }
                    return "N/A";
                }
            },
            {
                targets: 3,
                "sortable":false,
                render: function (data, type, row, meta) {
                    if (data!= null){
                        return '<span class="badge badge-pill badge-light">'+data+'</span>';
                    }
                    return "N/A";
                }
            },
            {
                targets: [4],
                render: function (data, type, row, meta) {
                    if (data!= null){
                        return '<span class="badge badge-secondary">'+data+' tk</span>';
                    }
                    else {
                        return "N/A";
                    }
                }
            },
            {
                targets: [5],
                render: function (data, type, row, meta) {
                    if (id < 0) {
                        return "";
                    }
                    else {
                        return '<a href="'+window.contextRoot+ '/details/'+data+'/single-item" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160'+
                            '<a href="#" class="btn btn-warning"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
                    }
                }
            },
            {
                targets: [6],
                render: function (data, type, row, meta) {
                    if (id < 0) {
                        return '<input id="productStatus" type="checkbox" onchange="changeProductStatus(this)" checked data-toggle="toggle" data-style="ios"> ' +
                            '<a data-toggle="modal" data-target="#updateProductModal" id="editBtn" onclick="editItems(this)"> <span class="glyphicon glyphicon-cog"></span> </a>';
                    }
                    else {
                        return "";
                    }
                }
            },

        ]
    });
    riceMeal.column(0).visible(false);

    var snacksTable = $("#snacksDataTable").DataTable({

        "processing": false,
        "searching":true,
        "scrollX": true,
        "order": false,/*[[0, "desc"]]*/
        "ajax": {
            "url":BASEURL+ "snacks/snacks-item-list",
            "type": "POST",
            "dataSrc": ''
        }
        ,
        "columns": [
            {"data": "id"},
            {"data": "image"},
            {"data": "typeName"},
            {"data": "quantity"},
            {"data": "price"},
            {"data": "id"},
            {"data": null}

        ],
        columnDefs: [
            {
                targets: 0,
                "sortable":false,
                render: function (data, type, row, meta) {
                    return data;
                }
            },
            {
                targets: 1,
                "sortable":false,
                render: function (data, type, row, meta) {
                    if (data!= null){
                        console.log(data);
                        return '<img src="/resources/images/'+data+'" alt="Pizza" class="img img-responsive" id="dataTableImg">';
                    }
                    return "N/A";
                }
            },
            {
                targets: 3,
                "sortable":false,
                render: function (data, type, row, meta) {
                    if (data!= null){
                        return '<span class="badge badge-pill badge-light">'+data+'</span>';
                    }
                    return "N/A";
                }
            },
            {
                targets: [4],
                render: function (data, type, row, meta) {
                    if (data!= null){
                        return '<span class="badge badge-secondary">'+data+' tk</span>';
                    }
                    else {
                        return "N/A";
                    }
                }
            },
            {
                targets: [5],
                render: function (data, type, row, meta) {
                    if (id < 0) {
                        return "";
                    }
                    else {
                        return '<a href="'+window.contextRoot+ '/details/'+data+'/single-item" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160'+
                            '<a href="#" class="btn btn-warning"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
                    }
                }
            },
            {
                targets: [6],
                render: function (data, type, row, meta) {
                    if (id < 0) {
                        return '<input id="productStatus" type="checkbox" onchange="changeProductStatus(this)" checked data-toggle="toggle" data-style="ios"> ' +
                            '<a data-toggle="modal" data-target="#updateProductModal" id="editBtn" onclick="editItems(this)"> <span class="glyphicon glyphicon-cog"></span> </a>';
                    }
                    else {
                        return "";
                    }
                }
            },

        ]
    });

    snacksTable.column(0).visible(false);


    var drinks = $("#drinkDataTable").DataTable({

        "processing": false,
        "searching":true,
        "scrollX": true,
        "order": false,/*[[0, "desc"]]*/
        "ajax": {
            "url":BASEURL+ "drink/drink-item-list",
            "type": "POST",
            "dataSrc": ''
        }
        ,
        "columns": [
            {"data": "id"},
            {"data": "image"},
            {"data": "typeName"},
            {"data": "quantity"},
            {"data": "price"},
            {"data": "id"},
            {"data": null}

        ],
        columnDefs: [
            {
                targets: 0,
                "sortable":false,
                render: function (data, type, row, meta) {
                    if (data!= null){
                        console.log(data);
                        return data;
                    }
                    return "N/A";
                }
            },
            {
                targets: 1,
                "sortable":false,
                render: function (data, type, row, meta) {
                    if (data!= null){
                        console.log(data);
                        return '<img src="/resources/images/'+data+'" alt="drink" class="img img-responsive" id="dataTableImg">';
                    }
                    return "N/A";
                }
            },
            {
                targets: 3,
                "sortable":false,
                render: function (data, type, row, meta) {
                    if (data!= null){
                        return '<span class="badge badge-pill badge-light">'+data+'</span>';
                    }
                    return "N/A";
                }
            },
            {
                targets: [4],
                render: function (data, type, row, meta) {
                    if (data!= null){
                        return '<span class="badge badge-secondary">'+data+' tk</span>';
                    }
                    else {
                        return "N/A";
                    }
                }
            },
            {
                targets: [5],
                render: function (data, type, row, meta) {
                    if (id < 0) {
                        return "";
                    }
                    else {
                        return '<a href="'+window.contextRoot+ '/details/'+data+'/single-item" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160'+
                            '<a href="#" class="btn btn-warning"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
                    }

                }
            },
            {
                targets: [6],
                render: function (data, type, row, meta) {
                    if (id < 0) {
                        return '<input id="productStatus" type="checkbox" onchange="changeProductStatus(this)" checked data-toggle="toggle" data-style="ios"> ' +
                            '<a data-toggle="modal" data-target="#updateProductModal" id="editBtn" onclick="editItems(this)"> <span class="glyphicon glyphicon-cog"></span> </a>';
                    }
                    else {
                        return "";
                    }
                }
            },

        ]
    });
    drinks.column(0).visible(false);

    $('#meatMealDataTable tbody').on( 'click', 'tr', function () {
        console.log( meatMealTable.row( this ).data().id );
        selectedFoodItemId = meatMealTable.row( this ).data().id;
    } );

    $('#burgerDataTable tbody').on( 'click', 'tr', function () {
        console.log( burgerTable.row( this ).data().id );
        selectedFoodItemId = burgerTable.row( this ).data().id;
    } );

    $('#pizzaDataTable tbody').on( 'click', 'tr', function () {
        console.log( pizzaTable.row( this ).data().id );
        selectedFoodItemId = pizzaTable.row( this ).data().id;
    } );

    $('#riceMealDataTable tbody').on( 'click', 'tr', function () {
        console.log( riceMeal.row( this ).data().id );
        selectedFoodItemId = riceMeal.row( this ).data().id;
    } );

    $('#snacksDataTable tbody').on( 'click', 'tr', function () {
        console.log( snacksTable.row( this ).data().id );
        selectedFoodItemId = snacksTable.row( this ).data().id;
    } );

    $('#drinkDataTable tbody').on( 'click', 'tr', function () {
        console.log( drinks.row( this ).data().id );
        selectedFoodItemId = drinks.row( this ).data().id;
    } );




    //------------ Details view Item ------------

    $("#viewItem").click(function () {
        console.log("555");
    });


    $("#addToCardBtn").click(function () {
        console.log("add to caRD");
        if(id == 0){
            $.growl.warning({ message: "You should login first!" });
        }
        else {
            $("#addToCardModal").modal('show');
        }

    });

    //----------- Confirm to card -------------------

    $('#confirmBtn').click(function () {

        var foodTypeId = $('#foodTypeId').text();
        var quantity = $('#qtyInput').val();
        var totalPrice = $('#totalPrice').text();
        var name = $('#itemTypeName').text();
        var image = $("#imageInput").val();
        var customerId = id;

        console.log("C_id: "+ id+"---"+quantity+"------"+name+"----"+foodTypeId+"---"+ image);
        $('#addToCardModal').modal('hide');
        $.growl.notice({ message: "Successfully added to your cart" });
        location. reload(true);
        $.ajax({
            method: 'POST',
            url: "/cart/confirm-add-to-cart",
            data : {
                userId : customerId,
                foodId : foodTypeId,
                quantity : quantity,
                tprice : totalPrice,
                typeName : name,
                image : image

            },
            success : function (response) {
                console.log("ok...5");
                if (response.status == 200) {
                    console.log("response ok..!");

                    // $('#addToCardModal').modal('hide');
                }
            }

        });


    });


    var cartTable = $("#cartDataTable").DataTable({

        "processing": false,
        "searching":true,
        "scrollX": true,
        "order": false,/*[[0, "desc"]]*/
        "ajax": {
            "url": "cart/userCartDetails",
            "type": "POST",
            "dataSrc": ''
        }
        ,
        "columns": [

            {"data": "id"},
            {"data": "image"},
            {"data": "foodTypeName"},
            {"data": "quantity"},
            {"data": "totalPrice"},
            {"data": null}

        ],
        columnDefs: [
            {
                targets: 0,
                "sortable":false,
                "hidden" : true,
                render: function (data, type, row, meta) {
                    if (data!= null){
                        return data;
                    }
                    return "";
                }
            },
            {
                targets: 1,
                "sortable":false,
                render: function (data, type, row, meta) {
                    if (data!= null){
                        console.log(data);
                        return '<img src="/resources/images/'+data+'" alt="Image" class="img img-responsive" id="dataTableImg">';
                    }
                    return "N/A";
                }
            },
            {
                targets: 2,
                "sortable":false,
                render: function (data, type, row, meta) {
                    if (data!= null){
                        return '<span class="badge badge-pill badge-light">'+data+'</span>';
                    }
                    return "N/A";
                }
            },
            {
                targets: 3,
                "sortable":false,
                render: function (data, type, row, meta) {
                    if (data!= null){
                        return '<span class="badge badge-pill badge-light">'+data+'</span>';
                    }
                    return "N/A";
                }
            },
            {
                targets: 4,
                render: function (data, type, row, meta) {
                    if (data!= null){
                        return '<span class="badge badge-secondary">'+data+' tk</span>';
                    }
                    else {
                        return "N/A";
                    }
                }
            },
            {
                targets: 5,
                render: function (data, type, row, meta) {
                    return '<button id="placeOrderBtn" onclick="placeOrder(this)" class="btn btn-success" data-toggle="modal" data-target="#paymentDiv">Place Order</button>' +
                        '<i class="fa fa-trash" data-toggle="modal" data-target="#warningModdal" onclick="deleteItem()" style="font-size:30px;color:red"></i>';
                }
            },

        ]
    });

    $('#paymentDiv').card({
        container: '.card-wrapper'
    });

    $('#remove_yes').click(function () {
        //console.log("remove");
        var userId = id;
        var foodId = selectedFoodId;

        console.log(id+"----"+ foodId);
        location. reload(true)

        $.ajax({
            method: 'POST',
            url: "/cart/removeFromCard",
            data: {
                uId : userId,
                foodId : foodId
            },
            success: function (response) {
                if(response.status == 200){
                    console.log("yes...updated...!!");

                }
            }
        });


    });

});


$('#addItemBtn').click(function () {

    var selectedCategory = $('#category').val();
    var foodName = $('#pName').val();
    var quantity = $('#quantity').val();
    var price = $('#price').val();
    var status = $('#status').val();
    var description = $('#description').val();
    var image = $('#image').val();

    console.log(selectedCategory+"  "+price +"  "+image);
    $.ajax({
        method: 'POST',
        url: "/admin/addFoodItem",
        data: {
            name : foodName,
            category : selectedCategory,
            quantity : quantity,
            price : price,
            status : status,
            description : description,
            imageUrl : image
        },
        success: function (response) {
            if(response.status == 200){
                console.log("yes Hit it...!!");

            }
        }
    });

});

$('#submitBtn').click(function () {
    $.growl.notice({ message: "Payment process is going on..!" });
});


function placeOrder(event) {
    console.log("place order")
}

function test(){
    var table = $('#cartDataTable').DataTable();
    $('#cartDataTable tbody').on( 'click', 'tr', function () {
        table.$('tr.selected').removeClass('selected');
        $(this).addClass('selected');
        return true;
    } );
    return false;
}


function deleteItem() {

    $.when(test()).then(function( x ) {
        $.each($("#cartDataTable tr.selected"),function(){ //get each tr which has selected class
            var selectedItemId = $(this).find('td').eq(0).text();
            console.log(selectedItemId);
            selectedFoodId = selectedItemId;

        });
    });

}

var selectedFoodItemId;
function changeProductStatus(checkboxElem) {
    var select = selectedFoodItemId;
    console.log("-----*****"+ selectedFoodItemId);
    if (checkboxElem.checked) {
        var foodTypeId = $('#foodTypeId').text();
        console.log("----------------"+ foodTypeId);
        $.ajax({
            method: 'POST',
            url: "/admin/changeProductStatus",
            data: {
                status: 1,
                foodId: select
            },
            success: function (response) {
                console.log("checked");
            }
        });

    } else {
        var select = selectedFoodItemId;
        $.ajax({
            method: 'POST',
            url: "/admin/changeProductStatus",
            data: {
                status: 0,
                foodId: select
            },
            success: function (response) {
                console.log("un-checked");
            }
        });

    }

}

//----edit items
function editItems(click) {
    var selectId = selectedFoodItemId;
    console.log("In Fetch "+ selectId);
    $.ajax({
        method: 'POST',
        url: "/admin/fetchProductById",
        data: {
            foodId : selectId,
        },
        success: function (response) {
            var datas = response.data;
            console.log(datas);
            var id = datas.id;
            var name = datas.typeName;
            var qnty = datas.quantity;
            var price = datas.price;
            var descrp = datas.desc;

            $('#nameUp').val(name);
            $('#qnty').val(qnty);
            $('#pric').val(price);
            $('#desc').val(descrp);
            $('#foodUpid').val(id);

        }
    });

}

$("#updateItemBtn").click(function () {
    var id = $('#foodUpid').val();
    var quantity = $('#qnty').val();
    var price = $('#pric').val();
    var desc = $('#desc').val();

    console.log("----------------"+id);

    $.ajax({
        method: 'POST',
        url: "/admin/updateBatchProduct",
        data: {
            foodId : id,
            quantity : quantity,
            price : price,
            desc : desc
        },
        success: function (response) {
            $.growl.notice({ message: "Product Updated Succfully" });
            location. reload(true);
        }
    });

})





