package com.nokchax.watcher.scrap.domain;

//extends node or array list or string
/*
    it needs not element but class
    to filter several input type and output typed
 */
public enum ElementType {
    TAG, // elements
    CLASS, // elements
    NAME, // elements
    ATTRIBUTE, //need two parameters (key value)
    TEXT,  // return string
    STRING, // ??
    GET, // return element
    PARENT, //elements
    CHILD, // input element -> output element
    CHILDREN // input element -> output elements
}
