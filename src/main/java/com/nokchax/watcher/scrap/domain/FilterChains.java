package com.nokchax.watcher.scrap.domain;

import com.nokchax.watcher.scrap.filter.Filter;
import lombok.Getter;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FilterChains {
    List<? extends Filter> filters = new ArrayList<>();

    /*
    Object output = Document.getBody();
    do {
        output = f.filtering(output);
    } while(Filter f : filters);

    return string;

    how about exception handling..? throw it? or catch... -> throw exception to upper layer
     */

    public String chaining(Document document) throws Exception {
        Object output = document.body();

        for(Filter filter : filters) {
            output = filter.filtering(output);
        }

        return output.toString();
    }
}
