<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body style="background-color: #003366">
	<div class="login" >
		<div class="login-form">
			<div class="top-login">
				<span><img src="images/group.png" alt=""/></span>
			</div>
			<h1>登录</h1>
			<div class="login-top">
			<form action="studentLogin" method="post">
				<div class="login-ic">
					<i ></i>
					<input type="text" placeholder="UserName" name="ssn" style="color:white">
					<div class="clear"> </div>
				</div>
				<div class="login-ic">
					<i class="icon"></i>
					<input type="password" placeholder="密码" name="password">
					<div class="clear"> </div>
				</div>
			
				<div class="log-bwn">
					<input type="submit"  value="Login" >
				</div>
				</form>
			</div>
			
</div>		
	</div>
	
</body>
</html>