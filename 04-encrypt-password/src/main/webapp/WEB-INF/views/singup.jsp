<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<form action="/signupProcess" method="POST">
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
            <td>name</td>
            <td>
                <input type="text" name="userNm">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="signup">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
