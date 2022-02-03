$(function() {
	
	$("#createBtn").click(function() {
		alert("등록버튼");
		
		var tdArr = new Array();
		var checkbox = $("input[id=selectCheckBox]:checked");
			
		checkbox.each(function(i) {		
		
		var tr = checkbox.parent().parent().eq(i);
		var td = tr.children();				
		
		var empNo = td.eq(1).find('input[type="text"]').val();
		var emp_Name = td.eq(2).find('input[type="text"]').val();
		var password = td.eq(3).find('input[type="text"]').val();
		var deptNo = td.eq(4).find('input[type="text"]').val();
		var dept_Name = td.eq(5).find('input[type="text"]').val();
				
				
		tdArr.push(empNo);
		tdArr.push(emp_Name);
		tdArr.push(password);
		tdArr.push(deptNo);
		tdArr.push(dept_Name);
		
		console.log(tdArr);
		
		});
		
		$.ajax ({
			cache		: false,
			type		: 'POST',
			url			: 'employeeOneAdd.do',
			data		: {
				tdArr 	: tdArr
			},
			success		: function(data) {
       					alert("성공");
    		}
		
			});
		}); // 등록버튼 끝
		
		$("#modifyBtn").click(function() {
			alert("수정버튼");
			
			var modArr = new Array();
			var checkbox = $("input[id=selectCheckBox]:checked");
			
			checkbox.each(function(i) {
		
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();				
		
			var empNo = td.eq(1).find('input[type="number"]').val();
			var emp_Name = td.eq(2).find('input[type="text"]').val();
			var password = td.eq(3).find('input[type="text"]').val();
			var deptNo = td.eq(4).find('input[type="number"]').val();
			var dept_Name = td.eq(5).find('input[type="text"]').val();
				
				
			modArr.push(empNo);
			modArr.push(emp_Name);
			modArr.push(password);
			modArr.push(deptNo);
			modArr.push(dept_Name);
		
			//console.log(modArr);
			
		});
		$.ajax ({
			cache		: false,
			type		: 'POST',
			url			: 'employeeOneMod.do',
			data		: {
				modArr 	: modArr
			},
			success		: function(data) {
       					alert("수정성공");
    		}
			});	// 수정 아작스 끝
		}); // 수정버튼 끝
		
		$("#deleteBtn").click(function() {
			alert("삭제버튼");
			
			var delArr = new Array();
			var checkbox = $("input[id=selectCheckBox]:checked");
			
			checkbox.each(function(i) {
		
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();				
		
			var empNo = td.eq(1).find('input[type="number"]').val();
			delArr.push(empNo);
		
			//console.log(modArr);
			
		});
		$.ajax ({
			cache		: false,
			type		: 'POST',
			url			: 'employeeOneDel.do',
			data		: {
				delArr 	: delArr
			},
			success		: function(data) {
       					alert("삭제성공");
    		}
			});	// 삭제 아작스 끝
		}); // 수정버튼 끝
	
}); // 끝