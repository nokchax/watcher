package com.nokchax.watcher.scrap.filter.doc;

import com.nokchax.watcher.scrap.filter.Filter;
import lombok.NoArgsConstructor;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.regex.Pattern;

@NoArgsConstructor
public class ElementsMatchingOwnTextPattern extends Filter<Document, Elements> {

    public ElementsMatchingOwnTextPattern(String regex) {
        super(regex);
    }

    @Override
    public Elements filtering(Document document) {
        return document.getElementsMatchingOwnText(Pattern.compile(filterString));
    }
}
