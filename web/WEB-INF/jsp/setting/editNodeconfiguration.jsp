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
                                    <h3 class="box-title">Edit Node Configuration</h3>
                                </div><!-- /.box-header -->
                                <c:url var="nodeconfigurationAction" value="/nodeconfiguration/update" ></c:url>
                                <f:form action="${nodeconfigurationAction}" commandName="nodeconfiguration" method="post" role="form" data-toggle="validator">
                                    <div class="box-body">                                    
                                        <div class="row margin">
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <input type="hidden" name="id" id="userId" value="<c:out value="${nodeconfiguration.id}" />">
                                                    <label for="txtFirstName">Country</label>
                                                    <input type="text" class="form-control" name="txtCountry" value="<c:out value="${nodeconfiguration.country}" />" id="txtCountry" placeholder="Enter Country">
                                                </div>
                                                <div class="form-group">
                                                    <label for="txtLastName">District</label>
                                                    <input type="text" class="form-control" name="txtDistrict" value="<c:out value="${nodeconfiguration.district}" />" id="txtLastName" placeholder="Enter Last Name">
                                                </div>
                                                
                                   
                                            </div>
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <label for="txtMiddleName">Province</label>
                                                    <input type="text" class="form-control" name="txtProvince" value="<c:out value="${nodeconfiguration.province}" />" id="txtProvince" placeholder="Enter Province">
                                                </div>
                                                <div class="form-group">
                                                    <label for="txtEmail">Facility</label>
                                                    <input type="email" class="form-control" name="txtFacility" value="<c:out value="${nodeconfiguration.facility}" />" id="txtEmail" placeholder="Enter Facility">
                                                </div>     
                                               
                                                </div>  
                                            </div>  
                                        </div><!-- /.box-body -->
                                        <hr>
                                        
                                        <div class="box-footer">
                                            <input type="submit" name="submit" value="Update" class="btn btn-primary">
                                            <input type="button" name="delete" id="delete" value="Delete" class="btn btn-primary">
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
            
            
          
            });
        </script>
    </body>
</html>

