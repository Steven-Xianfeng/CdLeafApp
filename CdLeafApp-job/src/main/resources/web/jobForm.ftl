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
                <h2>Add a Job</h2>

                <div class="container">
                    <form name="companyJob" action="/saveJob">
                        <input type="hidden" name="id" value="${companyJobVO.id}"/>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="inputCompanyName">Company Name</label>
                                <input type="text" class="form-control" name="companyName" id="inputCompanyName" placeholder="Apartment, studio, or floor" value="${companyJobVO.companyName!}">
                                    <#if companyJobVO.isError("company.name.exist") == true>
                                        <div class="alert alert-danger" role="alert">
                                            Company name is exist!
                                        </div>
                                </#if>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="inputAddress">Address</label>
                                <input type="text" class="form-control" name="address" id="inputAddress placeholder="1234 Main St" value="${companyJobVO.address!}">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="phone">Phone</label>
                                <input type="text" class="form-control" name="phone" id="phone" value="${companyJobVO.phone!}">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="inputDescription">Description</label>
                                <textarea class="form-control"  name="description" id="inputDescription"  rows="3">${companyJobVO.description!}</textarea>
                            </div>

                        </div>

                        <button type="submit" class="btn btn-primary"> Submit</button>
                    </form>





                </div>

            </div>
        </div>
    </div>

    <@cdleaf.footer />
</body>
</html>
