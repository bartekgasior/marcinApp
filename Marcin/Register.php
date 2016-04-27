<?php
    $con = mysqli_connect("mn26.webd.pl", "szzefu_user", "bartek1994", "szzefu_db");
    
    if (mysqli_connect_errno()){
        $response["success"]=false;
    }
    
	$name = $_POST["name"];
	$surname = $_POST["surname"];
    $username = $_POST["username"];
	//$email= $_POST["email"];
	$phone = $_POST["phone"];
    $password = $_POST["password"];
	$rePassword = $_POST["rePassword"];
    
    $response = array();
    $response["wrongPasswords"] = false;
    $response["wrongEMail"] = false;
    $response["success"]=false;
    
    if (preg_match("/^([a-zA-Z0-9])+([a-zA-Z0-9\._-])*@([a-zA-Z0-9_-])+([a-zA-Z0-9\._-]+)+$/",$_POST["email"])){
        $email = $_POST["email"];
        $response["wrongEMail"] = false;
    }
    else{
        $response["wrongEMail"] = true;
    }
    
    if($_POST["password"] == $_POST["rePassword"]){
        $response["wrongPasswords"] = false;
    }else{
        $response["wrongPasswords"] = true;
    }
    
    if($response["wrongEMail"]==false && $response["wrongPasswords"]==false){
        $statement = mysqli_prepare($con, "INSERT INTO user (name, surname, username, email, phone, password) VALUES (?, ?, ?, ?, ?, ?)");
        mysqli_stmt_bind_param($statement, "ssssis", $name, $surname, $username, $email, $phone, $password);
        mysqli_stmt_execute($statement);
        $response["success"]=true;
    }
    echo json_encode($response);
?>