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
                                    <h3 class="box-title">Edit Device</h3>
                                </div><!-- /.box-header -->
                                <c:url var="deviceAction" value="/device/update" ></c:url>
                                <f:form action="${devicetypeAction}" commandName="devicetype" method="post" role="form" data-toggle="validator">
                                    <div class="box-body">                                    
                                        <div class="row margin">
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <input type="hidden" name="id" id="deviceId" value="<c:out value="${device.id}" />">
                                                      <div class="form-group">
                                                    <label for="slctProvince">Device Type</label>
                                                    <select class="form-control" id="slctDevicetypes" name="slctDevicetypes" value="<c:out value="${device.devicetypeId}" />">
                                                        <option value="">--Select Device Type--</option>
                                                        <c:forEach items="${Devicetypes}" var="devicetype">
                                                            <option value="${devicetype.id}">${devicetype.typeName}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="txtTestingPoint">Testing Point</label>
                                                    <input type="text" class="form-control" name="txtTestingPoint" id="txtTestingPoint" value="<c:out value="${device.testingPoint}" />" placeholder="Enter Serial Number" required>
                                                </div>
                                               
                                              <div class="form-group">
                                                    <label for="txtLastmaintenanceDate">Scheduled Preventive Maintenance Date</label>
                                                    <div class="input-group">
                                                        <div class="input-group-addon">
                                                            <i class="fa fa-calendar"></i>
                                                        </div>
                                                    <input type="text" class="form-control" data-provide="datepicker" name="txtSeculededPreventiveMaintenaceDate" id="txtSeculededPreventiveMaintenaceDate" value="<c:out value="${device.seculededPreventiveMaintenaceDate}" />" placeholder="Enter Seculeded Preventive Maintenace Date">
                                                    </div>
                                                </div>
                                                                                  
                                            </div>
                                       <div class="col-sm-6">
                                                <div class="form-group">
                                                    <label for="txtSerialNumber">Serial Number</label>
                                                    <input type="text" class="form-control" name="txtSerialNumber" id="txtSerialNumber" value="<c:out value="${device.serialNumber}" />" placeholder="Enter Serial Number" required>
                                                </div>
                                              
                                                    <div class="form-group">
                                                    <label for="txtLastmaintenanceDate">Last Maintenance Date</label>
                                                     <div class="input-group">
                                                    <div class="input-group-addon">
                                                            <i class="fa fa-calendar"></i>
                                                        </div>
                                                    <input type="text" class="form-control" data-provide="datepicker" name="txtLastMaintenanceDate" id="txtLastMaintenanceDate" value="<c:out value="${device.lastMaintenanceDate}" />" placeholder="Enter Last Maintenance Date">
                                                    </div>
                                                
                                              
                                            </div>   
                                        </div><!-- /.box-body -->
                                          </div>
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

