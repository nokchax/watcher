package com.nokchax.watcher.scrap.filter.doc;

import com.nokchax.watcher.scrap.filter.Filter;
import lombok.NoArgsConstructor;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

@NoArgsConstructor
public class ElementsMatchingOwnTextRegex extends Filter<Document, Elements> {

    // how about this (duplicated assert statement extract with super())
    public ElementsMatchingOwnTextRegex(String regex) {
        super(regex);
    }

    @Override
    public Elements filtering(Document document) {

        return document.getElementsMatchingOwnText(filterString);
    }
}
