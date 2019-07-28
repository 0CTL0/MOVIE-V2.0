<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/26
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>搜索</title>
    <link href="../../../css/header.css" rel="stylesheet" type="text/css"/>
    <link href="../../../css/footer.css" rel="stylesheet" type="text/css"/>
    <link href="../../../css/search.css" rel="stylesheet" type="text/css"/>

    <script>
        function cctz(movieId) {
            var url = "/movie/detail?movieId="+movieId;
            window.location.href = url;
        }
    </script>
</head>


<body>
<c:import url="header.jsp"></c:import>

<div class="search-main">
    <div class="tip"><h2>共找到${resultTotal}条结果</h2></div>

    <c:forEach items="${searchMovies}" var="movie">
        <div class="movieRow" >
            <div class="movieUnit2" onclick="cctz(${movie.movieId})">
                <h3>${movie.movieName}</h3>
                <img src="${movie.movieImgUrl}" alt="">
            </div>
            <div class="movieInfo">
                <p>主演：${movie.movieStar}</p>
                <p>简介：${movie.movieSummary}</p>
            </div>
            <div class="clear"></div>
        </div>
    </c:forEach>
</div>


</body>
</html>