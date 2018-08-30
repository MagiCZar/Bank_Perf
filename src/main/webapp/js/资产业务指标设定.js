
var gettype = Object.prototype.toString;
function check() {
    var sum=0;
    var w1=parseInt(document.getElementsByName("w1")[0].value);
    if (!isNaN(w1))sum=sum+w1;
    var w2=parseInt(document.getElementsByName("w2")[0].value);
    if (!isNaN(w2))sum=sum+w2;
    if (sum!=100)
    {alert("权重总和应为100");
        return;
    }
    else  {
        document.getElementById("form1").submit();
    }
}
