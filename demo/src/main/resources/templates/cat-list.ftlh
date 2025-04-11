<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CatsBox</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-success py-1" data-bs-theme="dark">
    <div class="container">
        <a class="navbar-brand fs-1 text-start" href="all">Cats Box</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link active fs-7 fw-bold text-white" href="all">Home</a></li>
                <li class="nav-item mx-auto"><a class="nav-link fs-7 fw-semibold text-light" href="/details.html">Featured-Hachimaru</a></li>
                <li class="nav-item"><a class="nav-link fs-7 fw-light text-light" href="/about.html">About</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="content bg-light text-white p-4">

</div>
<header class="bg-success text-white p-3 d-flex flex-column justify-content-center align-items-center">
    <h1>The Cat Gallery</h1>
    <p class="fs-5 fw-bold fst-italic text-dark">Cute cats</p>
</header>
<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h2 class="text-center mb-3">Search for Your Favorite Cats</h2>
            <div class="row">
                <div class="col-8">
                    <form class="d-flex" method="get" action="/cats/name">
                        <input class="form-control form-control-lg me-2" type="search" name="search" placeholder="Search by Name" aria-label="Search">
                        <button class="btn btn-info btn-lg" type="submit">Search</button>
                    </form>
                </div>
                <div class="col-4 text-end">
                    <a href="/cats/createForm" class="btn btn-success btn-lg">Add New Cat</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Nav Bar -->

<div class="container mt-4">
    <div class="row">
        <#list catList as cat>
        <div class="col-md-4">
            <div class="card shadow-lg">
                <#if cat.imgPath??>
                    <img src=${cat.imgPath} class="card-img-top" alt="${cat.name}">
                <#else>
                    <img src="/images/default.jpg" class="card-img-top" alt="${cat.name}">
                </#if>

                <div class="card-body text-center">
                    <h3 class="card-title">${cat.name}</h3>
                    <p class="card-text"><strong>Breed:</strong> ${cat.breed}</p>
                    <p class="card-text"><strong>Age:</strong> ${cat.age} year(s)</p>
                    <div class="d-flex justify-content-center gap-2">
                        <a class="btn btn-info" href=${cat.catId}>View</a>
                        <a class="btn btn-secondary" href= update/${cat.catId}>Edit</a>
                    </div>
                </div>
            </div>
        </div>
        </#list>
    </div>
</div>


</body>
</html>
