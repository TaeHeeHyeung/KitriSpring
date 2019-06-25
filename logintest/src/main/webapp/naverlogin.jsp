<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.security.SecureRandom"%>
<%@ page import="java.math.BigInteger"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<c:set var="cookies" value="${reqeustScope.cookie}" />
<c:set var="svid" value="${svid }" />
<c:set var="ckid" value="${ckid }" />


<html>
<head>
<title>네이버 로그인</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<!-- (1) LoginWithNaverId Javscript SDK -->
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>


</head>
<body>
	
		
	<!-- Button to Open the Modal -->
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#myModal">로그인</button>
	<!-- The Modal -->
	<div class="modal" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<form id="loginform" method="post">
					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">로그인</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<div class="form-group" align="left">
							<label for="">아이디</label> <input type="text" class="form-control"
								id="id" name="id" placeholder="" value="${svid }">

						</div>
						<div class="form-group" align="left">
							<label for="">비밀번호</label> <input type="password"
								class="form-control" id="pass" name="pass" placeholder="">
						</div>

						<div class="form-group" align="right">
							<button type="button" class="btn btn-primary" id="loginBtn">로그인</button>
							<button type="button" class="btn " id="moveRegisterBtn">회원가입</button>
							<div id="naver_id_login"></div>
							<label class="form-check-label" for="checkid"> <input
								type="checkbox" class="form-check-input" id="checkid"
								name="idsave" value="idsave" checked="${ckid}"> 아이디 저장
							</label>
						</div>

					</div>

				</form>
			</div>

		</div>
	</div>
	<script type="text/javascript">
		// 	var naver_id_login = new naver_id_login("YOUR_CLIENT_ID", "YOUR_CALLBACK_URL");
		
// 		
		var naver_id_login = new naver_id_login("3FGMY2V_UXaBQxS0sx0g", "http://localhost/login/navercallback.jsp");
	  	var state = naver_id_login.getUniqState();
	  	naver_id_login.setButton("white", 2,40);
	  	naver_id_login.setDomain("http://localhost/login");
	  	naver_id_login.setState(state);
	  	naver_id_login.setPopup();
	  	naver_id_login.init_naver_id_login();
	</script>
</body>
</html>