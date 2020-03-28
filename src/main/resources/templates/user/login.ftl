<html>
<#include "../common/header.ftl">
<body>
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" action="/sell/seller/login" method="post">
                        <div class="form-group">
                            <label>Email address</label><input type="text" class="form-control" name="username"/>
                        </div>
                        <div class="form-group">
                            <label>Password</label><input type="password" class="form-control" name="password"/>
                        </div>
                        <input hidden name="returnUri" value="${returnUri}">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
        </div>
</body>
</html>