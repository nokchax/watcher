package com.nokchax.watcher.scrap.filter;

public abstract class Filter<T> {

    abstract T filtering(Filter<? extends Filter> type);
}
