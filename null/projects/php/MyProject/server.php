<?php
use \Psr\Http\Message\ServerRequestInterface as Request;
use \Psr\Http\Message\ResponseInterface as Response;

require 'vendor/autoload.php';

$app = new \Slim\App;
$app->get('/hello/{name}', function (Request $request, Response $response) {
    $name = $request->getAttribute('name');
    $response->getBody()->write("Hello, $name");

    return $response;
});


$app->get('/departments', function (Request $request, Response $response) {
    
    $response->getBody()->write("departments");

    return $response;
});


$app->get('/dept_emp', function (Request $request, Response $response) {
    
    $response->getBody()->write("dept_emp");

    return $response;
});


$app->get('/dept_manager', function (Request $request, Response $response) {
    
    $response->getBody()->write("dept_manager");

    return $response;
});


$app->get('/employees', function (Request $request, Response $response) {
    
    $response->getBody()->write("employees");

    return $response;
});


$app->get('/salaries', function (Request $request, Response $response) {
    
    $response->getBody()->write("salaries");

    return $response;
});


$app->get('/titles', function (Request $request, Response $response) {
    
    $response->getBody()->write("titles");

    return $response;
});


$app->get('/current_dept_emp', function (Request $request, Response $response) {
    
    $response->getBody()->write("current_dept_emp");

    return $response;
});


$app->get('/dept_emp_latest_date', function (Request $request, Response $response) {
    
    $response->getBody()->write("dept_emp_latest_date");

    return $response;
});



$app->run();