package com.nokchax.watcher.scrap.filter.doc;

import com.nokchax.watcher.scrap.filter.Filter;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ElementsByIndexGreaterThan extends Filter<Document, Elements> {

    public ElementsByIndexGreaterThan(String index) {
        super(index);
        Integer.parseInt(index);
    }

    @Override
    public Elements filtering(Document document) {
        return document.getElementsByIndexGreaterThan(Integer.parseInt(filterString));
    }
}
