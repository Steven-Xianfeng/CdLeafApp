<!DOCTYPE html>
<html lang="en">
<head>
    <#import "static/lib.ftl" as cdleaf>
    <@cdleaf.header />
</head>
<body>
    <@cdleaf.nav_top />

    <div class="container" style="margin-top:30px">
        <div class="row">
            <div class="col-sm-12">
                <h2>Job Detail </h2>
                <hr/>
                <div class="container">

                        <div class="form-row">
                            <div class="form-group col-md-6"">
                                <label >Company Name</label> :
                                ${job.companyName!}
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6"">
                                <label >Phone</label> :
                                ${job.phone!}
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6"">
                                <label for="inputAddress">Address</label> :
                                 ${job.address!}
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="inputCity">Description</label> :
                                ${job.description!}
                            </div>

                        </div>

                        <button type="button" class="btn btn-primary" onclick="location.href='/editJob?id=${job.id}';return true;"> Edit </button>



                </div>

            </div>
        </div>
    </div>

    <@cdleaf.footer />
</body>
</html>
