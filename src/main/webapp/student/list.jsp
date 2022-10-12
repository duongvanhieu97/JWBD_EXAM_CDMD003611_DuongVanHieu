<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
</head>
<body>
<center>
    <h1>Student Management</h1>
    <h2>
        <a href="/students?action=create" class="btn btn-info">Add New Student</a>
    </h2>

    <h2>List of Student</h2>
</center>
<div align="center">
    <form action="/students?action=find" method="post">
        <input type="text" name="nameStudent" placeholder="search"/>
        <input type="submit" style="border: 1px solid green; background: white; color: green" value="search"/>
    </form>
</div>
<div align="center">
    <table border="1" cellpadding="5" class="table">


        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Date of Birth</th>
            <th>Email</th>
            <th>Address</th>
<%--            <th>Classroom</th>--%>
            <th>Actions</th>
        </tr>
        <c:forEach var="student" items="${listStudent}">
            <tr>
                <td><c:out value="${student.getId()}"/></td>
                <td><c:out value="${student.getName()}"/></td>
                <td><c:out value="${student.getBirthday()}"/></td>
                <td><c:out value="${student.getEmail()}"/></td>
                <td><c:out value="${student.getAddress()}"/></td>
<%--                <td><c:out value="${student.getClassroom_id}"/></td>--%>

                <td>
                    <button class="btn btn-warning"><a href="/students?action=edit&id=${student.getId()}"
                               style="color: black;text-decoration: none">Edit</a>
                    </button>
                    <button class="btn btn-danger"><a href="/students?action=delete&id=${student.getId()}" style="color: white;text-decoration: none"
                                                       type="button">Delete</a>
                    </button>

                </td>
            </tr>
        </c:forEach>
    </table>
</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
