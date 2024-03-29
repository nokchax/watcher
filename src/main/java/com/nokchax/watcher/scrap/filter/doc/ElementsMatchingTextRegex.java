package com.nokchax.watcher.scrap.filter.doc;

import com.nokchax.watcher.scrap.filter.Filter;
import lombok.NoArgsConstructor;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * regex를 포함하고 있는 태그뿐만 아니라 상위의 태그 까지 모두 포함하여 가지고 옴
 * cf) elementsMatchingOwnPattern은 regex를 포함하고 있는 태그까지만 가져옴
 */
@NoArgsConstructor
public class ElementsMatchingTextRegex extends Filter<Document, Elements> {
    public ElementsMatchingTextRegex(String regex) {
        super(regex);
    }

    @Override
    public Elements filtering(Document document) {
        return document.getElementsMatchingText(filterString);
    }
}
