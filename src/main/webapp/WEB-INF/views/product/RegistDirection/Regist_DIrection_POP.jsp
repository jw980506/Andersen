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
<title>생산계획조회</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type ="text/javascript">
$(function(){
	$("#Apply").click(function(){
		alert("적용");
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
			
			var itemNO = td.eq(1).find('input[type="text"]').val();
			var item_Name = td.eq(2).find('input[type="text"]').val();
			var stockUnit = td.eq(3).find('input[type="text"]').val();
			var pp_Quantity = td.eq(4).find('input[type="text"]').val();
			var pp_Schedule = td.eq(5).find('input[type="text"]').val();
			var pp_no = td.eq(6).find('input[type="hidden"]').val();
							
			// 가져온 값을 배열에 담는다.
			tdArr.push(itemNO);
			tdArr.push(item_Name);
			tdArr.push(stockUnit);
			tdArr.push(pp_Quantity);
			tdArr.push(pp_Schedule);
			tdArr.push(pp_no);
			
			$.ajax({
                type : 'POST',
                url : 'POP_TO_REGI.do',
                data : {
                    tdArr : tdArr
                    },
                success : function(result) {
                	alert('성공');
                	window.opener.location.href = "${contextPath}/RegistDirection2.do";
                	window.close();
					}   
                });
		});
	});
});


$(function(){
	$("#Select_By_Date").click(function() {
		alert("검색버튼");
		
		var date1 = $('#_date1').val();
		var date2 = $('#_date2').val();
		
		
		$.ajax({
		type: 'post',
		url : "search_by_Date.do",
		data : {
			"_date1" : date1,
			"_date2" : date2
			},
		success : function(data){
			alert("버튼 동작 완료");
			location.reload();
			}
		});
	});
});
			
	

</script>
</head>
<style>
      .bt_1 .bt_01 {
            position:absolute;
            left:600px;
        }
        .bt_1 .bt_02 {
            position:absolute;
            left:652px;
        }
</style>
<body>
    <table cellspacing="15">
        <tr>
            <td style="text-align: right;">계획기간</td>
            <td><input type="text" id="_date1" style="background-color:yellow;" size="9"> </td>
            <td>~</td>
            <td><input type="text" id="_date2" style="background-color:yellow;" size="9"> </td>
            <td><input type="button" id="Select_By_Date" value="조회"></td> <!-- 품번 또는 작업예정일로 조회하는 버튼 "search" -->
        </tr>
    </table>
    
        <div class="bt_1">
	        <input type="button" id="Apply" value="적용" style="width: 50px;" class="bt_01" />
        	<input type="button" id="" value="취소" style="width: 50px;" class="bt_02" />
	    </div>
    <br><br><br>

    <div class="tb2">
        <table id="RD2" cellspacing="15" style="text-align: center;">
            <tr class="tbg">
                <th class="th_1">항목</th>
                <th class="th_2">품번</th>
                <th class="th_3">품명</th>
                <th class="th_4">단위</th>
                <th class="th_5">계획잔량</th>                                 
                <th class="th_5">작업예정일</th>                                 
            </tr>
            
            <c:forEach var="Find_POPUP_List" items="${POPUP_List}">
        	   	<tr align = "center">
    	       		<td class="td_1" style="text-align: center;">
    	       			<input type="checkbox" id="PlanList_Checkbox" ></td> <!-- 항목 -->     			
            	    	<td class="td_2"><input type="text" size=10 value="${Find_POPUP_List.itemNO}" disabled></td><!-- 품번 -->
                		<td class="td_3"><input type="text" size=10 value="${Find_POPUP_List.item_Name}" disabled></td><!-- 품명 -->
                		<td class="td_4"><input type="text" size=4 value="${Find_POPUP_List.stockUnit}" disabled></td><!-- 단위 -->
                		<td class="td_5"><input type="text" size=4 value="${Find_POPUP_List.pp_Quantity}" disabled></td><!-- 단위 -->
                		<td class="td_6"><input type="text" size=10 value="<fmt:formatDate value="${Find_POPUP_List.pp_Schedule}" pattern="yyyy-MM-dd"/>" disabled />
                		<td class="td_7"><input type="hidden" size=10 value="${Find_POPUP_List.pp_NO}" disabled></td><!-- asd -->
            	</tr>
            </c:forEach>
        </table>
    </div>    
</body>
</html>