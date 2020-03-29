<html>
<head>
    <meta charset="utf-8">
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/sell/css/style.css">

    <title>买家认证页面</title>
</head>
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