<!DOCTYPE html>
<html lang="en">
<head>
    <#import "static/lib.ftl" as cdleaf>
    <@cdleaf.header />
</head>

<body>

    <span class="test">

        FreeMarker ::::::::::::::::::: nihao:

        ${name}


    </span>

    <h2>hello CD Leaf</h2>
    <div class="container">
        <h2>Button</h2>
        <p>.btn 类是按钮的基本样式:</p>
        <button type="button" class="btn-warning">基本按钮</button>
    </div>




    <@cdleaf.footer />

</body>
</html>
