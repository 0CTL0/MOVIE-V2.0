
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/14
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="../../../css/header.css" rel="stylesheet" type="text/css"/>
    <link href="../../../css/footer.css" rel="stylesheet" type="text/css"/>
    <link href="../../../css/category.css" rel="stylesheet" type="text/css"/>


    <script>
        function cctz(movieId) {
            var url = "/movie/detail?"+"movieId="+movieId;
            window.location.href = url;
        }
    </script>
    <script type="text/javascript">
        function submitMovieForm(flag) {
            if ('first' == flag) {
                document.getElementById('page').value = 1;
            } else if ('pre' == flag) {
                var current = Number(document.getElementById('page').value);
                if (current > 1) {
                    document.getElementById('page').value = current - 1;
                }
            } else if ('next' == flag) {
                var current = Number(document.getElementById('page').value);
                var last = Number(document.getElementById('last').value);
                if (current < last) {
                    document.getElementById('page').value = current + 1;
                }
            } else if ('last' == flag) {
                var last = Number(document.getElementById('last').value);
                document.getElementById('page').value = last < 1 ? 1 : last;
            }
            document.getElementById('movieForm').submit();
        }
    </script>
</head>


<body>

    <c:import url="header.jsp"></c:import>

    <div class="contain">
    <div class="wrap">
        <div class="main">
            <div class="title">
                <div class="new">
                    <a href="#">最新</a>
                </div>
                <div class="hot">
                    <a href="#">最热</a>
                </div>
                <div class="clear"></div>
            </div>

            <C:forEach items="${categoryMovies}" var="movie">
                <div class="movieUnit" onclick="cctz(${movie.movieId})">
                    <img src="${movie.movieImgUrl}" alt="">
                    <p>${movie.movieName}</p>
                </div>
            </C:forEach>
    </div>


        <div class="rank">
            <div class="rank-title">排行榜</div>
            <div class="rank-list">
                <c:set var="rankNum" value="1" />
                <c:forEach items="${scoreMovies}" var="movie">
                <a href="/movie/detail?movieId=${movie.movieId}">
                    <p class="num">${rankNum}</p>
                    <p class="moviename">${movie.movieName}</p>
                    <p class="moviescore">${movie.movieScore}</p>
                    <c:set var="rankNum" value="${rankNum+1}" />
                    <div class="clear"></div>
                </a>
                </c:forEach>
            </div>
        </div>
        <div class="clear"></div>
        </div>
    </div>

    <!--用隐藏样式的表单提交请求，刷新页面数据-->
    <div class="pagefy">
        <ul>
            <form id="movieForm" action="/movie/category?movieType=${movieType}" method="post">
                <input type="hidden" id="page" name="page" value="${page}">
                <input type="hidden" id="last" name="last" value="${last}">
                <li><a href="javascript:void(0)" onclick="submitMovieForm('first')">首页</a></li>
                <li><a href="javascript:void(0)" onclick="submitMovieForm('pre')">上一页</a></li>
                <li><a href="javascript:void(0)">当前第${page}页</a></li>
                <li><a href="javascript:void(0)" onclick="submitMovieForm('next')">下一页</a></li>
                <li><a href="javascript:void(0)" onclick="submitMovieForm('last')">尾页</a></li>
            </form>
        </ul>
    </div>
    <div class="clear"></div>

    <c:import url="footer.jsp"></c:import>
</body>
</html>
