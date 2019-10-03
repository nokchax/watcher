package com.nokchax.watcher.scrap.domain;

public enum CompareType {
    /**
     * Contents equals exactly with compare string
     */
    EQUAL,
    /**
     * Contents contains compare string
     */
    CONTAIN,
    /**
     * Not compare contents but alarm contents always
     */
    NOT_COMPARE,
    /**
     * Compare with previous scraped contents
     */
    UPDATED
}