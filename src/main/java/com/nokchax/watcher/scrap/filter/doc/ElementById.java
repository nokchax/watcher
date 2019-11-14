package com.nokchax.watcher.scrap.filter.doc;

import com.nokchax.watcher.scrap.filter.Filter;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ElementById extends Filter<Document, Element> {

    public ElementById(String id) {
        super(id);
    }

    @Override
    public Element filtering(Document document) {
        return document.getElementById(filterString);
    }
}
