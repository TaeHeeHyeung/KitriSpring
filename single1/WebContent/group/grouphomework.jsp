<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/commons/template/modern_business_top.jsp"%>
<%@ include file="/WEB-INF/views/commons/alert_danger.jsp"%>
<%@ include file="/WEB-INF/views/commons/alert_success.jsp"%>
<link rel="stylesheet" href="${root}/resources/css/group/group.css">

<style>
/* 페이지에 유지할 부분*/
.carousel-item{
	height : 30vh;
}

</style>
<script>
$(function() {
	var width = 1;
	
	
	var interval = setInterval(frame, 10);
	
	function frame() {
		var progress = $(".ing");
		var progressBar = $(".progressBar");
		if(progress.length == 0){
			clearInterval(interval);
		}
		
		$.each(progress, function(index, item) {
			var progressBar = $(item).children(".progress-bar");
			var width = parseInt(progressBar.attr("data-prog"));
			var maxWidth = parseInt($(item).attr("data-prog"));
			//console.log("width : " + width + "//" + "maxWidth : " + maxWidth);
			if(width >= maxWidth){
				$(item).removeClass("ing");
			}else{
				progressBar.attr("data-prog" , width + 1);
				progressBar.css("width", width + 1 + "%");
			}
		});
	}
});



</script>


<%@ include file="groupheader.jsp"%>

<section class="contents">
	<div class="container col-lg-9 col-md-9 col-sm-9 whitespace">		
		<div class="groupmain">
		<!-- 모임 이름 뿌져지는 곳 -->
		<section class="groupsection groupheader">
			<div class="row">
				<div class="groupname center">모임 과제 관리</div>
			</div>
		</section>
		
		<!-- 과제 시작 -->
		<section class="groupsection homework">
			<div class="homework-item">
				<div class="homework-body col-sm-8">
					<h4 class="homework-title">기타를 칩시다</h4>
					<div class="homework-content">
					기타를 띵가띵가
					기타를 띵가띵가
					기타를 띵가띵가
					</div>
					<div class="homework-footer progress ing" data-prog="30">
						  <div class="progress-bar" data-prog="1"></div>
					</div>
				</div>
				<div class="col-sm-2 homework-status" style="background-image: none;">진행중</div>
			</div>
		</section>	
		
		<!-- 과제 시작 -->
		<section class="groupsection homework homework-end">
			<div class="homework-item">
				<div class="homework-body col-sm-8">
					<h4 class="homework-title">기타를 칩시다</h4>
					<div class="homework-content">
					50% 미만은 빨강불
					</div>
					<div class="homework-footer progress ing" data-prog="60" >
						<div class="progress-bar" data-prog="1"></div>
					</div>
				</div>
				<div class="col-sm-2 homework-status" 
					style="background-image: url('${root}/resources/img/group/checked_yellow.png')"></div>
			</div>
		</section>	
		
		<!-- 과제 시작 -->
		<section class="groupsection homework homework-end">
			<div class="homework-item">
				<div class="homework-body col-sm-8">
					<h4 class="homework-title">기타를 칩시다</h4>
					<div class="homework-content">
					50% 이상은 노랑불
					</div>
					<div class="homework-footer progress ing" data-prog="90" >
						<div class="progress-bar" data-prog="1"></div>
					</div>
				</div>
				<div class="col-sm-2 homework-status" 
					style="background-image: url('${root}/resources/img/group/checked_red.png')"></div>
			</div>
		</section>	
		<!-- 과제 시작 -->
		<section class="groupsection homework homework-end">
			<div class="homework-item">
				<div class="homework-body col-sm-8">
					<h4 class="homework-title">기타를 칩시다</h4>
					<div class="homework-content">
					80% 이상은 초록불
					</div>
					<div class="homework-footer progress ing" data-prog="90" >
						<div class="progress-bar" data-prog="1"></div>
					</div>
				</div>
				<div class="col-sm-2 homework-status" 
					style="background-image: url('${root}/resources/img/group/checked_green.png')"></div>
			</div>
		</section>	
		<%@ include file="/WEB-INF/views/commons/pagination.jsp"%>	
	</div>
	</div>
</section>
<!-- /.container -->

<%@ include file="/WEB-INF/views/commons/template/modern_business_bottom.jsp"%>
