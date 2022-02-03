<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>    
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type ="text/javascript">

$(function(){
	$("#search").click(function() {
		alert("조회완료");
	});
});

$(function(){
	$("#add").click(function() {
		alert("저장완료");
		
		var rowData = new Array();
		var tdArr = new Array();
		var checkbox = $("input[id=up_CheckBox]:checked");
		
		checkbox.each(function(i) {
			
			// checkbox.parent() : checkbox의 부모는 <td>이다.
			// checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();
			
			// 체크된 row의 모든 값을 배열에 담는다.
			rowData.push(tr.text());
			
			// td.eq(0)은 체크박스 이므로  td.eq(1)의 값부터 가져온다.
			var mr_Date = td.eq(2).find('input[type="text"]').val();
			var mr_Warehouse = td.eq(3).find('input[type="text"]').val();
			var mr_Place = td.eq(4).find('input[type="text"]').val();
			var rd_Process = td.eq(5).find('input[type="text"]').val();
			var rd_Workspace = td.eq(6).find('input[type="text"]').val();
			var emp_Name = td.eq(7).find('input[type="text"]').val();
			
			// 가져온 값을 배열에 담는다.
			tdArr.push(mr_Date);
			tdArr.push(mr_Warehouse);
			tdArr.push(mr_Place);
			tdArr.push(rd_Process);
			tdArr.push(rd_Workspace);
			tdArr.push(emp_Name);
	
			console.log(tdArr);
			
			$.ajax({
                type : 'GET',
                url : 'add_material_release.do',
                data : {
                    tdArr : tdArr},
                error:function(request,status,error){
                        alert("저장실패");
                       },
                success:function(result){
                	 location.reload();
                }
                    
                });
			
		});
	});
});
	
$(function(){
	$("#mod").click(function() {
		alert("수정완료");
		
		var rowData = new Array();
		var tdArr = new Array();
		var checkbox = $("input[id=up_CheckBox]:checked");
		
		checkbox.each(function(i) {
			
			// checkbox.parent() : checkbox의 부모는 <td>이다.
			// checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();
			
			// 체크된 row의 모든 값을 배열에 담는다.
			rowData.push(tr.text());
			
			// td.eq(0)은 체크박스 이므로  td.eq(1)의 값부터 가져온다.
			var mr_NO = td.eq(1).find('input[type="text"]').val();
			var mr_Date = td.eq(2).find('input[type="text"]').val();
			var mr_Warehouse = td.eq(3).find('input[type="text"]').val();
			var mr_Place = td.eq(4).find('input[type="text"]').val();
			var rd_Process = td.eq(5).find('input[type="text"]').val();
			var rd_Workspace = td.eq(6).find('input[type="text"]').val();
			var emp_Name = td.eq(7).find('input[type="text"]').val();
			
			// 가져온 값을 배열에 담는다.
			tdArr.push(mr_NO);
			tdArr.push(mr_Date);
			tdArr.push(mr_Warehouse);
			tdArr.push(mr_Place);
			tdArr.push(rd_Process);
			tdArr.push(rd_Workspace);
			tdArr.push(emp_Name);
			
			$.ajax({
                type : 'GET',
                url : 'mod_material_release.do',
                data : {
                    tdArr : tdArr},
                success:function(result){
                   	 location.reload();
                   }
			});
			
		});
	});
});

$(function(){
	$("#rem").click(function() {
		alert("삭제완료");
		
		var rowData = new Array();
		var tdArr = new Array();
		var checkbox = $("input[id=up_CheckBox]:checked");
		
		checkbox.each(function(i) {
			
			// checkbox.parent() : checkbox의 부모는 <td>이다.
			// checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();
			
			// 체크된 row의 모든 값을 배열에 담는다.
			rowData.push(tr.text());
			
			var mr_NO = td.eq(1).find('input[type="text"]').val();
			
			tdArr.push(mr_NO);
			
			$.ajax({
                type : 'GET',
                url : 'rem_material_release.do',
                data : {
                    tdArr : tdArr},
                success:function(result){
                   	 location.reload();
                   }
                });
		});
	});
});

$(function(){
	$("#request").click(function() {
		alert("팝업창");
		
		var url = "pop_material_release.do";
        var name = "popup test";
        var option = "width = 900, height = 500, top = 100, left = 200, location = no"
        window.open(url, name, option);
        
	});
});
	
</script>
</head>
<style>

	.div1{
         padding-left: 25px;
         font-size: 18px;
         text-align:center;
    }
     #bt_1{
            position: absolute;
            right: 0;
            padding-right: 150px;
            text-align:center;
            border: 0;
            
        }
     #bt_2{
            padding-left: 5px;
        }
        
</style>
<body>

		<div class="div1">
   			<br>
   			<form method="post" action="${contextPath}/product/find_material_release.do">
            <tr>
        		<td style="text-align: right;">출고기간 : <input type="text" name="beginDate" style="background-color:#a9e2f8;">
        		 - <input type="text" name="endDate" style="background-color:#a9e2f8;"></td>
            	<td><input type="submit" value="검색" style="width: 50px;"></td>
            </tr>
           	</form>
        </div><br>
        
        <div id="bt_1">
        <form name="search">
            <input type="submit" id="search" value="조회" style="width: 50px;" />
            <input type="submit" id="request" value="출고요청" style="width: 70px;"/>
            <input type="button" id="add" value="등록" style="width: 50px;"/>
          	<input type="button" id="mod" value="수정" style="width: 50px;"/>
          	<input type="button" id="rem" value="삭제"style="width: 50px;" />
        </div><br><br><br>
        
<div class="tb1"> 
	<table  id="RD1" cellspacing="10" align="center"  width="80%">
	    <tr class="tbg" align="center" bgcolor="#a9e2f8">
	      <th class="th_1">항목</th>
	      <th class="th_2"><b>출고번호</b></th>
	      <th class="th_3"><b>출고일자</b></th>
	      <th class="th_4"><b>출고창고</b></th>
	      <th class="th_5"><b>출고장소</b></th>
	      <th class="th_6"><b>공정</b></th>
	      <th class="th_7"><b>작업장</b></th>
	      <th class="th_8"><b>담당자</b></th>
   	</tr>
   
 <c:forEach var="main" items="${mainList}" >     
   <tr align="center">
   	<td class="td_1" style="text-align: center;"><input type="checkbox" name="checked_mr_no" id="up_CheckBox" value="${main.mr_NO}" style="width: 40px;"></td>
      <td class="th_2"><input type="text" size=20 value="${main.mr_NO}" disabled></td>
      <td class="th_3"><input type="text" size=10 value="${main.mr_Date}" disabled></td>
      <td class="th_4"><input type="text" size=10 value="${main.mr_Warehouse}" disabled></td>
      <td class="th_4"><input type="text" size=10 value="${main.mr_Place}" disabled></td>
      <td class="th_5"><input type="text" size=20 value="${main.rd_Process}" disabled></td>
      <td class="th_6"><input type="text" size=10 value="${main.rd_Workspace}" disabled></td>
      <td class="th_7"><input type="text" size=10 value="${main.emp_Name}" disabled></td>
    </tr>
  </c:forEach>
  </form>
  	<tr align="center">
   	<td class="td_1" style="text-align: center;"><input type="checkbox" id="up_CheckBox" style="width: 40px;"></td>
      <td class="th_2"><input type="text" size=20 name="rd_no" disabled></td>
      <td class="th_3"><input type="text" size=10 name="release_Status"></td>
      <td class="th_4"><input type="text" size=10 name="rd_Workspace"></td>
      <td class="th_4"><input type="text" size=10 name="rd_Date"></td>
      <td class="th_5"><input type="text" size=20 name="mr_Date"></td>
      <td class="th_6"><input type="text" size=10 name="itemNO"></td>
      <td class="th_7"><input type="text" size=10 name="item_Name"></td>
    </tr>
</table>
</div>
<br><br><br>
<div class="tb2">
           
            <table id="RD2" cellspacing="15" style="text-align: center;">
                <tr class="tbg" bgcolor="#a9e2f8">
                    <th class="th2_1">항목</th>
                    <th>순서</th>
                    <th>품번</th>
                    <th>품명</th>
                    <th>단위</th>
                    <th>요청수량</th>
                    <th>출고수량</th>
                </tr>
                <c:forEach var="down" items="${downList}" > 
                <tr>
	                <td style="text-align: center;"><input type="checkbox" id="down_CheckBox" style="width: 40px;"></td>
	                <td ><input type="text" size="10" name="pr_NO" value="${down.mrs_Sequence}" disabled></td>
	                <td ><input type="text" size=10 name="materials_Availability" value="${down.itemNO}" ></td><!--  -->
	                <td ><input type="text" size=10 name="pr_Date" value="${down.item_Name}"></td><!-- 실적일 -->
	                <td ><input type="text" size=10 name="rd_Process" value="${down.stockUnit}"></td><!-- 공정 -->
	                <td ><input type="text" size=10 name="rD_Workspace" value="${down.rr_Quantity}"></td><!-- 작업장 -->
	                <td ><input type="text" size=10 name="transfer_Separation" value="${down.mrs_Quantity}"></td><!--  -->
                </tr>
                </c:forEach>
                <tr>
	                <td style="text-align: center;"><input type="checkbox" id="down_CheckBox" style="width: 40px;"></td>
	                <td ><input type="text" size="10" name="pr_NO" disabled></td>
	                <td ><input type="text" size=10 name="materials_Availability" ></td><!--  -->
	                <td class="td_7"><input type="text" size=10 name="pr_Date" ></td><!-- 실적일 -->
	                <td class="td_8"><input type="text" size=10 name="pr_Process" ></td><!--  -->
	                <td class="td_9"><input type="text" size=10 name="pr_Workspace" ></td><!--  -->
	                <td class="td_10"><input type="text" size=10 name="transfer_Separation" ></td><!--  -->  
                </tr>
            </table>
        </div>
</body>
</html>
