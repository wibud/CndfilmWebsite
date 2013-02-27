$(function() {
	
	rainbows.init({
		selector: '.title',
		highlight: true,
		shadow: false,
		from: '#FF0000',
		to: '#700000'
	});
	
	rainbows.init({
		selector: '.sub_title',
		highlight: true,
		shadow: false,
		from: '#080808',
		to: '#E8E8E8'
	});
});

function seeDetail(filmId){
//	alert(filmId);
	window.open('filmDetail?filmId='+filmId,'_blank');
}

$(document).ready(function() {
	
	$('.imgAnchor').hover(
			function(){
				$(this).find('div').addClass('overlay image-preview');
			},
			function(){
				$(this).find('div').removeClass('overlay image-preview');
		});
	
	$('.videoAnchor').hover(
			function(){
				$(this).find('div').addClass('overlay video-preview');
			},
			function(){
				$(this).find('div').removeClass('overlay video-preview');
		});
});