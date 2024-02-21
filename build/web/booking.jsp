<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <title>Sidebar 07</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">

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
                <h2>List of Booking</h2>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Customer Name</th>
                            <th scope="col">create_at</th>
                            <th scope="col">Status</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="o" items="${bookings}">
                            <tr>
                                <th scope="row">${o.id}</th>
                                <td>${o.fullname}</td>
                                <td>${o.create_at}</td>
                                <td>
                                    <c:if test="${o.status==true}">
                                        <p>Da duoc phe duyet</p>
                                    </c:if>
                                    <c:if test="${o.status==false}">
                                        <p>Chua duoc phe duyet</p>
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${o.status==false}">
                                        <a href="updateStatusBooking?bookingid=${o.id}&&status=${o.status}"><span class="fa fa-hourglass"></span></a>
                                        </c:if>
                                        <c:if test="${o.status==true}">
                                        <a href="updateStatusBooking?bookingid=${o.id}&&status=${o.status}"><span class="fa fa-check"></span></a>
                                        </c:if>
                                </td>
                                <td><a href="detailBooking?bookingid=${o.id}"><span class="fa fa-info"></span></a></td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>

        <script src="js/jquery.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>