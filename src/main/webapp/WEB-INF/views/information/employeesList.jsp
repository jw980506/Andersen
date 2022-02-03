<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
  request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>전체 사원 조회</title>
  <link href="resources/css/information/css_List.css" rel="stylesheet" type="text/css">
  <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
  <script src="resources/js/information/js_List.js" type="text/javascript"></script>
</head>
<body>
<div id="content1">
   <div class="div1">
   			<br>
            <p>사원코드 : <input type="text"><button>검색</button></p>
        </div>
        <div class="btn">
            <button type="button" id="searchBtn" style="width: 50px;">조회</button>
            <button type="button" id="createBtn" style="width: 50px;">저장</button>
            <button type="button" id="modifyBtn" style="width: 50px;">수정</button>
            <button type="button" id="deleteBtn" style="width: 50px;">삭제</button>
        </div><br><br><br>
        
        <div class="tb1">
            <table id="RD1" cellspacing="15">
                <tr class="ths">
                	<th class="ths">항목</th>
                    <th class="ths">사원코드</th>
                    <th class="ths">사원명</th>
                    <th class="ths">비밀번호</th>
                    <th class="ths">부서코드</th>
                    <th class="ths">부서명</th>
                    <th class="ths">입사일</th>
                </tr>
                
                <tr>
                	<td class="td_value"><input type="checkbox" id="selectCheckBox" ></td>
                	<td class="td_value"><input type="text"></td>
                	<td class="td_value"><input type="text"></td>
                	<td class="td_value"><input type="text"></td>
                	<td class="td_value"><input type="text"></td>
                	<td class="td_value"><input type="text"></td>
                	<td class="td_value"><input type="date" disabled></td>
                </tr>
                
                <c:forEach var="listAllEmployee" items="${listAllEmployee}">  <%-- 컨트롤러 addObject로 받음 --%>
                <tr>
                    <td class="td_value"><input type="checkbox" id="selectCheckBox" ></td>
                    <td class="td_value"><input type="number" value="${listAllEmployee.empNo}" disabled /></td>	<!-- 사원코드 -->
                    <td class="td_value"><input type="text" value="${listAllEmployee.emp_Name}" /></td>			<!-- 사원명 -->
                    <td class="td_value"><input type="text" value="${listAllEmployee.password}" /></td>			<!-- 비밀번호 -->
                    <td class="td_value"><input type="number" value="${listAllEmployee.deptNo}" /></td>			<!-- 부서코드 -->
                    <td class="td_value"><input type="text" value="${listAllEmployee.dept_Name}"/></td>			<!-- 부서명 -->
                    <td class="td_value"><input type="date" value="${listAllEmployee.hireDate}" disabled /></td><!-- 입사일 -->
                </tr>
                </c:forEach>
            </table>
        </div>
</div>
</body>
</html>