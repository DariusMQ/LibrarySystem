<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Books">
    <h1>Books</h1>

    <b:if test="${pageContext.request.isUserInRole('WRITE_BOOKS')}">
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddBook">
            Add Book</a>
    </b:if>

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
                <div class="col">
                    <img src="${pageContext.request.contextPath}/BookPhotos?id=${book.id}" width="48"/>
                </div>

                <b:if test="${pageContext.request.isUserInRole('WRITE_BOOKS')}">
                    <div class="col">
                        <a class="btn btn-secondary"
                           href="${pageContext.request.contextPath}/AddBookPhoto?id=${book.id}" role="button">Add Photo</a>
                    </div>
                    <div class="col">
                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditBook?id=${book.id}">
                            Edit Book</a>
                    </div>
                    <div class="col">
                        <form method="POST" action="${pageContext.request.contextPath}/Books">
                            <button class="btn btn-danger" type="submit" name="deleteThis" value="${book.id}"> Delete
                                Book
                            </button>
                        </form>
                    </div>
                </b:if>

            </div>
        </b:forEach>
    </div>
    <h5>Number of books: ${numberOfBooks}</h5>
</t:pageTemplate>
