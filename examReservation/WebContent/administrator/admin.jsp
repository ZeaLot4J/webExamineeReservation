<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
		<!-- 第二行 -->
		<div class="row-fluid"  style="margin-top:100px">
			<div class="col-md-3">
				<h3 class="text-center text-primary"><span class="glyphicon glyphicon-menu-hamburger"></span> 后台管理</h3>
		    	<button class="btn btn-primary btn-block btn-lg" style="border-radius:0px" type="button" data-toggle="collapse" data-target="#userInfo" aria-expanded="false" aria-controls="collapseExample"><span class="glyphicon glyphicon-user"></span> 用户信息管理</button>
				<div class="collapse in active" id="userInfo">
					<div class="well">
						<a class="adminInfoManagement" href="javascript:" onclick="changePanel(this)">管理员用户</a><br>
						<a class="stuInfoManagement" href="javascript:" onclick="changePanel(this)">学生用户</a>
					</div>
				</div>
				<button class="btn btn-primary btn-block btn-lg" style="border-radius:0px" type="button" data-toggle="collapse" data-target="#individualInfo" aria-expanded="false" aria-controls="collapseExample"><span class="glyphicon glyphicon-list-alt"></span> 考试科目管理</button>
				<div class="collapse" id="individualInfo">
					<div class="well">
						<a class="examInfoManagement" href="javascript:" onclick="changePanel(this)">考试科目信息</a><br>
					</div>
				</div>
				<button class="btn btn-primary btn-block btn-lg" style="border-radius:0px" type="button" data-toggle="collapse" data-target="#reservationInfo" aria-expanded="false" aria-controls="collapseExample"><span class="glyphicon glyphicon-list"></span> 预约记录管理</button>
				<div class="collapse" id="reservationInfo" >
					<div class="well">
						<a class="newReserveInfoManagement" href="javascript:" onclick="changePanel(this)">最新预约记录</a><br>
						<a class="datedReserveInfoManagement" href="javascript:" onclick="changePanel(this)">历史记录信息</a>
					</div>
				</div>
				<button class="btn btn-primary btn-block btn-lg" style="border-radius:0px" type="button" data-toggle="collapse" data-target="#messageInfo" aria-expanded="false" aria-controls="collapseExample"><span class="glyphicon glyphicon-envelope"></span> 消息中心管理</button>
				<div class="collapse" id="messageInfo" >
					<div class="well">
						<a class="newMessageManagement" href="javascript:" onclick="changePanel(this)">最新消息</a><br>
						<a class="historyMessageManagement" href="javascript:" onclick="changePanel(this)">历史消息</a><br>
						<a class="notification" href="javascript:" onclick="changePanel(this)">发送通知</a>
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<div class="embed-responsive embed-responsive-16by9" >
					<iframe class="embed-responsive-item" src="adminInfoManagement.html"></iframe>
				</div>
			</div>
		</div>
<script src="../js/admin.js"></script>
<%@ include file="/common/footer.html"%>		
