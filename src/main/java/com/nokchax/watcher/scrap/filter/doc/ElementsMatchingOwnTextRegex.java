package com.nokchax.watcher.scrap.filter.doc;

import com.nokchax.watcher.scrap.filter.Filter;
import lombok.NoArgsConstructor;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.util.Assert;

@NoArgsConstructor
public class ElementsMatchingOwnTextRegex extends Filter<Document, Elements> {
    private String regex;

    public ElementsMatchingOwnTextRegex(String regex) {
        Assert.hasText(regex, "Regex must not be a null");
        this.regex = regex;
    }
    @Override
    public Elements filtering(Document document) {

        return document.getElementsMatchingOwnText(regex);
    }
}
