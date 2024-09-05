<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core" %>


<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="container-fluid">


            <a class="navbar-brand" href="${pageContext.request.contextPath}">Library</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                    aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>


            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav">

                    <li>
                        <a class="nav-link
                        ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf
("/")) eq '/books.jsp' ? ' active' : ''}" aria-current="page" href="${pageContext.request.contextPath}/Books">
                            Books</a>
                    </li>

                    <li>
                        <a class="nav-link
                        ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf
("/")) eq '/users.jsp' ? ' active' : ''}" aria-current="page" href="${pageContext.request.contextPath}/Users">
                            Users</a>
                    </li>

                    <li>
                        <a class="nav-link
                        ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf
("/")) eq '/borrowedbooks.jsp' ? ' active' : ''}" aria-current="page"
                           href="${pageContext.request.contextPath}/Borrowed_Books">
                            Borrowed</a>
                    </li>

                    <li>
                        <a class="nav-link
                        ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf
("/")) eq '/returnedbooks.jsp' ? ' active' : ''}" aria-current="page"
                           href="${pageContext.request.contextPath}/Returned_Books">
                            Returned</a>
                    </li>

                </ul>
            </div>


            <ul class="navbar-nav">
                <li class="nav-item">
                    <b:choose>
                        <b:when test="${pageContext.request.getRemoteUser() == null}">
                            <a class="nav-link" href="${pageContext.request.contextPath}/Login">Login</a>
                        </b:when>
                        <b:otherwise>
                            <a class="nav-link" href="${pageContext.request.contextPath}/Logout">Log Out</a>
                        </b:otherwise>
                    </b:choose>
                </li>
            </ul>


        </div>
    </nav>
</header>