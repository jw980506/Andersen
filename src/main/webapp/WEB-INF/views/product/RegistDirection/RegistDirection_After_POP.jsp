<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 
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
	function showPOP(){
		window.name="parentForm"
		window.open("${contextPath}/showpop.do", "a", "width=720, height=500, resizable=no");
	}
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

        .bt_1{
            position: relative;
            right: 0;
            padding-right: 150px;
        }
        .bt_1 .bt_01{
            position:absolute;
            right:218px;
        }

        .bt_1 .bt_02 {
            position:absolute;
            right:166px;
        }
        .bt_1 .bt_03 {
            position:absolute;
            right:114px;
        }
        .bt_1 .bt_04 {
            position:absolute;
            right:62px;
        }
        .bt_1 .bt_05 {
            position:absolute;
            right:10px;
        }
        
        .tb_all{
        	padding-left : 100px;
        }
        
         .th_1{
            width: 50px;
        }
        
        .th_10{
        	width: 80px;
        }
      
        
 </style>
<body>
2페이지
    <div class = "div_all">
		<div class="div1">
		<table cellspacing="15">
				<form method = "post" name="form" id="form">
				<tr>
        			<td style="text-align: right;">공정</td>
        			<td><select name="asd2" id="asd2">
                <option value="">선택</option>
                <option value="공정1">공정1</option>
                <option value="공정2">공정2</option>
            </select></td>
            <td style="text-align: right;">작업장</td>  
        			<td><select name="asd" id="asd">
                        <option value="">선택</option>
                        <option value="작업장1">작업장1</option>
                        <option value="작업장2">작업장2</option>
                    </select></td>
        			<td><input type="button" id="search_by_itemNO" value="검색"></td> <!-- 품번 또는 작업예정일로 조회하는 버튼 "search" -->
        		</tr>
        		</form>
        	</table>
		
    	</div>
    
    		<div class="bt_1">
    		<form method="post" name="form">
                <input type="button"value="생산계획조회" style="width: 100px;" class="bt_02" onclick="showPOP();"/>
        		<input type="button" id="add" value="등록" style="width: 50px;" class="bt_03" />
        		<input type="button" id="mod" value="수정" style="width: 50px;" class="bt_04" />
        		<input type="button" id="del" value="삭제" style="width: 50px;" class="bt_05" />
        		</form>

                <!-- 1234~ OR 2345~ -->
	    	</div>
    		<br><br><br>
		
			<div class="tb_all">
    			<div class="tb1">
        			<table id="RD1" cellspacing="15" style="text-align: center;">
            			<tr class="tbg" bgcolor ="#a9e2f8">
	                		<th class="th_1">항목</th>
                			<th class="th_2">작업지시번호</th>
                			<th class="th_3">공정</th>
                			<th class="th_4">작업장</th>
                			<th class="th_5">지시일</th>                                 
                            <th class="th_6">납기일</th>
                            <th class="th_7">품번</th>
                            <th class="th_8">품명</th>
                            <th class="th_9">단위</th>
                            <th class="th_10">지시수량</th>
                            <th class="th_11">상태</th>
                            <th class="th_12">검사</th>
            			</tr>
        				<c:forEach var="After_POPUP_List" items="${After_POPUP_List}">
        				<tr align = "center">
    	            		<td class="td_1" style="text-align: center;">
    	            		<input type="checkbox" id="ItemList_Checkbox" ></td> <!-- 항목 -->
            	    		
                            <td class="td_2"><input type="text" size=10 value=""></td>
                			
                            <td class="td_3"><select name="asd2" id="asd2">
                                <option value="">선택</option>
                                <option value="공정1">공정1</option>
                                <option value="공정2">공정2</option>
                            </select></td>
                            
                			<td class="td_4"><select name="asd" id="asd">
                                <option value="">선택</option>
                                <option value="작업장1">작업장1</option>
                                <option value="작업장2">작업장2</option>
                            </select></td>
                			<td class="td_3"><input type="text" size=6 value="<fmt:formatDate value="${After_POPUP_List.pp_Schedule}" pattern="yyyy-MM-dd"/>" /></td>

                            <td class="td_5"><input type="text" size=6 value=""></td>

                            <td class="td_2"><input type="text" size=10 value="${After_POPUP_List.itemNO}"></td>
                            
                            <td class="td_3"><input type="text" size=10 value="${After_POPUP_List.item_Name}"></td>
                            
                            <td class="td_4"><input type="text" size=4 value="${After_POPUP_List.stockUnit}"></td>

                            <td class="td_4"><input type="text" size=4 value="${After_POPUP_List.pp_Quantity}"></td>

                            <td class="td_4"><input type="text" size=4></td>
                        
                            <td class="td_4"><select name="asd" id="asd">
                                <option value="">선택</option>
                                <option value="검사1">검사1</option>
                                <option value="검사2">무검사</option>
                            </select></td>
                        
                        </tr>
                        </c:forEach>
        			</table>
	    		</div>

                
</body>
    
</html>