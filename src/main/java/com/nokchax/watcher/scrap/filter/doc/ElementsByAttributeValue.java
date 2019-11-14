package com.nokchax.watcher.scrap.filter.doc;

import com.nokchax.watcher.scrap.filter.Filter;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.util.Assert;

public class ElementsByAttributeValue extends Filter<Document, Elements> {
    private String value;

    public ElementsByAttributeValue(String attributeName, String value) {
        super(attributeName);

        Assert.hasText(value, "Value must be a not null");
        this.value = value;
    }

    @Override
    public Elements filtering(Document document) {
        return document.getElementsByAttributeValue(filterString, value);
    }
}
