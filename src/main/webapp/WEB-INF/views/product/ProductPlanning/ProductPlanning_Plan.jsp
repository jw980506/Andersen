<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> <!-- 생산계획등록 요청 -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type ="text/javascript">
$(function(){
	$("#search").click(function(){
		alert("조회");
		var rowData = new Array();
		var tdArr = new Array();
		var checkbox = $("input[id=ItemList_Checkbox]:checked");
		
		checkbox.each(function(i) {
			
			// checkbox.parent() : checkbox의 부모는 <td>이다.
			// checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();
			
			// 체크된 row의 모든 값을 배열에 담는다.
			rowData.push(tr.text());
			
			var itemNO = td.eq(1).find('input[type="text"]').val();
			var itemname = td.eq(2).find('input[type="text"]').val();
			var stockunit = td.eq(3).find('input[type="text"]').val();
			var dayproduction = td.eq(4).find('input[type="text"]').val();
			
			tdArr.push(itemNO);
			tdArr.push(itemname);
			tdArr.push(stockunit);
			tdArr.push(dayproduction);
			
			$.ajax({
                type : 'POST',
                url : 'SelectItem_Plan.do',
                data : {
                    tdArr : tdArr},
                success : function(result) {
                	alert('성공');
                	location.href = "${contextPath}/ProductPlanning_Plan.do";
					
					}   
                });
		});
	});
});

$(function(){
	$("#search_by_itemNO").click(function() {
		alert("검색버튼");
		
		var asd = $('#_itemNO').val();
		
		
		$.ajax({
		type: 'post',
		url : "search_by_itemNO.do",
		data : {
			"_itemno2" : asd
			},
		success : function(result){
			alert("버튼 동작 완료");
			location.href = "${contextPath}/ProductPlanning_Plan.do";
			}
		});
	});
});
	$(function(){
		$("#add").click(function() {
			alert("등록 버튼");
			
			var rowData = new Array();
			var tdArr = new Array();
			var checkbox = $("input[id=ADD_PlanList_Checkbox]:checked");
			
			checkbox.each(function(i) {
				
				// checkbox.parent() : checkbox의 부모는 <td>이다.
				// checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
				var tr = checkbox.parent().parent().eq(i);
				var td = tr.children();
				
				// 체크된 row의 모든 값을 배열에 담는다.
				rowData.push(tr.text());
				
				// td.eq(0)은 체크박스 이므로  td.eq(1)의 값부터 가져온다.
				var pp_Sequence = td.eq(1).find('input[type="text"]').val();
				var pp_Schedule = td.eq(2).find('input[type="text"]').val();
				var pp_Quantity = td.eq(3).find('input[type="text"]').val();
				var emp_Name = td.eq(4).find('input[type="text"]').val();
				
				// 가져온 값을 배열에 담는다.
				tdArr.push(pp_Sequence);
				tdArr.push(pp_Schedule);
				tdArr.push(pp_Quantity);
				tdArr.push(emp_Name);
				
				
				$.ajax({
	                type : 'post',
	                url : 'Add_Plan.do',
	                data : {
	                    tdArr : tdArr},
	                    success : function(data){
	        				alert("버튼 동작 완료");
	        				location.reload();
	        			}
	                    
	                });
				
			});
		});
	});
	
	$(function(){
		$("#mod").click(function() {
			alert("수정 버튼");
			
			var rowData = new Array();
			var tdArr = new Array();
			var checkbox = $("input[id=PlanList_Checkbox]:checked");
			
			checkbox.each(function(i) {
				
				// checkbox.parent() : checkbox의 부모는 <td>이다.
				// checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
				var tr = checkbox.parent().parent().eq(i);
				var td = tr.children();
				
				// 체크된 row의 모든 값을 배열에 담는다.
				rowData.push(tr.text());
				
				// td.eq(0)은 체크박스 이므로  td.eq(1)의 값부터 가져온다.
				var pp_Sequence = td.eq(1).find('input[type="text"]').val();
				var pp_Schedule = td.eq(2).find('input[type="text"]').val();
				var pp_Quantity = td.eq(3).find('input[type="text"]').val();
				var emp_Name = td.eq(4).find('input[type="text"]').val();
				var pp_no = td.eq(5).find('input[type="hidden"]').val();
								
				// 가져온 값을 배열에 담는다.
				tdArr.push(pp_Sequence);
				tdArr.push(pp_Schedule);
				tdArr.push(pp_Quantity);
				tdArr.push(emp_Name);
				tdArr.push(pp_no)
								
				$.ajax({
					 type : 'post',
		                url : 'Mod_Plan.do',
		                data : {
		                    tdArr : tdArr
		                    },
		                success : function(data){
		        				alert("버튼 동작 완료");
		        				location.reload();
		        			}
	                    <!-- 성공적으로 컨트롤러가 돌았다면 메인 화면으로 돌아감 -->
	                });
				
			});
		});
	});
	
	$(function(){
		$("#del").click(function(){
			alert("삭제");
			var rowData = new Array();
			var tdArr = new Array();
			var checkbox = $("input[id=PlanList_Checkbox]:checked");
			
			checkbox.each(function(i) {
				
				// checkbox.parent() : checkbox의 부모는 <td>이다.
				// checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
				var tr = checkbox.parent().parent().eq(i);
				var td = tr.children();
				
				// 체크된 row의 모든 값을 배열에 담는다.
				rowData.push(tr.text());
				
				var pp_no = td.eq(5).find('input[type="hidden"]').val();
				
				tdArr.push(pp_no)
				
				$.ajax({
	                type : 'POST',
	                url : 'Del_Plan.do',
	                data : {
	                    tdArr : tdArr},
	                success : function(result) {
	                	alert("버튼 동작 완료");
        				location.reload();
						
						}   
	                });
			});
		});
	});
	
	</script>
	</head>

<style>
	.div_all{
		padding : 0px 50px 0px 50px;
	}
    	.div1{
           	padding-top : 50px;
        	padding : left;
            font-size: 20px;
            width : 370px;
       	}
        
        #RD1 {
            width: auto;
            display: block;
        }
        #RD2 {
            width: auto;
            display: block;
        }

        .bt_1{
            position: relative;
            right: 0;
            padding-right: 150px;
        }
        
        .bt_1 .bt_01 {
            position:absolute;
            right:166px;
        }
        .bt_1 .bt_02 {
            position:absolute;
            right:114px;
        }
        .bt_1 .bt_03 {
            position:absolute;
            right:62px;
        }
        .bt_1 .bt_04 {
            position:absolute;
            right:10px;
        }
        
        .tb_all{
        	padding-left : 100px;
        }
      
        .tb1{
            float: left;
            width: 500px;          
        }
        .tb2{
            float : left;
            width: 500px;
        }
        .th_1{
            width: 50px;
        }
        .th2_1{         
            width: 50px;
        }
 </style>
<body>
2페이지
    <div class = "div_all">
		<div class="div1">
			<table cellspacing="15">
				<tr>
        			<td style="text-align: right;">품번</td>
        			<td><input type="text" style="background-color:yellow;" id="_itemNO"></td>
        			<td><input type="button" id="search_by_itemNO" value="검색"></td> <!-- 품번 또는 작업예정일로 조회하는 버튼 "search" -->
        		</tr>
        			
        	</table>
    	</div>
    
    		<div class="bt_1">
    		<form method="post" name="form">
	        	<input type="button" id="search" value="조회" style="width: 50px;" class="bt_01" />
        		<input type="button" id="add" value="등록" style="width: 50px;" class="bt_02" />
        		<input type="button" id="mod" value="수정" style="width: 50px;" class="bt_03" />
        		<input type="button" id="del" value="삭제" style="width: 50px;" class="bt_04" />
        		</form>
	    	</div>
    		<br><br><br>
		
			<div class="tb_all">
    			<div class="tb1">
        			<table id="RD1" cellspacing="15" style="text-align: center;">
            			<tr class="tbg" bgcolor ="#a9e2f8">
	                		<th class="th_1">항목</th>
                			<th class="th_2">품번</th>
                			<th class="th_3">품명</th>
                			<th class="th_4">단위</th>
                			<th class="th_5">일생산량</th>                                 
            			</tr>
        				
        				<c:forEach var="ProductPlanning_ItemList" items="${ProductPlanning_ItemList}">
        	   				<tr align = "center">
    	            			<td class="td_1" style="text-align: center;">
    	            			<input type="checkbox" id="ItemList_Checkbox" ></td> <!-- 항목 -->
            	    			<td class="td_2"><input type="text" size=10 value="${ProductPlanning_ItemList.itemNO}"></td><!-- 품번 -->
                				<td class="td_3"><input type="text" size=10 value="${ProductPlanning_ItemList.item_Name}"></td><!-- 품명 -->
                				<td class="td_4"><input type="text" size=4 value="${ProductPlanning_ItemList.stockUnit}"></td><!-- 단위 -->
                				<td class="td_5"><input type="text" size=6 value="${ProductPlanning_ItemList.dayProduction}"></td><!-- 일생산량 -->
            				</tr>
            			</c:forEach>
	        			
            			<c:forEach var="ProductPlanning_Item_Search_List" items="${ProductPlanning_Item_Search_List}">
        	   				<tr align = "center">
    	            			<td class="td_1" style="text-align: center;"><input type="checkbox" id="ItemList_Checkbox" ></td> <!-- 항목 -->
            	    			<td class="td_2"><input type="text" size=10 value="${ProductPlanning_Item_Search_List.itemNO}"></td><!-- 품번 -->
                				<td class="td_3"><input type="text" size=10 value="${ProductPlanning_Item_Search_List.item_Name}"></td><!-- 품명 -->
                				<td class="td_4"><input type="text" size=4 value="${ProductPlanning_Item_Search_List.stockUnit}"></td><!-- 단위 -->
                				<td class="td_5"><input type="text" size=6 value="${ProductPlanning_Item_Search_List.dayProduction}"></td><!-- 일생산량 -->
            				</tr>
            			</c:forEach>
            			
            				
        			</table>
	    		</div>

        		<div class="tb2">
            		<table id="RD2" cellspacing="15" style="text-align: center;">
	                	<tr class="tbg" bgcolor ="#a9e2f8">
	    	                <th class="th_1">항목</th>
                    		<th class="th_2">순서</th>
                    		<th class="th_3">작업예정일</th>
                    		<th class="th_4">수량</th>
                    		<th class="th_5">담당자</th>                                 
                		</tr>
                		<c:forEach var="Find_ProductPlanning_Item_Plan_List_All" items="${ProductPlanning_Item_Plan_List}">
                		<tr>
                    		<td class="td_1" style="text-align: center;">
                    		<input type="checkbox" id="PlanList_Checkbox" ></td> <!-- 항목 -->
                    		<td class="td_2"><input type="text" size=5 value="${Find_ProductPlanning_Item_Plan_List_All.pp_Sequence}"></td><!-- 순서 -->
                    		<td class="td_3"><input type="text" size=10 value="<fmt:formatDate value="${Find_ProductPlanning_Item_Plan_List_All.pp_Schedule}" pattern="yyyy-MM-dd"/>" /></td><!-- 작업예정일 -->
                    		<td class="td_4"><input type="text" size=6 value="${Find_ProductPlanning_Item_Plan_List_All.pp_Quantity}"></td><!-- 수량 -->
                    		<td class="td_5"><input type="text" size=6 value="${Find_ProductPlanning_Item_Plan_List_All.emp_Name}"></td><!-- 담당자 -->
                    		<td class="td_6"><input type="hidden" size=0 value="${Find_ProductPlanning_Item_Plan_List_All.pp_NO}"></td><!-- 수량 -->
                		</tr>
                		</c:forEach >
                		<tr>
                    		<td class="td_1" style="text-align: center;">
                    		<input type="checkbox" id="ADD_PlanList_Checkbox" ></td> <!-- 항목 -->
                    		<td class="td_2"><input type="text" size=5 value="${Find_ProductPlanning_Item_Plan_List_All.pp_Sequence}"></td><!-- 순서 -->
                    		<td class="td_3"><input type="text" size=10 value="<fmt:formatDate value="${Find_ProductPlanning_Item_Plan_List_All.pp_Schedule}" pattern="yyyy-MM-dd"/>" /></td><!-- 작업예정일 -->
                    		<td class="td_4"><input type="text" size=6 value="${Find_ProductPlanning_Item_Plan_List_All.pp_Quantity}"></td><!-- 수량 -->
                    		<td class="td_5"><input type="text" size=6 value="${Find_ProductPlanning_Item_Plan_List_All.emp_Name}"></td><!-- 담당자 -->
                		</tr>
            		</table>
        		</div>    
			</div>
		</div>
</body>
    
</html>