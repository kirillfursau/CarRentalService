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
            <div>
                <fmt:message key="label.changeLang"/>
            </div>
            <ul>
                <div class="button language"><a href="?lang=en_US"><fmt:message key="label.lang.en"/></a></div>
                <div class="button language"><a href="?lang=ru_RU"><fmt:message key="label.lang.ru"/></a></div>
            </ul>
            <div class="main__content__header--title">
                <h1><fmt:message key="label.carPark"/></h1>
            </div>
            <div class="main__content__header--links">
                <div class="links">
                    <div class="button register"><a href="./sign-up"><fmt:message key="label.registration"/></a></div>
                    <div class="button login"><a href="./sign-in"><fmt:message key="label.sign-in"/></a></div>
                    <div class="button account"><a href="./account-info"><fmt:message key="label.account-info"/></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="main__content__list">
            <c:choose>
                <c:when test="${cars.size() > 0}">
                    <c:forEach var="j" begin="0" end="${cars.size()-1}" step="1">
                        <div class="main__content__list--item">
                            <div class="item__disciption">
                                <div class="item__disciption--class">
                                    <c:out value="${cars.get(j).carClass.carClass}"/>
                                </div>
                                <div class="item__disciption--title">
                                    <a href="./car-info/${cars.get(j).id}">
                                        <c:out value="${cars.get(j).brand}"/> <c:out value="${cars.get(j).model}"/><br>
                                        <span class="subtitle--year">(<c:out
                                                value="${cars.get(j).yearOfIssue}"/> <fmt:message
                                                key="label.year"/>)</span></a><br>
                                    <span class="subtitle--price"></span><fmt:message key="label.price"/> <c:out
                                        value="${cars.get(j).rentalDayPrice}"/>
                                    р.</span>
                                </div>
                                <button class="item__disciption--order"><fmt:message key="label.reservation"/></button>
                            </div>
                        </div>
                    </c:forEach>
                    <br>
                    <c:forEach var="j" begin="0" end="${totalPages-1}" step="1">
                        <div class="main__content__list">
                            <div class="button login"><a href="./?page=${j}">${j+1}</a></div>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <div class="main__content__list--item">
                        <div class="item__disciption">
                            <div class="item__disciption--class">
                            </div>
                            <h1><fmt:message key="label.noCars"/></h1>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    </div>
</section>
</body>
</html>