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
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
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
		var checkbox = $("input[id=down_CheckBox]:checked");
		
		checkbox.each(function(i) {
			
			// checkbox.parent() : checkbox의 부모는 <td>이다.
			// checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();
			
			// 체크된 row의 모든 값을 배열에 담는다.
			rowData.push(tr.text());
			
			// td.eq(0)은 체크박스 이므로  td.eq(1)의 값부터 가져온다.
			var pr_NO = td.eq(1).find('input[type="text"]').val()+", ";
			var materials_Availability = td.eq(2).find('input[type="text"]').val()+", ";
			var pr_Date = td.eq(3).find('input[type="text"]').val()+", ";
			var pr_Process = td.eq(4).find('input[type="text"]').val()+", ";
			var pr_Workspace = td.eq(5).find('input[type="text"]').val()+", ";
			var transfer_Separation = td.eq(6).find('input[type="text"]').val()+", ";
			var pr_OrNot = td.eq(7).find('input[type="text"]').val()+", ";
			var pr_Quantity = td.eq(8).find('input[type="text"]').val()+", ";
			var rd_Test = td.eq(9).find('input[type="text"]').val()+", ";
			var pr_Name = td.eq(10).find('input[type="text"]').val()+", ";
			var warehouse_Process = td.eq(11).find('input[type="text"]').val()+", ";
			var place_Workspace = td.eq(12).find('input[type="text"]').val()+", ";
			
			// 가져온 값을 배열에 담는다.
			tdArr.push(pr_NO);
			tdArr.push(materials_Availability);
			tdArr.push(pr_Date);
			tdArr.push(pr_Process);
			tdArr.push(pr_Workspace);
			tdArr.push(transfer_Separation);
			tdArr.push(pr_OrNot);
			tdArr.push(pr_Quantity);
			tdArr.push(rd_Test);
			tdArr.push(pr_Name);
			tdArr.push(warehouse_Process);
			tdArr.push(place_Workspace);
			
			console.log(tdArr);
			
			$.ajax({
                type : 'GET',
                url : 'add_performance_registration.do',
                data : {
                    tdArr : tdArr},
                error:function(request,status,error){
                        alert("저장실패");
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
		var checkbox = $("input[id=down_CheckBox]:checked");
		
		checkbox.each(function(i) {
			
			// checkbox.parent() : checkbox의 부모는 <td>이다.
			// checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();
			
			// 체크된 row의 모든 값을 배열에 담는다.
			rowData.push(tr.text());
			
			// td.eq(0)은 체크박스 이므로  td.eq(1)의 값부터 가져온다.
			var pr_NO = td.eq(1).find('input[type="text"]').val()+", ";
			var materials_Availability = td.eq(2).find('input[type="text"]').val()+", ";
			var pr_Date = td.eq(3).find('input[type="text"]').val()+", ";
			var pr_Process = td.eq(4).find('input[type="text"]').val()+", ";
			var pr_Workspace = td.eq(5).find('input[type="text"]').val()+", ";
			var transfer_Separation = td.eq(6).find('input[type="text"]').val()+", ";
			var pr_OrNot = td.eq(7).find('input[type="text"]').val()+", ";
			var pr_Quantity = td.eq(8).find('input[type="text"]').val()+", ";
			var rd_Test = td.eq(9).find('input[type="text"]').val()+", ";
			var pr_Name = td.eq(10).find('input[type="text"]').val()+", ";
			var warehouse_Process = td.eq(11).find('input[type="text"]').val()+", ";
			var place_Workspace = td.eq(12).find('input[type="text"]').val()+", ";
			
			// 가져온 값을 배열에 담는다.
			tdArr.push(pr_NO);
			tdArr.push(materials_Availability);
			tdArr.push(pr_Date);
			tdArr.push(pr_Process);
			tdArr.push(pr_Workspace);
			tdArr.push(transfer_Separation);
			tdArr.push(pr_OrNot);
			tdArr.push(pr_Quantity);
			tdArr.push(rd_Test);
			tdArr.push(pr_Name);
			tdArr.push(warehouse_Process);
			tdArr.push(place_Workspace);
			
			console.log(tdArr);
			
			$.ajax({
                type : 'GET',
                url : 'mod_performance_registration.do',
                data : {
                    tdArr : tdArr}
			});
			
		});
	});
});

$(function(){
	$("#rem").click(function() {
		alert("삭제완료");
		
		var rowData = new Array();
		var tdArr = new Array();
		var checkbox = $("input[id=down_CheckBox]:checked");
		
		checkbox.each(function(i) {
			
			// checkbox.parent() : checkbox의 부모는 <td>이다.
			// checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();
			
			// 체크된 row의 모든 값을 배열에 담는다.
			rowData.push(tr.text());
			
			var pr_NO = td.eq(1).find('input[type="text"]').val();
			
			tdArr.push(pr_NO);
			
			$.ajax({
                type : 'GET',
                url : 'rem_performance_registration.do',
                data : {
                    tdArr : tdArr}
                });
		});
	});
});

$(function () {
    $("#datepicker1").datepicker({
    	dateFormat : "yy-mm-dd"
    });
});

$(function () {
    $("#datepicker2").datepicker({
    	dateFormat : "yy-mm-dd"
    });
});
	
</script>
</head>
<style>

	.div_all {
		padding: 0px 50px 0px 50px;
	}
	.div_div {
		height: 100px;
	}
	.div_top {
		display : flex;
		padding-top : 50px;
        font-size: 20px;
        height: 20px;
    }
    .top_bt {
    	padding-top : 20px;
    	position: relative;
        right: 0;
        padding-right: 150px;
    }
        .top_bt .bt_01 {
            position:absolute;
            right:166px;
        }
        .top_bt .bt_02 {
            position:absolute;
            right:114px;
        }
        .top_bt .bt_03 {
            position:absolute;
            right:62px;
        }
        .top_bt .bt_04 {
        	position:absolute;
            right:10px;
        }
        .tb_all {
        	padding-left : 100px;
        }
        .tb1{
            float: left;
            width: 1000px;          
        }
        .tb2{
        	padding-top: 150px;
            width: 500px;
        }
        .th_1{
            width: 50px;
        }
        .th_3 b {
        }
        .th2_1{         
            width: 50px;
        }
        #RD1 {
        	 width: auto;
            display: block;
        }
</style>
<body>
	<div class="div_all">
		<div class="div_div">
			<div class="div_top">
   			<br>
   			<form method="post" action="${contextPath}/product/find_performance_registration.do">
            <tr>
        		<td style="text-align: right;">지시기간 : <input type="date" id="datepicker1" name="beginDate" style="background-color:#a9e2f8;">
        		 ~ <input type="date" id="datepicker2" name="endDate" style="background-color:#a9e2f8;"></td>
            	<td><input type="submit" value="검색" style="width: 50px;"></td>
            </tr>
           	</form>
        </div>
        <br>
        
        <div class="top_bt">
        <form name="search">
            <input type="submit" id="search" value="조회" class="bt_01" style="width: 50px;"/>
            <input type="button" id="add" value="등록" class="bt_02" style="width: 50px;" />
          	<input type="button" id="mod" value="수정" class="bt_03" style="width: 50px;" />
          	<input type="button" id="rem" value="삭제" class="bt_04" style="width: 50px;" />
        </div>
       </div>
        <br><br><br>
        
       <div class="tb_all">
<div class="tb1"> 
	<table  id="RD1" cellspacing="15" align="center" >
	    <tr class="tbg" align="center" bgcolor="#a9e2f8">
	      <th class="th_1">항목</th>
	      <th class="th_2"><b>작업지시번호</b></th>
	      <th class="th_3"><b>자재출고상태</b></th>
	      <th class="th_4"><b>작업장</b></th>
	      <th class="th_5"><b>지시일</b></th>
	      <th class="th_6"><b>완료일</b></th>
	      <th class="th_7"><b>품번</b></th>
	      <th class="th_8"><b>품명</b></th>
	      <th class="th_9"><b>단위</b></th>
	      <th class="th_10"><b>지시수량</b></th>
	      <th class="th_11"><b>실적수량</b></th>
	      <th class="th_12"><b>실적잔량</b></th>
	      <th class="th_13"><b>상태</b></th>
	      <th class="th_14"><b>작업구분</b></th>
	      <th class="th_15"><b>검사</b></th>
   	</tr>
   
 <c:forEach var="main" items="${mainList}" >     
   <tr align="center">
   	<td class="td_1" style="text-align: center;"><input type="checkbox" name="checked_rd_no" class="checked_rd_no" value="${main.rd_no}" style="width: 40px;"></td>
      <td class="th_2"><input type="text" size=10 value="${main.rd_no}" disabled></td>
      <td class="th_3"><input type="text" size=10 value="${main.release_Status}" disabled></td>
      <td class="th_4"><input type="text" size=10 value="${main.rd_Workspace}" disabled></td>
      <td class="th_4"><input type="date" size=6 value="${main.rd_Date}" disabled></td>
      <td class="th_5"><input type="date" size=6 value="${main.mr_Date}" disabled></td>
      <td class="th_6"><input type="text" size=10 value="${main.itemNO}" disabled></td>
      <td class="th_7"><input type="text" size=10 value="${main.item_Name}" disabled></td>
      <td class="th_8"><input type="text" size=4 value="${main.stockUnit}" disabled></td>
      <td class="th_9"><input type="text" size=10 value="${main.rd_Quantity}" disabled></td>
      <td class="th_10"><input type="text" size=10 value="${main.pr_Quantity}" disabled></td>
      <td class="th_11"><input type="text" size=10 value="${main.pr_Residual_Quantity}" disabled></td>
      <td class="th_12"><input type="text" size=4 value="${main.rd_Status}" disabled></td>
      <td class="th_13"><input type="text" size=10 value="${main.work_Scope}" disabled></td>
      <c:if test="${main.rd_Test == '0'}">
      <td class="th_14"><input type="text" size=4 value="무검사" disabled></td></c:if>
      <c:if test="${main.rd_Test == '1'}">
      <td class="th_14"><input type="text" size=4 value="검사" disabled></td></c:if>
  </c:forEach>
  </form>
  	<tr align="center">
   	<td class="td_1" style="text-align: center;"><input type="checkbox" style="width: 40px;"></td>
      <td class="th_2"><input type="text" size=10 name="rd_no"></td>
      <td class="th_3"><input type="text" size=10 name="release_Status"></td>
      <td class="th_4"><input type="text" size=10 name="rd_Workspace"></td>
      <td class="th_4"><input type="date" size=6 name="rd_Date"></td>
      <td class="th_5"><input type="date" size=6 name="mr_Date"></td>
      <td class="th_6"><input type="text" size=10 name="itemNO"></td>
      <td class="th_7"><input type="text" size=10 name="item_Name"></td>
      <td class="th_8"><input type="text" size=4 name="stockUnit"></td>
      <td class="th_9"><input type="text" size=10 name="rd_Quantity"></td>
      <td class="th_10"><input type="text" size=10 name="pr_Quantity"></td>
      <td class="th_11"><input type="text" size=10 name="pr_Residual_Quantity"></td>
      <td class="th_12"><input type="text" size=4 name="rd_Status"></td>
      <td class="th_13"><input type="text" size=10 name="work_Scope"></td>
      <td class="th_14"><input type="text" size=4 name="rd_Test"></td>
    </tr>
</table>
</div>
<br><br><br>
<div class="tb2">
           
            <table id="RD2" cellspacing="15" style="text-align: center;">
                <tr class="tbg" bgcolor="#a9e2f8">
                    <th class="th2_1">항목</th>
                    <th>작업실적번호</th>
                    <th>자재사용유무</th>
                    <th>실적일</th>
                    <th>공정</th>
                    <th>작업장</th>
                    <th>구분</th>
                    <th>실적구분</th>
                    <th>실적수량</th>
                    <th>검사</th>
                    <th>실적담당</th>
                    <th>입고창고/이동공정</th>
                    <th>입고장소/이동작업장</th>
                </tr>
                <c:forEach var="down" items="${downList}" > 
                <tr>
	                <td style="text-align: center;"><input type="checkbox" id="down_CheckBox" style="width: 40px;"></td>
	                <td ><input type="text" size=10 name="pr_NO" value="${down.pr_NO}" disabled></td>
	                <td ><input type="text" size=10 name="materials_Availability" value="${down.materials_Availability}" disabled></td><!--  -->
	                <td ><input type="date" size=6 name="pr_Date" value="${down.pr_Date}"></td><!-- 실적일 -->
	                <td ><input type="text" size=10 name="rd_Process" value="${down.pr_Process}"></td><!-- 공정 -->
	                <td ><input type="text" size=10 name="rD_Workspace" value="${down.pr_Workspace}"></td><!-- 작업장 -->
	                <td ><input type="text" size=10 name="transfer_Separation" value="${down.transfer_Separation}"></td><!--  -->
	                <td ><input type="text" size=10 name="pr_OrNot" value="${down.pr_OrNot}"></td><!--  -->
	                <td ><input type="text" size=10 name="pr_Quantity" value="${down.pr_Quantity}"></td><!--  -->
	                <td ><input type="text" size=4 name="rd_Test" value="${down.rd_Test}"></td><!--  -->
	                <td ><input type="text" size=10 name="pr_Name" value="${down.pr_Name}"></td><!--  -->
	                <td ><input type="text" size=15 name="warehouse_Process" value="${down.warehouse_Process}"></td><!--  -->
	                <td ><input type="text" size=17 name="place_Workspace" value="${down.place_Workspace}"></td><!--  -->
                </tr>
                </c:forEach>
                <tr>
	                <td style="text-align: center;"><input type="checkbox" id="down_CheckBox" style="width: 40px;"></td>
	                <td ><input type="text" size=10 name="pr_NO" disabled></td>
	                <td ><input type="text" size=10 name="materials_Availability" disabled></td><!--  -->
	                <td class="td_7"><input type="date" size=6 name="pr_Date" ></td><!-- 실적일 -->
	                <td class="td_8"><input type="text" size=10 name="pr_Process" ></td><!--  -->
	                <td class="td_9"><input type="text" size=10 name="pr_Workspace" ></td><!--  -->
	                <td class="td_10"><input type="text" size=10 name="transfer_Separation" ></td><!--  -->
	                <td class="td_10"><input type="text" size=10 name="pr_OrNot" ></td><!--  -->
	                <td class="td_10"><input type="text" size=10 name="pr_Quantity" ></td><!--  -->
	                <td class="td_10"><input type="text" size=4 name="rd_Test" >
	                	<!-- <select>
                            <option value="">선택</option>
                            <option value="o">검사</option>
                            <option value="n">무검사</option>
                        </select> -->
	                </td><!--  -->
	                <td class="td_10"><input type="text" size=10 name="pr_Name"></td><!--  -->
	                <td class="td_10"><input type="text" size=15 name="warehouse_Process" ></td><!--  -->
	                <td class="td_10"><input type="text" size=17 name="place_Workspace" ></td><!--  -->
                </tr>
            </table>
        </div>
        </div>
	</div>
</body>
</html>
