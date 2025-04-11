<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cat Details</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<header class="bg-dark text-white text-center p-3">
    <h1>Cat Details</h1>
</header>

<nav class="navbar navbar-expand-lg navbar-dark bg-success py-1" data-bs-theme="dark">
    <div class="container">
        <a class="navbar-brand fs-1 text-start" href="/cats/all">Cats Box</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link active fs-7 fw-bold text-white" href="/cats/all">Home</a></li>
                <li class="nav-item mx-auto"><a class="nav-link fs-7 fw-semibold text-light" href="/details.html">Featured-Hachimaru</a></li>
                <li class="nav-item"><a class="nav-link fs-7 fw-light text-light" href="/about.html">About</a></li>
            </ul>
        </div>
    </div>
</nav>

<section class="cat-details">

    <#if cat.imgPath??>
        <img src=${cat.imgPath} class="card-img-top" alt="${cat.name}">
    <#else>
        <img src="/images/default.jpg" class="card-img-top" alt="${cat.name}">
    </#if>
    <h5 class="card-title">ID: ${cat.catId?c}</h5>
    <h2><strong>Name:</strong> ${cat.name}</h2>
    <p><strong>Description:</strong> ${cat.description}</p>
    <p><strong>Breed:</strong> ${cat.breed}</p>
    <p><strong>Age:</strong> ${cat.age} year(s)</p>
    <a href="/cats/all" class="btn btn-primary">Go back</a>
    <a href="/cats/delete/${catId?c}" class="btn btn-danger float-end">Delete Cat</a>
</section>

</body>
</html>