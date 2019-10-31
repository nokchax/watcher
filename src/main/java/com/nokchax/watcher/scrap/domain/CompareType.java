package com.nokchax.watcher.scrap.domain;

public enum CompareType {
    /**
     * Not compare contents but alarm contents always
     */
    NONE,
    /**
     * Contents equals exactly with compare string
     */
    EQUAL,
    /**
     * Contents contains compare string
     */
    CONTAIN,
    /**
     * Compare with previous scraped contents
     */
    UPDATED,

    START_WITH,

    END_WITH,

    REGEX
}