<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">
    <h1>Borrowed Books</h1>
    <div class="container text-center">
        <b:forEach var="borrowedBook" items="${borrowedBooks}">
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
                    Borrowed by:
                    ${borrowedBook.borrowerUsername}
                </div>
            </div>
        </b:forEach>
    </div>
</t:pageTemplate>