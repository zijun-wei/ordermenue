<html>
<#include "../common/header.ftl">
    <body>
    <div id="wrapper" class="toggled">
        <#include "../common/nav.ftl">
        <div id="page-content-wrapper">
            <div class="container-fluid">
        <div class="row clearfix">
            <div class="col-md-4 column">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>订单id</th>
                        <th>订单总金额</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="info">
                        <td>${orderDTO.getOrderId()}</td>
                        <td>${orderDTO.getOrderAmount()}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="col-md-12 column">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>商品id</th>
                        <th>商品名称</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>总额</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list orderDTO.getOrderDetailList()as orderDetail>
                        <tr class="info">
                            <td>${orderDetail.productId}</td>
                            <td>${orderDetail.productName}</td>
                            <td>${orderDetail.productPrice}</td>
                            <td>${orderDetail.productQuantity}</td>
                            <td>${orderDetail.productQuantity*orderDetail.productPrice}</td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
            <div class="col-md-12 column">
                <#if orderDTO.getOrderStatusEnum().getMessage()=="新订单">
                <a type="button" class="btn btn-default btn-primary" href="/sell/seller/order/finish?orderId=${orderDTO.orderId}">完结订单</a>
                <a type="button" class="btn btn-default btn-danger" href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}">取消订单</a>
                </#if>
            </div>

        </div>
    </div>
        </div>
    </div>
    </body>
</html>