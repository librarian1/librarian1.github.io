<%--
  Created by IntelliJ IDEA.
  User: TestUser
  Date: 2018/5/5
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="utf-8" />
    <title>小学四则运算网上系统</title>
    <link href="css/index.css" rel="stylesheet" />
  </head>
  <body>
  <div class="main" id="container">
    <div class="main-top">
      <h1>小学四则运算网上系统</h1>
    </div>
    <div class="main-bottom">
      <form action="${pageContext.request.contextPath}/gene?state=generation" method="post">
        <div class="form-group">
          <p>运算题目数量：</p>
          <input type="text"  name="n" class="form-control" placeholder="四则运算题目数">
        </div>
        <div class="form-group">
          <p>算式数值范围：范围上限</p>
          <input type="text "name="m1" class="form-control" placeholder="算式数值范围">
        </div>
        <div class="form-group">
          <p>范围下限</p>
          <input type="text "name="m2" class="form-control" placeholder="算式数值范围">
        </div>
        <div class="form-group">
          <p>运算符数量：</p>
          <select name="o">
            <option value="1" selected="selected">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
          </select>
        </div>
        <div class="form-group">
          括号：
          无
          <input type="radio" checked="checked" name="b" value="2"  />
          有
          <input type="radio"  name="b" value="1" />
        </div>
        <div class="form-group">
          <p>是否有乘除：</p>
          否<input type="radio" name="c" value="2"checked="checked"/>
          是<input type="radio" name="c" value="1" /><br><br>

        </div>
        <div class="form-group">
          <input class="button" type="submit" value="生成运算" />
        </div>
        <div></div>
      </form>
      <form action="${pageContext.request.contextPath}/upload?state=upload" method="post">
        <input type="file" name="upload_media" class="upload_media" multiple="multiple"/>
        <br/>
        <button type="submit" class="btn btn-info">上传文件</button>
      </form>
    </div>
  </div>
  ${msg}
  </body>
</html>
