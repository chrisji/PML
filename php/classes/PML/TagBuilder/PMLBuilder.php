<?php namespace PML\TagBuilder;

use PML\Tags\TagText;

class PMLBuilder {

    private $builder;

    /**
     * Construct a PML builder which can accept
     * a Tag Builder
     *
     * @param TagBuilder $builder
     */
    public function __construct(TagBuilder $builder)
    {
        $this->builder = $builder;
    }

    /**
     * Load a PML file
     *
     * @param String $filename
     * @return DOMDocument $document
     */
    public function loadPML($filename)
    {
        $doc = new \DOMDocument();
        $doc->load($filename);
        return $doc;
    }

    /**
     * Build the tag tree from root
     *
     * @param DOMElement $root
     */
    public function buildTagTree(\DOMElement $root)
    {
        $tagName = $root->tagName;
        $rootTag = $this->builder->build($tagName);
        $rootTag->setAttributes($this->buildAttributes($root));
        $rootTag->setChildTags($this->buildChildren($root));
        return $rootTag;
    }

    /**
     * Build an array of attributes given
     * a DOMNode
     *
     * @param DOMNode $node
     * @return Array
     */
    private function buildAttributes($node)
    {
        $attrList = [];
        if($node->hasAttributes()) {
            $attributes = $node->attributes;

            foreach($attributes as $attribute) {
                $attrList[$attribute->nodeName] = $attribute->nodeValue;
            }
        }

        return $attrList;
    }

    /**
     * Build an array of children given
     * a DOMNode
     *
     * @param DOMNode $node
     * @return Array
     */
    private function buildChildren($node)
    {
        $childTags = [];
        $children = $node->childNodes;

        foreach($children as $child) {

            if($child instanceof \DOMText) {
                $value = $child->nodeValue;

                if(!empty(trim($value))) {
                    $tag = new TagText($value);
                    $tag->setTagName('CharacterData');
                    $childTags[] = $tag;
                }

            } else {
                $childTags[] = $this->buildTagTree($child);
            }
        }

        return $childTags;
    }
}
