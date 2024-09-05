<%@ page import="java.time.LocalDate" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Return Book">
    <h1>Return Book</h1>

    <h2>Confirm return order:</h2>
    <h5>Title: ${book.bookTitle}</h5>
    <h5>Borrowed on: ${book.borrowDate}</h5>
    <h5>Returned on: ${today}</h5>
    <br>
    <h5>Borrower: ${pageContext.request.remoteUser} </h5>

    <form class="needs-validation" novalidate method="post" action="${pageContext.request.contextPath}/ReturnBook">

        <input type="hidden" name="bookId" value="${book.id}"/>
        <div class="row">
            <div class="col-md-6 nb-3">
                <input type="submit" class="btn btn-primary btn-lg" id="save" value="Confirm">
            </div>
        </div>

    </form>
</t:pageTemplate>