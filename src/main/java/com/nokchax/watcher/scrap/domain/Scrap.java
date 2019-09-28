package com.nokchax.watcher.scrap.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor
public class Scrap {
    private String url;
    private ElementPath elementPath;
    private String pastScrap;
    private String status;//hold, scrap, page not found, ....
    private String scrapPeriod;
    private CompareType compareType;
}
