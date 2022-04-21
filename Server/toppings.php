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

function getToppings(){
    global $con;
    $records = $con->query("SELECT * FROM toppings");
    return $records->fetch_all(MYSQLI_ASSOC);
}
function addToppings($name, $price){
    global $con;
    $con->query("INSERT INTO toppings (name, price) VALUES ('$name', '$price')");
}
function updateToppings($topping_id, $name, $price){
    global $con;
    $con->query("UPDATE toppings SET name = '$name', price = '$price' WHERE topping_id = '$topping_id'");
}
function deleteToppings($topping_id){
    global $con;
    $con->query("DELETE FROM toppings WHERE topping_id = '$topping_id'");
}
