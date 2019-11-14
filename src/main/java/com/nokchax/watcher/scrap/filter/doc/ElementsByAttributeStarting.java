package com.nokchax.watcher.scrap.filter.doc;

import com.nokchax.watcher.scrap.filter.Filter;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ElementsByAttributeStarting extends Filter<Document, Elements> {

    public ElementsByAttributeStarting(String keyPrefix) {
        super(keyPrefix);
    }

    @Override
    public Elements filtering(Document document) {
        return document.getElementsByAttributeStarting(filterString);
    }
}
