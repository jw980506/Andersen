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
       		right:218px;
   		 }
        .top_bt .bt_02 {
            position:absolute;
            right:166px;
        }
        .top_bt .bt_03 {
            position:absolute;
            right:114px;
        }
        .top_bt .bt_04 {
            position:absolute;
            right:62px;
        }
        .top_bt .bt_05 {
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
        
        .tb2 {
        	padding-top: 150px;
        	width: 500px;
        }
         .th_1{
            width: 50px;
        }
        
        .th_10{
        	width: 80px;
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
		<table cellspacing="15" width="500">
				<form method = "post" name="form" id="form">
				<tr>
        			<td style="text-align: right;">공정</td>
        			<td><select name="asd2" id="asd2">
               			<option value="">선택</option>
                		<option value="작업공정">작업공정</option>
						<option value="작업공정(도색)">작업공정(도색)</option>
            </select></td>
            <td style="text-align: right;">작업장</td>  
        			<td><select name="asd" id="asd">
                        <option value="">선택</option>
                        <option value="제품 작업장">제품 작업장</option>
                        <option value="반제품 작업장">반제품 작업장</option>
                    </select></td>
        			<td><input type="button" id="search_by_itemNO" value="검색"></td> <!-- 품번 또는 작업예정일로 조회하는 버튼 "search" -->
        		</tr>
        		</form>
        	</table>
			</div>
			<br />
    
    		<div class="top_bt">
    		<form method="post" name="form">
                <input type="button"value="생산계획조회" style="width: 80px;" class="bt_02" onclick="showPOP();"/>
        		<input type="button" id="" value="등록" style="width: 50px;" class="bt_03" disabled/>
        		<input type="button" id="" value="수정" style="width: 50px;" class="bt_04" disabled/>
        		<input type="button" id="" value="삭제" style="width: 50px;" class="bt_05" disabled/>
        		</form>

                <!-- 1234~ OR 2345~ -->
	    	</div>
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
        				
        				<tr align = "center">
    	            		<td class="td_1" style="text-align: center;">
    	            		<input type="checkbox" id="ItemList_Checkbox" ></td> <!-- 항목 -->
            	    		
                            <td class="td_2"><input type="text" size=10 value=""></td>
                			
                            <td class="td_3"><select name="asd2" id="asd2">
                                <option value="">선택</option>
                                <option value="작업공정">작업공정</option>
                                <option value="작업공정(도색)">작업공정(도색)</option>
                            </select></td>
                            
                			<td class="td_4"><select name="asd" id="asd">
                                <option value="">선택</option>
                                <option value="제품 작업장">제품 작업장</option>
                                <option value="반제품 작업장">반제품 작업장</option>
                            </select></td>
                			
                            <td class="td_5"><input type="text" size=6 value=""></td>

                            <td class="td_5"><input type="text" size=6 value=""></td>

                            <td class="td_2"><input type="text" size=10></td>
                            
                            <td class="td_3"><input type="text" size=10></td>
                            
                            <td class="td_4"><input type="text" size=4></td>

                            <td class="td_4"><input type="text" size=4></td>

                            <td class="td_4"><input type="text" size=4></td>
                        
                            <td class="td_4"><select name="asd" id="asd">
                                <option value="">선택</option>
                                <option value="검사1">검사1</option>
                                <option value="검사2">무검사</option>
                            </select></td>
                        
                        </tr>
        			</table>
	    		</div>
	</div>
	</div>
</body>
    
</html>