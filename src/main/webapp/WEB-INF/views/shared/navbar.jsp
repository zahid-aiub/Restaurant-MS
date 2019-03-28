
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${contextRoot}/home">
<%--				<img alt="Image" src="<c:url value="/resources/images/restaurant-logo01.png"></c:url> ">--%>
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a id="meatMeal" href="${contextRoot}/meat-meal">MEAT MEAL<%--<span class="sr-only">(current)</span>--%></a></li>
				<li><a id="burger" href="${contextRoot}/burger">BURGERS</a></li>
				<li><a id="pizza" href="${contextRoot}/pizza">PIZZA</a></li>
				<li><a id="riceMeal" href="${contextRoot}/rice-meal">RICE MEALS</a></li>
				<li><a id="snacks" href="${contextRoot}/snack">SNACKS</a></li>
				<li><a id="drinks" href="${contextRoot}/drink">DRINKS</a></li>
				<%--<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Food Items <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Another action</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Something else here</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					</ul>
				</li>--%>
			</ul>
			<form class="navbar-form navbar-left">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<a><span href="#" type="submit" class="btn btn-sm btn-default">Search</span></a>
			</form>
			<label id="nameSpace" ></label>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#" id="signInBtn" >Sign In</a></li>
				<li><a href="#" id="offer" >Offer</a></li>
<%--				<span id="nameSpace" ></span>--%>
				<li class="dropdown">
<%--					<a href="#">--%>
<%--						<span class="glyphicon glyphicon-align-right dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></span>--%>
<%--					</a>--%>
				<a id="profile" href="#" class="dropdown-toggle" data-toggle="dropdown" ><span class="glyphicon glyphicon-align-right"></span></a>
					<ul class="dropdown-menu">
						<li><a id="profileDetails" href="#">Profile Details</a></li>
						<li><a id="favorite" href="#">Favorite</a></li>
						<li><a id="cart" href="#">Cart</a></li>
						<li role="separator" class="divider"></li>
						<li><a id="logout" href="${contextRoot}/logout">Logout</a></li>
					</ul>
				</li>
			</ul>
		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>