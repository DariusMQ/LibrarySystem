<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Edit Book">
    <h1>Edit Book</h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/EditBook">

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="title">Title</label>
                <input type="text" class="form-control" id="title" name="title"
                       placeholder="" value="${book.title}" required>
                <div class="invalid-feedback">
                    Title is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="author">Author</label>
                <input type="text" class="form-control" id="author" name="author"
                       placeholder="" value="${book.author}" required>
                <div class="invalid-feedback">
                    Author is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="pages">Number of pages</label>
                <input type="number" class="form-control" id="pages" name="pages"
                       placeholder="" value="${book.numberOfPages}" required min="1" step="1">
                <div class="invalid-feedback">
                    Number of pages is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="code">Code</label>
                <input type="number" class="form-control" id="code" name="code"
                       placeholder="" value="${book.code}" required min="1" step="1">
                <div class="invalid-feedback">
                    Code is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="quantity">Quantity available</label>
                <input type="number" class="form-control" id="quantity" name="quantity"
                       placeholder="" value="${book.quantityAvailable}" required min="1" step="1">
                <div class="invalid-feedback">
                    Quantity is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="publishingDate">Publishing Date</label>
                <input type="date" class="form-control" id="publishingDate" name="publishingDate"
                       placeholder="" value="${book.publishingDate}" required>
                <div class="invalid-feedback">
                    Publishing date is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="location">Location</label>
                <input type="text" class="form-control" id="location" name="location"
                       placeholder="" value="${book.location}" required>
                <div class="invalid-feedback">
                    Location is required.
                </div>
            </div>
        </div>

        <input type="hidden" name="bookId" value="${book.id}" />

        <div class="row">
            <div class="col-md-6 nb-3">
                <input type="submit" class="btn btn-primary btn-lg" id="save" value="Save">
            </div>
        </div>

    </form>
</t:pageTemplate>