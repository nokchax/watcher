package com.nokchax.watcher.scrap.domain;

public enum Status {
    /*
     * Scrap page
     */
    SCRAP,
    /*
     * Do not scrap page
     */
    HOLD,
    /*
     * Scraped but page not found
     */
    NOT_FOUND
}
