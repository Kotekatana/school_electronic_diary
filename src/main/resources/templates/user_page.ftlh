<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Пользователь</title>
</head>
<body>
<a href="/users">Ко всем пользователям</a>
<h1>Хало</h1>
<form action="/users/${user.id}/update" method="post">
    <label>
        Email
        <input type="email" name="email" value=${user.email}>
    </label>
    <br>
    <label>
        Имя
        <input type="text" name="firstName" value=${user.firstName}>
    </label>
    <br>
    <label>
        Фамилия
        <input type="text" name="lastName" value=${user.lastName}>
    </label>
    <label>
        Возраст
<#--        <input type="text" name="age" value=${user.age}or>-->
    </label>
    <br>
    <input type="submit" value="Сохранить">
</form>
</body>
</html>