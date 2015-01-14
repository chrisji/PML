<?php


// Include the autoloader
// Put composer autoload here +++++++++++

// Init test class
$tests = new Tester()
    ->addTest('test', function($data) {
        return is_array($data);
    })
    ->run(['some', 'data']);
