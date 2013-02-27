//textarea编辑器
var introduceTextarea;
var filmIntroTextarea;
var awardsTextarea;
var broadcastSituationTextarea;
var commentTextarea;
var mediaTextarea;
var commentaryTextarea;
bkLib.onDomLoaded(function() {
	var o = {
		    buttonList : ['fontSize','fontFamily','fontFormat','bold','italic','underline','strikeThrough','subscript','superscript','html','left','center','right','justify','ol','ul','indent','outdent','removeformat','hr','link','unlink','forecolor','bgcolor','image'],
		    iconsPath : '../img/nicEditorIcons.gif',
		    maxHeight :220
		};
	
	introduceTextarea = new nicEditor(o).panelInstance('introduce');
	filmIntroTextarea = new nicEditor(o).panelInstance('filmIntro');
	awardsTextarea = new nicEditor(o).panelInstance('awards');
	broadcastSituationTextarea = new nicEditor(o).panelInstance('broadcastSituation');
	commentTextarea = new nicEditor(o).panelInstance('comment');
	mediaTextarea = new nicEditor(o).panelInstance('media');
	commentaryTextarea = new nicEditor(o).panelInstance('commentary');
});