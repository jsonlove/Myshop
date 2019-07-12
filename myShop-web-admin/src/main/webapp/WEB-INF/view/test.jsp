<%--
  Created by IntelliJ IDEA.
  User: zhangyz
  Date: 2019/5/23
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript">

    console.log(0.1+0.2===0.3)
    console.log(Math.pow(2,1023))
    console.log(parseInt("12"))
    console.log(btoa(encodeURIComponent("hello 你好")))
    console.log(decodeURIComponent(atob("aGVsbG8lMjAlRTQlQkQlQTAlRTUlQTUlQkQ=")))
    var ssdd=function (x) {
        return 3*x;
    };
    console.log(ssdd(2))
    var arr=[];
    console.log(arr)
    arr[1]=2321;
    console.log(arr)
    arr[2]={1:"job"}
    console.log(arr)
    arr[0]="213"
    console.log(arr)
    arr[3]=[2,3]
    console.log(arr)
    console.log(Object.keys(arr))
    arr.length=20;
    arr["dada"]="sd"
    console.log(arr)
    for (var i in arr){
        console.log(i)
    }
    console.log(String(arr))
    var lo=new Boolean(false);
    console.log(lo)
</script>

</body>
</html>
