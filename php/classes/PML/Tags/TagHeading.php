<?php namespace PML\Tags;

class TagHeading extends Tag {

    /**
     * Construct the base type, Tag
     *
     * @param Array $attributes
     * @param Array $childTags
     */
    public function __construct(Array $attributes, Array $childTags)
    {
        parent::__constrct($attributes, $childTags);
    }

    /**
     * Define some output for this tag
     *
     * @param  Array  $tags
     */
    public abstract function output(Array $tags)
    {
        echo '<h1>';
        PMLParser::parse($tags);
        echo '</h1>';
    }
}
