<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.net.HttpURLConnection"%>
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.InputStreamReader"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<title>NaverLoginSDK</title>
</head>

<body>
	<script>
		//키 , 사용자가 등록한 콜백 값 
		var naver_id_login = new naver_id_login("3FGMY2V_UXaBQxS0sx0g", "http://localhost/login");
		// 접근 토큰 값 
		var token = naver_id_login.oauthParams.access_token;
		// 네이버 사용자 프로필 조회
		naver_id_login.get_naver_userprofile("naverSignInCallback()");
		// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
		
		var email;
		function naverSignInCallback() {
			email = naver_id_login.getProfileData('email');
			console.log('email' + email);
			console.log('token' + token);
			//naver_id_login.getProfileData('nickname');
			//alert(naver_id_login.getProfileData('age'));
			
		}
	</script>
</body>

</html>