<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Books">
    <h1>Books</h1>
    <div class="container text-center">
        <div class="row">
            <div class="col">
                Book 1
            </div>
            <div class="col">
                Cota 1
            </div>
            <div class="col">
                Shelf 1
            </div>
        </div>
        <div class="row">
            <div class="col">
                Book 2
            </div>
            <div class="col">
                Cota 2
            </div>
            <div class="col">
                Shelf 2
            </div>
        </div>
        <div class="row">
            <div class="col">
                Book 3
            </div>
            <div class="col">
                Cota 3
            </div>
            <div class="col">
                Shelf 3
            </div>
        </div>
    </div>
    <h5>Number of books: ${numberOfBooks}</h5>
</t:pageTemplate>
