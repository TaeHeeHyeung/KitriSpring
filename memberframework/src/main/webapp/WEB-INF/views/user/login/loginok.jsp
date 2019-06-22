<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>


<script type="text/javascript">
function deleteMember(){
	//alert
	//confirm: return true false
	//property 
	if(confirm("정말로 탈퇴?")){
		$(location).attr("href", "${root}/user/delete.kitri");
	}
}
	
	
</script>
<c:if test="${userInfo !=null }">
	${userInfo.name }(${userInfo.id })님 로그인을 환영합니다..
</c:if>
<br>
<a href="${root}/user/logout.kitri"> 로그아웃</a>
<a href="${root}/user/modify.kitri"> 정보수정</a>
<a href="#" onclick="javascript: deleteMember();"> 회원탈퇴</a>

<c:if test="${'hth0893' == userInfo.id }">
	<a href="${root}/admin/mvmemberlist.kitri"> 관리자</a>
</c:if>
<c:if test="${'java2' == null }">
	<c:redirect url="/user/login.kitri"></c:redirect>
</c:if>
로그인 후 모든 서비스를 이용할 수 있습니다.

<a href=""></a>
<%@ include file="/WEB-INF/views/template/footer.jsp"%>