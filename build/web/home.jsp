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
                <c:if test="${sessionScope.user.role == true}">
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
                </c:if>
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
                <c:if test="${sessionScope.user.role == true}">
                    <h2>List of Vehicles</h2>
                    <div style="float:right"><a href="addVehicle"><span class="fa fa-plus"></span></a></div>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                               <th scope="col">
                                    <c:choose>
                                        <c:when test="${s eq 'asc'}">
                                            <c:set var="newSort" value="desc" />
                                        </c:when>
                                        <c:when test="${s eq 'desc'}">
                                            <c:set var="newSort" value="asc" />
                                        </c:when>
                                        <c:otherwise>
                                            <c:set var="newSort" value="asc" />
                                        </c:otherwise>
                                    </c:choose>
                                    <a href="sort?s=${newSort}">Vehicle Name</a>
                                </th>
                                <th scope="col">Category</th>
                                <th scope="col">($)RentalPrice</th>
                                <th scope="col">Status</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="o" items="${listV}">
                                <tr>
                                    <th scope="row">${o.id}</th>
                                    <td>${o.vehicleName}</td>
                                    <td>${o.cateName}</td>
                                    <td>$${o.rentalPrice}</td>
                                    <td>
                                        <c:if test="${o.status==1}">
                                            <span class="badge badge-pill badge-warning">Ðã cho thuê</span>
                                        </c:if>
                                        <c:if test="${o.status==0}">
                                            <span class="badge badge-pill badge-success">Chua cho thuê</span>
                                        </c:if>
                                    </td>
                                    <td></a><a href="editVehicle?vehicleid=${o.id}"><span class="fa fa-edit"></span></a></td>
                                    <td></a><a href="deleteVehicle?vid=${o.id}"><span class="fa fa-trash"></span></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>

            </div>
        </div>


        <script src="asset/js/jquery.min.js" type="text/javascript"></script>
        <script src="asset/js/popper.js" type="text/javascript"></script>
        <script src="asset/js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>