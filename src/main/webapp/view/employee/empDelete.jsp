<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete Employee</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-yellow w3-opacity w3-right-align">
    <h1>Delete Employee</h1>
</div>
<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <h2></h2>
        <TABLE  width="100%" align="center">
            <tr  align="center" bgcolor="#b22222" >
                <TD height="50"><H2></H2></TD>
            </tr>
        </TABLE>
    </div>
</div>
</TABLE>
<p>
</p>
<TABLE BORDER width="100%" align="center">
    <tr align="center">
        <TD><H1>You want to delete employee?</H1></TD>
    </tr>
</TABLE>
<TABLE BORDER width="100%" align="center">
    <tr align="center" bgcolor="#ffd700" >
        <TD><H2>Firstname</H2></TD>
        <TD><H2>Firstname</H2></TD>
        <TD><H2>Age</H2></TD>
        <TD><H2>Phone</H2></TD>
        <TD><H2>Email</H2></TD>
        <TD><H2>Position</H2></TD>

    </tr>
    <form method="post">

        <input type="hidden" value="${employee.id}" name="id" />

        <tr>
            <TD><input type="text" value="${employee.firstname}" name="firstname"/><br/></TD>
            <TD><input type="text" value="${employee.lastname}" name="lastname"/><br/></TD>
            <TD><input type="number" value="${employee.age}" name="age"/><br/></TD>
            <TD><input type="text" value="${employee.phone}" name="phone"/><br/></TD>
            <TD><input type="text" value="${employee.email}" name="email"/><br/></TD>
            <TD><input type="text" value="${employee.position}" name="position"/><br/></TD>
            <TD><input type="hidden" value="${employee.depId}" name="depId"required/><br/></TD>
        </tr>

        <TABLE  width="100%" align="center">
            <tr align="center" bgcolor="#ffd700"  >


            </tr>
        </TABLE>

            <tr align="center" bgcolor="#b22222" >
                <TD><button type="submit" class="w3-btn w3-hover-red w3-round-large w3-margin-bottom">Yes, Delete</button></TD>
            </tr>

    </form>

    <div class="w3-container w3-yellow w3-opacity w3-right-align w3-padding">

        <button class="w3-btn w3-hover-red w3-round-large" onclick="location.href='/employees?depId=${employee.depId}'">Back to Employees</button>


    </div>
</TABLE>


<p>
</p>



<div class="w3-container w3-yellow w3-opacity w3-right-align w3-padding">

    <button class="w3-btn w3-hover-yellow w3-round-large" onclick="location.href='/departments'">Back to Departments</button>

    <button class="w3-btn w3-hover-yellow w3-round-large" onclick="location.href='../..'">Back to main</button>
</div>

</body>
</html>


