<?php
    $con = mysqli_connect("mysql4.000webhost.com", "a5980064_bartek", "bartek1994", "a5980064_bartek");
    
    $tablesNumber;
    $tablesNames = array();
    
    $number = mysqli_prepare($con,"SELECT COUNT(*) FROM information_schema.TABLES WHERE TABLE_SCHEMA='a5980064_bartek'");
    mysqli_stmt_execute($number);
    
    mysqli_stmt_store_result($number);
    mysqli_stmt_bind_result($number, $tablesNumber);
    
    $names = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_SCHEMA='a5980064_bartek'";
    $result = mysqli_query($con, $names);

    $response = array();
    
    while(mysqli_stmt_fetch($number)){
        $response["tablesNumber"] = $tablesNumber - 1;
        }
        
    while ($row = mysqli_fetch_array($result)) {
        $tablesNames[] = $row["TABLE_NAME"];   
        }
        
    $response["tablesNames"] = $tablesNames;
    
        
    echo json_encode($response);
?>