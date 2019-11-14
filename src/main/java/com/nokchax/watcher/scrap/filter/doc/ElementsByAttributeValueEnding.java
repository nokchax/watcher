package com.nokchax.watcher.scrap.filter.doc;

import com.nokchax.watcher.scrap.filter.Filter;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.util.Assert;

public class ElementsByAttributeValueEnding extends Filter<Document, Elements> {
    private String suffix;

    public ElementsByAttributeValueEnding(String key, String suffix) {
        super(key);
        Assert.hasText(suffix, "Suffix must not be a null");
        this.suffix = suffix;
    }
    @Override
    public Elements filtering(Document document) {
        return document.getElementsByAttributeValueEnding(filterString, suffix);
    }
}
