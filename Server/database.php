<?php

$host="localhost";
$port=3306;
$socket="";
$user="root";
$password="";
$dbname="pizza_ordering";

$con = new mysqli($host, $user, $password, $dbname, $port, $socket)
    or die("Connection failed: ".mysqli_connect_error());

if ($con->connect_errno > 0) {
    printf("Connection failed: %\n",$con->connect_error);
}