<?php namespace PML\Tags;

use PML\Parser\PMLParser;

class TagFunction extends Tag {

    public function output()
    {
        $atts = $this->getAttributes();
        $name = $atts['name'];
        $args = $this->getChildTagsByName('argument');


        echo '<?php function '. $name .'(' . $this->buildArgumentString($args) . ') { ?>';
        PMLParser::parse([]);
        echo '<?php } ?>';
    }

    /**
     * Build the arguments string
     *
     * @param Array $args
     */
    private function buildArgumentString($args)
    {
        $text = '';

        if(!empty($args)) {
            foreach($args as $arg) {
                $attrs = $arg->getAttributes();
                $name = $attrs['name'];
                $text .= $name . ', ';
            }
        }
        
        return substr(trim($text), 0, -1);
    }
}
