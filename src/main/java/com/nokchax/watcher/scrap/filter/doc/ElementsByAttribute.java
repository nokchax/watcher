package com.nokchax.watcher.scrap.filter.doc;

import com.nokchax.watcher.scrap.filter.Filter;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ElementsByAttribute extends Filter<Document, Elements> {

    public ElementsByAttribute(String attributeName) {
        super(attributeName);
    }

    @Override
    public Elements filtering(Document document) {
        return document.getElementsByAttribute(filterString);
    }
}
