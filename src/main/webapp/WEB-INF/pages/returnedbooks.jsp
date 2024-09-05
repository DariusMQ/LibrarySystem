<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">
    <h1>Returned Books</h1>
    <div class="container text-center">
        <b:forEach var="returnedBook" items="${returnedBooks}">
            <div class="row">
                <div class="col">
                        ${returnedBook.bookTitle}
                </div>
                <div class="col">
                    Borrowed on:
                        ${returnedBook.borrowDate}
                </div>
                <div class="col">
                    Returned on:
                        ${returnedBook.returnDate}
                </div>
                <div class="col">
                    ${returnedBook.returnStatus eq "RETURNED_LATE" ?
                    'Returned late' : 'Returned on time'}
                </div>
                <div class="col">
                    Borrowed by:
                        ${returnedBook.borrowerUsername}
                </div>
            </div>
        </b:forEach>
    </div>
</t:pageTemplate>