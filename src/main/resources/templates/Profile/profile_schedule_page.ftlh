
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

<body class=" container">
<header>

</header>


<main class="">


<a class="btn btn-outline-danger" href="/profile" role="button">Назад</a>

        <#list schedule as key, values>
            <h2>${key}</h2>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Урок</th>
                    <th scope="col">№ Урока</th>
                </tr>
                </thead>
                <tbody>
            <#list values as value>
                <tr>
                    <td>${value.disciplineId.title}</td>
                    <td>${value.lessonNumber}</td>
                </tr>

            </#list>
                </tbody>
            </table>
        </#list>
</main>

<footer></footer>

</body>

</html>