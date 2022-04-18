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

function getPizza(){
    global $con;
    $records = $con->query("SELECT * FROM pizza");
    return $records->fetch_all(MYSQLI_ASSOC);
}
function addPizza($name, $price, $diameter){
    global $con;
    $con->query("INSERT INTO pizza (name, price, diameter) VALUES ('$name', '$price', '$diameter')");
}
function updatePizza($number, $name, $price, $diameter){
    global $con;
    $con->query("UPDATE pizza SET name = '$name', price = '$price', diameter = '$diameter' WHERE number = '$number'");
}
function deletePizza($number){
    global $con;
    $con->query("DELETE FROM pizza WHERE number = '$number'");
}