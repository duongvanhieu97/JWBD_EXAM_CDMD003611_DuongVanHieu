<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
<center>
    <h1>Student</h1>
    <h2>
        <a href="students?action=students" class="btn btn-primary">Back to student list</a>
    </h2>
    <h2 style="color: blue">Create New Student</h2>
</center>

<div align="center">
    <form method="post">
        <table border="1" cellpadding="5" class="table">
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="150"/>
                </td>
            </tr>
            <tr>
                <th>Date of Brith:</th>
                <td>
                    <input type="date" name="birthday" id="birthday" size="150"/>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="150"/>
                </td>
            </tr>
            <tr>
                <th>PhoneNumber:</th>
                <td>
                    <input type="text" name="phoneNumber" id="phoneNumber" size="150"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="150"/>
                </td>
            </tr>

<%--            <tr>--%>
<%--                <th>Classroom ID</th>--%>
<%--                <td>--%>
<%--                    <select name="classroom_id" id="classroom_id">--%>
<%--                        <option value="">Classroom</option>--%>
<%--                        <c:forEach items="${requestScope['listClassroom']}" var="classroom">--%>
<%--                            <option value="${classroom.getId()}">${classroom.getName()}</option>--%>
<%--                        </c:forEach>--%>
<%--                    </select>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>Classroom:</th>--%>
<%--                <td>--%>
<%--                    <select name="classroom_id" >--%>
<%--                        <c:forEach var="classroom" items="${classroomList}">--%>
<%--                            <option value="${classroom.idClass}"><c:out value="${classroom.nameClass}"/></option>--%>
<%--                        </c:forEach>--%>
<%--                    </select>--%>
<%--                </td>--%>
<%--            </tr>--%>
            <tr>
                <td>
                    <select name="classroom_id" id="classroom_id" >
                    <option value="" >Open this class Menu</option>
                    <option value="1">C06</option>
                    <option value="2">C07</option>
                    <option value="3">C08</option>

                    </select>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Submit" class="my-1 btn btn-success btn-block"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
