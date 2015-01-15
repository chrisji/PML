<?php


// Include the autoloader
include_once 'vendor/autoload.php';

// Init test class
use PML\Testing\Tester;
$tests = (new Tester())
    ->addTest('is_chris', function($data) {
        return 'chris';
    }, 'chris')
    ->run(['some', 'data']);
    
var_dump($tests);
