
$( document ).ready(function() {
    console.log( "ready!" );

    $("#signInBtn").click(function () {
        console.log("okkkk...!!!");
        $("#loginModal").modal("show");
    });

    $("#registration").click(function () {
        console.log("aaaaaa.....");
        $("#registrationModal").modal("show");
    });

    $("#offer").click(function () {
        $("#profile").hide();
    });

    $("#loginBtn").click(function () {
        var username = $('#phoneNumb').val();
        var password = $('#pass').val();

        $.ajax({
            method: 'POST',
            url: BASEURL + "user/loginProcess",
            data: {
                uname : username,
                pass : password
            },

            success: function (response) {
                if(response.status == 200){

                    $("#loginModal").modal("hide");
                    // $.growl.warning({message: "You have successfully registried!"});
                }
            },
            error: function (response) {
               console.log("error");
            }
        });

    });



    $("#registrationBtn").click(function () {
        console.log("clicked...!");
        var name = $('#name').val();
        var phone = $('#phone').val();
        var pass = $('#password').val();
        var confirmPass = $('#confirmPass').val();
        var address = $('#address').val();

        if (name != "" && phone.length==11 && pass == confirmPass) {
            $("#registrationModal").modal("hide");
            $.ajax({
                method: 'POST',
                url: BASEURL + "user/registrationProcess",
                data: {
                    name : name,
                    phone : phone,
                    password : pass,
                    address : address
                },
                success: function (response) {
                    if(status == 200){
                        console.log("yes...!!");
                        $("#registrationModal").modal("hide");
                        // $.growl.warning({message: "You have successfully registried!"});
                    }
                }
            });
        }
        else {
            alert("Something wrong in your process. Please try again!");
        }

    });



    //For burger item

    var table = $("#burgerDataTable").DataTable({

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
                        return '<img src="'+data+'" alt="Bugrer" class="img img-responsive" id="dataTableImg">';
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
                targets: [3],
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
                targets: [4],
                render: function (data, type, row, meta) {
                    return '<a href="'+window.contextRoot+ '/burger/'+data+'/single-item" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160'+
                        '<a href="#" class="btn btn-warning"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
                }
            },
            {
                targets: [5],
                render: function (data, type, row, meta) {
                    return '<a href="#" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span>'+' '+' Rating</a>';
                }
            },

        ]
    });

    //------------ Details view Item ------------

    $("#viewItem").click(function () {
        console.log("555");
    });


    $("#addToCardBtn").click(function () {
        console.log("add to caRD");
        $("#addToCardModal").modal('show');
    });

    //----------- Confirm to card -------------------

    $('#confirmBtn').click(function () {

        var foodTypeId = $('#foodTypeId').text();
        var quantity = $('#qtyInput').val();
        var totalPrice = $('#totalPrice').text();

        $.ajax({

            method: 'POST',
            url: BASEURL + "card/confirm-add-to-card",
            data : {
                foodTypeId : foodTypeId,
                quantity : quantity,
                tprice : totalPrice

            },
            success : function (response) {
                console.log("ok...5");
                if (response.status == 200) {
                    console.log("ok...200");
                }
            }

        });


    });

});
