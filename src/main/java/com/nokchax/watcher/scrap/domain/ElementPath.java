package com.nokchax.watcher.scrap.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ElementPath {
    List<Element> path = new ArrayList<>();
}
