package com.nokchax.watcher.scrap.filter.doc;

import com.nokchax.watcher.scrap.filter.Filter;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

// this class have no fields
public class AllElements extends Filter<Document, Elements> {

    @Override
    public Elements filtering(Document document) {
        return document.getAllElements();
    }
}
