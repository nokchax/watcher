package com.nokchax.watcher.scrap.filter;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TestFilter extends Filter<Document, Element> {

    @Override
    Element filtering(Document input) {

        return input.body();
    }
}
