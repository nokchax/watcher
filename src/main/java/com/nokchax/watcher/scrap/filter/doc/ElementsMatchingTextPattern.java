package com.nokchax.watcher.scrap.filter.doc;

import com.nokchax.watcher.scrap.filter.Filter;
import lombok.NoArgsConstructor;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.util.Assert;

import java.util.regex.Pattern;

@NoArgsConstructor
public class ElementsMatchingTextPattern extends Filter<Document, Elements> {
    private Pattern pattern;

    public ElementsMatchingTextPattern(String pattern) {
        Assert.hasText(pattern, "Pattern must not be a null");
        this.pattern = Pattern.compile(pattern);
    }

    @Override
    public Elements filtering(Document document) {
        return document.getElementsMatchingText(pattern);
    }
}
