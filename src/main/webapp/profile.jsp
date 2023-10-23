<%@page import="usermanage.user"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>Document</title>
</head>
<body>
<%
        user usr1 =(user) request.getAttribute("user");
        System.out.println(usr1.getfName());
      	
        %>
<div class="container rounded bg-white mt-5 mb-5">
    <div class="row">
        <div class="col-md-4 border-right">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                <img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg">
                <span class="font-weight-bold"><%=usr1.getfName()%></span>
                <span class="text-black-50"><%=usr1.getEmail()%></span>
            </div>
        </div>
        
      
        <div class="col-md-5 border-right">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right">Profile</h4>
                </div>
                <div class="row mt-2">
                    <div class="col-md-6">
                        <label class="labels">First Name</label>
                        <input type="text" class="form-control" value="<%=usr1.getfName()%>" readonly>
                    </div>
                    <div class="col-md-6">
                        <label class="labels">Last Name</label>
                        <input type="text" class="form-control"  value="<%=usr1.getlName()%>" readonly>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-md-12">
                        <label class="labels">UserName</label>
                        <input type="text" class="form-control" value="<%=usr1.getUserName()%>" readonly>
                    </div>
                    <!-- Add other form controls similarly -->
                </div>
                <div class="row mt-3">
                    <div class="col-md-12">
                        <label class="labels">Email</label>
                        <input type="text" class="form-control" value="<%=usr1.getEmail()%>" readonly>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-md-6">
                        <label class="labels">Country</label>
                        <input type="text" class="form-control" value="<%=usr1.getuCountry()%>" readonly>
                    </div>
                    <div class="col-md-6">
                        <label class="labels">City</label>
                        <input type="text" class="form-control" value="<%=usr1.getuCity()%>" readonly>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-md-12">
                        <label class="labels">Date Of Birth</label>
                        <input type="text" class="form-control" value="<%=usr1.getuDOB()%>" readonly>
                    </div>
                </div>
                
                <div class="mt-5 text-center">
                    <a href= "index.jsp"><button class="btn btn-primary profile-button"  type="button">Dashboard</button></a>
                </div>
            </div>
        </div>
        
        </div>
    </div>
</div>
</body>
</html>
