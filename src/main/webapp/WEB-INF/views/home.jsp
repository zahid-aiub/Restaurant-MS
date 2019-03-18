
<div class="container">
	<div class="container" id="sliderDiv">
		<div id="myCarousel" class="carousel slide center-block" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" id="imgsize">
				<div class="item active">
					<img src="<c:url value="/resources/images/aa.jpg"/>" alt="Los Angeles">
				</div>

				<div class="item">
					<img src="<c:url value="/resources/images/cc.jpg"/>" alt="Chicago">
				</div>

				<div class="item">
					<img src="<c:url value="/resources/images/ee.jpg"/>" alt="New York">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
				<span class="sr-only">Previous</span>
			</a>
			<a class="right carousel-control" href="#myCarousel" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>

	</div>

	<%--End of image slider--%>

	<div id="cardDiv" class="container">
		<div class="col">
			<div class="col">
				<div class="col-sm-3">
					<div class="thumbnail">
						<img src="/resources/images/01.jpg" alt="Image">
						<div class="caption">
							<h3>Food item 1</h3>
							<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
							<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
						</div>
					</div>
				</div>
			</div>

			<div class="col">
				<div class="col-sm-3">
					<div class="thumbnail">
						<img src="/resources/images/02.jpg" alt="Image">
						<div class="caption">
							<h3>Food item 2</h3>
							<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
							<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
						</div>
					</div>
				</div>
			</div>

			<div class="col">
				<div class="col-sm-3">
					<div class="thumbnail">
						<img src="/resources/images/03.jpg" alt="Image">
						<div class="caption">
							<h3>Food item 3</h3>
							<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
							<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
						</div>
					</div>
				</div>
			</div>

			<div class="col">
				<div class="col-sm-3">
					<div class="thumbnail">
						<img src="/resources/images/02.jpg" alt="Image">
						<div class="caption">
							<h3>Food item 4</h3>
							<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
							<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>