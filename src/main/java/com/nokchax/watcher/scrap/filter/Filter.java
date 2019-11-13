package com.nokchax.watcher.scrap.filter;

import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@NoArgsConstructor
public abstract class Filter<INPUT, OUTPUT> {
    protected String filterString;

    public Filter(String filterString) {
        Assert.hasText(filterString, "Filter string must not be a null");
        this.filterString = filterString;
    }

    public abstract OUTPUT filtering(INPUT input);
}
