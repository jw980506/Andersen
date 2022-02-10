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
			var gw_DATE = td.eq(2).find('input[type="text"]').val()+", ";
			var gw_Warehouse = td.eq(3).find('input[type="text"]').val()+", ";
			var gw_Place = td.eq(4).find('input[type="text"]').val()+", ";
			var gw_Quantity = td.eq(5).find('input[type="text"]').val()+", ";
			
			// 가져온 값을 배열에 담는다.
			tdArr.push(gw_DATE);
			tdArr.push(gw_Warehouse);
			tdArr.push(gw_Place);
			tdArr.push(gw_Quantity);
			
			$.ajax({
                type : 'GET',
                url : 'add_goods_warehouse.do',
                data : {
                    tdArr : tdArr}
                    
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
			var gw_NO = td.eq(1).find('input[type="text"]').val()+", ";
			var gw_DATE = td.eq(2).find('input[type="text"]').val()+", ";
			var gw_Warehouse = td.eq(3).find('input[type="text"]').val()+", ";
			var gw_Place = td.eq(4).find('input[type="text"]').val()+", ";
			var gw_Quantity = td.eq(5).find('input[type="text"]').val()+", ";
		
			// 가져온 값을 배열에 담는다.
			tdArr.push(gw_NO);
			tdArr.push(gw_DATE);
			tdArr.push(gw_Warehouse);
			tdArr.push(gw_Place);
			tdArr.push(gw_Quantity);
			
			console.log(tdArr);
			
			$.ajax({
                type : 'GET',
                url : 'mod_goods_warehouse.do',
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
			
			var gw_NO = td.eq(1).find('input[type="text"]').val();
			
			tdArr.push(gw_NO);
			
			$.ajax({
                type : 'GET',
                url : 'rem_goods_warehouse.do',
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
        .th2_1{         
            width: 50px;
        }
        #RD1 {
        	 width: auto;
            display: block;
        }
        #RD2 {
        	 width: auto;
            display: block;
        }
</style>
<body>
	<div class="div_all">
		<div class="div_div">
			<div class="div_top">
   			<br>
            <form method="post" action="${contextPath}/product/find_performance_test.do">
            <tr>
        		<td style="text-align: right;">실적기간 : <input type="text" id="datepicker1" name="beginDate" style="background-color:#a9e2f8;">
        		 ~ <input type="text" id="datepicker2" name="endDate" style="background-color:#a9e2f8;"></td>
            	<td><input type="submit" value="검색" style="width: 50px;"></td>
            </tr>
           	</form>
        </div>
        <br>
        
        <div class="top_bt">
        <form name="search">
            <input type="submit" id="search" value="조회" class="bt_01" style="width: 50px;" />
            <input type="button" id="add" value="등록" class="bt_02" style="width: 50px;" />
          	<input type="button" id="mod" value="수정" class="bt_03" style="width: 50px;" />
          	<input type="button" id="rem" value="삭제" class="bt_04" style="width: 50px;" />
        </div>
        </div>
         <br><br><br>
        
        <div class="tb_all">
<div class="tb1"> 
	<table  id="RD1" cellspacing="15" align="center">
	    <tr class="tbg" align="center" bgcolor="#a9e2f8">
	      <th class="th_1">항목</th>
	      <th class="th_2"><b>작업지시번호</b></th>
	      <th class="th_3"><b>작업실적번호</b></th>
	      <th class="th_3"><b>실적일</b></th>
	      <th class="th_5"><b>품번</b></th>
	      <th class="th_6"><b>품명</b></th>
	      <th class="th_7"><b>단위</b></th>
	      <th class="th_9"><b>상태</b></th>
	      <th class="th_8"><b>실적수량</b></th>
	      <th class="th_8"><b>압고대상수량</b></th>
	      <th class="th_10"><b>입고가능</b></th>
   	</tr>
   
 <c:forEach var="main" items="${mainList}" >     
   <tr align="center">
   	<td class="td_1" style="text-align: center;"><input type="checkbox" name="checked_pr_no" class="checked_rd_no" value="${main.pr_NO}" style="width: 40px;"></td>
      <td class="th_2"><input type="text" size=20 value="${main.rd_NO}" disabled></td>
      <td class="th_3"><input type="text" size=20 value="${main.pr_NO}" disabled></td>
      <td class="th_3"><input type="text" size=15 value="${main.pr_Date}" disabled></td>
      <td class="th_4"><input type="text" size=10 value="${main.itemNO}" disabled></td>
      <td class="th_4"><input type="text" size=10 value="${main.item_Name}" disabled></td>
      <td class="th_5"><input type="text" size=10 value="${main.stockUnit}" disabled></td>
      <td class="th_6"><input type="text" size=10 value="${main.rd_Status}" disabled></td>
      <td class="th_7"><input type="text" size=10 value="${main.pr_Quantity}" disabled></td>
      <td class="th_8"><input type="text" size=13 value="${main.warehouse_Quantity}" disabled></td>
      <td class="th_9"><input type="text" size=10 value="${main.warehousing_Quantity}" disabled></td>
    </tr>
  </c:forEach>
  </form>
  	<tr align="center">
   	<td class="td_1" style="text-align: center;"><input type="checkbox" style="width: 40px;"></td>
      <td class="th_2"><input type="text" size=20 name="rd_no"></td>
      <td class="th_3"><input type="text" size=20 name="pr_NO"></td>
      <td class="th_3"><input type="text" size=15 name="pr_Date"></td>
      <td class="th_4"><input type="text" size=10 name="use_Report"></td>
      <td class="th_4"><input type="text" size=10 name="pr_Process"></td>
      <td class="th_5"><input type="text" size=10 name="pr_Workspace"></td>
      <td class="th_6"><input type="text" size=10 name="pr_Date"></td>
      <td class="th_7"><input type="text" size=10 name="itemNO"></td>
      <td class="th_8"><input type="text" size=13 name="item_Name"></td>
      <td class="th_9"><input type="text" size=10 name="stockUnit"></td>
    </tr>
</table>
</div>
<br><br><br>
<div class="tb2">
           
            <table id="RD2" cellspacing="15" style="text-align: center;">
                <tr class="tbg" bgcolor="#a9e2f8">
                    <th class="th2_1">항목</th>
                    <th>입고번호</th>
                    <th>입고일자</th>
                    <th>입고창고</th>
                    <th>입고장소</th>
                    <th>입고수량</th>
                </tr>
                <c:forEach var="down" items="${downList}" > 
                <tr>
	                <td style="text-align: center;"><input type="checkbox" id="down_CheckBox" style="width: 40px;" value="${down.pr_NO}"></td>
	                <td ><input type="text" size=20 name="use_Date" value="${down.gw_NO}" disabled></td><!--  -->
	                <td ><input type="text" size=15 name="pr_Process" value="${down.gw_DATE}"></td><!-- 실적일 -->
	                <td ><input type="text" size=15 name="pr_Workspace" value="${down.gw_Warehouse}"></td><!-- 공정 -->
	                <td ><input type="text" size=20 name="itemNO" value="${down.gw_Place}"></td><!-- 작업장 -->
	                <td ><input type="text" size=10 name="item_Name" value="${down.gw_Quantity}"></td><!--  -->
                </tr>
                </c:forEach>
                <tr>
	                <td style="text-align: center;"><input type="checkbox" id="down_CheckBox" style="width: 40px;"></td>
	                <td ><input type="text" size=20 name="use_Date" disabled></td><!--  -->
	                <td class="td_7"><input type="text" size=15 name="pr_Process" ></td><!-- 실적일 -->
	                <td class="td_8"><input type="text" size=15 name="pr_Workspace" ></td><!--  -->
	                <td class="td_9"><input type="text" size=20 name="itemNO" ></td><!--  -->
	                <td class="td_10"><input type="text" size=10 name="item_Name" ></td><!--  -->
                </tr>
            </table>
        </div>
        </div>
	</div>        
</body>
</html>
