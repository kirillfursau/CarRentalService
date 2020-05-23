<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css?family=Exo+2:400,500|Montserrat:300,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
    <title>Document</title>
    <script type="text/javascript">
        <%@include file="/script/reg.js" %>
    </script>
    <style>
        <%@include file="/css/style.css" %>
    </style>
</head>

<body>
<section class="section__outer section__inner">
    <div class="main__content">
        <div class="main__content__header">
            <div class="main__content__header--title">
                <h1>ДОПОЛНИТЕЛЬНАЯ ИНФОРМАЦИЯ</h1>
            </div>
            <div class="main__content__header--links">
                <div class="links">
                    <div class="button back"><a href="./sign-in">&lsaquo;</a></div>
                    <div class="button login"><a href="./sign-in">Вход</a></div>
                </div>
            </div>
        </div>
        <div class="main__content--register">
            <form action="/CarRentalService_war_exploded/registration/full-sign-up" method="post">
                <div class="container">
                    <p>Заполните дополнительные поля, необходимые для совершения заказа.</p>
                    <hr>

                    <label><b>Ваше Имя</b></label>
                    <input type="text" placeholder="Введите имя" name="firstName">

                    <label><b>Фамилия</b></label>
                    <input type="text" placeholder="Введите фамилию" name="secondName" autocomplete="text">

                    <label><b>Год рождения</b></label>
                    <input id="date-mask" type="date" placeholder="Введите год рождения" name="dateOfBirth"
                           autocomplete="text">

                    <label><b>Пол</b></label><br>
                    <input type="radio" value="Male" name="gender" id="man"><label for="man">
                    Мужской</label><br>
                    <input type="radio" value="Female" name="gender" id="woman"><label for="woman"> Женский</label>
                    <br><br>

                    <label><b>Страна</b></label>
                    <input type="text" placeholder="Введите страну" name="country" autocomplete="text">

                    <label><b>Город</b></label>
                    <input type="text" placeholder="Введите город" name="city" autocomplete="text">

                    <label><b>Улица</b></label>
                    <input type="text" placeholder="Введите улицу" name="street" autocomplete="text">

                    <label><b>Дом</b></label>
                    <input type="text" placeholder="Введите дом" name="building" autocomplete="text">

                    <label><b>Квартира</b></label>
                    <input type="text" placeholder="Введите квартиру" name="apartment" autocomplete="text">

                    <label><b>Номер паспорта</b></label>
                    <input type="text" placeholder="Введите номер паспорта" name="passportId">

                    <label><b>Дата выдачи паспорта</b></label>
                    <input type="date" placeholder="Введите дату выдачи паспорта" name="passportDateOfIssue"
                           autocomplete="text">

                    <label><b>Дата окончания паспорта</b></label>
                    <input type="date" placeholder="Введите дату окончания паспорта" name="passportExpiryDate"
                           autocomplete="text">

                    <label><b>Место рождения</b></label>
                    <input type="text" placeholder="Введите место рождения" name="placeOfBirthDay" autocomplete="text">

                    <label><b>Страна резиденства</b></label>
                    <input type="text" placeholder="Введите страну резиденства" name="countryOfResidence"
                           autocomplete="text">

                    <hr>
                    <button type="submit" class="registerbtn">Подтвердить</button>

                </div>

                <div class="container login">
                </div>
            </form>
        </div>
    </div>
</section>
</body>
<script src="https://unpkg.com/imask"></script>
<script src="./script//reg_add.js"></script>

</html>