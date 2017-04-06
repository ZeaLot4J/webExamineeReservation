/**
 * 管理员界面的处理
 */

function changePanel(obj){
	var panelName = $(obj).attr("class");
	$("iframe").attr("src",panelName+".html");
}