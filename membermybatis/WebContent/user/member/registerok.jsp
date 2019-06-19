<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/template/header.jsp"%>
<c:if test="${userInfo !=null }">
	<strong>${userInfo.name }</strong>님 회원가입을 환영합니다.<br>
	가입하신 정보는 아래와 같습니다.<br>
	아이디 :${userInfo.id }<br>
	이름:${userInfo.name }<br>
	전화번호 :${userInfo.tel1 }-${userInfo.tel2 }-${userInfo.tel3 }<br>
	주소: ${userInfo.zipcode} ${userInfo.address } ${userInfo.addressDetail }
</c:if>

<br>
<c:if test="${userInfo ==null }">
	<c:redirect url="/user/"> </c:redirect>
</c:if>


<%@ include file="/template/footer.jsp"%>