<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create New Cat</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- Your custom CSS -->
</head>
<body>
<header class="bg-dark text-white text-center p-3">
    <h1>Create a New Cat</h1>
</header>

<nav class="navbar navbar-expand-lg navbar-dark bg-success py-1" data-bs-theme="dark">
    <div class="container">
        <a class="navbar-brand fs-1 text-start" href="/cats/all">Cats Box</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link fs-7 fw-bold text-white" href="/cats/all">Home</a></li>
                <li class="nav-item mx-auto"><a class="nav-link fs-7 fw-semibold text-light" href="/details.html">Featured-Hachimaru</a></li>
                <li class="nav-item"><a class="nav-link fs-7 fw-light text-light" href="/about.html">About</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h2 class="text-center mb-3">Add a New Cat</h2>
            <form id="new-cat" action="/cats/new" method="post">
                <input type="text" id="name" name="name" placeholder="Name" class="form-control mb-2" required>
                <input type="text" id="breed" name="breed" placeholder="Breed" class="form-control mb-2" required>
                <input type="number" id="age" name="age" step="0.1" placeholder="Age" class="form-control mb-2" required>
                <input type="text" id="description" name="description" placeholder="Description" class="form-control mb-2" required>
                <input type="text" id="imgPath" name="imgPath" placeholder="Image URL" class="form-control mb-2">
                <button type="submit" class="btn btn-primary">Save</button>
                <a href="/cats/all" class="btn btn-outline-danger">Cancel</a>
            </form>
        </div>
    </div>
</div>

</body>
</html>
