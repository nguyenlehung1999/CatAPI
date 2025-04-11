<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Cat</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<header class="bg-dark text-white text-center p-3">
    <h1>Update Cat Details</h1>
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

<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card shadow-lg">
                <div class="card-header bg-success text-white">
                    <h2 class="mb-0">Edit Cat Information</h2>
                </div>
                <div class="card-body">
                    <form method="post" action="/cats/update/${cat.catId}">

                        <div class="mb-3">
                            <label for="name" class="form-label">Name</label>
                            <input type="text" name="name" id="name" class="form-control" value="${cat.name}" required>
                        </div>

                        <div class="mb-3">
                            <label for="description" class="form-label">Temperament/Description</label>
                            <textarea name="description" id="description" class="form-control" rows="3" required>${cat.description}</textarea>
                        </div>

                        <div class="mb-3">
                            <label for="breed" class="form-label">Breed</label>
                            <input type="text" name="breed" id="breed" class="form-control" value="${cat.breed}" required>
                        </div>

                        <div class="mb-3">
                            <label for="age" class="form-label">Age (years)</label>
                            <input type="number" name="age" id="age" class="form-control" value="${cat.age}" step="0.1" required>
                        </div>

                        <div class="mb-3">
                            <label for="imgPath" class="form-label">Image URL</label>
                            <input name="imgPath" id="imgPath" class="form-control" value="${cat.imgPath!''}">
                        </div>

                </div>

                <button type="submit" class="btn btn-info w-100" href="/cats/all">Update Cat</button>
                </form>
            </div>
        </div>
    </div>
</div>
</div>

</body>
</html>
