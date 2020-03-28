<html>
<#include "../common/header.ftl">
    <body>
        <div id="wrapper" class="toggled">

            <#include "../common/nav.ftl">

            <div id="page-content-wrapper">
                <div class="container-fluid">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-bordered table-condensed">
                            <thead>
                            <tr>
                                <th>订单id</th>
                                <th>姓名</th>
                                <th>手机号</th>
                                <th>地址</th>
                                <th>金额</th>
                                <th>订单状态</th>
                                <th>支付状态</th>
                                <th>创建时间</th>
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list orderDTOPage.getContent()as orderDTO>
                                <tr>
                                    <td>${orderDTO.orderId}</td>
                                    <td>${orderDTO.buyerName}</td>
                                    <td>${orderDTO.buyerPhone}</td>
                                    <td>${orderDTO.buyerAddress}</td>
                                    <td>${orderDTO.orderAmount}</td>
                                    <td>${orderDTO.orderStatusEnum.message}</td>
                                    <td>${orderDTO.payStatusEnum.message}</td>
                                    <td>${orderDTO.createTime}</td>
                                    <td><a href="/sell/seller/order/detail?orderId=${orderDTO.orderId}">详情</a></td>
                                    <td>
                                        <#if orderDTO.getOrderStatusEnum().message =="新订单">
                                            <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}">取消</a>
                                        </#if>
                                    </td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                    <#--分页-->
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                            <#if currentPage lte 1>
                                <li><a href="#" class="disabled">上一页</a></li>
                            <#else>
                                <li><a href="/sell/seller/order/list?page=${currentPage-1}&size=${pageSize}">上一页</a></li>
                            </#if>

                            <#list 1..orderDTOPage.getTotalPages() as index>
                                <#if currentPage==index>
                                    <li class="disabled"><a href="#">${index}</a></li>
                                <#else>
                                    <li><a href="/sell/seller/order/list?page=${index}&size=${pageSize}">${index}</a></li>
                                </#if>
                            </#list>
                            <#if currentPage gte orderDTOPage.getTotalPages()>
                                <li><a href="#" class="disabled">下一页</a></li>
                            <#else>
                                <li><a href="/sell/seller/order/list?page=${currentPage+1}&size=${pageSize}">下一页</a></li>
                            </#if>
                        </ul>
                    </div>
                </div>
            </div>
            </div>
        </div>

        <#--弹框-->
        <div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title" id="myModalLabel">
                            提醒
                        </h4>
                    </div>
                    <div class="modal-body">
                        你有新的订单
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="javascript:document.getElementById('notice').pause();">关闭</button>
                        <button type="button" class="btn btn-primary" onclick="location.reload()">查看新的订单</button>
                    </div>
                </div>

            </div>

        </div>

        <audio id="notice" loop="loop">
            <source src="/" type="audio/mepg">
        </audio>



        <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://cdn.bootcss.com/twitter-bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <script>
        var webSocket=null;
        if ('WebSocket'in window){
            webSocket=new WebSocket('ws://localhost:8080/sell/webSocket');
        }else {
            alert('该浏览器不支持websocket!');
        }

        webSocket.onopen=function (event) {
            console.log('建立连接');
        }
        webSocket.onclose=function (event) {
            console.log('连接关闭');
        }
        webSocket.onmessage=function (event) {
            console.log('收到消息：'+event.data);

            $('#myModal').modal('show');
            document.getElementById("notice").play();

        }
        webSocket.onerror=function () {
            console.log('websocket通信发生错误！');
        }
        webSocket.onbeforeunload=function () {
            webSocket.close();
        }
    </script>
    </body>

</html>