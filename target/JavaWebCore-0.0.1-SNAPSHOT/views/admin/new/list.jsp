<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="main-content">
    <form action="<c:url value="/admin-new"/>" id="formSubmit" method="get">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Trang chủ</a>
                    </li>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="widget-box table-filter">
                    <div class="table-btn-controls">
                        <div class="pull-right tableTools-container">
                            <div class="dt-buttons btn-overlap btn-group">
                                <a flag="info"
                                   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
                                   title='Thêm bài viết' href='<c:url value="/admin-new?type=edit"/>'>
															<span>
																<i class="fa fa-plus-circle bigger-110 purple"></i>
															</span>
                                </a>
                                <button id="btnDelete" type="button"
                                        class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa bài viết'>
																<span>
																	<i class="fa fa-trash-o bigger-110 pink"></i>
																</span>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Content</th>
                                <th>CategoryID</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:if test="${not empty model.list}">
                                <c:forEach var="new" items="${model.list}">
                                    <tr>
                                        <td>${new.id}</td>
                                        <td>${new.content}</td>
                                        <td>${new.categoryId}</td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            </tbody>
                        </table>
                        <ul class="pagination" id="pagination"></ul>
                        <input type="hidden" value="" id="page" name="page">
                        <input type="hidden" value="" id="maxPageItems" name="maxPageItems">
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript">
    $(function () {
        let totalPages = ${model.totalPage};
        let maxPageItems = 2;
        let currentPage = ${model.page};
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: maxPageItems,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if(page !== currentPage) {
                    $('#page').val(page);
                    $('#maxPageItems').val(maxPageItems);
                    $('#formSubmit').submit();
                }
            }
        })
    });
</script>
</body>
</html>