package com.nokchax.watcher.scrap.filter.doc;

import com.nokchax.watcher.scrap.filter.Filter;
import lombok.NoArgsConstructor;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.regex.Pattern;

@NoArgsConstructor
public class ElementsMatchingTextPattern extends Filter<Document, Elements> {

    public ElementsMatchingTextPattern(String regex) {
        super(regex); // how about this
    }

    @Override
    public Elements filtering(Document document) {
        return document.getElementsMatchingText(Pattern.compile(filterString));
    }
}
