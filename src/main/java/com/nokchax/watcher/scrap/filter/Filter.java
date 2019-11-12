package com.nokchax.watcher.scrap.filter;

public abstract class Filter<INPUT, OUTPUT> {

    abstract OUTPUT filtering(INPUT input);
}
