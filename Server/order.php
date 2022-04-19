<?php
include("database.php");
$request = $_SERVER['REQUEST_METHOD'];

switch($request){
    case "GET":
        $pizza = getOrder();
        echo json_encode($pizza);
        break;
    case "POST":
        $content = file_get_contents('php://input');
        $data=json_decode($content, true);
        newOrder($data["pizza_id"], $data["topping_id"]);
        break;
    case "PUT":
        $content = file_get_contents('php://input');
        $data=json_decode($content, true);
        updateOrder($data["order_id"], $data["pizza_id"], $data["topping_id"]);
        break;
    case "DELETE":
        $content = file_get_contents('php://input');
        $data=json_decode($content, true);
        deleteOrder($data["order_id"]);
        break;
    default:
        header('HTTP/1.1 405 Method Not Allowed');
        header('Allow : GET, POST, PUT, DELETE');
        break;
}

function getOrder(){
    global $con;
    $records = $con->query("SELECT * FROM pizza");
    return $records->fetch_all(MYSQLI_ASSOC);
}
function newOrder($pizza_id, $topping_id){
    global $con;
    $con->query("INSERT INTO pizza (pizza_id, topping_id) VALUES ('$pizza_id', '$topping_id')");
}
function updateOrder($order_id, $pizza_id, $topping_id){
    global $con;
    $con->query("UPDATE pizza SET pizza_id = '$pizza_id', topping_id = '$topping_id' WHERE order_id = '$order_id'");
}
function deleteOrder($order_id){
    global $con;
    $con->query("DELETE FROM pizza WHERE number = '$order_id'");
}