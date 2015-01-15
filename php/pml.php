<?php


// Include the autoloader
include_once 'vendor/autoload.php';

// Init test class
use PML\Testing\Tester;
use PML\TagBuilder\TagBuilder;
use PML\Exceptions\TagClassNotImplemented;

$tests = (new Tester())
    ->addTest('can_if', function($data) {

        try {
            $tag = (new TagBuilder())->build('if');
            return ($tag instanceof PML\Tags\TagText);
        } catch(TagClassNotImplemented $e) {
            echo $e;
            return false;
        }

    }, true)
    ->run(['some', 'data']);

var_dump($tests);
