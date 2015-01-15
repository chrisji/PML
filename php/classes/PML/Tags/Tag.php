<?php namespace PML\Tags;

use PML\Parser\PMLParser;

/**
 * Represents a PML element.
 *
 * @author Craig Childs
 */
class Tag {

    private $attributes = [],
            $childTags  = [],
            $tagName    = null;

    /**
     * Declare required output function
     */
    public function output()
    {
        echo '<' . $this->tagName . $this->buildAttributeString() . '>';
        PMLParser::parse($this->childTags);
        echo '</' . $this->tagName . '>';
    }

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
     * Get child tags by name
     *
     * @param String $name
     * @return Array The child tags
     */
    public function getChildTagsByName($name)
    {
        $children = [];
        foreach($this->childTags as $tag) {
            if($tag->getTagName() == $name) {
                $children[] = $tag;
            }
        }
        return $children;
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

    /**
     * Get child tags
     *
     * @return Array The child tags
     */
    public function setChildTags($tags = [])
    {
        $this->childTags = $tags;
    }

    /**
     * Get tag attributes
     *
     * @return Array The key/value attributes
     */
    public function setAttributes($attributes = [])
    {
        $this->attributes = $attributes;
    }

    /**
     * Get child tags
     *
     * @return Array The child tags
     */
    public function setTagName($name = '')
    {
        $this->tagName = $name;
    }

    /**
     * Build the attributes as a string
     *
     * @return String  The string of attributes
     */
    public function buildAttributeString()
    {
        $attString = '';

        if($this->hasAttributes()) {
            $attString += ' ';

            foreach($this->attributes as $name => $value) {
                $attString += $name . '="' . $value . '"';
            }
        }

        return $attString;
    }

    /**
     * Check if this tag has attributes
     *
     * @return Boolean  do we have attrs?
     */
    public function hasAttributes()
    {
        return !empty($this->getAttributes());
    }

    /**
     * Does this tag have children
     *
     * @return Boolean  Does this tage have children
     */
    public function hasChildren()
    {
        return !empty($this->getChildTags());
    }

    /**
     * Get the tag name
     *
     * @return String $name
     */
    public function getTagName()
    {
        return $this->tagName;
    }

}
