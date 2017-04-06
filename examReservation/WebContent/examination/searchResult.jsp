<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!-- 第二行 -->
<div class="row-fluid" style="padding-top: 50px">
	<div class="col-md-3"></div>
	<div class="col-md-6">
		<h2 class="text-danger text-center">考试预约</h2>
		<div class="input-group has-error" >
	     	<input type="text" style="border:2px solid #d9534f;border-right:0px;border-radius:0px" class="form-control input-lg" placeholder="请输入考试科目名称">
	    	<span class="input-group-btn">
	        	<button class="btn btn-danger btn-lg" type="button" style="border-radius:0px"><span class="glyphicon glyphicon-search"></span></button>
	      	</span>
	    </div>
    </div>
	<div class="col-md-3"></div>
</div>
<div class="row-fluid" style="margin-top: 150px">
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
					<img src="image/bg1.jpg" style="width: 100%; height: 300px"
						alt="无法显示">
					<div class="carousel-caption">图片一</div>
				</div>
				<div class="item">
					<img src="image/bg2.jpg" style="width: 100%; height: 300px"
						alt="无法显示">
					<div class="carousel-caption">图片二</div>
				</div>
				<div class="item">
					<img src="image/bg3.jpg" style="width: 100%; height: 300px"
						alt="无法显示">
					<div class="carousel-caption">图片三</div>
				</div>
				<div class="item">
					<img src="image/bg4.jpg" style="width: 100%; height: 300px"
						alt="无法显示">
					<div class="carousel-caption">图片四</div>
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

<div class="row-fluid" style="margin-top: 480px">
	<div class="col-md-6">
		<div class="jumbotron" style="background-color: white;border-radius:0px">
			<ul class="media-list">
				<li class="media">
					<div class="media-left" style="border-radius:0px">
						<a href="#"> <img class="media-object img-thumbnail"
							src="image/bg1.jpg"
							style="width: 200px; height: 160px;border-radius:0px"
							alt="考试信息">
						</a>
					</div>
					<div class="media-body">
						<h2 class="media-heading">中国历史</h2>
						<span class="label label-info">未满</span> 
						<a class="btn btn-lg" data-toggle="modal" data-target="#reserve_modal">查看详情</a><br>
						<span>
							开考时间：<strong class="text-success">2016年12月30日8:00</strong><br>
							结束时间：<strong class="text-success">2016年12月30日8:00</strong>
						</span>
					</div>
				</li>
				<li class="media">
					<div class="media-left">
						<a href="#"> <img class="media-object img-thumbnail"
							src="image/bg2.jpg"
							style="width: 200px; height: 160px;border-radius:0px"
							alt="考试信息">
						</a>
					</div>
					<div class="media-body">
						<h2 class="media-heading examName">计算机网络</h2>
						<span class="label label-danger">已满</span>
						<a href="javascript:" type="button" class="btn btn-lg">查看详情</a><br>
						<span>
							开考时间：<strong class="text-success">2016年12月30日8:00</strong><br>
							结束时间：<strong class="text-success">2016年12月30日8:00</strong>
						</span>
					</div>
				</li>
				<li class="media">
					<div class="media-left">
						<a href="#"> <img class="media-object img-thumbnail"
							src="image/bg3.jpg"
							style="width: 200px; height: 160px;border-radius:0px"
							alt="考试信息">
						</a>
					</div>
					<div class="media-body">
						<h2 class="media-heading">英语四级</h2>
					</div>
				</li>
				<li class="media">
					<div class="media-left">
						<a href="#"> <img class="media-object img-thumbnail"
							src="image/bg4.jpg"
							style="width: 200px; height: 160px;border-radius:0px"
							alt="考试信息">
						</a>
					</div>
					<div class="media-body">
						<h2 class="media-heading">日语N4</h2>
					</div>
				</li>
				<li class="media">
					<div class="media-left">
						<a href="#"> <img class="media-object img-thumbnail"
							src="image/bg4.jpg"
							style="width: 200px; height: 160px;border-radius:0px"
							alt="考试信息">
						</a>
					</div>
					<div class="media-body">
						<h2 class="media-heading">日语N4</h2>
					</div>
				</li>
			</ul>
		</div>
	</div>
	<div class="col-md-6">
		<div class="jumbotron" style="background-color: white;border-radius:0px">
			<ul class="media-list">
				<li class="media">
					<div class="media-left">
						<a href="#"> <img class="media-object img-thumbnail"
							src="image/bg1.jpg"
							style="width: 200px; height: 160px;border-radius:0px"
							alt="考试信息">
						</a>
					</div>
					<div class="media-body">
						<h2 class="media-heading">中国历史</h2>
						<span class="label label-info">未满</span> <a href="javascript:"
							type="button" class="btn btn-lg">查看详情</a>

					</div>
				</li>
				<li class="media">
					<div class="media-left">
						<a href="#"> <img class="media-objectimg-thumbnail"
							src="image/bg2.jpg"
							style="width: 200px; height: 160px;border-radius:0px"
							alt="考试信息">
						</a>
					</div>
					<div class="media-body">
						<h2 class="media-heading examName">计算机网络</h2>
						<span class="label label-danger">已满</span>
					</div>
				</li>
				<li class="media">
					<div class="media-left">
						<a href="#"> <img class="media-object img-thumbnail"
							src="image/bg3.jpg"
							style="width: 200px; height: 160px;border-radius:0px"
							alt="考试信息">
						</a>
					</div>
					<div class="media-body">
						<h2 class="media-heading">英语四级</h2>
					</div>
				</li>
				<li class="media">
					<div class="media-left">
						<a href="#"> <img class="media-object img-thumbnail"
							src="image/bg4.jpg"
							style="width: 200px; height: 160px;border-radius:0px"
							alt="考试信息">
						</a>
					</div>
					<div class="media-body">
						<h2 class="media-heading">日语N4</h2>
					</div>
				</li>
				<li class="media">
					<div class="media-left">
						<a href="#"> <img class="media-object img-thumbnail"
							src="image/bg4.jpg"
							style="width: 200px; height: 160px;border-radius:0px"
							alt="考试信息">
						</a>
					</div>
					<div class="media-body">
						<h2 class="media-heading">日语N4</h2>
					</div>
				</li>
			</ul>
		</div>		
	</div>
</div>
<div class="row-fluid">
	<div class="col-md-12 text-center">
		<ul class="pagination pagination-lg">
			<li class="disabled"><a href="javascript:"  style="border-radius:0px" aria-label="Previous"> <span aria-hidden="true">上一页</span></a></li>
			<li class="active"><a href="javascript:">1</a></li>
			<li><a href="javascript:">2</a></li>
			<li><a href="javascript:">2</a></li>
			<li><a href="javascript:">2</a></li>
			<li><a href="javascript:">2</a></li>
			<li><a href="javascript:">2</a></li>
			<li><a href="javascript:">2</a></li>
			<li><a href="javascript:">2</a></li>
			<li><a href="javascript:">2</a></li>
			<li><a href="javascript:">2</a></li>
			<li><a href="javascript:">2</a></li>
			<li><a href="javascript:">2</a></li>
			<li><a href="javascript:">2</a></li>
			<li><a href="javascript:">2</a></li>
			<li><a href="javascript:">2</a></li>
			<li><a href="javascript:">3</a></li>
			<li><a href="javascript:"  style="border-radius:0px" aria-label="Next"> <span aria-hidden="true">下一页</span>	</a></li>
		</ul>
	</div>
</div>

<!--弹出预约模态框-->	
<div class="modal fade" id="reserve_modal" data-keyboard="false">
	<div class="modal-dialog">
		<div class="modal-content" style="border-radius:0px">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h3 class="modal-title" style="text-align:center"><label for="inputName">考试信息</label></h3>
			</div>
			<div class="modal-body">
				<dl class="dl-horizontal">
					<dt class="text-danger">
						考试科目：
					</dt>
					<dd>
						中国历史
					</dd>
					<dt class="text-primary">
						开考时间：
					</dt>
					<dd>
						2016年12月31日8:00
					</dd>
					<dt class="text-primary">
						结束时间：
					</dt>
					<dd>
						2016年12月31日9:40
					</dd>
					<dt class="text-success">
						最大预约人数：
					</dt>
					<dd>
						500
					</dd>
					<dt class="text-success">
						已经预约人数：
					</dt>
					<dd>
						400
					</dd>
					<dt class="text-info">
						描述：
					</dt>
					<dd>
						考察学生对中国千年历史的了解程度，宏扬中国辉煌文化，培养一批历史学者
					</dd>
				</dl>
				<div class="modal-footer">
					<div class="col-md-12">
						<button type="submit" style="border-radius:0px" class="btn btn-danger btn-lg btn-block">预约考试&nbsp;<span class="glyphicon glyphicon-ok"></span></button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../common/footer.html"%>