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
                            <div class="box">
                                <div class="box-header">
                                    <h3 class="box-title">Property List</h3>
                                    <!-- tools box -->
                                    <div class="pull-right box-tools">
                                        <button class="btn btn-default btn-sm" data-widget="collapse" data-toggle="tooltip" title="" data-original-title="Collapse"><i class="fa fa-minus"></i></button>                                        
                                    </div><!-- /. tools -->
                                </div><!-- /.box-header -->
                                <div class="box-body pad" style="text-align: right;">
                                    <div id="propertyGridContainer" style="width: 100%;">
                                        <table id="propertysGrid"></table>
                                        <div id="pager2"></div><br>
                                        <input type="button" name="btnEdit" id="btnEdit" value="Edit Selected Property" class="btn btn-primary">
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.box -->
                </section><!-- /.content -->
            </div><!-- /.content-wrapper -->

            <%@include file="../footer.jsp" %>
        </div><!-- ./wrapper -->
        <%@include file="../scripts.jsp" %> 
        <!-- The JQuery UI code -->
        <script type="text/javascript" src="<c:url value="/resources/jquery-ui-1.10.2/ui/minified/jquery-ui.min.js" />" ></script>
        <!-- The jqGrid language file code-->
        <script type="text/javascript" src="<c:url value="/resources/jqGrid-4.8.2/js/i18n/grid.locale-en.js" />" ></script>
        <!-- The actual jqGrid code -->
        <script type="text/javascript" src="<c:url value="/resources/jqGrid-4.8.2/js/jquery.jqGrid.src.js" />" ></script>

        <script type="text/javascript">
            jQuery("#propertysGrid").jqGrid({
                url: '/EPMS/property/propertysGrid',
                datatype: 'json',
                mtype: 'GET',
                colNames: ['Property Id','Key','Value'],
                colModel: [
                    {name: 'propertyId', index: 'propertyId', hidden: true},
                    {name: 'key', index: 'key'},
                    {name: 'value', index: 'value'}
                    
                ],
                jsonReader: {
                    root: "rows",
                    page: "page",
                    total: "total",
                    records: "records",
                    repeatitems: false,
                    cell: "cell",
                    id: "id"
                },
                search: {
                    caption: "Search...",
                    Find: "Find",
                    Reset: "Reset",
                    odata: ['equal', 'not equal', 'less', 'less or equal', 'greater', 'greater or equal', 'begins with', 'does not begin with', 'is in', 'is not in', 'ends with', 'does not end with', 'contains', 'does not contain'],
                    groupOps: [{op: "AND", text: "all"}, {op: "OR", text: "any"}],
                    matchText: " match",
                    rulesText: " rules"
                },
                rowNum: 10,
                rowList: [10, 20, 30],
                loadonce: true,
                pager: '#pager2',
                sortname: 'ID',
                viewrecords: true,
                sortorder: 'desc',
                caption: 'Property Grid'
            });
            jQuery("#propertysGrid").jqGrid('navGrid', '#pager2', {edit: false, add: false, del: false, search: true});

            jQuery(document).ready(function() {
                jQuery("#btnEdit").click(function() {
                    var selr = jQuery('#propertysGrid').jqGrid('getGridParam', 'selrow');
                    if (selr)
                        window.location.href = "/EPMS/property/edit/" + selr;
                    else
                        alert("No selected row");
                    return false;
                });
                
                var width = $('#propertyGridContainer').width();
                jQuery('#propertysGrid').setGridWidth(width, true);
            });
            jQuery(window).resize(function() {
                var width = $('#propertyGridContainer').width();
                jQuery('#propertysGrid').setGridWidth(width, true);
            });
            
                     

        </script>


    </body>
</html>

