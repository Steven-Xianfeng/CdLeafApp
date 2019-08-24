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
                <h2>Job List</h2>

                <div class="container">
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">ID</th>
                            <th scope="col">Date</th>
                            <th scope="col">Company</th>
                            <th scope="col">Phone</th>
                            <th scope="col">Address</th>
                            <th scope="col">Description</th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list jobList as job>
                            <tr>
                                <th scope="row">#{job_index + 1}</th>
                                <td> ${job.id}</td>
                                <td> ${job.createTime? string("yyyy-MM-dd HH:mm")!}</td>
                                <td> <a href="/showJob?id=${job.id}"> ${job.companyName!}</a></td>
                                <td> ${job.phone!}</td>
                                <td> ${job.address!}</td>
                                <td> ${job.description!}</td>
                                <td> <a href="/editJob?id=${job.id}"> Edit</a> | <a href="/deleteJob?id=${job.id}" onclick="return confirm('Are you sure?');"> Delete</a></td>
                            </tr>
                        </#list>

                        </tbody>
                    </table>






                </div>

            </div>
        </div>
    </div>

    <@cdleaf.footer />
</body>
</html>
