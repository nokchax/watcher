package com.nokchax.watcher.scrap.filter;

public abstract class Filter<T> {

    abstract T filter(Filter<? extends Filter> type);
}
