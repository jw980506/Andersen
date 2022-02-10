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
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type ="text/javascript">

</script>
</head>

<style>
	.div_all{
		padding : 0px 50px 0px 50px;
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
        
        .tb_all{
        	padding-left : 100px;
        }
        .tb1 {
        	float: left;
        	width: 1000px;
        }
         .th_1{
            width: 50px;
        }
        
      #RD1 {
            width: auto;
            display: block;
        }
        
 </style>
<body>
    <div class = "div_all">
			<div class="div_div">
		<div class="div_top">
				<form method = "post" name="form" id="form">
				<tr>
        			<td style="text-align: right;">품번</td>
        			<td><input type="text" style="background-color:yellow;" id="_itemNO"></td>
        			<td><input type="button" id="search_by_itemNO" value="검색"></td> <!-- 품번 또는 작업예정일로 조회하는 버튼 "search" -->
        		</tr>
        		</form>
    	</div>
    	<br />
    		<div class="top_bt">
    		<form method="post" name="form">
	        	<input type="button" id="search" value="조회" style="width: 50px;" class="bt_01" />
        		<button type="button" style="width: 50px;" class="bt_02">등록</button>
        		<button type="button" style="width: 50px;" class="bt_03">수정</button>
        		<button type="button" style="width: 50px;" class="bt_04">삭제</button>
	    	</form>
	    	</div>
	    	</div>
    		<br><br><br>
		
			<div class="tb_all">
    			<div class="tb1">
        			<table id="RD1" cellspacing="15" style="text-align: center;">
            			<tr class="tbg" bgcolor ="#a9e2f8">
	                		<th class="th_1">항목</th>
                			<th class="th_2">품번</th>
                			<th class="th_3">품목명</th>
                			<th class="th_4">계정구분</th>
                			<th class="th_5">조달구분</th>                                 
                            <th class="th_6">재고단위</th>
                            <th class="th_7">lot여부</th>
                            <th class="th_8">set품목</th>
                            <th class="th_9">검사여부</th>
                            <th class="th_10">중량</th>
                            <th class="th_11">일별생산량</th>
                            <th class="th_12">소요일자</th>
                            <th class="th_13">표준원가</th>
                            <th class="th_14">실제원가</th>
                            <th class="th_15">안전재고량</th>
            			</tr>
            			<c:forEach var="listAllItem" items="${listAllItem}" >     
   						<tr align="center">
   						<td class="td_1" style="text-align: center;"><input type="checkbox" name="checked_pr_no" class="checked_rd_no" value="${listAllItem.itemNo}" style="width: 40px;"></td>
     					<td class="th_2"><input type="text" size=10 value="${listAllItem.itemNo}" disabled></td>
     					<td class="th_3"><input type="text" size=20 value="${listAllItem.item_Name}" disabled></td>
     					<td class="th_4"><input type="text" size=10 value="${listAllItem.account}" disabled></td>
      					<td class="th_4"><input type="text" size=10 value="${listAllItem.procurement}" disabled></td>
      					<td class="th_5"><input type="text" size=10 value="${listAllItem.stockUnit}" disabled></td>		
     					<td class="th_6"><input type="text" size=10 value="${listAllItem.lot}" disabled></td>
      					<td class="th_7"><input type="text" size=10 value="${listAllItem.setItem}" disabled></td>
      					<td class="th_8"><input type="text" size=10 value="${listAllItem.test}" disabled></td>
      					<td class="th_9"><input type="text" size=10 value="${listAllItem.weight}" disabled></td>
      					<td class="th_10"><input type="text" size=10 value="${listAllItem.dayProduction}" disabled></td>
      					<td class="th_11"><input type="text" size=10 value="${listAllItem.leadTime}" disabled></td>
      					<td class="th_12"><input type="text" size=13 value="${listAllItem.stdCost}" disabled></td>
      					<td class="th_13"><input type="text" size=13 value="${listAllItem.actualCost}" disabled></td>
      					<td class="th_14"><input type="text" size=10 value="${listAllItem.safetyStock}" disabled></td>
    </tr>
  </c:forEach>
					</table>
			</div>
		</div>
	</div>		        				
</body>
    
</html>