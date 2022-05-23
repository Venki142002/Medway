<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MedWAy</title>
    <spring:url value="../css/reg.css" var="regCss"/>
    <spring:url value="reg" var="form"/>

    <spring:url value="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" var="regicon"/>
    <link href="${regCss}" rel="stylesheet">
    <link href="${regicon}" rel="stylesheet" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous">
</head>

<div class="container">
    <header>
        <div class="header">
            <h2>CREATE ACCOUNT</h2>
        </div>
    </header>
    <form id="forms" method="post">
        <div class="part1" >
            <div class="form_controller">
                <label>USER NAME</label>
                <input type="text" placeholder="USER NAME" id="username" name="username">
            </div>
            <div class="form_controller">
                <label>FIRST NAME</label>
                <input type="text" placeholder="Full Name" id="fullname" name="fullname">
            </div>
            <div class="form_controller">
                <label>MAIL ID</label>
                <input type="email" placeholder="Enter Your mailID" id="mailid" name="mailid">
            </div>
            <div class="form_controller">
                <label>PASSWORD</label>
                <input type="password" placeholder="Enter password" id="password" name="password">
            </div>
            <div class="form_controller">
                <label>CONFIRM PASSWORD</label>
                <input type="password" placeholder="Enter password" id="conpassword" name="conpassword">
            </div>
        </div>
        <!--part2-->
        <div class="more"> <h4>MORE</h4> </div>
    </form>
</div>
<div class="bg">
    <div class="popup">
        <h1>${result}</h1><br><br>
        <button><a href="/">ok</a></button>
    </div>
</div>

</body>
</html>