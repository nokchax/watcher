package com.nokchax.watcher.scrap.domain;

import com.nokchax.watcher.scrap.filter.Filter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ElementPath {
    List<? extends Filter> path = new ArrayList<>();
}
