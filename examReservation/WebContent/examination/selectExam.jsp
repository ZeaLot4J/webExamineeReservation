<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/stuHeader.jsp"%>
<!-- 第二行 -->
<style>
#to_top{width:60px; height:70px; padding:20px; font:14px/20px arial; text-align:center;  background:#06c; position:absolute; cursor:pointer; color:#fff}
</style>
<div id="to_top"><span class="glyphicon glyphicon-chevron-up"></span></div>
<div class="row-fluid" style="margin-top: 70px">
	<div class="col-md-12">
		<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0"
					class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				<li data-target="#carousel-example-generic" data-slide-to="3"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="../image/carousel2.png" style="width: 100%; height: 430px"
						alt="无法显示">
					<div class="carousel-caption"></div>
				</div>
				<div class="item">
					<img src="../image/carousel1.jpg" style="width: 100%; height: 430px"
						alt="无法显示">
					<div class="carousel-caption"></div>
				</div>
				<div class="item">
					<img src="../image/carousel3.jpg" style="width: 100%; height: 430px"
						alt="无法显示">
					<div class="carousel-caption"></div>
				</div>
				<div class="item">
					<img src="../image/carousel4.png" style="width: 100%; height: 430px"
						alt="无法显示">
					<div class="carousel-caption"></div>
				</div>
			</div>
			<a class="left carousel-control" href="#carousel-example-generic"
				role="button" data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#carousel-example-generic"
				role="button" data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>
</div>
<div class="row-fluid">
	<div class="col-md-3"></div>
	<div class="col-md-6">
		<h2 class="text-primary text-center">考试预约</h2>
		<div class="input-group has-error">
	     	<input id="searchExam" type="text" style="border:2px solid #337ab7;border-right:0px;border-radius:0px" class="form-control input-lg" placeholder="请输入考试科目名称">
	    	<span class="input-group-btn">
	        	<button id="searchBtn" class="btn btn-primary btn-lg" type="button" style="border-radius:0px"><span class="glyphicon glyphicon-search"></span></button>
	      	</span>
	    </div>
    </div>
	<div class="col-md-3"></div>
</div>
<div class="container" id="examList">
</div>
<!--弹出预约模态框-->	
<div class="modal fade" id="reserve_modal" data-keyboard="false">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h3 class="modal-title" style="text-align:center"><label for="inputName">考试信息</label></h3>
			</div>
			<div class="modal-body">
				<dl class="dl-horizontal">
					<dt class="text-default">
						编号：
					</dt>
					<dd class="eid">
					</dd>
					<dt class="text-danger">
						考试科目：
					</dt>
					<dd class="ename">
					</dd>
					<dt class="text-primary">
						开考时间：
					</dt>
					<dd class="estart">
					</dd>
					<dt class="text-primary">
						结束时间：
					</dt>
					<dd class="eend">
					</dd>
					<dt class="text-success">
						最大预约人数：
					</dt>
					<dd class="emaxnum">
					</dd>
					<dt class="text-success">
						已经预约人数：
					</dt>
					<dd class="ecurrnum">
					</dd>
					<dt class="text-info">
						描述：
					</dt>
					<dd class="edscp">
					</dd>
				</dl>
				<div class="modal-footer">
					<div class="col-md-12">
						<button id="reserveBtn" type="button" class="btn btn-primary btn-lg btn-block">预约考试&nbsp;<span class="glyphicon glyphicon-ok"></span></button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="../js/selectExam.js"></script>
<%@ include file="../common/footer.html"%>