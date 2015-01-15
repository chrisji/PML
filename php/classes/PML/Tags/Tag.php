<?php namespace PML\Tags;

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
     *
     * @param Array $tags pass all tag info
     */
    public output(Array $tags)
    {
        echo '<' . $this->tagName . $this->buildAttributeString() . '>';
        PMLParse::parse($tags);
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

        if(!empty($this->attributes)) {
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

}
