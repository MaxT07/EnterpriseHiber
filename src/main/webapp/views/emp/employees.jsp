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
    <title>Employees</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-yellow w3-opacity w3-right-align">
    <h1>Employees</h1>
</div>

<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">

        <div class="w3-container w3-white w3-right-align">
            <h2></h2>

            <body class="w3-light-grey">
            <div class="w3-container w3-yellow w3-opacity w3-right-align w3-padding">
                <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/employees?depId=${param.depId}'">Add Employee</button>

                <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/departments'">Back to Departments</button>

                <button class="w3-btn w3-hover-yellow w3-round-large" onclick="location.href='../..'">Back to main</button>


            </div>


            </body>

            <p>

            </p>
            <TABLE BORDER width="100%" align="center">





                <tr align="center" bgcolor="green" >


                    <TD><H2>Firstname</H2></TD>
                    <TD><H2>Lastname</H2></TD>
                    <TD><H2>Age</H2></TD>
                    <TD><H2>Phone</H2></TD>
                    <TD><H2>Email</H2></TD>
                    <TD><H2>Position</H2></TD>
                    <TD><H2>Edit</H2></TD>
                    <TD><H2>Delete</H2></TD>
                </tr>
                <c:forEach items="${employee}" var="employee">

                <tr>


                    <TD>${employee.firstname}</TD>
                    <TD>${employee.lastname}</TD>
                    <TD>${employee.age}</TD>
                    <TD>${employee.phone}</TD>
                    <TD>${employee.email}</TD>
                    <TD>${employee.position}</TD>



        <TD>


            <div class="w3-container w3-white w3-opacity w3-right-align w3-padding">
                <button class="w3-btn w3-green w3-round-large" onclick="location.href='/employees?id=${employee.id}&action=edit'">Edit</button>
            </div>


        </TD>
        <TD>
            <div class="w3-container w3-white w3-opacity w3-right-align w3-padding">
                <button class="w3-btn w3-green w3-round-large" onclick="location.href='/employees?id=${employee.id}&action=delete'">Delete</button>
            </div>

        </TD>

        </tr>
                </c:forEach>
        </TABLE>

        <p>

        </p>

    </div>
</div>

<div class="w3-container w3-green w3-opacity w3-right-align w3-padding">
    <div class="w3-container w3-green w3-opacity w3-right-align w3-padding">
        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/views/emp/empAdd.jsp?depId=${param.depId}'">Add Employee</button>

        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/departments'">Back to Departments</button>

        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='../..'">Back to main</button>
    </div>
</div>
</div>
</div>
</body>
</html>