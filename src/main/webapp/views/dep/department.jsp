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
    <title>Departments</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-green w3-opacity w3-right-align">
    <h1>Departments</h1>
</div>

<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">

        <div class="w3-container w3-white w3-right-align">
            <h2></h2>

            <body class="w3-light-grey">
            <div class="w3-container w3-green w3-opacity w3-right-align w3-padding">
                <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='views/dep/depAdd.jsp'">Add Department</button>

                <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='../..'">Back to main</button>
            </div>


</body>

<p>

</p>
                <TABLE BORDER width="100%" align="center">





                    <tr align="center" bgcolor="green" >


                        <TD><H2>Name</H2></TD>
                        <TD><H2>Phone</H2></TD>
                        <TD><H2>Email</H2></TD>
                        <TD><H2>Address</H2></TD>
                        <TD><H2>Short Description</H2></TD>
                        <TD><H2>Employees</H2></TD>
                        <TD><H2>Edit</H2></TD>
                        <TD><H2>Delete</H2></TD>
    </tr>

    <c:forEach items="${department}" var="department">
        <tr>


            <TD>${department.name}</TD>
            <TD>${department.phone}</TD>
            <TD>${department.email}</TD>
            <TD>${department.address}</TD>
            <TD>${department.description}</TD>


            <TD>



                    <div class="w3-container w3-white w3-opacity w3-right-align w3-padding">
                        <button class="w3-btn w3-green w3-round-large" onclick="location.href='/employees?depId=${department.id}'">Employees</button>
                    </div>

                </div>
            </TD>
            <TD>


                <div class="w3-container w3-white w3-opacity w3-right-align w3-padding">
                    <button class="w3-btn w3-green w3-round-large" onclick="location.href='/departments?id=${department.id}&action=edit'">Edit</button>
                </div>


            </TD>
            <TD>
                <div class="w3-container w3-white w3-opacity w3-right-align w3-padding">
                    <button class="w3-btn w3-green w3-round-large" onclick="location.href='/departments?id=${department.id}&action=delete'">Delete</button>
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
            <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='views/dep/depAdd.jsp'">Add Department</button>

            <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='../..'">Back to main</button>
        </div>
    </div>
    </div>
</div>
</body>
</html>