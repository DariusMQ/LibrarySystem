<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Books">
    <div class="container text-center">
        <br>
        <h1>Books</h1>
        <br>
        <b:if test="${pageContext.request.isUserInRole('WRITE_BOOKS')}">
            <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddBook">
                Add Book</a>
        </b:if>
        <br>
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">


            <b:forEach var="book" items="${books}">
                <div class="col">
                    <div class="card shadow-sm">
                        <svg class="bd-placeholder-img card-img-top" width="100%" height="215"
                             xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail"
                             preserveAspectRatio="xMidYMid slice" focusable="false">
                            <rect width="100%" height="100%" fill="#55595c"></rect>
                            <image href="${pageContext.request.contextPath}/BookPhotos?id=${book.id}"
                                   x="32%"/>
                        </svg>

                        <div class="card-body">
                            <div class="col">
                                Title: ${book.title}
                            </div>
                            <div class="col">
                                Author: ${book.author}
                            </div>
                            <div class="col">
                                Code: ${book.code}
                            </div>
                            <div class="col">
                                Number of Pages: ${book.numberOfPages}
                            </div>
                            <div class="col">
                                Quantity available: ${book.quantityAvailable}
                            </div>
                            <div class="col">
                                Published on: ${book.publishingDate}
                            </div>
                            <div class="col">
                                Location: ${book.location}
                            </div>

                            <b:if test="${pageContext.request.isUserInRole('READ_BOOKS')}">
                                <div class="col">
                                    <a class="btn btn-success"
                                       href="${pageContext.request.contextPath}/BorrowBook?id=${book.id}" role="button"
                                       style="width: 100%">
                                        Borrow Book</a>
                                </div>
                            </b:if>

                            <br>

                            <b:if test="${pageContext.request.isUserInRole('WRITE_BOOKS')}">
                                <div class="row">
                                    <div class="col">
                                        <a class="btn btn-secondary"
                                           href="${pageContext.request.contextPath}/AddBookPhoto?id=${book.id}"
                                           role="button">Add
                                            Photo</a>
                                    </div>
                                    <div class="col">
                                        <a class="btn btn-secondary"
                                           href="${pageContext.request.contextPath}/EditBook?id=${book.id}">
                                            Edit Book</a>
                                    </div>
                                    <div class="col">
                                        <form method="POST" action="${pageContext.request.contextPath}/Books">
                                            <button class="btn btn-danger" type="submit" name="deleteThis"
                                                    value="${book.id}">
                                                Delete
                                                Book
                                            </button>
                                        </form>
                                    </div>
                                </div>
                            </b:if>

                        </div>
                    </div>
                </div>
            </b:forEach>

            <b:forEach var="unavailableBook" items="${unavailablebooks}">
                <div class="col">
                    <div class="card shadow-sm">
                        <svg class="bd-placeholder-img card-img-top" width="100%" height="215"
                             xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail"
                             preserveAspectRatio="xMidYMid slice" focusable="false">
                            <rect width="100%" height="100%" fill="#55595c"></rect>
                            <image href="${pageContext.request.contextPath}/BookPhotos?id=${unavailableBook.id}"
                                   x="32%"/>
                        </svg>

                        <div class="card-body">
                            <div class="col">
                                Title: ${unavailableBook.title}
                            </div>
                            <div class="col">
                                Author: ${unavailableBook.author}
                            </div>
                            <div class="col">
                                Code: ${unavailableBook.code}
                            </div>
                            <div class="col">
                                Number of Pages: ${unavailableBook.numberOfPages}
                            </div>
                            <div class="col" style="color: red">
                                UNAVAILABLE
                            </div>
                            <div class="col">
                                Published on: ${unavailableBook.publishingDate}
                            </div>
                            <div class="col">
                                Location: ${unavailableBook.location}
                            </div>

                            <br>

                            <b:if test="${pageContext.request.isUserInRole('WRITE_BOOKS')}">
                                <div class="row">
                                    <div class="col">
                                        <a class="btn btn-secondary"
                                           href="${pageContext.request.contextPath}/AddBookPhoto?id=${unavailableBook.id}"
                                           role="button">Add
                                            Photo</a>
                                    </div>
                                    <div class="col">
                                        <a class="btn btn-secondary"
                                           href="${pageContext.request.contextPath}/EditBook?id=${unavailableBook.id}">
                                            Edit Book</a>
                                    </div>
                                    <div class="col">
                                        <form method="POST" action="${pageContext.request.contextPath}/Books">
                                            <button class="btn btn-danger" type="submit" name="deleteThis"
                                                    value="${unavailableBook.id}">
                                                Delete
                                                Book
                                            </button>
                                        </form>
                                    </div>
                                </div>
                            </b:if>

                        </div>
                    </div>
                </div>
            </b:forEach>
        </div>
    </div>
</t:pageTemplate>
