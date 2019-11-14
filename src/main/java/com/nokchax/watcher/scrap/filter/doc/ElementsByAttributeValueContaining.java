package com.nokchax.watcher.scrap.filter.doc;

import com.nokchax.watcher.scrap.filter.Filter;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.util.Assert;

public class ElementsByAttributeValueContaining extends Filter<Document, Elements> {
    private String match;

    public ElementsByAttributeValueContaining(String key, String match) {
        super(key);
        Assert.hasText(match, "Value must not be a null");
        this.match = match;
    }
    @Override
    public Elements filtering(Document document) {
        return document.getElementsByAttributeValueContaining(filterString, match);
    }
}
