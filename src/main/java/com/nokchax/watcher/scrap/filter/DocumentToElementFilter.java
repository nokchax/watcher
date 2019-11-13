package com.nokchax.watcher.scrap.filter;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class DocumentToElementFilter extends Filter<Document, Element> {

    @Override
    public Element filtering(Document input) {
        return input.body();
    }
}
