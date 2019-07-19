<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
function groupDetailModalSetting(json) {
	var group = json.group;
	//console.log(group);
	$("#groupDetailModal .card-body .card-title").text(group.groupName);
	$("#groupDetailModal .card-body .groupDescription").text(group.groupDescription);
	$("#groupDetailModal .card-body .groupCategoryName").text("카테고리 : " + group.groupCategoryName);
	$("#groupDetailModal .card-body .groupMember").text("인원 : " + group.groupMemberCount + " / " + group.groupMemberLimit);
	$("#groupDetailModal .card-body .groupMainPlace").text("주요장소 : " + group.groupMainPlace);
	$("#groupDetailModal .modal-body .card-img-top").attr("src", group.groupImgSrc);
	var tag = json.taglist;
	var tagStr = "";
	for(var i=0; i<tag.length ; i++){
		tagStr += "<tag>#" + tag[i] + "</tag> ";
	}
	$("#groupDetailModal .card-body .taglist").html(tagStr);
	$("#groupDetailModal .modal-footer .btn-primary").attr("data-num", group.groupNum);
}

$(function() {
	
});

</script>
<div id="groupDetailModal" class="modal fade" role="dialog">
	<div class="modal-dialog modal-dialog-scrollable modal-lg">
		<div class="modal-content">
			<div class="modal-header text-center">
				<label style="margin-left: auto; margin-bottom:auto; margin-top:auto; font-size: 1.5rem">모임 상세 설명</label>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">X</span>
				</button>
			</div>
			<div class="modal-body text-center">
				<img class="card-img-top"
					src="https://cdn.studysearch.co.kr/images/leader/357/4564-1560735145.png?v=1560735145"
					alt="">
				<h4 class="card-title">영어단어 스터디</h4>
				<div class="card-body">
					<p class="card-text groupDescription">모임설명</p>
					<p class="card-text groupCategoryName">카테고리 : </p>
					<p class="card-text taglist"></p>
					<p class="card-text groupMember">인원 : </p>
					<p class="card-text groupMainPlace">장소 : </p>
				</div>
			</div>
			
			<!-- Modal footer -->
	        <div class="modal-footer">
	        	<button type="button" class="btn btn-primary" data-num="">가입신청</button>
	          	<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
	        </div>
		</div>
	</div>
</div>