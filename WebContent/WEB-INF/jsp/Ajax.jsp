<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/test2/script/jquery-1.7.2.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
      function check(){
    	  $.get("ajax1",function(data){
    		  $("#name1").text(data[1].name);
    	  })
    	  }
</script>
</head>
<body>
              用户名:<input id="name" type="text" onblur="check()">&nbsp;<font color="red" id="name1"></font>
      <a href="ajax">A</a>
</body>
</html>