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

function getUsers(){
    global $con;
    $records = $con->query("SELECT * FROM users");
    return $records->fetch_all(MYSQLI_ASSOC);
}
function addUsers($username, $password){
    global $con;
    $con->query("INSERT INTO users (username, password) VALUES ('$username', '$password')");
}

function deleteUsers($username){
    global $con;
    $con->query("DELETE FROM users WHERE username = '$username'");
}
