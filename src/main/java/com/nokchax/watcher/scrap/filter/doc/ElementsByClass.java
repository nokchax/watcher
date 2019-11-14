package com.nokchax.watcher.scrap.filter.doc;

import com.nokchax.watcher.scrap.filter.Filter;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ElementsByClass extends Filter<Document, Elements> {

    public ElementsByClass(String className) {
        super(className);
    }

    @Override
    public Elements filtering(Document document) {
        return document.getElementsByClass(filterString);
    }
}
