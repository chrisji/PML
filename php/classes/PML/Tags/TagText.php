<?php namespace PML\Tags;

class TagText extends Tag {

    private $characterData = '';

    /**
     * Construct the base type, Tag
     *
     * @param Array $attributes
     * @param Array $childTags
     */
    public function __construct($characterData)
    {
        $this->characterData = $characterData;
    }

    /**
     * Define some output for this tag
     */
    public function output()
    {
        echo $this->characterData;
    }
}
