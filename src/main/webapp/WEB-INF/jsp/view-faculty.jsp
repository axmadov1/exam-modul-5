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
    <title>View Faculties</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <style>

        h1, th, td, a{
            font-family: 'Al Bayan'
        }
    </style>
</head>
<body>
<div class="container text-center">
    <h1 style="margin-top: 50px">View Faculties</h1>
    <a class="btn btn-outline-primary my-4" href="/faculty/add-form">+ add new faculty</a>

    <div class="row">
        <div class="col-md-4 offset-4">
            <table class="table">
                <thead class="table-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">ACTION</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${allFacultys}" var="faculty" varStatus="loop">
                <tr>
                    <th scope="row">${loop.index+1}</th>
                    <td>${faculty.name}</td>
                    <td>
                        <a class="btn btn-warning" href="/faculty/edit/${faculty.id}">EDIT</a>
                        <a class="btn btn-danger" href="/faculty/delete/${faculty.id}">DELETE</a>
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
