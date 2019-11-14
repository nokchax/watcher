package com.nokchax.watcher.scrap.filter.elements;

import com.nokchax.watcher.scrap.filter.Filter;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ElementByIndex extends Filter<Elements, Element> {

    public ElementByIndex(String index) {
        super(index);
        Integer.parseInt(index);
    }

    @Override
    public Element filtering(Elements elements) {
        return elements.get(Integer.parseInt(filterString));
    }
}
