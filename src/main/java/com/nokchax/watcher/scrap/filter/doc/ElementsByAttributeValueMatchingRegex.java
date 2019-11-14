package com.nokchax.watcher.scrap.filter.doc;

import com.nokchax.watcher.scrap.filter.Filter;
import lombok.NoArgsConstructor;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.util.Assert;

public class ElementsByAttributeValueMatchingRegex extends Filter<Document, Elements> {
    private String regex;

    public ElementsByAttributeValueMatchingRegex(String attributeName, String regex) {
        super(attributeName);

        Assert.hasText("regex", "Regex must not be a null");
        this.regex = regex;
    }
    @Override
    public Elements filtering(Document document) {
        return document.getElementsByAttributeValueMatching(filterString, regex);
    }
}
