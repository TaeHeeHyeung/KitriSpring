<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/commons/template/top.jsp" %>

<style>
.menulist {width:300px;}
.category{
	padding: 5px 10px;
	cursor: pointer;
	position: relative;
	font-weight: bold;
	text-align:left;
	background-color: aqua;
}
.menu{
 	display: none; 
	text-align: left;

}

.menu a{
	display: block;
	background-color: light-gray;
	padding: 10px;
	text-decoration: none;
}

.menu a:hover{
	color:#000000;
	text-decoration: underline;
}
</style>
<script>
$(document).ready(function() {
	$("#boardmenu p.category").click(function() {
		$(this).next("div.menu").slideDown(500).siblings("div.menu").slideUp("slow");
	});
});
</script>
<div id ="boardmenu">
	<c:set var= "idx" value ="0"/>
	<c:forEach var="board" items="${boardmenu}" varStatus="i">
	<c:if test="${idx != board.ccode }">	
		<p class ="category">${board.cname}</p>
		<c:set var ="idx" value="${board.ccode }"/>
		<div class ="menu">
	</c:if>
	
<%-- 	<a href="${root}/${board.control}/write?bcode=${board.bcode}&pg=1&key=&word="> --%>
	<a href="${root}/${board.control}/list?bcode=${board.bcode}&pg=1&key=&word=">
		${board.bname}
	</a>
	<c:if test= "${i.index < boardmenu.size() - 1 }" >
		<c:if test="${idx != boardmenu.get(i.index+1).ccode }">
		</div>
		</c:if>
	</c:if>
	</c:forEach>
	</div>
</div>
<%@ include file = "/WEB-INF/views/commons/template/bottom.jsp" %>