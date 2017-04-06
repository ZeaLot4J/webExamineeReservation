/**
 * 共用界面的处理
 */

$(function(){
	$("#stubtn").click(function(){
		var userName = $("#sno").val();
		var userPassword = $("#spwd").val();
		var verifyCode = $("#stuverifycode").val();
		var isAutoLogin = $("#stuautologin").prop("checked");
		
		if(""==userName || ""==userPassword){
			$("#stualertinfo").html("<div class='alert alert-warning'><span class='glyphicon glyphicon-alert'></span>&nbsp;学号或密码不能为空!</div>");
			if(""==userName){
				$("#sno").focus();
			}else if(""==userPassword){
				$("#spwd").focus();
			}
			return;
		}
		if(""==verifyCode){
			$("#stualertinfo").html("<div class='alert alert-warning'><span class='glyphicon glyphicon-alert'></span>&nbsp;验证码不能为空!</div>");
			$("#stuverifycode").focus();
			return;
		}
		
		$.ajax({
			url: "../login.action",
			type: "POST",
			dataType: "JSON",
			data: $("#stuform").serialize()+"&op=stu",
			success: function(data){
				if(data.code==1){//登录成功
					$("#stualertinfo").html("<div class='alert alert-success'><span class='glyphicon glyphicon-alert'></span>&nbsp;登录成功!</div>");
					location.href = "../student/student.jsp";//网址
				}else if(data.code==0){
					$("#stualertinfo").html("<div class='alert alert-danger'><span class='glyphicon glyphicon-alert'></span>&nbsp;"+data.errorMsg+"</div>");
					$("#stuverifycode").val("");
					$("#stuverifyimg").attr("src","../produceVerifyCode.action?"+Math.random()*100);
				}
			}
		});
	});
		
	$("#adminbtn").click(function(){
		var userName = $("#aname").val();
		var userPassword = $("#apwd").val();
		var verifyCode = $("#adminverifycode").val();
		var isAutoLogin = $("#adminautologin").prop("checked");
		
		if(""==userName || ""==userPassword){
			$("#adminalertinfo").html("<div class='alert alert-warning'><span class='glyphicon glyphicon-alert'></span>&nbsp;学号或密码不能为空!</div>");
			if(""==userName){
				$("#aname").focus();
			}else if(""==userPassword){
				$("#apwd").focus();
			}
			return;
		}
		if(""==verifyCode){
			$("#adminalertinfo").html("<div class='alert alert-warning'><span class='glyphicon glyphicon-alert'></span>&nbsp;验证码不能为空!</div>");
			$("#adminverifycode").focus();
			return;
		}
		
		$.ajax({
			url: "../login.action",
			type: "POST",
			dataType: "JSON",
			data: $("#adminform").serialize()+"&op=admin",
			success: function(data){
				if(data.code==1){//登录成功
					$("#adminalertinfo").html("<div class='alert alert-success'><span class='glyphicon glyphicon-alert'></span>&nbsp;登录成功!</div>");
					location.href = "../administrator/admin.jsp";//网址
				}else if(data.code==0){
					$("#adminalertinfo").html("<div class='alert alert-danger'><span class='glyphicon glyphicon-alert'></span>&nbsp;"+data.errorMsg+"</div>");
					$("#adminverifycode").val("");
					$("#adminverifyimg").attr("src","../produceVerifyCode.action?"+Math.random()*100);
				}
			}
		});
	});
	
	
		
	
	
	$('#login_modal').on('shown.bs.modal', function (e){
		$("#stuverifyimg").attr("src","../produceVerifyCode.action?"+Math.random()*100);
	})
	$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
		var tmp = $(e.target).attr("href");
		$(tmp+" img").attr("src","../produceVerifyCode.action?"+Math.random()*100);
	})
	$("#stuverifyimg").click(function(){
		$("#stuverifyimg").attr("src","../produceVerifyCode.action?"+Math.random()*100);
	})
	$("#adminverifyimg").click(function(){
		$("#adminverifyimg").attr("src","../produceVerifyCode.action?"+Math.random()*100);
	})
	$("#login_modal").on('hidden.bs.modal',function(e){
		$("#stualertinfo").html("");
		$("#adminalertinfo").html("");
	});
})