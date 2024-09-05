<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Edit User">
    <h1>Edit User</h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/EditUser">

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="username">Username</label>
                <input type="text" class="form-control" id="username" name="username"
                       placeholder="" value="${user.username}" required>
                <div class="invalid-feedback">
                    Username is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email"
                       placeholder="" value="${user.email}" required>
                <div class="invalid-feedback">
                    Email is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password"
                       placeholder="" value="">
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="user_groups">Groups</label>
                <select class="custom-select d-block w-100" id="user_groups" name="user_groups" multiple>
                    <b:forEach var="user_group" items="${usergroups}" varStatus="status">
                        <option value="${user_group}">${user_group}</option>
                    </b:forEach>
                </select>
            </div>
        </div>

        <input type="hidden" name="userId" id="userId" value="${user.id}">

        <div class="row">
            <div class="col-md-6 nb-3">
                <input type="submit" class="btn btn-primary btn-lg" id="save" value="Save">
            </div>
        </div>

    </form>
</t:pageTemplate>