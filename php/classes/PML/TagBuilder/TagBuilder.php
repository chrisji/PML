<?php namespace PML\TagBuilder;

use PML\Tags\Tag;
use PML\Exceptions\TagClassNotImplemented;

class TagBuilder {

    private $tagMap;

    /**
     * Construct a new builder
     */
    public function __construct()
    {
        $this->tagMap = [
            'if'    => 'PML\\Tags\\TagIf',
            'then'  => 'PML\\Tags\\TagThen',
            'else'  => 'PML\\Tags\\TagElse',
            'elif'  => 'PML\\Tags\\TagElseIf',
            'function' => 'PML\\Tags\\TagFunction'
        ];
    }

    /**
     * Build a tag using the Tag Map
     *
     * @param  String $tagName
     * @return Tag  Instance of tag by name
     */
    public function build($tagName)
    {
        $tag = null;

        if(isset($this->tagMap[$tagName])) {

            $className = $this->tagMap[$tagName];
            if(class_exists($className)) {
                $tag = new $className();
            } else {
                throw new TagClassNotImplemented($tagName);
            }

        } else {
            $tag = new Tag();
        }

        $tag->setTagName($tagName);
        return $tag;
    }

}
