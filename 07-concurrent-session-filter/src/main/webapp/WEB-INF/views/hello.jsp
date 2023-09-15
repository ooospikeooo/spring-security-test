<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Hello World</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $("button").on("click", getData);
            });

            function getData() {
                $.ajax({
                    type:"POST",  //전송타입
                    url:"/public/test.json",//서버요청대상파일
                    dataType : "text" ,
                    success: function (data, status, xhr) {
                        $("#result").text(data);
                    },
                    error: function (xhr, status, e) {
                        console.log("error", e);
                        console.log("status", status);
                    }
                });
            }
        </script>
    </head>

    <body>
        <h2>${message}</h2>
        <ul>
            <li><a href="/logout">로그아웃</a></li>
            <li><a href="/admin/hello_admin">admin</a></li>
            <li><a href="/hello_user">user</a></li>
        </ul>
        <button id="ajax">ajax</button>
        <div id="result"></div>
    </body>
</html>