function seeComment(filmId){
	window.open('filmDetail?filmId='+filmId+'&linkTo=comment','_blank');
}

function seeCommentary(filmId){
	window.open('filmDetail?filmId='+filmId+'&linkTo=commentary','_blank');
}

function seePhoto(filmId){
	window.open('filmDetail?filmId='+filmId+'&linkTo=photo','_blank');
}

function seePoster(filmId){
	window.open('filmDetail?filmId='+filmId+'&linkTo=poster','_blank');
}

function seeMoreVideo(filmId){
	window.open('filmDetail?filmId='+filmId+'&linkTo=video','_blank');
}

function seeVideo(filmId,videoName){
	window.open('filmDetail?filmId='+filmId+'&videoName='+videoName+'&linkTo=videoDetail','_blank');
}