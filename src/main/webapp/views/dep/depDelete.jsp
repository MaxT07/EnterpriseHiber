<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false"%>

<%@ page import="java.util.List" %>
<%@ page import="model.Department" %>
<%@ page import="repository.DepRepoHiber" %><%--<%@ page session="false" pageEncoding="UTF-8" %>--%>
<%----%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete Department</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-red w3-opacity w3-right-align">
    <h1>Delete Departments</h1>
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
     <TD><H1>You want to delete this Department?</H1></TD>
    </tr>
</TABLE>
<TABLE BORDER width="100%" align="center">
    <tr align="center" bgcolor="#b22222" >
        <TD><H2>Name of Department</H2></TD>
        <TD><H2>Phone</H2></TD>
        <TD><H2>Email</H2></TD>
        <TD><H2>Address of Department</H2></TD>
        <TD><H2>Short Description</H2></TD>
    </tr>
    <form method="post">

        <input type="hidden" value="${department.id}" name="id" />

        <tr>
            <TD><input type="text" value="${department.name}" name="name"/><br/></TD>
            <TD><input type="text" value="${department.phone}" name="phone"/><br/></TD>
            <TD><input type="text" value="${department.email}" name="email"/><br/></TD>
            <TD><input type="text" value="${department.address}" name="address"/><br/></TD>
            <TD><input type="text" value="${department.description}" name="description"/><br/></TD>

        </tr>

        <TABLE  width="100%" align="center">


            </tr>
            <tr align="center" bgcolor="#b22222" >
            <TD><button type="submit" class="w3-btn w3-hover-red w3-round-large w3-margin-bottom">Yes, Delete</button></TD>
</tr>
    </form>
            <tr align="center" bgcolor="#b22222" >
                <TD><button class="w3-btn w3-hover-red w3-round-large" onclick="location.href='/departments'">No, back to Departments</button></TD>
        </TABLE>


</TABLE>
<p>
</p>

    <div class="w3-container w3-red w3-opacity w3-right-align w3-padding">

        <button class="w3-btn w3-hover-red w3-round-large" onclick="location.href='../..'">Back to main</button>
    </div>

</body>
</html>


