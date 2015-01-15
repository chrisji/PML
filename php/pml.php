<?php


// Include the autoloader
include_once 'vendor/autoload.php';

// Init test class
use PML\Testing\Tester;
use PML\TagBuilder\TagBuilder;

$tests = (new Tester())
    ->addTest('can_if', function($data) {

        $tag = (new TagBuilder())->build('if');
        return ($tag instanceof PML\Tags\TagText);

    })
    ->run(['some', 'data']);

var_dump($tests);
