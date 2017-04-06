<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, javax.sql.*, javax.naming.*,com.zealot.dao.DBHelper,java.util.*"%>
<html>     
<head>     
<title>Tomcat6.0 JNDI!</title>    
<script src="js/jquery-1.9.1.js"></script>
<script src="js/ajaxfileupload.js"></script>
</head>    
  <body>      
		<button id="import" type="button" class="btn btn-primary btn-lg">导入</button>
		<input id="excel" name="excel" type="file" class="input-lg" style="border:3px solid #337ab7;background-color:white">
		<button id="import2" type="button" >导入</button>
		<input id="excel2" name="excel2" type="file" style="border:3px solid #337ab7;background-color:white">
	
<script type="text/javascript">
	$(function(){
		$("#import").click(function(){	
			if($("#excel").val()==""){
				return;
			}
			
			$.ajaxFileUpload({
				url:"import.action?op=importExamInfo",
				secureuri:false,
				fileElementId:"excel",
				dataType:"json",
				success:function(data,status){
					data = $.trim(data);
					if(data=="0"){
						alert("导入失败，学号重复或格式错误");
					}else{
						alert("导入成功");
						$("#stuInfoTable").bootstrapTable('refresh', {url: '../student.action?op=all'});
					}
				},
				error:function(data,status,e){
					alert(e);
				}
			});
		});
		$("#import2").click(function(){	
			if($("#excel2").val()==""){
				return;
			}
		
			$.ajaxFileUpload({
				url:"import.action?op=importExamInfo",
				secureuri:false,
				fileElementId:"excel2",
				dataType:"text",
				success:function(data,status){
					data = $.trim(data);
					if(data=="0"){
						alert("导入失败，格式有误");
					}else{
						alert("导入成功");
						$("#examInfoTable").bootstrapTable('refresh', {url: '../examination.action?op=all'});
					}
				},
				error:function(data,status,e){
					alert(e);
				}
			});
		});
	});
</script>
  </body>     
</html>   