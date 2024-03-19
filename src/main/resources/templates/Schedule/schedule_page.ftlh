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

    <#if role =="ADMIN">
        <form action="/schedule" method="post">
            <div class="mb-3">
                <label for="disciplineId" class="form-label">Discipline</label>
                <select class="form-select" aria-label="Default select example" name="disciplineId" required>
                    <#list disciplines as discipline>
                        <option value="${discipline.id}">${discipline.title}</option>
                    </#list>
                </select>
            </div>
            <div class="mb-3">
                <label for="groupId" class="form-label">Group</label>
                <select class="form-select" aria-label="Default select example" name="groupId" required>
                    <#list groups as group>
                        <option value="${group.id}">${group.title}</option>
                    </#list>
                </select>
            </div>
            <div class="mb-3">
                <label for="date" class="form-label">Date</label>
                <input type="date" name="date" required>
            </div>
            <div class="mb-3">
                <label for="lessonNumber" class="form-label">Lesson №</label>
                <input type="number" name="lessonNumber" min="1" max="8" value="1" required>
            </div>
            <div class="mb-3">
                <button type="submit" class="btn btn-primary">Add</button>
            </div>

        </form>
    </#if>

        <#list schedule as key, values>
            <h2>${key}</h2>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Класс</th>
                    <th scope="col">Урок</th>
                    <th scope="col">№ урока</th>
                    <th scope="col">Действие</th>
                </tr>
                </thead>
                <tbody>
                <#list values as value>
                    <tr>
                        <td>${value.groupId.title}</td>
                        <td>${value.disciplineId.title}</td>
                        <td>${value.lessonNumber}</td>
                        <td>
                            <a href="/schedule/${value.id}/">Перейти</a>
                            <#if role=="ADMIN">
                                <a href="/schedule/${value.id}/delete">Удалить</a>
                            </#if>
                        </td>
                    </tr>

                </#list>
                </tbody>
            </table>
        </#list>
</main>

<footer></footer>

</body>
</html>