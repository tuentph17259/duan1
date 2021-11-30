var btLogin = document.getElementById("login");
var username = document.getElementById("Username");
var password = document.getElementById("Passwword");

btLogin.onclick = function () {
    
    if (username.value.trim() == "") {
        alert('họ tên khong để trống')
        return;
    }
    if (password.value.trim() == "") {
        alert("Chưa nhập password");
        return;
    }

}