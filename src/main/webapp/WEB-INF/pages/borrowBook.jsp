<%@ page import="java.time.LocalDate" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Borrow Book">
    <h1>Borrow Book</h1>

    <h2>Confirm borrow order:</h2>
    <h5>Title: ${book.title}</h5>
    <h5>Author: ${book.author}</h5>
    <h5>Code: ${book.code}</h5>
    <h5>Location: ${book.location}</h5>
    <br>
    <h5>Borrower: ${pageContext.request.remoteUser} </h5>
    <br>
    <h5>Borrowed on: ${today}</h5>

    <form class="needs-validation" novalidate method="post" action="${pageContext.request.contextPath}/BorrowBook">

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="returnDate">To be returned on:</label>
                <input type="date" class="form-control" id="returnDate" name="returnDate"
                       placeholder="" value="" required>
                <div class="invalid-feedback">
                    Return date is required.
                </div>
            </div>
        </div>

        <input type="hidden" name="bookId" value="${book.id}"/>
        <input type="hidden" name="userId" value="${pageContext.request.remoteUser}"/>
        <div class="row">
            <div class="col-md-6 nb-3">
                <input type="submit" class="btn btn-primary btn-lg" id="save" value="Confirm">
            </div>
        </div>

    </form>
</t:pageTemplate>