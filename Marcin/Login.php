<?php
    $con = mysqli_connect("mn26.webd.pl", "szzefu_user", "bartek1994", "szzefu_db");
    $conTemplates = mysqli_connect("mn26.webd.pl", "szzefu_templates", "bartek1994", "szzefu_templates");
    $response = array();
    $response["connection_status"]  = false;
    if (mysqli_connect_errno()){
        $response["connection_status"] =true;
    }
    
    
    $username = $_POST["username"];
	$email = $_POST["email"];
    $password = $_POST["password"];
    
    $tablesNumber;
    $tablesNames = array();
    
    $statement = mysqli_prepare($con, "SELECT * FROM user WHERE username = ? AND email = ? AND password = ? ");
    mysqli_stmt_bind_param($statement, "sss", $username, $email, $password);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $user_ID, $name, $surname, $username, $email, $phone, $password, $privileged);
    
    
    $response["success"] = false;
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
        $response["name"] = $name;
        $response["surname"] = $age;
        $response["username"] = $username;
        $response["email"] = $password;
		$response["phone"] = $password;
		$response["password"] = $password;
        }
        
        
  $number = mysqli_prepare($conTemplates,"SELECT COUNT(*) FROM information_schema.TABLES WHERE TABLE_SCHEMA='szzefu_templates'");
    mysqli_stmt_execute($number);
    
    mysqli_stmt_store_result($number);
    mysqli_stmt_bind_result($number, $tablesNumber);
    
    $names = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_SCHEMA='szzefu_templates'";
    $result = mysqli_query($conTemplates, $names);
    
    while(mysqli_stmt_fetch($number)){
        $response["tablesNumber"] = $tablesNumber;
        }
        
    while ($row = mysqli_fetch_array($result)) {
        $tablesNames[] = $row["TABLE_NAME"];   
        }
        
    $response["tablesNames"] = $tablesNames;
    
    echo json_encode($response);
?>