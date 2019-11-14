package com.nokchax.watcher.scrap.filter.elements;

import com.nokchax.watcher.scrap.filter.Filter;
import org.jsoup.select.Elements;

public class Attribute extends Filter<Elements, String> {

    public Attribute(String attributeName) {
        super(attributeName);
    }

    @Override
    public String filtering(Elements elements) {
        return elements.attr(filterString);
    }
}
