<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">

    <#include "../common/nav.ftl">

    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" action="/sell/seller/category/save">
                        <div class="form-group">
                            <label>名称</label>
                            <input name="categoryName" class="form-control" type="text" value="${(productCategory.categoryName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>Type</label>
                            <input name="categoryType" class="form-control" type="number" value="${(productCategory.categoryType)!''}"/>
                        </div>
                        <input hidden type="text" name="productId" value="${(productCategory.categoryId)!''}">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>