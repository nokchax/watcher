package com.nokchax.watcher.scrap.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Scrap {
    private String url;
    private Status status;
    private String targetPath;
    private String targetString;
    //private ElementPath elementPath;
    private String scrapedContents;
    private String scrapPeriod;
    private CompareType compareType;
    private AlarmCondition alarmCondition;
}
