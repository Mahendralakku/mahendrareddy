<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
<style type="text/css">
body {

  margin: 0;
  background-image:url('abc.jpg');
  background-color:aqua;
  font-family: Arial, Helvetica, sans-serif;
  background-size:cover;
  border-color: aqua;
}
.A{
margin-top: 5px;
margin-left: -100px;
width: 225px;
height: 20px;

}
</style>
</head>

<body>
<h1><center>Registration</center></h1>
<form action="SaveRegistrationServlet" method="POST">

<center>
<table>
<tr><td>First Name:</td><td><input type="text" class ="A" name="userFirstname"/></td></tr>
<tr><td>Last Name:</td><td><input type="text" class ="A" name="userLastname"/></td></tr>
<tr><td>Email:</td><td><input type="email" class ="A" name="userEmail"/></td></tr><br>
<tr><td>Date Of Birth:</td><td><input type="date" class ="A" name="userDOB"/></td></tr>
<tr><td>Address:</td><td><input type="text" class ="A" name="userAddress"/></td></tr>
<tr><td>User Name:</td><td><input type="text" class ="A" name="userName"/></td></tr>
<tr><td>Password:</td><td><input type="password"  class ="A" name="userPassword"/></td></tr>
<tr><td>Confirm Password:</td><td><input type="password" class ="A" name="userConfirmPW"></td></tr>
<tr><td>User Type:<select name="userType" style="margin-right: 30px;margin-top: 5px;width: 125px">
  <option value="1">Admin</option>
  <option value="2">Employee</option>
  <option value="3">Training Admin</option>
  </select>
</td></tr>
<tr><td><input type="submit" name="submit" style="margin-top: 5px;margin-left: 200px"></td></tr>
</table>
</center>

     </form>
   </body>
</html>