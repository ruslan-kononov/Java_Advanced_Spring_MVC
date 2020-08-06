<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Main Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
          crossorigin="anonymous">
</head>
<body>
<header style="margin-bottom: 60px;">
    <jsp:include page="header.jsp" />
</header>
<div>
<c:choose>
    <c:when test="${mode=='VIEW'}">
        <div class="container" style="margin: 70px 50px;">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Level</th>
                    <th scope="col">Skill</th>
                    <th scope="col">${participants.size()}</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="person" items="${participants}">
                    <tr>
                        <td class="align-middle">${person.id}</td>
                        <td class="align-middle">${person.name}</td>
                        <td class="align-middle">${person.email}</td>
                        <td class="align-middle">${person.level}</td>
                        <td class="align-middle">${person.primarySkill}</td>
                        <td><button type="button" class="btn btn-danger"
                                    onclick="document.location.href='delete?id=${person.id}'">Delete</button></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:when>
    <c:otherwise>
        <div class="container">
            <div style="margin: 80px 150px">
                <form:form class="needs-validation" action="saveNew" method="POST" modelAttribute="part">
                    <div class="form-row">
                        <div class="col-md-6 mb-3">
                            <label path="name">Full name</label>
                            <form:input type="text" class="form-control"  id="participantName" path="name"  />
                        </div>
                        <div class="col-md-4 mb-3">
                            <form:label path="email">Email</form:label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">@</span>
                                </div>
                                <form:input type="text" class="form-control" path="email" />
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-6 mb-3">
                            <form:label path="primarySkill">Skill</form:label>
                            <form:input type="text" class="form-control" path="primarySkill" />
                        </div>
                        <div class="col-md-3 mb-3" path="level">
                            <label>Level</label>
                            <form:select class="custom-select" path="level">
                                <form:option value="L1">L1</form:option>
                                <form:option value="L2">L2</form:option>
                                <form:option value="L3">L3</form:option>
                                <form:option value="L4">L4</form:option>
                                <form:option value="L5">L5</form:option>
                            </form:select>
                        </div>
                        <div class="col-md-3 mb-3">
                        </div>
                    </div>
                    <button class="btn btn-success" type="submit">Save</button>
                </form:form>
            </div>
        </div>
    </c:otherwise>
</c:choose>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
</body>
</html>
