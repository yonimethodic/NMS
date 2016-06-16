<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>NMS | Log in</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- Bootstrap 3.3.2 -->
        <c:url value='/resources/bootstrap/css/bootstrap.min.css' var="url" />
        <link href="${url}" rel="stylesheet" type="text/css">
        <!-- Font Awesome Icons -->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <c:url value="/resources/dist/css/AdminLTE.min.css" var="url" />
        <link href="${url}" rel="stylesheet" type="text/css">
        <!-- iCheck -->
        <c:url value="/resources/plugins/iCheck/square/blue.css" var="url" />
        <link href="${url}" rel="stylesheet" type="text/css" >

    </head>
    <body class="login-page">
        <div class="login-box">
            <div class="login-logo">
                <a href="<c:url value="/index"/>"><b>NMS</b></a>
            </div><!-- /.login-logo -->
            <div class="login-box-body">
                <c:if test="${!empty param.message}">
                    <div class="alert alert-danger">
                        <h4><i class="icon fa fa-ban"></i> Alert!</h4>
                        <c:out value="${param.message}"/>
                    </div>
                </c:if>
                <p class="login-box-msg">Sign in to start your session</p>
                <c:url var="login" value="/j_spring_security_check" ></c:url>
                <f:form action="${login}" commandName="user" method="post" role="form">
                    <div class="form-group has-feedback">
                        <input type="text" name="txtUsername" class="form-control" placeholder="User Name">
                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" name="txtPassword" class="form-control" placeholder="Password">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="row">
                        <div class="col-xs-8">    
                            <div class="checkbox icheck">
                                <label>
                                    <input type="checkbox"> Remember Me
                                </label>
                            </div>                        
                        </div><!-- /.col -->
                        <div class="col-xs-4">
                            <input type="submit" name="submit" value="Sign In" class="btn btn-primary btn-block btn-flat">
                        </div><!-- /.col -->
                    </div>
                </f:form>

                <a href="#">I forgot my password</a>

            </div><!-- /.login-box-body -->
        </div><!-- /.login-box -->

        <!-- jQuery 2.1.3 -->
        <c:url value="/resources/plugins/jQuery/jQuery-2.1.3.min.js" var="url" />        
        <script src="${url}" type="text/javascript"></script>
        <!-- Bootstrap 3.3.2 JS -->
        <c:url value="/resources/bootstrap/js/bootstrap.min.js" var="url" />
        <script src="${url}" type="text/javascript"></script>
        <!-- iCheck -->
        <c:url value="/resources/plugins/iCheck/icheck.min.js" var="url" />
        <script src="${url}" type="text/javascript"></script>
        <script type="text/javascript">
            $(function() {
                $('input').iCheck({
                    checkboxClass: 'icheckbox_square-blue',
                    radioClass: 'iradio_square-blue',
                    increaseArea: '20%' // optional
                });
            });
        </script>
    </body>
</html>

