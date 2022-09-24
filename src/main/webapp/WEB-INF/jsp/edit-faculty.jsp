<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Faculty</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <style>
        button, a, h1 {
            margin-top: 20px;
            font-family: 'Al Bayan'
        }
    </style>
</head>
<body>

<div class="container text-center">
    <h1 style="margin-top: 30px">Edit Faculty</h1>

    <div class="row">
        <div class="col-md-8 offset-2">
            <form action="/faculty/edit" method="post">
                <c:forEach items="${faculty}" var="faculty">
                    <div class="mb-3">
                        <input type="hidden" name="id" value="${faculty.id}">
                    </div>

                    <div class="mb-3">
                        <label for="name" class="form-label">Name</label>
                        <input name="name" type="text" class="form-control" id="name" value="${faculty.name}">
                    </div>

                </c:forEach>

                <a href="/faculty" class="btn btn-outline-secondary">Back</a>
                <button type="reset" class="btn btn-warning">Tozalash</button>
                <button type="submit" class="btn btn-success">Saqlash</button>

            </form>


        </div>
    </div>
</div>

</body>
</html>
