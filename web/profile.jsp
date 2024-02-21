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
                <section style="background-color: #eee;">
                    <div class="container py-5">


                        <div class="row">
                            <div class="col-lg-4">
                                <div class="card mb-4">
                                    <div class="card-body text-center">
                                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp" alt="avatar"
                                             class="rounded-circle img-fluid" style="width: 150px;">
                                        <h5 class="my-3">${user.fullname}</h5>
                                        <p class="text-muted mb-1">${user.email}</p>
                                        <p class="text-muted mb-4">${user.address}</p>

                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-8">
                                <div class="card mb-4">
                                    <div class="card-body">
                                        <form method="post" action="profile">
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <p class="mb-0">Username</p>
                                                </div>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="username" name="username" value="${user.username}">
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <p class="mb-0">Full Name</p>
                                                </div>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="fullname" name="fullname" value="${user.fullname}">
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <p class="mb-0">Email</p>
                                                </div>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="email" name="email" value="${user.email}">
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <p class="mb-0">Address</p>
                                                </div>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="address" name="address" value="${user.address}">
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <p class="mb-0"></p>
                                                </div>
                                                <div class="col-sm-9">
                                                    <button type="submit" class="btn btn-primary">Save changes</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </section>
                <c:if test="${message eq 'success'}">
                    <p class="alert-success">C?p nh?t ngu?i dùng thành cong</p>
                </c:if>
                    <c:if test="${message eq 'fail'}">
                    <p class="alert-warning">C?p nh?t ngu?i dùng th?t b?i </p>
                </c:if>

            </div>
        </div>
    </body>
</html>
