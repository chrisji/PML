<?php namespace PML\Exceptions;

class TagClassNotImplemented extends \Exception {

    public function __construct($name, Exception $previous = null) {
        parent::__construct("You have not implemented tag -> {$name}", 0, $previous);
    }

    public function __toString() {
        return "\n" . __CLASS__ . ":: \n\t{$this->message}\n\n";
    }

}
