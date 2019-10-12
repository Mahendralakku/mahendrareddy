<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style> 
#example1 {
 background-color:  aqua;
  }
  #userName{
  margin-left: 450px;
  font-size: 20px;
  }
</style>

</head>
<body>
<div id="example1">
<form action="SaveLoginServlet" method="POST">
<h1><center>Training Management System</center></h1>

<h2><center>Login</center></h2><br><br>

<div id="userName">
User Name:<input type="text" name="uName" style="height: 30px;width:280px  "/><br><br>
Password:<input type="password" name="passWord" style="height: 30px;width: 280px;margin-left: 10px"/><br><br>
<input type="hidden" name="adminId" value="1">
<a href="adminRegistration.jsp?">New User</a><input type="submit" value="LogIn" style="margin-left: 60px;height: 30px;width:120px;"/>
</div>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</form>
<footer>
  <p>For More Information: <a href="https://www.virtusa.com">www.virtusa.com</a></p>
</footer>

</div>
</body>
</html>