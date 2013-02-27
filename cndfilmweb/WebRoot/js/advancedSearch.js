$(document).ready(function(){
	
	$('#search').click(function(){
		
		var searchFilmName = $('#searchFilmName').val();
		var searchFilmLength = $('#searchFilmLength').val();
		var searchFilmTime = $('#searchFilmTime').val();
		var searchFilmType = $('#searchFilmType').val();
		var searchStandard = $('#searchStandard').val();
		var searchFilmKeyword = $('#searchFilmKeyword').val();
		var searchDirector = $('#searchDirector').val();
		var searchAwards = $('#searchAwards').val();
		
		window.open('advancedSearchFilm?filmName='+searchFilmName+'&filmLength='+searchFilmLength+'&filmTime='+searchFilmTime+'&filmType='+searchFilmType+'&standard='+searchStandard+'&filmKeyword='+searchFilmKeyword+'&director='+searchDirector+'&awards='+searchAwards,'_blank');
	});
});