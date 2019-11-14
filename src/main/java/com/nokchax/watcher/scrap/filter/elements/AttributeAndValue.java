package com.nokchax.watcher.scrap.filter.elements;

import com.nokchax.watcher.scrap.filter.Filter;
import org.jsoup.select.Elements;
import org.springframework.util.Assert;

public class AttributeAndValue extends Filter<Elements, Elements> {
    private String value;

    public AttributeAndValue(String attributeName, String value) {
        super(attributeName);
        Assert.hasText(value, "Value must not be a null");
        this.value = value;
    }

    @Override
    public Elements filtering(Elements elements) {
        return elements.attr(filterString, value);
    }
}
