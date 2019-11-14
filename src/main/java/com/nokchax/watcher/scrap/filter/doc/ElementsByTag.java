package com.nokchax.watcher.scrap.filter.doc;

import com.nokchax.watcher.scrap.filter.Filter;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ElementsByTag extends Filter<Document, Elements> {

    public ElementsByTag(String tagName) {
        super(tagName);
    }

    @Override
    public Elements filtering(Document document) {
        return document.getElementsByTag(filterString);
    }
}
