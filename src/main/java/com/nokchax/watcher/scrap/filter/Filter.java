package com.nokchax.watcher.scrap.filter;

import com.nokchax.watcher.scrap.domain.CompareType;

public abstract class Filter<INPUT, OUTPUT> {
    protected CompareType compareType; // is this fields necessary? how about divide one class to several classes
    protected String compareString;

    abstract OUTPUT filtering(INPUT input);
}
