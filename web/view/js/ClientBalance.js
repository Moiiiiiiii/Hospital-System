var request;
var password1,password2,balance;
function Edit()
{
    balance = document.getElementById("balance").value;
    password1 = document.getElementById("password1").value;
    password2 = document.getElementById("password2").value;
    var url = "../ClientBalance";
    if (window.XMLHttpRequest) {
        request = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        request = new ActiveXObject("Microsoft.XMLHTTP");
    }
    try
    {
        request.onreadystatechange = getInfo;
        request.open("POST", url, true);
        request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        request.send("balance=" + balance + "&password1=" + password1 + "&password2=" + password2);
    } catch (e)
    {
        alert("Unable to connect to server");
    }
}
var Balance = document.getElementById("Balance"),
    Password1 =  document.getElementById("Password1"),
    Password2 = document.getElementById("Password2");
function getInfo() {
    if (this.readyState === 4 && this.status === 200) {
        var val = this.responseText;
         if (val === "balance") {
            Balance.innerHTML = "Invalid Balance";
            clear(Balance);
        } else if (val === "password1") {
            Password1.innerHTML = "Invalid Password";
            clear(Password1);
        } else if (val === "password2") {
            Password2.innerHTML = "Invalid Password";
            clear(Password2);
        } else if (val === "identical") {
            Password2.innerHTML = "Not Identical";
            clear(Password2);
        } else if (val === "invalidadmin") {
            Password2.innerHTML = "Invalid Password";
            clear(Password2);
        }  else if (val === "success") {
            alert("Success Process");
            location.replace("MainClient.jsp");
        }
    }
    
}
function clear(x) {
    setTimeout(function () {
        x.innerHTML = "";
    }, 2000);
}