<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>메뉴</title>
</head>
<style>
	* {
		margin: 0;
		padding: 0;
	}

	ul#navi {
		width: 250px;
		text-indent: 15px;
        position: absolute;
        top: 150px;
	}

	ul#navi, ul#navi ul {
		margin:0;
		padding:0;
		list-style:none;
	}

	li.menu {
		margin-bottom: 3px;
	}

	li.menu div.title {
		height: 60px;
		line-height: 60px;
		background: #a9e2f8;
		cursor:pointer;
	}
	ul.subMenu li {
		margin-bottom: 2px;
		height: 60px;
		line-height: 60px;
		background: #f7f7f7;
		cursor:pointer;
	}
	ul.subMenu li a {
		display: block;
		width: 100%;
		height:100%;
		text-decoration:none;
		color:#000;
	}
	ul.subMenu li:hover {
		background: #709bac;
	}
</style>
<body>
	<ul id="navi">
		<li class="menu">
			<div class="title">기초정보</div>
			<ul class="subMenu">
				<li><a href="#">사원</a></li>
				<li><a href="#">품목</a></li>
				<li><a href="#">BOM</a></li>
			</ul>
		</li>
		<li class="menu">
			<div class="title">생산관리</div>
			<ul class="subMenu">
                <li><a href="${contextPath}/ProductPlanning.do">생산계획등록</a></li>
                <li><a href="#">작업지시등록</a></li>
                <li><a href="#">작업지시확정</a></li>
                <li><a href="#">생산자재출고</a></li>
                <li><a href="#">작업실적등록</a></li>
                <li><a href="#">생산자재사용등록</a></li>
                <li><a href="#">생산실적검사</a></li>
                <li><a href="#">생산품창고 입고처리</a></li>
                <li><a href="#">작업지시마감처리</a></li>			
			</ul>
		</li>
	</ul>
</body>
</html>