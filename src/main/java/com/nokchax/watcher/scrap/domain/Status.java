package com.nokchax.watcher.scrap.domain;

public enum Status {
    /**
     * Scrap page
     */
    SCRAP,
    /**
     * Not scrap page
     */
    HOLD,
    /**
     * Scraped but page not found
     */
    NOT_FOUND
}
