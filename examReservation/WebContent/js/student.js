/*
 * 学生主页处理
 */
$(function(){
	function changePanel2(obj){
		var panelName = $(obj).attr("class");
		$("iframe").attr("src",panelName+".html");
	}
})
