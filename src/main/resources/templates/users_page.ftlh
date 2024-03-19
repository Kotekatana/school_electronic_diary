<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Пользователи</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<#include "Navigation/nav.ftlh">

<body class=" container">
<header>

</header>

<main class="">
    <form action="/users" method="post">

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
            <label for="groups">Choose a learning group:</label>
            <select name="groupId" id="groups">
                <#list groups as group>
                    <option value=${group.id}>${group.title}</option>
                </#list>
            </select>
        </div>
        <div>
            <label for="ROLES" class="form-label">Role</label>
        </div>

        <div class="btn-group btn-group-toggle mb-3" data-toggle="buttons" id="ROLES">
            <label class="btn btn-secondary active">
                <input type="radio" name="role"  value="PUPIL" id="option1" autocomplete="off" checked> Pupil
            </label>
            <label class="btn btn-secondary">
                <input type="radio" name="role" value="TEACHER" id="option2" autocomplete="off"> Teacher
            </label>
            <label class="btn btn-secondary">
                <input type="radio" name="role" value="ADMIN" id="option3" autocomplete="off"> Admin
            </label>
        </div>

        <div class="mb-3">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>

    </form>
    <table class="table">
        <thead>
        <tr>
            <th>Email</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Роль</th>
            <td>Действия</td>
        </tr>
        </thead>
        <#list users as user>
            <tr>
                <td>${user.email}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.role}</td>
                <td>
                    <a href="/users/${user.id}">Перейти</a>
                    <a href="/users/${user.id}/delete">Удалить</a>
                </td>
            </tr>
        </#list>
    </table>
<#--    <form action="/users" method="post">-->
<#--        <label>-->
<#--            Email-->
<#--            <input type="email" name="email" placeholder="Введите почту">-->
<#--        </label>-->
<#--        <br>-->
<#--        <label>-->
<#--            Имя-->
<#--            <input type="text" name="firstName" placeholder="Введите имя">-->
<#--        </label>-->
<#--        <br>-->
<#--        <label>-->
<#--            Фамилия-->
<#--            <input type="text" name="lastName" placeholder="Введите фамилию">-->
<#--        </label>-->
<#--        <br>-->
<#--        <label>-->
<#--            Роль-->
<#--            <p><input name="role" type="radio" value="PUPIL" checked>Ученик</p>-->
<#--            <p><input name="role" type="radio" value="TEACHER">Учитель</p>-->
<#--            <p><input name="role" type="radio" value="ADMIN" >Админ</p>-->
<#--        </label>-->
<#--        <p><b></b></p>-->

<#--        <div class="form-check">-->
<#--            <input class="form-check-input" type="radio" name="role" id="PUPIL" checked>-->
<#--            <label class="form-check-label" for="PUPIL">-->
<#--                Ученик-->
<#--            </label>-->
<#--        </div>-->
<#--        <div class="form-check">-->
<#--            <input class="form-check-input" type="radio" name="role" id="TEACHER" >-->
<#--            <label class="form-check-label" for="TEACHER">-->
<#--                Учитель-->
<#--            </label>-->
<#--        </div>-->
<#--        <div class="form-check">-->
<#--            <input class="form-check-input" type="radio" name="role" id="ADMIN">-->
<#--            <label class="form-check-label" for="ADMIN">-->
<#--                Админ-->
<#--            </label>-->
<#--        </div>-->
<#--        <input autofocus type="submit" value="Добавить"/>-->
<#--    </form>-->

</main>

<footer></footer>

</body>
</html>