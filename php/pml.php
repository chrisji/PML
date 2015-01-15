<?php


// Include the autoloader
include_once 'vendor/autoload.php';

// Init test class
use PML\Testing\Tester;
use PML\TagBuilder\TagBuilder;
use PML\TagBuilder\PMLBuilder;
use PML\Exceptions\TagClassNotImplemented;


$tests = (new Tester())

    // Can we create an if?
    ->addTest('can_if', function($data) {

        try {
            $tag = (new TagBuilder())->build('if');
            return ($tag instanceof PML\Tags\TagText);
        } catch(TagClassNotImplemented $e) {
            echo $e;
            return false;
        }

    }, true)

    // Check if we can load a PML file
    ->addTest('can_load_pml', function($data) {

        $builder = new PMLBuilder(new TagBuilder());
        $doc = $builder->loadPML('test.pml')->documentElement;
        $tags = $builder->buildTagTree($doc);
        var_dump($tags);

    }, true)

    // Run the tests
    ->run(['some', 'data']);

var_dump($tests);
