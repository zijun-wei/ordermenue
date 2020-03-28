<html>
<#include "../common/header.ftl">
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" action="/sell/wechat/userInfo" method="post">
                <div class="form-group">
                    <label>昵称</label><input type="text" class="form-control" name="username"/>
                </div>
                <div class="form-group">
                    <label>手机号</label><input type="text" class="form-control" name="telephone"/>
                </div>
                <input hidden name="returnUri" value="${returnUri}">
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>