
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
<#if role=="ADMIN">
    <#include "../Navigation/nav.ftlh">
</#if>
<body class=" container">
<header>

</header>

<main class="">

    <form action="/schedule/${schedule.id}" method="post">
        <h2> ${schedule.disciplineId.title} ${schedule.groupId.title}</h2>
        <div class="mb-3">
            <label for="userId" class="form-label">Pupil</label>
            <select class="form-select" aria-label="Default select example" name="userId" required>
                <#list users as user>
                    <option value="${user.id}">${user.firstName} ${user.lastName}</option>
                </#list>
            </select>
        </div>
        <div class="mb-3">
            <label for="mark" class="form-label">Mark</label>
            <input type="number" name="mark" min="1" max="5" value="5" required>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <div>
                <textarea type="text" name="description"></textarea>
            </div>
        </div>
        <div class="mb-3">
            <button type="submit" class="btn btn-primary">Add</button>
        </div>

    </form>
    <table class="table">
        <thead>
        <tr>
            <th>First name</th>
            <td>Last name</td>
            <td>Description</td>
            <td>Mark</td>
            <td>Действие</td>
        </tr>
        </thead>
        <#list marks as mark>
            <tr>
                <td>${mark.userId.firstName}</td>
                <td>${mark.userId.lastName}</td>
                <td>${(mark.description)!""}</td>
                <td>${mark.mark}</td>
                <td>
                    <a href="/marks/${mark.id}/delete">Удалить</a>
                </td>
            </tr>
        </#list>
    </table>


</main>

<footer></footer>

</body>
</html>