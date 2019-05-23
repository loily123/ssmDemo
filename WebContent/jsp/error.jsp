<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error page</title>
</head>
<script type="text/javascript" src="/ssmDemo/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function() {
		var errorCode = "${errorCode}";
		var msg = "${errorMsg}";
		switch (errorCode) {
		case "001":
		case "002":
			alert(errorCode + "\n" + msg);
			location.href = "/ssmDemo/jsp/adminLogin.jsp";
			break;
		case "003":
			msg = "重置密码失败";
			alert(errorCode + "\n" + msg);
			location.href = "/ssmDemo/jsp/resetPassword.jsp";
			break;
		default:
			alert(errorCode + "\n" + msg);
			location.href = "/ssmDemo/jsp/adminLogin.jsp";
			break;
		}
	})
</script>
<body>

</body>
</html>