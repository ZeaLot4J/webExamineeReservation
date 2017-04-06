/**
 * 选课界面处理
 */
var currExam;
var pageSize = 4;//一行n个考试
var pageNum = 0;               //第几页  
var lock = true;
$(function(){
	loadExam();
	
	$("#searchBtn").click(function(){
		var ename = $("#searchExam").val();
		if(ename==""){
			pageNum = 0;
			$("#examList").empty();
			loadExam();
		}else{
			$.ajax({
				url: "../examination.action?op=searchExam",
				type: "POST",
				dataType: "JSON",
				data: "ename="+ename,
				success: function(data){
					if(data.code==1){
						currExam = data.obj;
						$("#examList").empty();
						if(currExam.length<=4){//如果不到4个
							addExamToBottom(0,currExam.length);
						}else if(currExam.length<=8){//如果在4~8之间
							addExamToBottom(0,4);
							addExamToBottom(4,currExam.length);
						}
					}else if(data.code==0){//如果没有
						currExam = null;
						$("#examList").empty();
						$("#examList").append("<div class='row'><div class='col-md-12'><h3 class='text-center text-primary'>查询的考试不存在</h5></div></div>");
					}
					$("#examList").append("<div class='row'><div class='col-md-12'><h3 class='text-center text-primary'>已经全部加载完毕</h5></div></div>");
				}
			});
		}
	});
	
	$("#reserve_modal").on('show.bs.modal', function (e) {
		var examInfo = $(e.relatedTarget).parents("div.caption").children();
		$("#reserve_modal .ename").text($(examInfo[0]).text());
		$("#reserve_modal .estart").text($(examInfo[2]).text());
		$("#reserve_modal .eend").text($(examInfo[5]).text());
		$("#reserve_modal .edscp").text($(examInfo[6]).text());
		$("#reserve_modal .emaxnum").text($(examInfo[8]).text());
		$("#reserve_modal .ecurrnum").text($(examInfo[9]).text());
		$("#reserve_modal .eid").text($(examInfo[10]).text());
	});
	
	$("#reserveBtn").click(function(){
		$.ajax({
			url: "../reserve.action",
			type: "POST",
			dataType: "JSON",
			data: "eid="+$("#reserve_modal .eid").text()+"&op=reserve",
			success: function(data){
				if(data.code==1){
					alert("预约成功");
					pageNum = 0;
					$("#examList").empty();
					loadExam();
					$("#reserve_modal").modal('hide');
				}else if(data.code==0){
					alert(data.errorMsg);
				}
			}
		});
	});
})
function loadMore(){
	$("#examList div").last().remove();
	loadExam();
	
}
window.onload = function(){
	  var oTop = document.getElementById("to_top");
	  var screenw = document.documentElement.clientWidth || document.body.clientWidth;
	  var screenh = document.documentElement.clientHeight || document.body.clientHeight;
	  oTop.style.left = screenw - oTop.offsetWidth +"px";
	  oTop.style.top = screenh - oTop.offsetHeight + "px";
	  window.onscroll = function(){
	    var scrolltop = document.documentElement.scrollTop || document.body.scrollTop;
	    oTop.style.top = screenh - oTop.offsetHeight + scrolltop +"px";
	  }
	  oTop.onclick = function(){
	    document.documentElement.scrollTop = document.body.scrollTop =0;
	  }
	}  
function loadExam(){
	$.ajax({
		url: "../examination.action?op=getByPage&pageNum="+pageNum+"&pageSize=8",//请求8个
		type: "GET",
		dataType: "JSON",
		success: function(data){
			if(data.code==1){
				currExam = data.obj;
				if(currExam.length<=4){//如果不到4个
					addExamToBottom(0,currExam.length);
				}else if(currExam.length<=8){//如果在4~8之间
					addExamToBottom(0,4);
					addExamToBottom(4,currExam.length);
				}
				$("#examList").append("<div class='row'><div class='col-md-12'><h3 class='text-center'><a onclick='loadMore()' href='javascript:' id='loadMore'>加载更多</a></h3></div></div>");
			}else if(data.code==0){
				currExam = null;
				$("#examList").append("<div class='row'><div class='col-md-12'><h3 class='text-center text-primary'>已经全部加载完毕</h5></div></div>");
			}
			pageNum += 8;//最好改成变量
		}
	});
	lock = true;
}
function addExamToBottom(start,len){
	$("#examList").append("<div class='row'>");
	var bottom = "";
	for(var i = start; i<len; i++){
		//alert(pageNum);
		if(currExam[i].ecurrnum>=currExam[i].emaxnum){//如果已满
			bottom = "<p><a href='javascript:' class='btn btn-primary disabled' role='button'>预约</a>&nbsp;<label class='label label-danger'>已满</label></p>";
		}else{
			bottom = "<p><a href='javascript:' data-toggle='modal' data-target='#reserve_modal'  class='btn btn-primary' role='button'>预约</a>&nbsp;<label class='label label-success'>未满<label></p>";
		}
		$("#examList").append("<div class='col-md-3'>"+
					    "<div class='thumbnail'>"+
					      	"<img src='../"+(currExam[i].epic==""?"image/zanwu.jpg":currExam[i].epic)+"' alt='考试图片'>"+
					      	"<div class='caption'>"+
					        	"<h3>"+currExam[i].ename+"</h3>"+
					        	"<strong>开考时间：</strong><span class='text-danger'>"+currExam[i].estart+"</span><br/>"+
					        	"<strong>结束时间：</strong><span class='text-danger'>"+currExam[i].eend+"</span>"+
					        	"<p style='height:100px'>"+currExam[i].edscp+"</p>"+bottom+
					        	"<small style='display:none'>"+currExam[i].emaxnum+"</small>"+
					        	"<small style='display:none'>"+currExam[i].ecurrnum+"</small>"+
					        	"<small style='display:none'>"+currExam[i].eid+"</small>"+
					      	"</div>"+
					    "</div>"+
					"</div>");
	}
	$("#examList").append("</div>");
}
