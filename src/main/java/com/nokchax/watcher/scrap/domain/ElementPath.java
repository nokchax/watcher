package com.nokchax.watcher.scrap.domain;

import com.nokchax.watcher.scrap.filter.Filter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ElementPath {
    List<? extends Filter> path = new ArrayList<>();

    /*
    Object output = Document.getBody();
    do {
        output = f.filtering(output);
    } while(Filter f : path);

    return string;

    how about exception handling..? throw it? or catch... -> throw exception to upper layer
     */
}
