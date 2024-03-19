<form action="/signUp" method="post">
    <div class="mb-3">
        <label for="firstName" class="form-label">First Name</label>
        <input type="text" class="form-control" id="firstName"  name="firstName" required>
    </div>

    <div class="mb-3">
        <label for="lastName" class="form-label">Last Name</label>
        <input type="text" class="form-control" id="lastName"  name="lastName" required>
    </div>

    <div class="mb-3">
        <label for="patronymic" class="form-label">Patronymic</label>
        <input type="text" class="form-control" id="patronymic"  name="patronymic">
    </div>
    <div class="mb-3">
        <label for="dateOfBirth" class="form-label">Date of birth</label>
        <input type="date" name="dateOfBirth" required>
    </div>
    <div class="mb-3">
        <label for="Email" class="form-label">Email address</label>
        <input type="email" class="form-control" id="Email" aria-describedby="emailHelp" name="email" required>
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" class="form-control" id="password" name="password" required>
    </div>

    <div class="mb-3">
        <button type="submit" class="btn btn-primary">Submit</button>
    </div>

</form>