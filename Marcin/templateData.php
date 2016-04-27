<?php
    $conTemplates = mysqli_connect("mn26.webd.pl", "szzefu_templates", "bartek1994", "szzefu_templates");
    
    $templateName = $_POST["templateName"];
    $templateRows = array();
    
    $statement = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '$templateName' ";
   // mysqli_stmt_bind_param($statement, "s", $templateName);
    $result = mysqli_query($conTemplates, $statement);
    
    while ($row = mysqli_fetch_array($result)) {
        $templateRows[] = $row['COLUMN_NAME'];   
        }
        
    $response["templateRows"] = $templateRows;
    
    echo json_encode($response);
?>