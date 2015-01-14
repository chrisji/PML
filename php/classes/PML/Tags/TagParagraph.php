<?php namespace PML\Tags;

class TagParagraph extends Tag {

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
        echo '<p>';
        PMLParser::parse($tags);
        echo '</p>';
    }
}
