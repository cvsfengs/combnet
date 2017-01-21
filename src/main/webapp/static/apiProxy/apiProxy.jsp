<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>apiProxy List</title>
  <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
</head>
<body>
<button onclick="PROXY.getApiList()">getApiList</button>&nbsp;
<button onclick="PROXY.getVersionIpMenu()">getVersionIpMenu</button>&nbsp;
cid:<input id="cid">
<button onclick="PROXY.doProxy()">doProxy</button>
  <textarea id="show" style="width: 500px;height: 400px"></textarea>
<script type="text/javascript" src="js/apiProxy.js"></script>
</body>
</html>
