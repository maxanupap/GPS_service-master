<?php    
			require("conn.php");   
		$lat = $_POST["lat"];  
		$lon = $_POST["lon"]; 
			$boat = $_POST["boat"]; 
			$type = $_POST["type"]; 
			$lineboat = $_POST["lineboat"]; 
		 $statement = mysqli_prepare($conn, "INSERT INTO location2 ( lat,lon,id_boat,type,id_line) VALUES($lat,$lon,$boat,$type,$lineboat)"); 
 
    mysqli_stmt_execute($statement);  
		$response = array(); 
		$response["online"] = true;  
			echo json_encode($response); 
?>