<%@page import="com.zealot.util.ZLConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.zealot.bean.Student"%>
<meta name="viewpoint" content="width=device-width,initial-scale=1.0" charset="UTF-8">
<link href="../css/bootstrap.min.css" rel="stylesheet"/>
<link href="../css/bootstrap-table.min.css" rel="stylesheet"/>
<link href="../css/main.css" rel="stylesheet"/>
<script src="../js/jquery-1.9.1.js"></script>

<form class="form-horizontal" role="form">
	<div class="panel panel-danger">
		<div class="panel-heading">个人信息</div>
		<div class="panel-body">
			<div class="form-group">
				<div class="col-sm-2 control-label">头像：</div>
				<div class="col-sm-4">
					<div id="showpic" style="width:100px;height:100px">
						<img alt="头像" style="width:100px;height:100px" src="${sessionScope.user.savator==''?'../../ERimage/zanwu.jpg': sessionScope.user.savator}">
					</div>
				</div>
				<div class="col-sm-2 control-label">选择：</div>
				<div class="col-sm-4">
					<input type="file" name="savator" id="savator" multiple="multiple" onchange="previewMultipleImage(this,'showpic')"  class="form-control">
				</div>
			</div>	
			<div class="form-group">
				<div class="col-sm-2 control-label">学号：</div>
				<div class="col-sm-4">
					<input value="${sessionScope.user.sno }" type="text" name="sno" id="sno" class="form-control" disabled>
				</div>
				<div class="col-sm-2 control-label">性别：</div>
				<div class="col-sm-4">
					<input value="${sessionScope.user.ssex }" type="text" name="ssex" id="ssex" class="form-control disabled" value="男" disabled>
				</div>
			</div>	
			<div class="form-group">
				<div class="col-sm-2 control-label" >姓名：</div>
				<div class="col-sm-4">
					<input value="${sessionScope.user.sname }" type="text" name="sname" id="sname" class="form-control" disabled>
				</div>
				<div class="col-sm-2 control-label">出生日期：</div>
				<div class="col-sm-4">
					<input value="${sessionScope.user.sbirth }" type="text" name="sbirth" id="sbirth" class="form-control">
				</div>
			</div>	
			<div class="form-group">
				<div class="col-sm-2 control-label" >身份证号码：</div>
				<div class="col-sm-4">
					<input value="${sessionScope.user.sidentity }" type="text" name="sidentity" id="sidentity" class="form-control" disabled>
				</div>
				<div class="col-sm-2 control-label">邮箱：</div>
				<div class="col-sm-4">
					<input value="${sessionScope.user.semail }" type="text" name="semail" id="semail" class="form-control">
				</div>
			</div>	
			<div class="form-group">
				<div class="col-sm-2 control-label">电话：</div>
				<div class="col-sm-4">
					<input value="${sessionScope.user.stel }" type="text" name="stel" id="stel" class="form-control">
				</div>
				<div class="col-sm-2 control-label">学校：</div>
				<div class="col-sm-4">
					<input value="${sessionScope.user.sunivsersity }" type="text" name="sunivsersity" id="sunivsersity" class="form-control">
				</div>
			</div>	
			<div class="form-group">
				<div class="col-sm-12 col-sm-pull-5 control-label">
					<button type="button" id="saveInfo" class="btn btn-danger btn-lg">保存 <span class="glyphicon glyphicon-save"></span></button>
				</div>
			</div>	
			
		</div>
	</div>
</form>

<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-table.min.js"></script>
<script src="../js/bootstrap-table-zh-CN.min.js"></script>
<script src="../js/common.js"></script>
<script src="../js/ajaxfileupload.js"></script>
<script src="../js/showpic.js"></script>
<script>
$(function(){
	$("#saveInfo").click(function(){
		var sbirth = $("#sbirth").val();
		var semail = $("#semail").val();
		var sunivsersity = $("#sunivsersity").val();
		var stel = $("#stel").val();
		data={sbirth:sbirth,semail:semail,sunivsersity:sunivsersity,stel:stel};
		
		$.ajaxFileUpload({
 			url:"../student.action?op=saveInfo",
 			secureuri:false,
 			fileElementId:"savator",// ["pic","pic"]要上传的文件的文本框的id
 			data:data,
 			dataType:"json",
 			success:function(data,status){
 				data=$.trim(data);
 				if(data=="0"){
 					alert("保存失败");
 				}else{
 					alert("信息保存成功");
 					console.info($("#top_avator"));//.attr("src","${sessionScope.user.savator}");
 				}
 			},
 			error:function(data,status,e){
 				alert(e);
 			}
 		});
	});
});
</script>