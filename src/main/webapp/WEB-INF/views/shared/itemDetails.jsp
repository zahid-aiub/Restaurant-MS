<%--
  Created by IntelliJ IDEA.
  User: zahidul
  Date: 3/11/19
  Time: 1:11 AM
  To change this template use File | Settings | File Templates.
--%>

<div class="container">

    <div class="row">

        <div class="col-xs-12">

            <ol class="breadcrumb">

                <li><a href="${contextRoot}/">Home</a></li>
                <li><a href="${contextRoot}/${foodItem.category.toLowerCase()}">${foodItem.category}</a></li>
                <li class="active"><a href="#">${foodItem.typeName}</a></li>

            </ol>

        </div>

    </div>


    <div class="row">

        <div class="col-xs-12 col-sm-4">

            <div class="thumbnail">
                
                <img src="/resources/images/${foodItem.image}" class="img img-responsive" id="detailViewImg">
                
            </div>
            
        </div>

        <div class="col-xs-12 col-sm-8">

            <h3>${foodItem.typeName}</h3>
            <hr>

            <p>${foodItem.desc}</p>
            <hr>
            <h4> Price: <strong> TK ${foodItem.price} /-</strong></h4>
            <hr>

            <h5> Qty. Available: ${foodItem.quantity} </h5>
            <hr>

<%--            <button id="addToCardBtn" class="btn btn-sm btn-success">Add to Card</button>--%>
            <a href="#" class="btn btn-success" name="addToCart" id="addToCardBtn" <%--data-toggle="modal" data-target="#addToCardModal"--%>><span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a>
            <a href="${contextRoot}/burger" class="btn btn-primary">Back</a>


        </div>

    </div>

</div>
