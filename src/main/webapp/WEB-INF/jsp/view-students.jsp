<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 24/09/22
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Students</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <style>

        h1, th, td, a{
            font-family: 'Al Bayan'
        }
    </style>
</head>
<body>
<div class="container text-center">
    <h1 style="margin-top: 50px">View Students</h1>
    <a class="btn btn-outline-primary my-4" href="/students/add-form">+ add new student</a>

    <div class="row">
        <div class="col-md-8 offset-2">
            <table class="table">
                <thead class="table-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Surname</th>
                    <th scope="col">Course</th>
                    <th scope="col">University</th>
                    <th scope="col">Faculty</th>
                    <th scope="col">ACTION</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${allStudents}" var="student" varStatus="loop">
                    <tr>
                        <th scope="row">${loop.index+1}</th>
                        <td>${student.name}</td>
                        <td>${student.surname}</td>
                        <td>${student.course}</td>
                        <td>${student.universityName}</td>
                        <td>${student.facultyName}</td>
                        <td>
                            <a class="btn btn-warning" href="/students/edit/${student.id}">EDIT</a>
                            <a class="btn btn-danger" href="/students/delete/${student.id}">DELETE</a>
                        </td>
                </c:forEach>

                </tbody>
            </table>

            <a href="/" class="btn btn-outline-secondary">Back</a>
        </div>
    </div>
</div>
</body>
</html>
