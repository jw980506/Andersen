<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>출고요청</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type ="text/javascript">

$(function(){
	$("#request").click(function() {
		alert("저장완료");
		
		var rowData = new Array();
		var tdArr = new Array();
		var checkbox = $("input[id=checkBox]:checked");
		
		checkbox.each(function(i) {
			
			// checkbox.parent() : checkbox의 부모는 <td>이다.
			// checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();
			
			// 체크된 row의 모든 값을 배열에 담는다.
			rowData.push(tr.text());
			
			// td.eq(0)은 체크박스 이므로  td.eq(1)의 값부터 가져온다.
			var rd_NO = td.eq(2).find('input[type="text"]').val();
			var itemNO = td.eq(4).find('input[type="text"]').val();
			var item_Name = td.eq(5).find('input[type="text"]').val();
			var stockUnit = td.eq(6).find('input[type="text"]').val();
			var cds_needQuantity = td.eq(7).find('input[type="text"]').val();
			
			// 가져온 값을 배열에 담는다.
			tdArr.push(rd_NO);
			tdArr.push(itemNO);
			tdArr.push(item_Name);
			tdArr.push(stockUnit);
			tdArr.push(cds_needQuantity);
			
			$.ajax({
                type : 'GET',
                url : 'add_pop_material.do',
                data : {
                    tdArr : tdArr},
                error:function(request,status,error){
                        alert("저장실패");
                },
                success:function(result){
                	window.close();
                }
                    
                });
			
		});
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
</style>
<body>

	<div class="div1">
   			<br>
   			<form method="post" action="${contextPath}/product/pop_material_release.do">
            <tr>
        		<td style="text-align: right;">청구기간 : <input type="text" name="beginDate" style="background-color:#a9e2f8;">
        		 - <input type="text" name="endDate" style="background-color:#a9e2f8;"></td>
            	<td><input type="submit" value="조회" style="width: 50px;"></td>
            </tr>
           	</form>
     </div><br>
     <div id="bt_1">
        <form name="search">
            <input type="submit" id="request" value="요청적용" style="width: 70px;"/>
     </div><br><br>
     <div class="tb1"> 
	<table  id="RD1" cellspacing="10" align="center"  width="80%">
	    <tr class="tbg" align="center" bgcolor="#a9e2f8">
	      <th class="th_1">항목</th>
	      <th class="th_2"><b>청구일자</b></th>
	      <th class="th_3"><b>지시번호</b></th>
	      <th class="th_4"><b>순서</b></th>
	      <th class="th_5"><b>품번</b></th>
	      <th class="th_6"><b>품명</b></th>
	      <th class="th_7"><b>단위</b></th>
	      <th class="th_8"><b>청구수량</b></th>
	      <th class="th_8"><b>투입수량</b></th>
	      <th class="th_8"><b>청구잔량</b></th>
   	</tr>
   
	 <c:forEach var="pop" items="${popList}" varStatus="popList" >     
	   <tr align="center">
	   	<td class="td_1" style="text-align: center;"><input type="checkbox" name="checked_mr_no" id="checkBox" value="${pop.rd_NO}" style="width: 40px;"></td>
	      <td class="th_2"><input type="text" size=20 value="${pop.cds_Request_Date}" disabled></td>
	      <td class="th_3"><input type="text" size=10 value="${pop.rd_NO}" disabled></td>
	      <td class="th_4"><input type="text" size=10 value="${popList.count}" disabled></td>
	      <td class="th_4"><input type="text" size=10 value="${pop.itemNO}" disabled></td>
	      <td class="th_5"><input type="text" size=20 value="${pop.item_Name}" disabled></td>
	      <td class="th_6"><input type="text" size=10 value="${pop.stockUnit}" disabled></td>
	      <td class="th_7"><input type="text" size=10 value="${pop.cds_needQuantity}" disabled></td>
	      <td class="th_6"><input type="text" size=10 value="0" disabled></td>
	      <td class="th_7"><input type="text" size=10 value="${pop.cds_needQuantity}" disabled></td>
	    </tr>
	  </c:forEach>
	  </form>
	  	<tr align="center">
	   	<td class="td_1" style="text-align: center;"><input type="checkbox" style="width: 40px;"></td>
	      <td class="th_2"><input type="text" size=20 name="rd_no"></td>
	      <td class="th_3"><input type="text" size=10 name="release_Status"></td>
	      <td class="th_4"><input type="text" size=10 name="rd_Workspace"></td>
	      <td class="th_4"><input type="text" size=10 name="rd_Date"></td>
	      <td class="th_5"><input type="text" size=20 name="mr_Date"></td>
	      <td class="th_6"><input type="text" size=10 name="itemNO"></td>
	      <td class="th_7"><input type="text" size=10 name="item_Name"></td>
	      <td class="th_6"><input type="text" size=10 name="itemNO"></td>
	      <td class="th_7"><input type="text" size=10 name="item_Name"></td>
	    </tr>
	</table>
	</div>

</body>
</html>