<?php namespace PML\Tags;

/**
 * Represents a PML element.
 *
 * @author Craig Childs
 */
class Tag {

    private $attributes = [],
            $childTags  = [];

    /**
     * Construct a new Tag
     * @param Array $attributes Key/Value pairs of attributes
     * @param Array $childTags  An array of child tags
     */
    public function __construct(Array $attributes, Array $childTags)
    {
        $this->attributes = $attributes;
        $this->childTags  = $childTags;
    }

    /**
     * Declare required output function
     *
     * @param Array $tags pass all tag info
     */
    public abstract output(Array $tags);

    /**
     * Get child tags
     *
     * @return Array The child tags
     */
    public function getChildTags()
    {
        return $this->childTags;
    }

    /**
    * Get tag attributes
    *
    * @return Array The key/value attributes
    */
    public function getAttributes()
    {
        return $this->attributes;
    }

}
