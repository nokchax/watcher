package com.nokchax.watcher.scrap.filter.doc;

import com.nokchax.watcher.scrap.filter.Filter;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ElementsByIndexEquals extends Filter<Document, Elements> {
    public ElementsByIndexEquals(String index) {
        super(index);
        // check input is parserable
        Integer.parseInt(index);
    }
    @Override
    public Elements filtering(Document document) {
        return document.getElementsByIndexEquals(Integer.parseInt(filterString));
    }
}
