<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="${user.username}">
    <h1>Profile Page</h1>
    <div class="container">


        <div class="row">
            <h1>Username</h1>
            <div class="col">
                    ${user.username}
            </div>
        </div>

        <div class="row">
            <h1>Email</h1>
            <div class="col">
                    ${user.email}
            </div>
        </div>

        <div class="row">
            <br>
            <div class="col">
                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditProfile?id=${user.id}">
                    Edit Profile</a>
            </div>
        </div>

        <br><br>

        <h1>Borrowed Books</h1>
        <b:forEach var="borrowedBook" items="${books}">
            <div class="row">
                <div class="col">
                        ${borrowedBook.bookTitle}
                </div>
                <div class="col">
                    Borrowed on:
                        ${borrowedBook.borrowDate}
                </div>
                <div class="col">
                    To be returned on:
                        ${borrowedBook.toBeReturnedDate}
                </div>
                <div class="col">
                    <a class="btn btn-success"
                       href="${pageContext.request.contextPath}/ReturnBook?id=${borrowedBook.id}" role="button">
                        Return Book</a>
                </div>
            </div>
            <br>
        </b:forEach>

    </div>
</t:pageTemplate>