<!DOCTYPE html>
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
                        <input type="text" name="loginid">
                    </td>
                </tr>
                <tr>
                    <td>password</td>
                    <td>
                        <input type="password" name="loginpwd">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Login">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>