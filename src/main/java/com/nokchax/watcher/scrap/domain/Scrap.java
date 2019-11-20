package com.nokchax.watcher.scrap.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private FilterChains filterChains;

    // make filterChains using targetPath after load scrap entity from db
    // update targetPath using filterChains before send update query

    @PreUpdate
    public void updateTargetPath() {
        // filterChains (object) -> targetPath (string)
        // TODO: 2019-11-12 need to target filters parser that parse string to elements
    }

    @PostLoad
    public void loadFilterChains() {
        // targetPath (String) -> filterChains (object)
        // TODO: 2019-11-12 elements to string
    }
}
