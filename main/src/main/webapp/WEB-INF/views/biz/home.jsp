<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/25
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>/css/home.css" rel="stylesheet" type="text/css"/>
    <link href="<%=request.getContextPath()%>/css/header.css"  rel="stylesheet" type="text/css"/>
    <link href="<%=request.getContextPath()%>/css/footer.css" rel="stylesheet" type="text/css"/>
    <title>home</title>
</head>


<body>
<c:import url="header.jsp"></c:import>

<!--轮播图-->

<!--影片分类推荐-->
<div class="movie">

    <div class="movie-category">
        <a href="" class="name">动作片</a>
        <a href="" class="more">更多>>></a>
    </div>
    <div class="movie-list">
        <ul>
            <c:forEach items="${actionMovies}" var="movie">
                <li>
                    <a href="/movie/detail?movieId=${movie.movieId}">
                        <img src="${movie.movieImgUrl}" alt="">
                        <p>${movie.movieName}</p>
                    </a>
                </li>
            </c:forEach>

        </ul>
        <div class="clear"></div>
    </div>


    <div class="movie-category">
        <a href="" class="name">喜剧片</a>
        <a href="" class="more">更多>>></a>
    </div>
    <div class="movie-list">
        <ul>
            <c:forEach items="${comedyMovies}" var="movie">
                <li>
                    <a href="/movie/detail?movieId=${movie.movieId}">
                        <img src="${movie.movieImgUrl}" alt="">
                        <p>${movie.movieName}</p>
                    </a>
                </li>
            </c:forEach>
        </ul>
        <div class="clear"></div>
    </div>


    <div class="movie-category">
        <a href="" class="name">爱情片</a>
        <a href="" class="more">更多>>></a>
    </div>
    <div class="movie-list">
        <ul>
            <c:forEach items="${LoveMovies}" var="movie">
                <li>
                    <a href="/movie/detail?movieId=${movie.movieId}">
                        <img src="${movie.movieImgUrl}" alt="">
                        <p>${movie.movieName}</p>
                    </a>
                </li>
            </c:forEach>
        </ul>
        <div class="clear"></div>
    </div>

</div>


<c:import url="footer.jsp"></c:import>
</body>
</html>

