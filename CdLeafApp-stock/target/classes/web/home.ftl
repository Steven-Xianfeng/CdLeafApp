<!DOCTYPE html>
<html lang="en">
<head>
    <#import "static/lib.ftl" as cdleaf>
    <@cdleaf.header />
</head>
<body>

    <div class="jumbotron text-center" style="margin-bottom:0">
        <h1>CD Leaf Job</h1>
        <p>My Job List</p>
    </div>

    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a class="navbar-brand" href="#">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">Link 1</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link 2</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link 3</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container" style="margin-top:30px">
        <div class="row">
            <div class="col-sm-4">
                <h2>About Me</h2>
                <h5>Photo:</h5>
                <div class="container"><img src="imgs/home.jpg" class="img-fluid rounded-circle"/></div>

                <p>about  ..</p>
                <h3>More... </h3>
                <p>This is showing Bootstrap container...</p>
                <ul class="nav nav-pills flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">Active status</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/signout">Sign out</a>
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
