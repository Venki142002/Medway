<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>MedWay</title>
    <link rel="stylesheet" href="../css/home.css">
</head>
<body>
<div id="nav-container">
    <div class="logo">
        <h1>MedWAY</h1>
    </div>
    <div class="navlink" id="beforelogin">
        <ul id="nav-link" >
            <li>
                <a href="#" class="embtn">EMERGENCY</a>
            </li>
            <li>
                <a href="login">LOGIN</a>
            </li>
        </ul>
    </div>
    <div class="navlink" id="afterlogin">
        <ul id="nav-links" >
            <li>
                <h5>WELCOME ${username}</h5>
            </li>
            <li>
                <a href="#" class="emp">EMERGENCY</a>
            </li>
            <li>
                <a href="logout">LOGOUT</a>
            </li>
        </ul>
    </div>
</div>

<%--Gathering location from user--%>
<%--before login--%>
<div class="response" id="notlogin">
        <h1>EMERGENCY</h1>
        <form method="post" action="emergency" name="forms" >
            <div class="em">
                NAME:<label>
                <input type="text" placeholder="name" name="name" required>
            </label>
            </div>
            <div class="em">
                  NUMBER: <label>
                <input type="text" placeholder="mobile number" name="mobile" required>
                     </label>
            </div>
            <label for="lat"></label><input type="text" id="lat" placeholder="Get Value" name="latitude" hidden>
            <label for="log"></label><input type="text" id="log" placeholder="Set Value" name="longitude" hidden>
    <div class="em">
            <button type="submit" class="emrok">SUBMIT</button>
</div>
</form>
</div>
<%--after login--%>
<div class="response" id="login">
        <form method="post" action="emergency"  name="forms">
            <div class="em">
                ${username} are you in a Danger
            </div>
                 <input type="text" id="input-get" placeholder="Get Value" name="latitude" hidden>
                 <input type="text" id="input-set" placeholder="Set Value" name="longitude" hidden>

            <div class="em">
            <button type="submit" class="emrok">YES</button>
</div>
</form>
    </div>


<script>
    varcd = "x";
    var pa1 = document.querySelector("#beforelogin");
    var pa2 = document.querySelector("#afterlogin");
    var emnotlog = document.querySelector("#notlogin");
    var emlog = document.querySelector("#login");
    var embtn = document.querySelector(".embtn");
    var emp = document.querySelector(".emp");
    var hed = document.querySelector(".response");
    const check ='${username}';
    embtn.addEventListener("click",() =>
    {
        if(check != "")
        {
            emlog.classList.toggle("logined");
        }
        else
        {
            emnotlog.classList.toggle("logined");
        }
    })
    emp.addEventListener("click",() =>
    {
        if(check != "")
        {
            emlog.classList.toggle("logined");
        }
        else
        {
            emnotlog.classList.toggle("logined");
        }
    })
    if(check != "")
    {
        pa1.classList.add("login");
        pa2.classList.add("logout");
    }
    else
    {
        pa1.classList.remove("login");
        pa2.classList.remove(".logout");
    }
    let inputGet = document.querySelector('#input-get');
    let inputSet = document.querySelector('#input-set');
    let loginGet = document.querySelector('#lat');
    let loginSet = document.querySelector('#log');

        if(navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(e => {
               let latis = e.coords.latitude;
                let long = e.coords.longitude;
                inputGet.value = latis;
                inputSet.value = long;
            });
        }
        if(navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(e => {
               let latis = e.coords.latitude;
                let long = e.coords.longitude;
                loginGet.value = latis;
                loginSet.value = long;
            });
        }



</script>
</body>
</html>