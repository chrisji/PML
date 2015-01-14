<?php namespace PML\Tags;

class TagText extends Tag {

    private $characterData = '';

    /**
     * Construct the base type, Tag
     *
     * @param Array $attributes
     * @param Array $childTags
     */
    public function __construct(Array $attributes, $characterData)
    {
        parent::__constrct($attributes, []);
        $this->characterData = $characterData;
    }

    /**
     * Define some output for this tag
     *
     * @param  Array  $tags
     */
    public abstract function output(Array $tags)
    {
        echo $this->characterData;
    }
}
