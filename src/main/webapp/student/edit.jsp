<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        #logo {
            margin: 0;
            float: none;
            width: 50px;
            height: 50px;
        }
    </style>
</head>
<body>
<center>
    <h1>Edit Category</h1>
    <h2>
        <a href="categories?action=books">Back List All Categories</a>
    </h2>

</center>

<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">

            <c:if test="${student != null}">
                <input type="hidden" name="id" value="<c:out value='${student.id}' />"/>
            </c:if>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" size="50"
                           value="${requestScope["student"].getName()}"
                    />
                </td>
            </tr>
            <tr>
                <th>Brithday :</th>
                <td>
                    <input type="date" name="birthday" size="50"
                           value="${requestScope["student"].getBirthday()}"
                    />
                </td>
            </tr>
            </tr><tr>
            <th>Address:</th>
            <td>
                <input type="text" name="address" size="45"
                       value="<c:out value='${student.address}' />"
                />
            </td>
        </tr><tr>
            <th>Phone Number:</th>
            <td>
                <input type="text" name="phoneNumber" size="45"
                       value="<c:out value='${student.phoneNumber}' />"
                />
            </td>
        </tr>
            <tr>
                <th>Student Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${student.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Classroom:</th>
                <td>
                    <select name="classroom_id" id="classroom_id">
                        <option value=" "> </option>
                        <c:forEach var="classroom" items="${classroomList}">

                            <option value="${classroom.getId()}">${classroom.getName()}</option>

                        </c:forEach>
                    </select>
                </td>
            </tr>
<%--            <tr>--%>
<%--                <th>Brithday :</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="birthday" size="50"--%>
<%--                           value="${requestScope["student"].getBirthday()}"--%>
<%--                    />--%>
<%--                </td>--%>
<%--            </tr>--%>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" class="my-1 btn btn-success btn-block"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
