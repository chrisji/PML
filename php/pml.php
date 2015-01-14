<?php


// Include the autoloader
// Put composer autoload here +++++++++++

// Init test class
use PML\Testing\Tester;
$tests = new Tester()
    ->addTest('test', function($data) {
        return is_array($data);
    })
    ->run(['some', 'data']);
