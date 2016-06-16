<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <%@include file="../includes.jsp" %>

    <body class="skin-blue">
        <%@include file="../header.jsp" %>
        <!-- Site wrapper -->
        <div class="wrapper">

            <%@include file="../sideBar.jsp" %>

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper" style="min-height: 858px;">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Setting Module
                    </h1>
                </section>

                <!-- Main content -->
                <section class="content">
                    <!-- Default box -->
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box box-primary">
                                <div class="box-header">
                                    <h3 class="box-title">Edit Property</h3>
                                </div><!-- /.box-header -->
                                <c:url var="propertyAction" value="/property/update" ></c:url>
                                <f:form action="${propertyAction}" commandName="property" method="post" role="form" data-toggle="validator">
                                    <div class="box-body">                                    
                                        <div class="row margin">
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <input type="hidden" name="id" id="propertyId" value="<c:out value="${property.id}" />">
                                                   
                                                    <label for="txtKey">Key</label>
                                                    <input type="text" class="form-control" name="txtKey" id="txtKey" readonly="true" value="<c:out value="${property.key}" />" >
                                                    </div>
                                            </div>
                                                     <div class="col-sm-6">
                                                 <div class="form-group">
                                                    <label for="txtvalue">Value</label>
                                                    <input type="text" class="form-control" name="txtValue" id="txtValue" value="<c:out value="${property.value}" />" required>
                                                </div>
                                                                                  
                                            </div>
                                       
                                        </div><!-- /.box-body -->
                                        <hr>
                                  
                                        <div class="box-footer">
                                            <input type="submit" name="submit" value="Update" class="btn btn-primary">
                                            
                                        </div>
                                    </f:form>                                
                                </div><!-- /.box -->
                            </div>
                        </div>
                        <!-- /.box -->
                    </div>
                </section><!-- /.content -->
            </div><!-- /.content-wrapper -->

            <%@include file="../footer.jsp" %>
        </div><!-- ./wrapper -->
        <%@include file="../scripts.jsp" %> 
        <script type="text/javascript">
            jQuery(document).ready(function() {
                jQuery("#delete").click(function() {
                    var r = window.confirm("Are you sure you want to delete this record?");
                    if (r === true) {
                        window.location.href = "/EPMS/device/delete/" + jQuery("#deviceId").val();
                    } else {
                        return false;
                    }
                });
        
             
            });
        </script>
    </body>
</html>

