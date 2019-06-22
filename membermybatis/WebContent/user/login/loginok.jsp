<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/template/header.jsp"%>


<script type="text/javascript">
function deleteMember(){
	//alert
	//confirm: return true false
	//property 
	if(confirm("정말로 탈퇴?")){
		document.location.href="${root}/user?act=deletemember";
		}
	}
	
	
</script>
<c:if test="${userInfo !=null }">
	${userInfo.name }(${userInfo.id })님 로그인을 환영합니다..
</c:if>
<br>
<a href="${root}/user?act=logout"> 로그아웃</a>
<a href="${root}/user?act=mvmodify"> 정보수정</a>
<a href="#" onclick="javascript: deleteMember();"> 회원탈퇴</a>

<c:if test="${'java2' == userInfo.id }">
	<a href="${root}/admin?act=memberlist"> 관리자</a>
</c:if>
<c:if test="${'java2' == null }">
	<c:redirect url="/user?act=mvlogin"></c:redirect>
</c:if>

로그인 후 모든 서비스를 이용할 수 있습니다.

<a href=""></a>
<%@ include file="/template/footer.jsp"%>