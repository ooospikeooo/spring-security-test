<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
    </head>
    <body>
        <form action="/loginProcess" method="POST">
            <table>
                <tr>
                    <td>id</td>
                    <td>
                        <input type="text" name="userLoginId">
                    </td>
                </tr>
                <tr>
                    <td>password</td>
                    <td>
                        <input type="password" name="userPwd">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Login">
                    </td>
                </tr>
            </table>
        </form>

        <a href="/signup">회원가입</a>
    </body>
</html>