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
                                    <h3 class="box-title">Add Device</h3>
                                </div><!-- /.box-header -->
                                <c:url var="addDevice" value="/device/add" ></c:url>
                                <f:form action="${addDevice}" commandName="device" method="post" role="form" data-toggle="validator">
                                    <div class="box-body">                                 
                                        <div class="row margin">
                                            <div class="col-sm-6">
                                                
                                                    <div class="form-group">
                                                    <label for="slctProvince">Device Type</label>
                                                    <select class="form-control" id="slctDevicetype" name="slctDevicetype">
                                                        <option value="">--Select Device Type--</option>
                                                        <c:forEach items="${Devicetypes}" var="devicetype">
                                                            <option value="${devicetype.id}">${devicetype.typeName}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label for="txtTestingPoint">Testing Point</label>
                                                    <input type="text" class="form-control" name="txtTestingPoint" id="txtTestingPoint" placeholder="Enter Serial Number" required>
                                                </div>
                                             <div class="form-group">
                                                    <label for="txtLastmaintenanceDate">Scheduled Preventive Maintenance Date</label>
                                                    <div class="input-group">
                                                        <div class="input-group-addon">
                                                            <i class="fa fa-calendar"></i>
                                                        </div>
                                                    <input type="text" class="form-control" data-provide="datepicker" name="txtSeculededPreventiveMaintenaceDate" id="txtSeculededPreventiveMaintenaceDate" placeholder="Enter Seculeded Preventive Maintenace Date">
                                                    </div>
                                                </div>
                                                
                                              
                                            </div>
                                                <div class="col-sm-6">
                                                <div class="form-group">
                                                    <label for="txtSerialNumber">Serial Number</label>
                                                    <input type="text" class="form-control" name="txtSerialNumber" id="txtSerialNumber" placeholder="Enter Serial Number" required>
                                                </div>
                                                    <div class="form-group">
                                                    <label for="txtLastmaintenanceDate">Last Maintenance Date</label>
                                                     <div class="input-group">
                                                    <div class="input-group-addon">
                                                            <i class="fa fa-calendar"></i>
                                                        </div>
                                                    <input type="text" class="form-control" data-provide="datepicker" name="txtLastMaintenanceDate" id="txtLastMaintenanceDate" placeholder="Enter Last Maintenance Date">
                                                    </div>
                                                
                                              
                                            </div>                              
                                        </div>
                                    </div><!-- /.box-body -->
                                    <hr>
                                    

                                    <div class="box-footer">
                                        <input type="submit" name="submit" value="Save" class="btn btn-primary">
                                    </div>
                                </f:form>                                
                            </div><!-- /.box -->
                        </div>
                    </div>
                    <!-- /.box -->

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
                        window.location.href = "/EPMS/devicetype/delete/" + jQuery("#devicetypeId").val();
                    } else {
                        return false;
                    }
                });

            });
        </script>
    </body>
</html>

