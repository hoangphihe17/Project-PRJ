<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <title>Sidebar 07</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="asset/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>


        <div class="wrapper d-flex align-items-stretch">
            <nav id="sidebar" class="active">
                <h1><a href="index.html" class="logo">M.</a></h1>
                <ul class="list-unstyled components mb-5">
                    <li>
                        <a href="vehicle"><span class="fa fa-car"></span>Vehicle</a>
                    </li>
                    <li>
                        <a href="booking"><span class="fa fa-cogs"></span> Booking</a>
                    </li>
                    <li>
                        <a href="profile"><span class="fa fa-user"></span> Profile</a>
                    </li>
                </ul>
            </nav>

            <!-- Page Content  -->
            <div id="content" class="p-4 p-md-5">

                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">

                        <button type="button" id="sidebarCollapse" class="btn btn-primary">
                            <i class="fa fa-bars"></i>
                            <span class="sr-only">Toggle Menu</span>
                        </button>
                        <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <i class="fa fa-bars"></i>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="nav navbar-nav ml-auto">
                                <li class="nav-item active">
                                    <a class="nav-link" href="#">Home</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">About</a>
                                </li>
                               <c:if test="${sessionScope.user == null}">
                                    <a class="nav-link" href="login">Login</a>
                                </c:if>
                                <c:if test="${sessionScope.user != null}">
                                    <a class="nav-link" href="logout">Logout</a>
                                </c:if>
                            </ul>
                        </div>
                    </div>
                </nav>
                <h2>Edit Vehicle</h2>
                <form method="post" action="vehicle">
                        <div class="modal-body">
                            <input type="hidden"  name="ID" value="${vehicle.id}"><!-- Replace with actual ID from your data -->

                            <div class="form-group">
                                <label for="Name">Name:</label>
                                <input type="text" class="form-control" id="Name" name="Name" value="${vehicle.vehicleName}"><!-- Replace with actual value -->
                            </div>

                            <div class="form-group">
                                <label for="LicensePlate">License Plate:</label>
                                <input type="text" class="form-control" id="LicensePlate" name="LicensePlate" value="${vehicle.licensePlate}"><!-- Replace with actual value -->
                            </div>

                            <div class="form-group">
                                <label for="Status">Status:</label>
                                <select  class="form-control" id="Status" name="Status" >
                                        <option ${vehicle.status==1?"selected":""} value="1">Ðã cho thuê</option>
                                        <option ${vehicle.status==0?"selected":""} value="0">Chua cho thuê</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <label for="cateId">Category</label>
                                <select class="form-control" id="cateId" name="cateId" >
                                    <c:forEach var="o" items="${listC}">
                                        <option ${o.id==vehicle.id?"selected":""} value="${o.id}">${o.categoryName}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group">
                                <label for="RentalPrice">Rental Price:</label>
                                <input type="text" class="form-control" id="RentalPrice" name="RentalPrice" value="${vehicle.rentalPrice}"><!-- Replace with actual value -->
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary">Save changes</button>
                        </div>
                    </form>
            </div>
        </div>
      
        <script src="asset/js/jquery.min.js" type="text/javascript"></script>
        <script src="asset/js/popper.js" type="text/javascript"></script>
        <script src="asset/js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>