<?php namespace PML\Tags;

use PML\Parser\PMLParser;

class TagIf extends Tag {

    public function output()
    {
        $atts = $this->getAttributes();
        $cond = $atts['cond'];
        echo '<?php if(' . $cond . ') : ?>';
        PMLParser::parse($this->getChildTags());
        echo '<?php endif; ?>';
    }
}
