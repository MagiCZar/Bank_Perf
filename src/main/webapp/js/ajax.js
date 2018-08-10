/**
 * Created by CZ on 2018/8/4.
 */
function requestJson(){
    var jsonData = {
        "id" : id,
        "password" : password
    };
    $.ajax({
        type:'post',
        url:'${pageContext.request.contextPath }/login.action',
        contentType:'application/json;charset=utf-8',//指定为json类型
        //数据格式是json串，商品信息
        data:JSON.stringify(jsonData),
        success:function(user){//返回json结果
            alert(user.id);
        }
    });
}