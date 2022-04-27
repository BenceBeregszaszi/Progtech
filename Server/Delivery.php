<?php
include("database.php");
$request = $_SERVER['REQUEST_METHOD'];

switch($request){
    case "GET":
        $pizza = getPizza();
        echo json_encode($pizza);
        break;
    case "POST":
        $content = file_get_contents('php://input');
        $data=json_decode($content, true);
        addPizza($data["name"], $data["price"], $data["diameter"]);
        break;
    case "PUT":
        $content = file_get_contents('php://input');
        $data=json_decode($content, true);
        updatePizza($data["number"], $data["name"], $data["price"], $data["diameter"]);
        break;
    case "DELETE":
        $content = file_get_contents('php://input');
        $data=json_decode($content, true);
        deletePizza($data["id"]);
        break;
    default:
        header('HTTP/1.1 405 Method Not Allowed');
        header('Allow : GET, POST, PUT, DELETE');
        break;
}

function getDelivery(){
    global $con;
    $records = $con->query("SELECT * FROM delivery");
    return $records->fetch_all(MYSQLI_ASSOC);
}
function addDelivery($name, $location){
    global $con;
    $con->query("INSERT INTO delivery (name, location) VALUES ('$name', '$location')");
}
function updateDelivery($delivery_id, $location, $name){
    global $con;
    $con->query("UPDATE delivery SET name = '$name', location = '$location' WHERE delivery_id = '$delivery_id'");
}
function deleteDelivery($delivery_id){
    global $con;
    $con->query("DELETE FROM delivery WHERE delivery_id = '$delivery_id'");
}
