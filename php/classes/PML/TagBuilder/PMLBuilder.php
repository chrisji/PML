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
        $children = $root->childNodes;

        $childTags = [];

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

        if($root->hasAttributes()) {
            $attrList = [];
            $attributes = $root->attributes;

            foreach($attributes as $attribute) {
                $attrList[] = [
                    $attribute->nodeName,
                    $attribute->nodeValue
                ];
            }

            $rootTag->setAttributes($attrList);
        }

        $rootTag->setChildTags($childTags);
        return $rootTag;
    }
}
