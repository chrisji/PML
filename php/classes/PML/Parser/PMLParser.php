<?php namespace PML\Parser;

/**
 * The parser
 *
 * @author Craig Childs
 */
class PMLParser {

    /**
     * Parse a set of tags
     *
     * @param Array $tags A set of tags
     */
    public static function parse(Array $tags)
    {
        if(count($tags) > 0) {
            foreach($tags as $tag) {
                $tag->output();
            }
        }
    }
}
