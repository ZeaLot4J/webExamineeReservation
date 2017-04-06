<%@page import="com.zealot.util.ZLConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.zealot.bean.Student"%>
<%@ include file="../common/stuHeader.jsp"%>
		<!-- 第二行 -->
		<div class="row-fluid"  style="margin-top:100px">
			<div class="col-md-3">
				<ul class="list-group">
					<li class="list-group-item"><img id="top_avator" class="img-rounded center-block img-link" src="${sessionScope.user.savator==''?'../../ERimage/zanwu.jpg': sessionScope.user.savator}" style="width:200px;height:160px;border:1px solid #222" alt="头像"></li>
					<li class="list-group-item" style="text-align:center">&nbsp;<strong>${sessionScope.user.sname }</strong></li>
					<li class="list-group-item">学号：&nbsp;<strong>${sessionScope.user.sno }</strong></li>
					<li class="list-group-item">性别：&nbsp;<strong>${sessionScope.user.ssex }</strong></li>
					<li class="list-group-item">学校：&nbsp;<strong>${sessionScope.user.sunivsersity==""?"未填":sessionScope.user.sunivsersity }</strong></li>
					<li class="list-group-item">邮箱：&nbsp;<strong>${sessionScope.user.semail}</strong></li>
				</ul>
				<button class="btn btn-danger btn-block btn-lg" style="border-radius:0px" type="button" data-toggle="collapse" data-target="#reservationInfo" aria-expanded="false" aria-controls="collapseExample"><span class="glyphicon glyphicon-list-alt"></span> 我的考试</button>
				<div class="collapse in active" id="reservationInfo">
					<div class="well">
						<a class="student_newReservation"  href="javascript:" onclick="changePanel(this)">最新预约</a></br>
						<a class="student_historyReservation"  href="javascript:" onclick="changePanel(this)">历史预约</a>
					</div>
				</div>
				<button class="btn btn-danger btn-block btn-lg" style="border-radius:0px" type="button" data-toggle="collapse" data-target="#individualInfo" aria-expanded="false" aria-controls="collapseExample"><span class="glyphicon glyphicon-user"></span> 账号管理</button>
				<div class="collapse " id="individualInfo">
					<div class="well">
						<a class="modifyPwd" href="javascript:" onclick="changePanel(this)">修改个人密码</a><br>
						<a class="editSelfInfo" href="javascript:" onclick="changePanel2(this)">编辑个人信息</a>
					</div>
				</div>
				<button class="btn btn-danger btn-block btn-lg" style="border-radius:0px" type="button" data-toggle="collapse" data-target="#messageInfo" aria-expanded="false" aria-controls="collapseExample"><span class="glyphicon glyphicon-envelope"></span> 消息中心</button>
				<div class="collapse" id="messageInfo" >
					<div class="well">
						<a class="student_newMessage" href="javascript:"  onclick="changePanel(this)" >最新消息</a><br>
						<a class="student_historyMessage" href="javascript:"  onclick="changePanel(this)" >历史消息</a><br>
						<a class="student_feedback" href="javascript:" onclick="changePanel(this)">投诉反馈</a>
					</div>
				</div>
				<a href="../examination/selectExam.jsp" class="btn btn-danger btn-block btn-lg" style="border-radius:0px" type="button" ><span class="glyphicon glyphicon-arrow-right"></span> 预约考试</a>
			</div>
			<div class="col-md-9">
				<div class="embed-responsive embed-responsive-16by9" >
					<iframe class="embed-responsive-item" src="student_newReservation.html"></iframe>
				</div>
			</div>
		</div>
<script src="../js/admin.js"></script>
<script>
function changePanel2(obj){
	var panelName = $(obj).attr("class");
	$("iframe").attr("src",panelName+".jsp");
}
</script>
<%@ include file="../common/footer.html"%>		
