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
<#include "../Navigation/nav.ftlh">

<body class=" container">
<header>

</header>

<main class="">
    <form action="/disciplines" method="post">
        <div class="mb-3">
            <label for="discipline" class="form-label">Discipline name</label>
            <input type="text" class="form-control" id="discipline" aria-describedby="emailHelp" name="title">
        </div>

        <div class="mb-3">
            <button type="submit" class="btn btn-primary">Add</button>
        </div>

    </form>
    <table class="table">
        <thead>
        <tr>
            <th>Название</th>
            <td>Действия</td>
        </tr>
        </thead>
        <#list disciplines as discipline>
            <tr>
                <td>${discipline.title}</td>
                <td>
                    <a href="/disciplines/${discipline.id}/delete">Удалить</a>
                </td>
            </tr>
        </#list>
    </table>


</main>

<footer></footer>

</body>
</html>