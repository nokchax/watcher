package com.nokchax.watcher.scrap.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor
public class Scrap {
    private String url;
    private Status status;
    private String path;
    //private ElementPath elementPath;
    private String scrapedContents;
    private String scrapPeriod;
    private String targetString;
    private CompareType compareType;
}
