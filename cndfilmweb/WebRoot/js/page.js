function createPage(url,param,tab){
	
	//翻页
	var page = $('#page').val();
	var pageCount = $('#pageCount').val();
	var count = $('#count').val();
	var prePage = 1;
	var nextPage = pageCount;
	if(Number(page)>1){
		prePage = Number(page)-1;
	}
	if(Number(page)<Number(pageCount)){
		nextPage = Number(page)+1;
	}
	$('.myPagination').append('<a href="'+url+'?page=1'+param+tab+'" title="First Page">&laquo; 第一页</a><a href="'+url+'?page='+prePage+param+tab+'" title="Previous Page">&laquo; 上一页</a>');
	
	var startPage = 1;
	var endPage;
	if(Number(pageCount)==0){
		endPage = 1;
		nextPage = 1;
	}else{
		endPage = pageCount;
	}
	if(Number(page)-2>=1&&Number(page)+2<=endPage){
		startPage = Number(page)-2;
		endPage = Number(page)+2;
	}else if(Number(page)-2<1){
		if(Number(pageCount)>=5){
			endPage = 5;
		}
	}else if(Number(page)+2>endPage){
		if(Number(pageCount)-5>=1){
			startPage = Number(pageCount)-5;
		}
	}
	
	if(Number(pageCount)==0){
		pageCount = 1;
	}
	
	for(var i=startPage;i<=endPage;i++){
		var pageClass="number";
		if(i==Number(page)){
			pageClass +=" current";
		}
		$('.myPagination').append('<a href="'+url+'?page='+i+param+tab+'" class="'+pageClass+'" title="'+i+'">'+i+'</a>');
	}
	$('.myPagination').append('<a href="'+url+'?page='+nextPage+param+tab+'" title="Next Page">下一页 &raquo;</a><a href="'+url+'?page='+pageCount+param+tab+'" title="Last Page">最后页('+pageCount+')&raquo;</a>');

}

function createPageByFormSumit(){
	
	//翻页
	var page = $('#page').val();
	var pageCount = $('#pageCount').val();
	var count = $('#count').val();
	var prePage = 1;
	var nextPage = pageCount;
	if(Number(page)>1){
		prePage = Number(page)-1;
	}
	if(Number(page)<Number(pageCount)){
		nextPage = Number(page)+1;
	}
	$('.myPagination').append('<a href="javascript:turnPage(1);" title="First Page">&laquo; 第一页</a><a href="javascript:turnPage('+prePage+');" title="Previous Page">&laquo; 上一页</a>');
	
	var startPage = 1;
	var endPage;
	if(Number(pageCount)==0){
		endPage = 1;
		nextPage = 1;
	}else{
		endPage = pageCount;
	}
	if(Number(page)-2>=1&&Number(page)+2<=endPage){
		startPage = Number(page)-2;
		endPage = Number(page)+2;
	}else if(Number(page)-2<1){
		if(Number(pageCount)>=5){
			endPage = 5;
		}
	}else if(Number(page)+2>endPage){
		if(Number(pageCount)-5>=1){
			startPage = Number(pageCount)-5;
		}
	}
	
	if(Number(pageCount)==0){
		pageCount = 1;
	}
	
	for(var i=startPage;i<=endPage;i++){
		var pageClass="number";
		if(i==Number(page)){
			pageClass +=" current";
		}
		$('.myPagination').append('<a href="javascript:turnPage('+i+');" class="'+pageClass+'" title="'+i+'">'+i+'</a>');
	}
	$('.myPagination').append('<a href="javascript:turnPage('+nextPage+');" title="Next Page">下一页 &raquo;</a><a href="javascript:turnPage('+pageCount+');" title="Last Page">最后页('+pageCount+') &raquo;</a>');
}

function turnPage(page){
	
	$('#desPage').val(page);
	document.turnPage.submit();
}