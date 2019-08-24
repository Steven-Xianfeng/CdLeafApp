<!DOCTYPE html>
<html lang="en">
<head>
    <#import "static/lib.ftl" as cdleaf>
    <@cdleaf.header />
</head>
<body>

    <div class="jumbotron text-center" style="margin-bottom:0">
        <h1>CD Leaf Stocks</h1>
        <p>U.S.  and  Canada</p>
    </div>

    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a class="navbar-brand" href="#">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">

        </div>
    </nav>

    <div class="container" style="margin-top:30px">
        <div class="row">
            <div class="col-sm-4">
                <h2>Please Sign In</h2>


                <div class = "container">
                    <div class="wrapper">
                        <form action="/signin" method="post" name="userForm" class="form-signin">
                            <hr class="colorgraph"><br>

                            <input type="text" class="form-control" name="userName" value="<#if userForm??>${userForm.userName!}</#if>" placeholder="Username" required="" autofocus="" />
                            <br/>
                            <input type="password" class="form-control" name="userPwd" placeholder="Password" required=""/>
                            <br/>
                            <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Sign in" type="Submit">Sign in</button>

                            <label class="checkbox pull-left">
                                <input type="checkbox" name="chkSave" value="1" <#if userForm??><#if userForm.chkSave == 1>checked</#if></#if>>
                                Remember me
                            </label>
                            <a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span>

                            <#if userForm??>
                                <div class="alert alert-danger alert-dismissible fade show">
                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                    <strong>Sorry, your login entry doesn't match our records. </strong>
                                    <#if accountNotExistError??>*accountNotExistError*</#if>
                                    <#if passwordError??>*passwordError*</#if>
                                </div>
                            </#if>
                        </form>

                    </div>
                </div>

                <br/> <br/> <br/> <br/> <br/> <br/>

                <div class = "container">

                    <p>about  ..</p>
                    <h3>More... </h3>
                    <p>This is showing Bootstrap container...</p>
                    <ul class="nav nav-pills flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Active status</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">link</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">link</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="#">disabled</a>
                        </li>
                    </ul>
                    <hr class="d-sm-none">
                </div>
            </div>


            <div class="col-sm-8">
                <h2>Stock</h2>
                <h5>U.S. QD</h5>
                <div class="container"><img src="imgs/stock.jpg" class="img-fluid"/></div>
                <p>show some stocks..</p>
                <p>Automatic show some chart ！！！</p>
                <br>
                <h2>Title</h2>
                <h5>Sub Title</h5>
                <div class="container">image!</div>
                <p>text ..</p>
                <p>note ！！！</p>
            </div>
        </div>
    </div>

    <@cdleaf.footer />
</body>
</html>
