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
                        User Module
                    </h1>
                </section>

                <!-- Main content -->
                <section class="content">
                    <!-- Default box -->
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box box-primary">
                                <div class="box-header">
                                    <h3 class="box-title">Add User</h3>
                                </div><!-- /.box-header -->
                                <c:url var="addUser" value="/user/add" ></c:url>
                                <f:form action="${addUser}" commandName="user" method="post" role="form" data-toggle="validator">
                                    <div class="box-body">                                    
                                        <div class="row margin">
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <label for="txtFirstName">First Name</label>
                                                    <input type="text" class="form-control" name="txtFirstName" id="txtFirstName" placeholder="Enter First Name" required>
                                                </div>
                                                <div class="form-group">
                                                    <label for="txtLastName">Last Name</label>
                                                    <input type="text" class="form-control" name="txtLastName" id="txtLastName" placeholder="Enter Last Name">
                                                </div>
                                                <div class="form-group">
                                                    <label for="txtUsername">Username</label>
                                                    <input type="text" class="form-control" name="txtUsername" id="txtUsername" placeholder="Enter Username">
                                                </div>                                                
                                                <div class="form-group">
                                                    <label for="txtPosition">Phone No</label>
                                                    <input type="text" class="form-control" name="txtPosition" id="txtPosition" placeholder="Enter Position">
                                                </div>
                                                <div class="checkbox">
                                                    <label>                                                       
                                                        <input type="checkbox" id="ckGetSMSNotification" name="ckGetSMSNotification"> Get SMS Notification       
                                                    </label> 
                                                </div>  
                                            </div>
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <label for="txtMiddleName">Middle Name</label>
                                                    <input type="text" class="form-control" name="txtMiddleName" id="txtMiddleName" placeholder="Enter Middle Name">
                                                </div>
                                                <div class="form-group">
                                                    <label for="txtEmail">Email address</label>
                                                    <input type="email" class="form-control" name="txtEmail" id="txtEmail" placeholder="Enter email">
                                                </div>     
                                                <div class="form-group">
                                                    <label for="txtPassword">Password</label>
                                                    <input type="password" class="form-control" name="txtPassword" id="txtPassword" placeholder="Enter Password">
                                                </div>
                                                <br/>
                                                <div class="checkbox">
                                                    <label>                                                       
                                                        <input type="checkbox" id="ckIsActive" name="ckIsActive"> Is Active       
                                                    </label> 
                                                </div>  
                                                <br/>
                                                <div class="checkbox">
                                                    <label>                                                       
                                                        <input type="checkbox" id="getEMailNotification" name="getEMailNotification"> Get EMAIL Notification       
                                                    </label> 
                                                </div>  
                                            </div>                                    
                                        </div>
                                    </div><!-- /.box-body -->
                                    <hr>
                                    <div class="box-body">                                    
                                        <div class="row margin">
                                            <div class="col-sm-6">
                                                <h3 class="box-title">Assign Roles</h3>
                                                <c:forEach items="${Roles}" var="role">
                                                    <div class="checkbox">
                                                        <label>                                                       
                                                            <input type="checkbox" id="ckRole" name="ckRole" value="${role.id}"> ${role.name}       
                                                        </label> 
                                                    </div> 
                                                </c:forEach>                                                
                                            </div>
                                        </div>
                                    </div>

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
                        window.location.href = "/EPMS/user/delete/" + jQuery("#userId").val();
                    } else {
                        return false;
                    }
                });

                //Selecting province to fill districts
                jQuery("#slctProvince").change(function() {
                    //Use JQuery Ajax get method to call controller and get districts within province
                    var url = '/EPMS/user/districts/' + jQuery('select#slctProvince').val();
                    jQuery.get(url, function(data) {
                        jQuery('#slctDistrict').empty();
                        jQuery("#slctDistrict").append(jQuery("<option>").text("--Select District--").attr('value', ''));
                        var parsed = JSON.parse(data);
                        jQuery.each(parsed, function() {
                            var value = this.id;
                            var text = this.districtName;
                            jQuery("#slctDistrict").append(jQuery("<option>").text(text).attr('value', value));
                        });
                    });
                });
                //Selecting district to fill facilities
                jQuery("#slctDistrict").change(function() {
                    var url = '/EPMS/user/facilities?distId=' + jQuery('select#slctDistrict').val();
                    jQuery.get(url, function(data) {
                        jQuery('#slctFacility').empty();
                        jQuery("#slctFacility").append(jQuery("<option>").text("--Select Facility--").attr('value', ''));
                        var parsed = JSON.parse(data);
                        jQuery.each(parsed, function() {
                            var value = this.id;
                            var text = this.facilityName;
                            jQuery("#slctFacility").append(jQuery("<option>").text(text).attr('value', value));
                        });
                    });
                });
            });
        </script>
    </body>
</html>

