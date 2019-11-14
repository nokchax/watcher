package com.nokchax.watcher.scrap.filter.doc;

import com.nokchax.watcher.scrap.filter.Filter;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ElementsByIndexLessThan extends Filter<Document, Elements> {

    public ElementsByIndexLessThan(String index) {
        super(index);
        Integer.parseInt(index);
    }

    @Override
    public Elements filtering(Document document) {
        return document.getElementsByIndexLessThan(Integer.parseInt(filterString));
    }
}
