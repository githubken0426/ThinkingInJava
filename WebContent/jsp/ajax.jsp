<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'MyJsp.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript"
			src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
    $(function() {
    	connect();
        $("#btn").click(function() {
            var value = $("#message").val();
            $.ajax({
                url : "asyncServlet",
                type:'post',
                timeout:5000,    //超时时间
                data:{method:'onMessage',msg:value},
                cache : false,
                dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
              	//默认值：发送信息至服务器时内容编码类型
                contentType:'application/x-www-form-urlencoded',
                beforeSend:function(xhr){
                    console.log(xhr)
                    console.log('发送前')
                },
                success:function(data,textStatus,jqXHR){
                    console.log(data)
                    console.log(textStatus)
                    console.log(jqXHR)
                },
                error:function(xhr,textStatus){
                    console.log('错误')
                    console.log(xhr)
                    console.log(textStatus)
                },
                complete:function(){
                    console.log('结束')
                }
            });
        });
    });
    function connect() {
        $.ajax({
            url : "asyncServlet",
            type:'post',
            data:{method:'onOpen'},
            cache : false,
            dataType : "text",
            success : function(data) {
                connect();
                //alert(data);
            }
        });
    }

    
	$('#send').click(function() {
			//请求的5个阶段，对应readyState的值
			//0: 未初始化，send方法未调用；
			//1: 正在发送请求，send方法已调用；
			//2: 请求发送完毕，send方法执行完毕；
			//3: 正在解析响应内容；
			//4: 响应内容解析完毕；
			var data = 'name=yang';
			var xhr = new XMLHttpRequest(); //创建一个ajax对象
			xhr.onreadystatechange = function(event) { //对ajax对象进行监听
				if (xhr.readyState == 4) { //4表示解析完毕
					if (xhr.status == 200) { //200为正常返回
						console.log(xhr)
					}
				}
			};
			//建立连接，参数一：发送方式，二：请求地址，三：是否异步，true为异步
			xhr.open('POST', 'url', true); 
			xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded'); //可有可无
			xhr.send(data); //发送
		});
</script>
	</head>
	<body>
		<!-- 这是注释 -->
		<%--这还是注释 --%>
		<%
  		int a=10;
  	 %>
		<%!
  	 	int a=12;
  	 	
  	  %>
		<% out.print(a); %>
		This is my JSP page.
		<br>
		<input type="text" id="message" />
		<input type="button" id="btn" value="反ajax" />

		<input type="button" id="jqueryAjax" value="jquery ajax" />
		<input type="button" id="ajax" value="原生ajax" />
	</body>
</html>
