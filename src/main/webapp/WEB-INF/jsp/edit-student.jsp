<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Student</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <style>
        button, a, h1 {
            margin-top: 20px;
            font-family: 'Al Bayan';
    </style>
    }
    </style>
</head>
<body>

<div class="container text-center">
    <h1 style="margin-top: 30px">Edit Student</h1>

    <div class="row">
        <div class="col-md-8 offset-2">
            <form action="/students/edit" method="post">
                <c:forEach items="${student}" var="student">
                    <div class="mb-3">
                        <input type="hidden" name="id" value="${student.id}">
                    </div>

                    <div class="mb-3">
                        <label for="name" class="form-label">Name</label>
                        <input name="name" type="text" class="form-control" id="name" value="${student.name}">
                    </div>

                    <div class="mb-3">
                        <label for="surname" class="form-label">Surname</label>
                        <input name="surname" type="text" class="form-control" id="surname" value="${student.surname}">
                    </div>

                    <div class="mb-3">
                        <label for="course" class="form-label">Course</label>
                        <input name="course" type="number" class="form-control" id="course" value="${student.course}">
                    </div>


                    <div class="form-group">
                        <label for="universityId">University</label>
                        <select id="universityId"
                                class="selectpicker form-control"
                                aria-label="Please select university"
                                data-live-search="true"
                                name="universityId">
                            <c:forEach items="${universityList}" var="university">
                                <option value="${university.id}">${university.name}</option>
                            </c:forEach>
                        </select>
                    </div>


                    <div class="form-group">
                        <label for="facultyId">Faculty</label>
                        <select id="facultyId"
                                class="selectpicker form-control"
                                aria-label="Please select faculty"
                                data-live-search="true"
                                name="facultyId">
                            <c:forEach items="${facultyList}" var="faculty">
                                <option value="${faculty.id}">${faculty.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </c:forEach>

                <a href="/students" class="btn btn-outline-secondary">Back</a>
                <button type="reset" class="btn btn-warning">Tozalash</button>
                <button type="submit" class="btn btn-success">Saqlash</button>

            </form>


        </div>
    </div>
</div>

</body>
</html>
