<%@ page language="java" import="java.util.*,com.lc.pojo.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">管理信息</a></li>
    <li><a href="#">查看用户信息</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">

    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>用户id<i class="sort"><img src="images/px.gif" /></i></th>
        <th>用户名</th>
        <th>密码</th>
        <th>性别</th>
        <th>年龄</th>
        <th>生日</th>
        </tr>
        </thead>
        <tbody>
        <%
        	List<User> lu =(ArrayList<User>)request.getAttribute("lu");
        	for( User u :  lu ){
        %>
                <tr>
		        <td><%=u.getUid() %></td>
		        <td><%=u.getUname() %></td>
		        <td><%=u.getPwd() %></td>
		        <td><%=("1".equals(u.getSex()))?"男":"女" %></td>
		        <td><%=u.getAge() %></td>
		        <td><%=u.getBirth()%></td> 
        		</tr> 
        <% 			
        	}
         %>

    
        </tbody>
    </table>

    
    </div>

</body>

</html>
