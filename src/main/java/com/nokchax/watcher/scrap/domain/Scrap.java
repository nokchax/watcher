package com.nokchax.watcher.scrap.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Transient;

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
    private String scrapedContents;
    private String scrapPeriod;
    private CompareType compareType;
    private AlarmCondition alarmCondition;

    @Transient
    private ElementPath elementPath;

    // make elementPath using targetPath after load scrap entity from db
    // update targetPath using elementPath before send update query
}
