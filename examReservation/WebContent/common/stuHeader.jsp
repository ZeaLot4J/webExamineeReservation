<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewpoint" content="width=device-width,initial-scale=1.0" charset="UTF-8">
<title>ZeaLot考试预约系统</title>
<link rel="icon" href="../image/logo.png" type="image/x-icon"/>
<link href="../css/bootstrap.min.css" rel="stylesheet"/>
<link href="../css/bootstrap-table.min.css" rel="stylesheet"/>
<link href="../css/main.css" rel="stylesheet"/>
<script src="../js/jquery-1.9.1.js"></script>
</head>
<body style="background:url(../image/page_bg.jpg);background-size:cover">
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-12">
				<nav class="navbar navbar-inverse navbar-fixed-top" >
					<div class="navbar-header" style="margin-left:60px">
							<img src="../image/author4.png" class="img-responsive" alt="作者">
					</div>
					<ul class="nav navbar-nav navbar-right" style="margin-right:100px">
						<li>
							<a class="btn" data-toggle="modal" data-target="#login_modal"><span class="glyphicon glyphicon-retweet"></span><span>&nbsp;切换用户</span></a>
						</li>
						<li>
							<a class="btn" id="exit"><span class="glyphicon glyphicon-log-out"></span><span>&nbsp;退出</span></a>
						</li>
						<li>
							<a href="../student/student.jsp" class="btn"><span class="glyphicon glyphicon-user"></span>&nbsp;当前用户:&nbsp;<span class="text-info" id="currUser">${sessionScope.user.sname }</span></a>
						</li>
					</ul>
				</nav>
			</div>
		</div>
<script>
$(function(){
	$("#exit").click(function(){
		
		$.ajax({
			url: "../login.action?op=logout",
			dataType: "JSON",
			success: function(data){
				location.href = "../login.html";//网址
			}
		});
	});

})


</script>