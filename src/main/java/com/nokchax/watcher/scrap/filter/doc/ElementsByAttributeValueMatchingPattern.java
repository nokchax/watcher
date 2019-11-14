package com.nokchax.watcher.scrap.filter.doc;

import com.nokchax.watcher.scrap.filter.Filter;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.util.Assert;

import java.util.regex.Pattern;

public class ElementsByAttributeValueMatchingPattern extends Filter<Document, Elements> {
    private Pattern pattern;

    public ElementsByAttributeValueMatchingPattern(String attributeName, String regex) {
        super(attributeName);
        Assert.hasText(regex, "Regex must not be a null");
        pattern = Pattern.compile(regex);
    }

    @Override
    public Elements filtering(Document document) {
        return document.getElementsByAttributeValueMatching(filterString, pattern);
    }
}
