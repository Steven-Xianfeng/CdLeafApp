
<#macro header>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>CD Leaf Job</title>
    <link href="form.css" rel="stylesheet" type="text/css"  />
    <script src="webjars/jquery/3.0.0/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
</#macro>

<#macro footer>
    <div class="jumbotron text-center" style="margin-bottom:0">
        <p>Copyright (C) 2019 . All rights reserved.</p>
    </div>
</#macro>

<#macro nav_top>
    <div class="jumbotron text-center" style="margin-bottom:0">
        <h3>CD Leaf Job</h3>
        <p>Find & Record</p>
    </div>

    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a class="navbar-brand" href="/">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/listJob">List Job</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/allJob">All Job</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/searchJob">Search</a>
                </li>
            </ul>

            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

            <a href="/newJob" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Add New</a>

        </div>
    </nav>
</#macro>
