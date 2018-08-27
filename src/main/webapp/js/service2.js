var gettype = Object.prototype.toString;

function check() {
    var sum=0;
    var w1=parseInt(document.getElementsByName("w1")[0].value);
    if (!isNaN(w1))sum=sum+w1;
    var w2=parseInt(document.getElementsByName("w2")[0].value);
    if (!isNaN(w2))sum=sum+w2;
    var w3=parseInt(document.getElementsByName("w3")[0].value);
    if (!isNaN(w3))sum=sum+w3;
    var w4=parseInt(document.getElementsByName("w4")[0].value);
    if (!isNaN(w4))sum=sum+w4;
    var w5=parseInt(document.getElementsByName("w5")[0].value);
    if (!isNaN(w5))sum=sum+w5;
    var w6=parseInt(document.getElementsByName("w6")[0].value);
    if (!isNaN(w6))sum=sum+w6;
    var w7=parseInt(document.getElementsByName("w7")[0].value);
    if (!isNaN(w7))sum=sum+w7;
    if (sum!=100)
    {alert("权重总和应为100");
        return;
    }
    else  {
        document.getElementById("form1").submit();
    }
}
var zk = function (value,index) {
    if (value>0){
        var size;
        if(value%10==0)
            size=0;
        else if (value<1){
            size=2;
        }
        else size=1;
        document.getElementById("k"+index+"1").innerHTML =0 + "——" +((value/10)*6).toFixed(size) + "万元-不合格";
        document.getElementById("k"+index+"2").innerHTML = ((value/10)*6).toFixed(size) + "——" +((value/10)*9).toFixed(size) + "万元-合格";
        document.getElementById("k"+index+"3").innerHTML = ((value/10)*9).toFixed(size)+ "——" + 1 * value + "万元-优秀";
        document.getElementById("bei"+index).innerHTML = "(" + value / 100 + "万元/分)";
    }else {
        document.getElementById("k"+index+"1").innerHTML ="";
        document.getElementById("k"+index+"2").innerHTML="";
        document.getElementById("k"+index+"3").innerHTML="";
        document.getElementById("bei"+index).innerHTML="";

    }
}