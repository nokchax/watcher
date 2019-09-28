package com.nokchax.watcher.scrap.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor
public class Scrap {
    private String url;
    private String elementPath;
    private String pastScrap;
    private String scrapPeriod;
    private String compareType;
}
