<?php namespace PML\Testing;

class Tester {

    // Store tests, key/value where value is an array with
    // function and expected value
    private $tests;

    /**
     * Create a new Tester
     * @param Array $tests default tests
     */
    public function __construct($tests = [])
    {
        $this->tests = $tests;
    }

    /**
     * Add a new test
     *
     * @param String $name     Name of the test
     * @param Function $function
     * @param Any $expected
     */
    public function addTest($name, $function, $expected = true)
    {
        $this->tests[$name] = [
            'function' => $function,
            'expected' => $expected
        ];

        return $this;
    }

    /**
     * Run a test or all tests, pass some
     * data and check if it returns what's expected
     *
     * @param String/Bool $name The name of the single test to run, or false if all
     * @param Array $data An array of data to pass to all tests
     * @return Array/Bool The results of the tests
     */
    public function run($data = [], $name = false)
    {
        if($name) {
            if(isset($this->tests[$name]))
                return $this->tests[$name]['function']($data) === $this->tests[$name]['expected'];
        }

        $results = [];

        foreach($this->tests as $name => $test) {
            $results[$name] = $test['function']($data) === $test['expected'];
        }

        return $results;
    }
}
