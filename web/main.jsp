<%--
  Created by IntelliJ IDEA.
  User: TestUser
  Date: 2018/5/5
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>四则运算题目</title>
    <link href="css/main.css" rel="stylesheet" />
    <script src=js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        /*计时器*/
        function two_char(n) {
            return n >= 10 ? n : "0" + n;
        }
        function time_fun() {
            var sec=0;
            setInterval(function () {
                sec++;
                var date = new Date(0, 0)
                date.setSeconds(sec);
                var h = date.getHours(), m = date.getMinutes(), s = date.getSeconds();
                document.getElementById("mytime").innerText = two_char(h) + ":" + two_char(m) + ":" + two_char(s);
            }, 1000);
        }
        /*弹窗*/
        $(function() {
            $(".button").click(function(){
                var $p=$("<p>3</p>");
                var p_txt=$p.text();
                var $h2=$("h2")
                var h2_txt=$h2.text();
                $(".mainone").remove();
                $("h1").after(p_txt)
                $("h1").after("<h3>正确题目数：</h3>")
                $("h1").after(h2_txt)
                $("h1").after("<h3>此次所用时间：</h3>")
            });
        });

    </script>
</head>
<body onload="time_fun()">
<div class="main" id="container">
    <h1>四则运算题目</h1>
    <div class="mainone">
        <div>
            <h2 id="mytime">00:00:00</h2>
        </div>
        <div>
            <table border="1">
                <tr>
                    <th>题目</th>
                    <th>答案</th>
                </tr>
            </table>
        </div>
        <div>
            <table border="1">
                <tr>
                    <td>12-12-12-12</td>
                    <td><input type="text" class="form-control" placeholder="答案"></td>
                </tr>
            </table>
        </div>
        <div>
            <table border="1">
                <tr>
                    <td>12-12-12-12</td>
                    <td><input type="text" class="form-control" placeholder="答案"></td>
                </tr>
            </table>
        </div>
        <div>
            <table border="1">
                <tr>
                    <td>12-12-12-12</td>
                    <td><input type="text" class="form-control" placeholder="答案"></td>
                </tr>
            </table>
        </div>
        <div>
            <table border="1">
                <tr>
                    <td>12-12-12-12</td>
                    <td><input type="text" class="form-control" placeholder="答案"></td>
                </tr>
            </table>
        </div>
        <div>
            <table border="1">
                <tr>
                    <td>12-12-12-12</td>
                    <td><input type="text" class="form-control" placeholder="答案"></td>
                </tr>
            </table>
        </div>
        <div class="form-group">
            <input class="button" type="submit" value="提交" />
        </div>
    </div>
</div>
</body>
</html>
