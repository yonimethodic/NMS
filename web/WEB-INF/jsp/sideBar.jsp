<%-- 
    Document   : sideBar
    Created on : Jun 24, 2015, 11:24:31 AM
    Author     : Kibreab
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- =============================================== -->

<!-- Left side column. contains the sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar" style="height: auto;">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left info">
                <p>
                    <sec:authorize access="isAuthenticated()">
                        <sec:authentication property="principal.username" /> 
                    </sec:authorize>
                </p>

                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>               
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-user-md"></i> <span>Dashboard</span> <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    
                </ul>
            </li>
       
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-gear"></i> <span>Setting Module</span> <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                  <li><a href="<c:url value="/devicetype/devicetypes"/>"><i class="fa fa-circle-o"></i>Device Types</a></li>
                  <li><a href="<c:url value="/device/devices"/>"><i class="fa fa-circle-o"></i>Devices</a></li>
                  <li><a href="<c:url value="/nodeconfiguration/nodeconfigurations"/>"><i class="fa fa-circle-o"></i>Node Configuration</a></li>
                  <li><a href="<c:url value="/nodehealth/nodehealths"/>"><i class="fa fa-circle-o"></i>Node Health Statistics</a></li>
                  <li><a href="<c:url value="/property/propertys"/>"><i class="fa fa-circle-o"></i>Properties</a></li>
                </ul>
            </li> 
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-user"></i> <span>Admin Module</span> <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="<c:url value="/user/users"/>"><i class="fa fa-circle-o"></i>Users</a></li>
                    
                </ul>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>

<!-- =============================================== -->
