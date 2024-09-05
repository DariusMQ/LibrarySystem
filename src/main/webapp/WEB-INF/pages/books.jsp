<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Books">
    <h1>Books</h1>
    <div class="container text-center">
        <b:forEach var="book" items="${books}">
            <div class="row">
                <div class="col">
                        ${book.title}
                </div>
                <div class="col">
                        ${book.author}
                </div>
                <div class="col">
                        ${book.numberOfPages}
                </div>
                <div class="col">
                        ${book.code}
                </div>
                <div class="col">
                        ${book.quantityAvailable}
                </div>
                <div class="col">
                        ${book.publishingDate}
                </div>
                <div class="col">
                        ${book.location}
                </div>
            </div>
        </b:forEach>
    </div>
    <h5>Number of books: ${numberOfBooks}</h5>
</t:pageTemplate>
