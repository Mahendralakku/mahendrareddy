<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>

<style>
#h1 {
  margin-left: 20%;
}
</style>
</head>
<body>

<%@include  file="myActSidePanelAdmin.jsp" %>
<%@include file="LogOutPage.jsp" %>
<form action="SaveTrainingServlet" method="POST">

<div id=h1>
<h1>Add Trainings</h1>
Training Name:<input type="text" name="trainingName" required="required"><br><br>

Training Type:<input type="text" name="trainingType"><br><br>
Training Desc:<input type="text" name="trainingDesc"><br><br>
<a href ="ViewTrainings">View Trainings</a><input type="submit" name="submit" value="Submit" style="margin-left: 20px">

  
  </div>
  </form>
</body>
</html>