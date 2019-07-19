<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/commons/template/modern_business_top.jsp" %>

<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script> -->



<!-- summernote setting-->
<link href="${root}/resources/summernote/summernote.css" rel="stylesheet">
<script src="${root}/resources/summernote/summernote.js"></script>
<!-- summernote korean language pack -->
<script src="${root}/resources/summernote/lang/summernote-ko-KR.js"></script>
<!-- summernote setting-->
<script type="text/javascript">
  $(function() {
    $('.summernote').summernote({
      height: 300,          // 기본 높이값
      minHeight: null,      // 최소 높이값(null은 제한 없음)
      maxHeight: null,      // 최대 높이값(null은 제한 없음)
      focus: true,          // 페이지가 열릴때 포커스를 지정함
      lang: 'ko-KR'         // 한국어 지정(기본값은 en-US)
    });
  });
</script>



<div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h2 class="mt-4 mb-3">자취생활 팁
      <small>- 글쓰기</small>
    </h2>

    <ol class="breadcrumb" style="background-color: #004085!important;"></ol>




    <div class="row">
    <!-- 메인 중앙 -->
    <div class="col-lg-10 mb-4">
      
    <div class="container">
		<form class="form-horizontal">
			<div class="form-group">
				<label for="content" class="col-sm-2 control-label"><p3>내용입력</p3></label>
				<div class="col-sm-10">
					<textarea name="content" id="content" class="summernote"></textarea>
				</div>
				</div>
					<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default" style="color: #007bff; border-color: #007bff;">Save</button>
				</div>
			</div>
		</form>
    </div> 	
     
     
      	
      	
      	
	</div>
	  
	  
	  
	  
	<!-- Sidebar Column -->
	<div class="col-lg-2 mb-4" align="center"><br>
		<div class="list-group">
			<a href="index.html" class="list-group-item">메인</a>
			<a href="about.html" class="list-group-item">자취생활 팁</a>
			<a href="services.html" class="list-group-item">요리 레시피</a>
			<a href="contact.html" class="list-group-item">명예의 전당</a>
		</div>
	</div>
		
		
		
		
	</div>
	<!-- row -->

</div>
<br><br><br><br><br><br><br><br>






  
  
  
  
  
  
  
<%@ include file = "/WEB-INF/views/commons/template/modern_business_bottom.jsp" %>
