<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/"%>

<title>Login</title>

<t:_layout>

	<jsp:body>

        <div class="container" >

            <form class="form-signin" method="post">
                <h2 class="form-signin-heading">Please sign in</h2>
                <label for="inputEmail" class="sr-only">Email address</label>
                <input type="email" style="width: 100%" name="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password"  style="width: 100%" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
                <%--<div class="checkbox">--%>
                    <%--<label>--%>
                        <%--<input type="checkbox" value="remember-me"> Remember me--%>
                    <%--</label>--%>
                <%--</div>--%>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                <a href="/registration" type="button" class="btn btn-lg btn-primary btn-block">Registers</a>
            </form>

            <script src="${pageContext.request.contextPath}/resources/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
        </div>

     </jsp:body>
</t:_layout>