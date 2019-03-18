(function($){
	
	switch(menu) {
		
		case 'About Us':
			$('#about').addClass('active');
			break;
		
		case 'Contact Us':
			$('#contact').addClass('active');
			break;
		
		case 'Home':
			$('#home').addClass('active');
			break;
			
		case 'All Product':
			$('#productList').addClass('active');
			break;
			
		default:
			if(menu == "Home") break;
		
			$('#productList').addClass('active');
			$('#a_'+menu).addClass('active');
			break;
	}
	
	
	var $table = $('#productListTable');
	
	if ($table.length){
		
		var jsonUrl = '';
		if(window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}
		else {
			jsonUrl = window.contextRoot + '/json/data/category/'+window.categoryId+'/products';
		}
		console.log(jsonUrl);
		$table.dataTable({
			pageLength: 5,
			ajax: {
				url: jsonUrl,
				dataSrc: '',
				column: [
					{data: 'name'},
					{data: 'brand'},
					{data: 'unitPrice'},
					{data: 'quantity'}
				]
			}
			
		});
	}
})(jQuery);
