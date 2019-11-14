package com.nokchax.watcher.scrap.filter;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DocumentToElementFilter extends Filter<Document, Element> {

    @Override
    public Element filtering(Document input) {
        Elements elements = input.getElementsByIndexLessThan(1);
        return input.body();
    }
}
